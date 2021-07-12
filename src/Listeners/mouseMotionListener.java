package Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import mainPackage.MyPanel;

public class mouseMotionListener implements MouseMotionListener {
	MyPanel panel;
	private long thisTime = 0;
	private int place2soundWaitTime = 50;

	public mouseMotionListener(MyPanel panel) {
		this.panel = panel;
	}

	public void mouseDragged(MouseEvent e) {

		// schritte zwischen last mousepos und this mousepos
		float thisMouseX;
		float thisMouseY;

		if (!panel.fullscreen) {
			thisMouseX = e.getX() - 7;
			thisMouseY = e.getY() - 30;
		} else {
			thisMouseX = e.getX();
			thisMouseY = e.getY();
		}

		if (panel.gameScreen) {
			if (panel.mouseButtonPressed == 1) {
				if (panel.onPixelScreen()) {

					if (!panel.fillMode && !panel.copyMode && !panel.drawRect) {
						if (!panel.drawLine) {
							if (e.isControlDown()) {// offset screen
								panel.offsetX += thisMouseX - panel.mouseX;
								panel.offsetY += thisMouseY - panel.mouseY;
							} else {

								int subMousePositions = panel.constrain(
										(long) panel.getDist(panel.mouseX, panel.mouseY, thisMouseX, thisMouseY)
												/ (panel.pixelWidth / 2 + 1),
										10, 1000);

								float[][] subMousePos = new float[subMousePositions + 1][2];

								// set zwischenpositions
								for (int i = 0; i < subMousePos.length; i++) {
									subMousePos[i][0] = panel.mouseX
											+ (thisMouseX - panel.mouseX) / (subMousePositions + 1) * (i + 1);// x
									subMousePos[i][1] = panel.mouseY
											+ (thisMouseY - panel.mouseY) / (subMousePositions + 1) * (i + 1);// y
								}

								for (int n = 0; n < subMousePos.length; n++) {

									int x = (int) (subMousePos[n][0]);

									while ((x - panel.offsetLeft - panel.offsetX)
											% (panel.pixelWidth * panel.zoomFactor) != 0) {
										x--;
									}
									x = (x - panel.offsetLeft - panel.offsetX) / (panel.pixelWidth * panel.zoomFactor);

									int y = (int) (subMousePos[n][1]);
									while ((y - panel.offsetUp - panel.offsetY)
											% (panel.pixelHeight * panel.zoomFactor) != 0) {
										y--;
									}
									y = (int) ((y - panel.offsetUp - panel.offsetY)
											/ (panel.pixelWidth * panel.zoomFactor));

									int I = x + y * panel.anzahlPixelWidth;
									int minX = ((I % panel.anzahlPixelWidth) - panel.brushSize < 0) ? 0
											: (I % panel.anzahlPixelWidth) - panel.brushSize;
									int maxX = ((I % panel.anzahlPixelWidth)
											+ panel.brushSize >= panel.anzahlPixelWidth) ? panel.anzahlPixelWidth - 1
													: (I % panel.anzahlPixelWidth) + panel.brushSize;

									int minY = (Math.floorDiv(I, panel.anzahlPixelWidth) - panel.brushSize < 0) ? 0
											: Math.floorDiv(I, panel.anzahlPixelWidth) - panel.brushSize;
									int maxY = (Math.floorDiv(I, panel.anzahlPixelWidth)
											+ panel.brushSize >= panel.anzahlPixelHeight) ? panel.anzahlPixelHeight - 1
													: Math.floorDiv(I, panel.anzahlPixelWidth) + panel.brushSize;

									for (int posy = minY; posy <= maxY; posy++) {
										for (int posx = minX; posx <= maxX; posx++) {
											int i = posx + (posy * panel.anzahlPixelWidth);
											boolean set = false;
											if (panel.brushSize == 1) {
												if (panel.pixelArray[i].mouseOverPixel(subMousePos[n][0],
														subMousePos[n][1])) {
													set = true;
												}
											} else if (panel.brushSize > 1) {
												if (panel.getDist((int) subMousePos[n][0], (int) subMousePos[n][1],
														panel.pixelArray[i].posX + panel.pixelWidth / 2,
														panel.pixelArray[i].posY
																+ panel.pixelHeight / 2) <= panel.brushSize
																		* panel.pixelWidth / 2 * panel.zoomFactor) {
													set = true;
												}
											}
											if (set) {
												if (!panel.replaceBlocks) {
													if (panel.pixelArray[i].name == "Air") {
														panel.pixelArray[i].setDataByName(panel.ausgewaehlterPixel.name,
																false);
														// specific data
														panel.pixelArray[i].setIndividualData(
																panel.ausgewaehlterPixel.getIndividualData());
													}
												} else {

													panel.pixelArray[i].setDataByName(panel.ausgewaehlterPixel.name,
															false);
													// specific data
													panel.pixelArray[i].setIndividualData(
															panel.ausgewaehlterPixel.getIndividualData());
												}
											}

										}
									}
								}

								if (!panel.muteSound && panel.playPlaceSound) {
									if (System.currentTimeMillis() > thisTime + place2soundWaitTime) {
										panel.playSound("place2.wav", panel.place2Volume);
										thisTime = System.currentTimeMillis();
									}
								}

							}
						}
					}
				} else {
					if (panel.brushSizeBox.mouseOverPixel(thisMouseX, thisMouseY)) {
						float verhaeltnis = 0;
						verhaeltnis = ((float) panel.mouseX - panel.brushSizeBox.posX) / panel.brushSizeBox.boxWidth;
						panel.brushSize = (int) (1 + Math.floor(verhaeltnis * panel.maxBrushSize));
						panel.brushColor = 255;
					}
				}
			} else if (panel.mouseButtonPressed == 2) {
				panel.offsetX += thisMouseX - panel.mouseX;
				panel.offsetY += thisMouseY - panel.mouseY;
			} else if (panel.mouseButtonPressed == 3) {
				// set pixel
				if (!panel.copyMode && !e.isAltDown()) {
					for (int i = 0; i < panel.pixelArray.length; i++) {
						if (panel.pixelArray[i].mouseOverPixel(panel.mouseX, panel.mouseY)) {
							panel.ausgewaehlterPixel.setDataByName(panel.pixelArray[i].name, false);
							// specific data
							panel.ausgewaehlterPixel.setIndividualData(panel.pixelArray[i].getIndividualData());
						}
					}
				}
			}

		}
		if (!panel.fullscreen) {
			panel.mouseX = e.getX() - 7;
			panel.mouseY = e.getY() - 30;
		} else {
			panel.mouseX = e.getX();
			panel.mouseY = e.getY();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (!panel.fullscreen) {
			panel.mouseX = e.getX() - 7;
			panel.mouseY = e.getY() - 30;
		} else {
			panel.mouseX = e.getX();
			panel.mouseY = e.getY();
		}

	}

}

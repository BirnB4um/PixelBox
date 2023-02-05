package Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mainPackage.AuswahlPixel;
import mainPackage.MyPanel;
import mainPackage.Sound;

public class mouseListener implements MouseListener {
	MyPanel panel;

	public mouseListener(MyPanel panel) {
		this.panel = panel;
	}

	public void mouseClicked(MouseEvent e) {
		// System.out.println("mouse clicked");
	}

	public void mousePressed(MouseEvent e) {
		panel.mouseButtonPressed = e.getButton();

		// leftclick
		if (e.getButton() == 1) {

			if (panel.gameScreen) {

				// draw rect on
				if (e.isShiftDown()) {
					panel.drawRect = true;

					for (int i = 0; i < panel.pixelArray.length; i++) {
						if (panel.pixelArray[i].mouseOverPixel(panel.mouseX, panel.mouseY)) {
							panel.startMousePos[0] = panel.pixelArray[i].posX;
							panel.startMousePos[1] = panel.pixelArray[i].posY;
							break;
						}
					}
				} else
				// draw line on
				if (e.isControlDown()) {

					panel.drawLine = true;
					panel.startMousePos[0] = panel.mouseX;
					panel.startMousePos[1] = panel.mouseY;

				} else

				// draw pixel
				if (panel.onPixelScreen() && !e.isControlDown()) {

					// loop through all pixels
					for (int i = 0; i < panel.pixelArray.length; i++) {

						if (panel.copyMode) {// set first copy point
							if (panel.copyEndpoint == null || (panel.pixelArray[i].posX <= panel.copyEndpoint.posX
									&& panel.pixelArray[i].posY <= panel.copyEndpoint.posY)) {
								if (panel.pixelArray[i].mouseOverPixel(panel.mouseX, panel.mouseY)) {
									panel.copyStartpoint = panel.pixelArray[i];
								}
							}

						} else if (panel.fillMode) {// fill pixel
							if (panel.pixelArray[i].mouseOverPixel(panel.mouseX, panel.mouseY)
									&& panel.pixelArray[i].name != panel.ausgewaehlterPixel.name) {
								panel.fillArea(i, panel.pixelArray[i].name);
							}

						} else {
							boolean place = false;
							if (this.panel.brushSize == 1) {// draw 1 pixel
								if (panel.pixelArray[i].mouseOverPixel(panel.mouseX, panel.mouseY)) {
									place = true;
								}
							} else if (panel.brushSize > 1) {// draw many pixel
								if (panel.getDist((int) panel.mouseX, (int) panel.mouseY,
										panel.pixelArray[i].posX + panel.pixelWidth / 2,
										panel.pixelArray[i].posY + panel.pixelHeight / 2) <= panel.brushSize
												* panel.pixelWidth / 2 * panel.zoomFactor) {
									place = true;
								}
							}

							if (place) {
								if (!panel.replaceBlocks) {
									if (panel.pixelArray[i].name == "Air") {
										panel.pixelArray[i].setDataByName(panel.ausgewaehlterPixel.name, false);
										// specific data
										panel.pixelArray[i]
												.setIndividualData(panel.ausgewaehlterPixel.getIndividualData());
									}
								} else {
									panel.pixelArray[i].setDataByName(panel.ausgewaehlterPixel.name, false);
									// specific data
									panel.pixelArray[i].setIndividualData(panel.ausgewaehlterPixel.getIndividualData());
								}
							}

						}
					}

//					panel.removeNewestStepsFromHistoryList();//?
//					panel.addOneHistoryList = true;

					if (panel.checkMuteAndMaxSize() && panel.playPlaceSound)
						Sound.PLACE.play();

					panel.fillMode = false;
					panel.fillBox.fillRect = false;
				} else

				// change step speed
				if (panel.stepSpeedBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {// in liste umwandeln???
					if (panel.stepFrameRateFactor == 0.5) {
						if (panel.checkMuteAndMaxSize())
							Sound.CHANGESPEED2.play();
						panel.stepFrameRateFactor = 1.0f;
					} else if (panel.stepFrameRateFactor == 1.0f) {
						if (panel.checkMuteAndMaxSize())
							Sound.CHANGESPEED3.play();
						panel.stepFrameRateFactor = 2.0f;
					} else if (panel.stepFrameRateFactor == 2.0f) {
						if (panel.checkMuteAndMaxSize())
							Sound.CHANGESPEED4.play();
						panel.stepFrameRateFactor = 4.0f;
					} else if (panel.stepFrameRateFactor == 4.0f) {
						if (panel.checkMuteAndMaxSize())
							Sound.CHANGESPEED5.play();
						panel.stepFrameRateFactor = 8.0f;
					} else if (panel.stepFrameRateFactor == 8.0f) {
						if (panel.checkMuteAndMaxSize())
							Sound.CHANGESPEED6.play();
						panel.stepFrameRateFactor = 16.0f;
					} else if (panel.stepFrameRateFactor == 16.0f) {
						if (panel.checkMuteAndMaxSize())
							Sound.CHANGESPEED1.play();
						panel.stepFrameRateFactor = 0.5f;
					}

				} else if (panel.copyInnerBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {// copy area
					panel.copyInnerBox.setAlpha(255);
					panel.copySelectedArea();
					panel.copyMode = false;

					panel.copyStartpoint = null;
					panel.copyEndpoint = null;
					if (panel.checkMuteAndMaxSize())
						Sound.COPY.play();

				}

			}
//			else if (panel.settingsMenu) {
//
//			}
		}

		// rightclick
		if (e.getButton() == 3) {
			if (panel.gameScreen && !e.isAltDown()) {
				// set pixel
				for (int i = 0; i < panel.pixelArray.length; i++) {
					if (panel.pixelArray[i].mouseOverPixel(panel.mouseX, panel.mouseY)) {

						if (panel.copyMode) {// set sec copy point
							if (panel.copyStartpoint == null || (panel.pixelArray[i].posX >= panel.copyStartpoint.posX
									&& panel.pixelArray[i].posY >= panel.copyStartpoint.posY)) {
								panel.copyEndpoint = panel.pixelArray[i];
							}

						} else {// select pixel
							panel.ausgewaehlterPixel.setDataByName(panel.pixelArray[i].name, false);
							// specific data
							panel.ausgewaehlterPixel.setIndividualData(panel.pixelArray[i].getIndividualData());
						}
					}
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		panel.mouseButtonPressed = -1;

		// set pixel
		if (panel.auswahlMenu) {
			if (panel.auswahlPixelArray != null) {
				for (int i = 0; i < panel.auswahlPixelArray.length; i++) {
					if (panel.auswahlPixelArray[i].mouseOverPixel(panel.mouseX, panel.mouseY)
							&& panel.auswahlPixelArray[i].name != "Coming Soon") {
						panel.ausgewaehlterPixel.setDataByName(panel.auswahlPixelArray[i].name, false);
						// specific data
						panel.ausgewaehlterPixel.setIndividualData(panel.auswahlPixelArray[i].getIndividualData());

						panel.setToGameScreen();
					}
				}
			}

			for (int i = 0; i < panel.categoryPixels.length; i++) {

				if (panel.categoryPixels[i].mouseOverPixel(panel.mouseX, panel.mouseY)) {
					if (panel.showWhichCategoryItems != i) {
						panel.showWhichCategoryItems = i;
						int dx = 70;
						int dy = 190;
						int auswahlPixelAbstand = 7;
						int auswahlPixelWidth = 60;
						int auswahlPixelHeight = auswahlPixelWidth;
						int howManyAuswahlPixelsInWidth = (panel.width - 2 * dx)
								/ (auswahlPixelWidth + auswahlPixelAbstand);

						String[] itemList = null;

						if (i == 0) {
							itemList = panel.gasItems;
						} else if (i == 1) {
							itemList = panel.liquidItems;
						} else if (i == 2) {
							itemList = panel.solidItems;
						} else if (i == 3) {
							itemList = panel.technicItems;
						} else if (i == 4) {
							itemList = panel.animalList;
						}

						if (itemList != null) {
							panel.auswahlPixelArray = new AuswahlPixel[itemList.length];
							for (int n = 0; n < itemList.length; n++) {

								int posX = dx
										+ (n % howManyAuswahlPixelsInWidth) * (auswahlPixelWidth + auswahlPixelAbstand);
								int posY = dy + (n / howManyAuswahlPixelsInWidth)
										* (auswahlPixelHeight + auswahlPixelAbstand);

								panel.auswahlPixelArray[n] = new AuswahlPixel(posX, posY, auswahlPixelWidth,
										auswahlPixelHeight, panel, itemList[n]);

							}
						}

					}
				}
			}

		} else if (panel.gameScreen) {

			if (panel.onPixelScreen()) {
				panel.removeNewestStepsFromHistoryList();
				panel.addOneHistoryList();
			}

			if (panel.drawLine) {// draw line

				panel.drawLine = false;

				float thisX = panel.mouseX;
				float thisY = panel.mouseY;

				if (panel.getDist(panel.startMousePos[0], panel.startMousePos[1], thisX, thisY) >= 3 * panel.pixelWidth
						* panel.zoomFactor) {
				}

				int subMousePositions = panel
						.constrain((long) panel.getDist(thisX, thisY, panel.startMousePos[0], panel.startMousePos[1])
								/ (panel.pixelWidth / 2 + 1), 10, 1000);

				float[][] subMousePos = new float[subMousePositions + 1][2];

				// set zwischenpositions
				for (int i = 0; i < subMousePos.length; i++) {
					subMousePos[i][0] = thisX + ((panel.startMousePos[0] - thisX) / (subMousePositions)) * (i);// x
					subMousePos[i][1] = thisY + ((panel.startMousePos[1] - thisY) / (subMousePositions)) * (i);// y
				}

				for (int n = 0; n < subMousePos.length; n++) {

					int x = (int) (subMousePos[n][0]);

					while ((x - panel.offsetLeft - panel.offsetX) % (panel.pixelWidth * panel.zoomFactor) != 0) {
						x--;
					}
					x = (x - panel.offsetLeft - panel.offsetX) / (panel.pixelWidth * panel.zoomFactor);

					int y = (int) (subMousePos[n][1]);
					while ((y - panel.offsetUp - panel.offsetY) % (panel.pixelHeight * panel.zoomFactor) != 0) {
						y--;
					}
					y = (int) ((y - panel.offsetUp - panel.offsetY) / (panel.pixelWidth * panel.zoomFactor));

					int I = x + y * panel.anzahlPixelWidth;
					int minX = ((I % panel.anzahlPixelWidth) - panel.brushSize < 0) ? 0
							: (I % panel.anzahlPixelWidth) - panel.brushSize;
					int maxX = ((I % panel.anzahlPixelWidth) + panel.brushSize >= panel.anzahlPixelWidth)
							? panel.anzahlPixelWidth - 1
							: (I % panel.anzahlPixelWidth) + panel.brushSize;

					int minY = (Math.floorDiv(I, panel.anzahlPixelWidth) - panel.brushSize < 0) ? 0
							: Math.floorDiv(I, panel.anzahlPixelWidth) - panel.brushSize;
					int maxY = (Math.floorDiv(I, panel.anzahlPixelWidth) + panel.brushSize >= panel.anzahlPixelHeight)
							? panel.anzahlPixelHeight - 1
							: Math.floorDiv(I, panel.anzahlPixelWidth) + panel.brushSize;

					for (int posy = minY; posy <= maxY; posy++) {
						for (int posx = minX; posx <= maxX; posx++) {
							int i = posx + (posy * panel.anzahlPixelWidth);
							boolean set = false;
							if (panel.brushSize == 1) {
								if (panel.pixelArray[i].mouseOverPixel(subMousePos[n][0], subMousePos[n][1])) {
									set = true;
								}
							} else if (panel.brushSize > 1) {
								if (panel.getDist((int) subMousePos[n][0], (int) subMousePos[n][1],
										panel.pixelArray[i].posX + panel.pixelWidth / 2,
										panel.pixelArray[i].posY + panel.pixelHeight / 2) <= panel.brushSize
												* panel.pixelWidth / 2 * panel.zoomFactor) {
									set = true;
								}
							}
							if (set) {
								if (!panel.replaceBlocks) {
									if (panel.pixelArray[i].name == "Air") {
										panel.pixelArray[i].setDataByName(panel.ausgewaehlterPixel.name, false);
										// specific data
										panel.pixelArray[i]
												.setIndividualData(panel.ausgewaehlterPixel.getIndividualData());
									}
								} else {

									panel.pixelArray[i].setDataByName(panel.ausgewaehlterPixel.name, false);
									// specific data
									panel.pixelArray[i].setIndividualData(panel.ausgewaehlterPixel.getIndividualData());
								}
							}

						}
					}
				}

			} else if (panel.drawRect) {

				panel.drawRect = false;
				int endPointPos[] = new int[2];

				int x, y;
				x = panel.mouseX;
				y = panel.mouseY;

				if (x < panel.startMousePos[0]) {
					x = panel.startMousePos[0] + 1;
				}
				if (y < panel.startMousePos[1]) {
					y = panel.startMousePos[1] + 1;
				}

				for (int i = panel.pixelArray.length - 1; i >= 0; i--) {

					if (panel.pixelArray[i].mouseOverPixel(x, y)) {
						endPointPos[0] = panel.pixelArray[i].posX;
						endPointPos[1] = panel.pixelArray[i].posY;
					}

					if (panel.pixelArray[i].posX >= panel.startMousePos[0] && panel.pixelArray[i].posX <= endPointPos[0]
							&& panel.pixelArray[i].posY >= panel.startMousePos[1]
							&& panel.pixelArray[i].posY <= endPointPos[1]) {
						panel.pixelArray[i].setDataByName(panel.ausgewaehlterPixel.name, false);
						// specific data
						panel.pixelArray[i].setIndividualData(panel.ausgewaehlterPixel.getIndividualData());
					}

				}

			} else // ausgewaehlter Pixel
			if (panel.auswahlPixelBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {
				panel.setToAuswahlMenu();
			} else
			// fillbox
			if (panel.fillBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {
				panel.fillMode = !panel.fillMode;
				panel.fillBox.fillRect = !panel.fillBox.fillRect;
			} else
			// brushsize Box
			if (panel.brushSizeBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {
				float verhaeltnis = 0;
				verhaeltnis = ((float) panel.mouseX - panel.brushSizeBox.posX) / panel.brushSizeBox.boxWidth;
				panel.brushSize = (int) (1 + Math.floor(verhaeltnis * panel.maxBrushSize));
				panel.brushColor = 255;
			} else
			// replace Box
			if (panel.replaceBlocksBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {
				panel.replaceBlocks = !panel.replaceBlocks;
				panel.replaceBlocksBox.fillRect = panel.replaceBlocks;
			}

		} else if (panel.settingsMenu) {
			if (panel.settingsBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {
				panel.setToGameScreen();
			} else if (panel.muteBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {
				panel.muteSound = !panel.muteSound;
				if (panel.muteSound) {
					panel.muteBox.imgIndex = 158;
				} else {
					panel.muteBox.imgIndex = 159;
				}
			} else if (panel.mutePlaceSoundBox.mouseOverPixel(panel.mouseX, panel.mouseY)) {
				panel.playPlaceSound = !panel.playPlaceSound;
				if (panel.playPlaceSound) {
					panel.mutePlaceSoundBox.imgIndex = 159;
				} else {
					panel.mutePlaceSoundBox.imgIndex = 158;
				}
			}

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("mouse entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("mouse exited");
	}

}

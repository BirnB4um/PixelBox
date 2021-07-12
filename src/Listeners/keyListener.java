package Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import mainPackage.MyPanel;
import mainPackage.Pixel;

public class keyListener implements KeyListener {
	MyPanel panel;

	public keyListener(MyPanel panel) {
		this.panel = panel;
	}

	@Override
	public void keyPressed(KeyEvent e) {

//		System.out.println(e.getKeyChar());
//		System.out.println(e.getKeyCode());
//		System.out.println();

		if (panel.gameScreen) {
			if (e.getKeyCode() == panel.KEY_V && !panel.copyMode) {
				if (panel.copyPixelList != null) {
					panel.drawPasteFrame = true;
				}
			}

		}
		if (e.getKeyCode() == panel.KEY_ESC && !e.isControlDown()) {// esc -> close
			System.exit(0);
		}

		if (panel.showInfo) {
			// change

			if (e.getKeyCode() == panel.KEY_UP) {// up
				panel.ausgewaehlteInfoNummer--;
				if (panel.ausgewaehlteInfoNummer < 1) {
					panel.ausgewaehlteInfoNummer = 15;
				}
			}

			if (e.getKeyCode() == panel.KEY_DOWN) {// down
				panel.ausgewaehlteInfoNummer++;
				if (panel.ausgewaehlteInfoNummer > 15) {
					panel.ausgewaehlteInfoNummer = 1;
				}
			}

			if (e.getKeyCode() == panel.KEY_PLUS || e.getKeyCode() == panel.KEY_RIGHT) {
				if (panel.ausgewaehlteInfoNummer == 1) {// lifecount
					panel.pixelArray[panel.mouseOverPixelIndex].lifecount++;
					panel.nextPixelArray[panel.mouseOverPixelIndex].lifecount = panel.pixelArray[panel.mouseOverPixelIndex].lifecount;
				} else if (panel.ausgewaehlteInfoNummer == 2) {// gravity
					panel.pixelArray[panel.mouseOverPixelIndex].gravity = !panel.pixelArray[panel.mouseOverPixelIndex].gravity;
					panel.nextPixelArray[panel.mouseOverPixelIndex].gravity = panel.pixelArray[panel.mouseOverPixelIndex].gravity;
				} else if (panel.ausgewaehlteInfoNummer == 3) {// fallUp
					panel.pixelArray[panel.mouseOverPixelIndex].fallUp = !panel.pixelArray[panel.mouseOverPixelIndex].fallUp;
					panel.nextPixelArray[panel.mouseOverPixelIndex].fallUp = panel.pixelArray[panel.mouseOverPixelIndex].fallUp;
				} else if (panel.ausgewaehlteInfoNummer == 4) {// slide
					panel.pixelArray[panel.mouseOverPixelIndex].slide = !panel.pixelArray[panel.mouseOverPixelIndex].slide;
					panel.nextPixelArray[panel.mouseOverPixelIndex].slide = panel.pixelArray[panel.mouseOverPixelIndex].slide;
				} else if (panel.ausgewaehlteInfoNummer == 5) {// flow
					panel.pixelArray[panel.mouseOverPixelIndex].flow = !panel.pixelArray[panel.mouseOverPixelIndex].flow;
					panel.nextPixelArray[panel.mouseOverPixelIndex].flow = panel.pixelArray[panel.mouseOverPixelIndex].flow;
				} else if (panel.ausgewaehlteInfoNummer == 6) {// dir
					if (panel.pixelArray[panel.mouseOverPixelIndex].dir < 8) {
						panel.pixelArray[panel.mouseOverPixelIndex].dir++;
						panel.nextPixelArray[panel.mouseOverPixelIndex].dir = panel.pixelArray[panel.mouseOverPixelIndex].dir;
					}
				} else if (panel.ausgewaehlteInfoNummer == 7) {// density
					if (panel.pixelArray[panel.mouseOverPixelIndex].density < 100) {
						panel.pixelArray[panel.mouseOverPixelIndex].density++;
						panel.nextPixelArray[panel.mouseOverPixelIndex].density = panel.pixelArray[panel.mouseOverPixelIndex].density;
					}
				} else if (panel.ausgewaehlteInfoNummer == 8) {// flammable
					panel.pixelArray[panel.mouseOverPixelIndex].flammable = !panel.pixelArray[panel.mouseOverPixelIndex].flammable;
					panel.nextPixelArray[panel.mouseOverPixelIndex].flammable = panel.pixelArray[panel.mouseOverPixelIndex].flammable;
				} else if (panel.ausgewaehlteInfoNummer == 9) {// onFire
					panel.pixelArray[panel.mouseOverPixelIndex].onFire = !panel.pixelArray[panel.mouseOverPixelIndex].onFire;
					panel.nextPixelArray[panel.mouseOverPixelIndex].onFire = panel.pixelArray[panel.mouseOverPixelIndex].onFire;
				} else if (panel.ausgewaehlteInfoNummer == 10) {// warm
					panel.pixelArray[panel.mouseOverPixelIndex].warm = !panel.pixelArray[panel.mouseOverPixelIndex].warm;
					panel.nextPixelArray[panel.mouseOverPixelIndex].warm = panel.pixelArray[panel.mouseOverPixelIndex].warm;
				} else if (panel.ausgewaehlteInfoNummer == 11) {// electricityStatus
					if (panel.pixelArray[panel.mouseOverPixelIndex].electricityStatus < 9999) {
						panel.pixelArray[panel.mouseOverPixelIndex].electricityStatus++;
						panel.nextPixelArray[panel.mouseOverPixelIndex].electricityStatus = panel.pixelArray[panel.mouseOverPixelIndex].electricityStatus;
					}
				} else if (panel.ausgewaehlteInfoNummer == 12) {// clone...
					if (panel.pixelArray[panel.mouseOverPixelIndex].otherPixelListIndex < panel.listOfAllItems.length
							- 1) {
						panel.pixelArray[panel.mouseOverPixelIndex].otherPixelListIndex++;
						panel.nextPixelArray[panel.mouseOverPixelIndex].otherPixelListIndex = panel.pixelArray[panel.mouseOverPixelIndex].otherPixelListIndex;
					}
				} else if (panel.ausgewaehlteInfoNummer == 13) {// repeater
					if (panel.pixelArray[panel.mouseOverPixelIndex].repeaterValue < 9999) {
						panel.pixelArray[panel.mouseOverPixelIndex].repeaterValue++;
						panel.nextPixelArray[panel.mouseOverPixelIndex].repeaterValue = panel.pixelArray[panel.mouseOverPixelIndex].repeaterValue;
					}
				} else if (panel.ausgewaehlteInfoNummer == 14) {// explodable
					panel.pixelArray[panel.mouseOverPixelIndex].explodable = !panel.pixelArray[panel.mouseOverPixelIndex].explodable;
					panel.nextPixelArray[panel.mouseOverPixelIndex].explodable = panel.pixelArray[panel.mouseOverPixelIndex].explodable;
				} else if (panel.ausgewaehlteInfoNummer == 15) {// conductor
					panel.pixelArray[panel.mouseOverPixelIndex].conductor = !panel.pixelArray[panel.mouseOverPixelIndex].conductor;
					panel.nextPixelArray[panel.mouseOverPixelIndex].conductor = panel.pixelArray[panel.mouseOverPixelIndex].conductor;
				}
			}
			if (e.getKeyCode() == panel.KEY_MINUS || e.getKeyCode() == panel.KEY_LEFT) {
				if (panel.ausgewaehlteInfoNummer == 1) {// lifecount
					panel.pixelArray[panel.mouseOverPixelIndex].lifecount--;
					panel.nextPixelArray[panel.mouseOverPixelIndex].lifecount = panel.pixelArray[panel.mouseOverPixelIndex].lifecount;
				} else if (panel.ausgewaehlteInfoNummer == 2) {// gravity
					panel.pixelArray[panel.mouseOverPixelIndex].gravity = !panel.pixelArray[panel.mouseOverPixelIndex].gravity;
					panel.nextPixelArray[panel.mouseOverPixelIndex].gravity = panel.pixelArray[panel.mouseOverPixelIndex].gravity;
				} else if (panel.ausgewaehlteInfoNummer == 3) {// fallUp
					panel.pixelArray[panel.mouseOverPixelIndex].fallUp = !panel.pixelArray[panel.mouseOverPixelIndex].fallUp;
					panel.nextPixelArray[panel.mouseOverPixelIndex].fallUp = panel.pixelArray[panel.mouseOverPixelIndex].fallUp;
				} else if (panel.ausgewaehlteInfoNummer == 4) {// slide
					panel.pixelArray[panel.mouseOverPixelIndex].slide = !panel.pixelArray[panel.mouseOverPixelIndex].slide;
					panel.nextPixelArray[panel.mouseOverPixelIndex].slide = panel.pixelArray[panel.mouseOverPixelIndex].slide;
				} else if (panel.ausgewaehlteInfoNummer == 5) {// flow
					panel.pixelArray[panel.mouseOverPixelIndex].flow = !panel.pixelArray[panel.mouseOverPixelIndex].flow;
					panel.nextPixelArray[panel.mouseOverPixelIndex].flow = panel.pixelArray[panel.mouseOverPixelIndex].flow;
				} else if (panel.ausgewaehlteInfoNummer == 6) {// dir
					if (panel.pixelArray[panel.mouseOverPixelIndex].dir > 0) {
						panel.pixelArray[panel.mouseOverPixelIndex].dir--;
						panel.nextPixelArray[panel.mouseOverPixelIndex].dir = panel.pixelArray[panel.mouseOverPixelIndex].dir;
					}
				} else if (panel.ausgewaehlteInfoNummer == 7) {// density
					if (panel.pixelArray[panel.mouseOverPixelIndex].density > -99) {
						panel.pixelArray[panel.mouseOverPixelIndex].density--;
						panel.nextPixelArray[panel.mouseOverPixelIndex].density = panel.pixelArray[panel.mouseOverPixelIndex].density;
					}
				} else if (panel.ausgewaehlteInfoNummer == 8) {// flammable
					panel.pixelArray[panel.mouseOverPixelIndex].flammable = !panel.pixelArray[panel.mouseOverPixelIndex].flammable;
					panel.nextPixelArray[panel.mouseOverPixelIndex].flammable = panel.pixelArray[panel.mouseOverPixelIndex].flammable;
				} else if (panel.ausgewaehlteInfoNummer == 9) {// onFire
					panel.pixelArray[panel.mouseOverPixelIndex].onFire = !panel.pixelArray[panel.mouseOverPixelIndex].onFire;
					panel.nextPixelArray[panel.mouseOverPixelIndex].onFire = panel.pixelArray[panel.mouseOverPixelIndex].onFire;
				} else if (panel.ausgewaehlteInfoNummer == 10) {// warm
					panel.pixelArray[panel.mouseOverPixelIndex].warm = !panel.pixelArray[panel.mouseOverPixelIndex].warm;
					panel.nextPixelArray[panel.mouseOverPixelIndex].warm = panel.pixelArray[panel.mouseOverPixelIndex].warm;
				} else if (panel.ausgewaehlteInfoNummer == 11) {// electricityStatus
					if (panel.pixelArray[panel.mouseOverPixelIndex].electricityStatus > -9999) {
						panel.pixelArray[panel.mouseOverPixelIndex].electricityStatus--;
						panel.nextPixelArray[panel.mouseOverPixelIndex].electricityStatus = panel.pixelArray[panel.mouseOverPixelIndex].electricityStatus;
					}
				} else if (panel.ausgewaehlteInfoNummer == 12) {// clone...
					if (panel.pixelArray[panel.mouseOverPixelIndex].otherPixelListIndex > 0) {
						panel.pixelArray[panel.mouseOverPixelIndex].otherPixelListIndex--;
						panel.nextPixelArray[panel.mouseOverPixelIndex].otherPixelListIndex = panel.pixelArray[panel.mouseOverPixelIndex].otherPixelListIndex;
					}
				} else if (panel.ausgewaehlteInfoNummer == 13) {// repeater
					if (panel.pixelArray[panel.mouseOverPixelIndex].repeaterValue > -9999) {
						panel.pixelArray[panel.mouseOverPixelIndex].repeaterValue--;
						panel.nextPixelArray[panel.mouseOverPixelIndex].repeaterValue = panel.pixelArray[panel.mouseOverPixelIndex].repeaterValue;
					}
				} else if (panel.ausgewaehlteInfoNummer == 14) {// explodable
					panel.pixelArray[panel.mouseOverPixelIndex].explodable = !panel.pixelArray[panel.mouseOverPixelIndex].explodable;
					panel.nextPixelArray[panel.mouseOverPixelIndex].explodable = panel.pixelArray[panel.mouseOverPixelIndex].explodable;
				} else if (panel.ausgewaehlteInfoNummer == 15) {// conductor
					panel.pixelArray[panel.mouseOverPixelIndex].conductor = !panel.pixelArray[panel.mouseOverPixelIndex].conductor;
					panel.nextPixelArray[panel.mouseOverPixelIndex].conductor = panel.pixelArray[panel.mouseOverPixelIndex].conductor;
				}

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == panel.KEY_ENTER && e.isControlDown() && e.isAltGraphDown()) {
			panel.devMode = !panel.devMode;
		}

		if (panel.gameScreen) {

			if (panel.showInfo) {

				if (e.getKeyCode() == panel.KEY_1)
					panel.ausgewaehlteInfoNummer = 1;
				if (e.getKeyCode() == panel.KEY_2)
					panel.ausgewaehlteInfoNummer = 2;
				if (e.getKeyCode() == panel.KEY_3)
					panel.ausgewaehlteInfoNummer = 3;
				if (e.getKeyCode() == panel.KEY_4)
					panel.ausgewaehlteInfoNummer = 4;
				if (e.getKeyCode() == panel.KEY_5)
					panel.ausgewaehlteInfoNummer = 5;
				if (e.getKeyCode() == panel.KEY_6)
					panel.ausgewaehlteInfoNummer = 6;
				if (e.getKeyCode() == panel.KEY_7)
					panel.ausgewaehlteInfoNummer = 7;
				if (e.getKeyCode() == panel.KEY_8)
					panel.ausgewaehlteInfoNummer = 8;
				if (e.getKeyCode() == panel.KEY_9)
					panel.ausgewaehlteInfoNummer = 9;

				if (e.getKeyCode() == panel.KEY_0) {// reset

					// panel.pixelArray[panel.mouseOverPixelIndex].clonePixelListIndex = 0;
					// panel.nextPixelArray[panel.mouseOverPixelIndex].clonePixelListIndex = 0;
					//
					// panel.pixelArray[panel.mouseOverPixelIndex].electricityStatus = 0;
					// panel.nextPixelArray[panel.mouseOverPixelIndex].electricityStatus = 0;
					// panel.pixelArray[panel.mouseOverPixelIndex].repeaterValue = 1;
					// panel.nextPixelArray[panel.mouseOverPixelIndex].repeaterValue = 1;

					panel.pixelArray[panel.mouseOverPixelIndex]
							.setDataByName(panel.pixelArray[panel.mouseOverPixelIndex].name, true);

				}
			}

			if (e.getKeyCode() == panel.KEY_I) {// toggle show info
				panel.showInfo = !panel.showInfo;
				if (panel.showInfo) {
					panel.ausgewaehlteInfoNummer = 1;
				}
			}

			if (e.getKeyCode() == panel.KEY_A) {// analyse

				int anzahlElement[] = new int[panel.listOfAllItems.length];

				for (int i = 0; i < panel.pixelArray.length; i++) {
					anzahlElement[panel.pixelArray[i].getIndexInList(panel.pixelArray[i].name)]++;
				}
				System.out.println();
				System.out.println("============");
				System.out.println("  Analyse:");
				for (int i = 0; i < anzahlElement.length; i++) {
					if (anzahlElement[i] > 0)
						System.out.println(panel.listOfAllItems[i] + ": " + anzahlElement[i]);
				}

			}

			if (e.getKeyCode() == panel.KEY_V && !panel.copyMode) {
				if (panel.copyPixelList != null) {
					panel.drawCopyList(panel.mouseOverPixelIndex);
				}
				panel.drawPasteFrame = false;
			}

			if (e.getKeyCode() == panel.KEY_SPACE) {// pause
				panel.pause = !panel.pause;
			}
			if (e.getKeyCode() == panel.KEY_F) {// fillmode
				panel.fillMode = !panel.fillMode;
				panel.fillBox.fillRect = !panel.fillBox.fillRect;
			}
			if (e.getKeyCode() == panel.KEY_B) {// replace Blocks mode
				panel.replaceBlocks = !panel.replaceBlocks;
				panel.replaceBlocksBox.fillRect = panel.replaceBlocks;
			}
			if (e.getKeyCode() == panel.KEY_C && !panel.drawPasteFrame) {// copymode
				panel.copyMode = !panel.copyMode;

				if (!panel.copyMode) {// reset copy points
					panel.copyStartpoint = null;
					panel.copyEndpoint = null;
				}

			}
			if (e.getKeyCode() == panel.KEY_R) {// randomize

				for (int i = 0; i < panel.pixelArray.length; i++) {
					String str = "TNT";
					while (str == "TNT" || str == "Nitro" || str == "Lufter" || str == "Cweeper" || str == "Uran"
							|| str == "Napalm") {
						str = panel.listOfAllItems[panel.rand.nextInt(panel.listOfAllItems.length)];
					}
					panel.pixelArray[i].setDataByName(str, true);
					panel.nextPixelArray[i].setDataByName(str, true);
				}

			}

			// undo
			if (e.getKeyCode() == panel.KEY_Z && !panel.showInfo && panel.pause) {
				panel.undoPosition--;
				if (panel.historyPixelList.size() - 1 + panel.undoPosition < 0) {
					panel.undoPosition = -panel.historyPixelList.size() + 1;
				}

				// update pixelArray
				for (int i = 0; i < panel.pixelArray.length; i++) {
					panel.pixelArray[i].setDataByName(
							panel.historyPixelList.get(panel.historyPixelList.size() - 1 + panel.undoPosition)[i].name,
							false);
					panel.pixelArray[i].setIndividualData(
							panel.historyPixelList.get(panel.historyPixelList.size() - 1 + panel.undoPosition)[i]
									.getIndividualData());
				}
			}

			// redo
			if (e.getKeyCode() == panel.KEY_Y && !panel.showInfo && panel.pause) {
				for (int i = 0; i < panel.pixelArray.length; i++) {

					if (panel.undoPosition < 0) {

						// step forward in historyList
						panel.pixelArray[i].setDataByName(
								panel.historyPixelList
										.get(panel.historyPixelList.size() - 1 + panel.undoPosition + 1)[i].name,
								false);
						panel.pixelArray[i].setIndividualData(panel.historyPixelList
								.get(panel.historyPixelList.size() - 1 + panel.undoPosition + 1)[i]
										.getIndividualData());
					}
				}
				if (panel.undoPosition < 0)
					panel.undoPosition++;
			}

			// right arrow
			if (e.getKeyCode() == panel.KEY_RIGHT && !panel.showInfo && panel.pause) {// one step

				/*
				 * ========================== Main loop ================================
				 */
				Pixel[] undoList = new Pixel[panel.pixelArray.length];
				panel.removeNewestStepsFromHistoryList();
				for (int y = panel.anzahlPixelHeight - 1; y >= -4; y--) {// each row in pixelArray + buffer

					@SuppressWarnings("unchecked")
					ArrayList<Integer> this_changeIndexList = (ArrayList<Integer>) panel.changeIndexList.clone();

					for (int x = panel.anzahlPixelWidth - 1; x >= 0; x--) {// col in row
						int i = y * panel.anzahlPixelWidth + x;

						// ===================================================================================================

						// copy pixelArray in nextPixelArray
						if (i >= 0) {

							panel.nextPixelArray[i].setDataByName(panel.pixelArray[i].name, false);
							panel.nextPixelArray[i].setIndividualData(panel.pixelArray[i].getIndividualData());

						}

						// ===================================================================================================

//						if (panel.undoPosition == 0) {
						// update
						if (y <= panel.anzahlPixelHeight - 3 && y >= -2) {
							int index = panel.rand.nextInt(this_changeIndexList.size());// random
							// index = this_changeIndexList.size() - 1;// right -> left

							int n = (y + 2) * panel.anzahlPixelWidth + this_changeIndexList.get(index);

							panel.pixelArray[n].update(n);

							this_changeIndexList.remove(index);

						}

						// ===================================================================================================

						// copy nextPixelArray in pixelArray
						if (y <= panel.anzahlPixelHeight - 5) {
							int n = (y + 4) * panel.anzahlPixelWidth + x;

							panel.pixelArray[n].setDataByName(panel.nextPixelArray[n].name, false);
							panel.pixelArray[n].setIndividualData(panel.nextPixelArray[n].getIndividualData());

							// fill undoPixelList
							undoList[n] = new Pixel(panel.pixelArray[n].posX, panel.pixelArray[n].posY, panel, "Air");
							undoList[n].setDataByName(panel.pixelArray[n].name, false);
							undoList[n].setIndividualData(panel.pixelArray[n].getIndividualData());

						}

						// ===================================================================================================

//						}

					}

				}
				panel.undoPosition = 0;

				// add undoList to historyPixelsList
//				if (panel.undoPosition == 0) {
				panel.historyPixelList.add(undoList);

				// remove oldest list if max size
				while (panel.historyPixelList.size() > panel.maxHistorySize) {
					panel.historyPixelList.remove(0);
				}
//				}

				/*
				 * ========================== end of Main loop ================================
				 */

			}
			if (e.getKeyCode() == panel.KEY_X) {
				// reset zoom & offset
//				panel.zoomFactor = 1;
//				panel.offsetX = 0;
//				panel.offsetY = 0;

				for (int i = 0; i < panel.pixelArray.length; i++) {
					panel.pixelArray[i].setDataByName("Air", true);
					panel.nextPixelArray[i].setDataByName("Air", true);
				}

				panel.removeNewestStepsFromHistoryList();

//				panel.resetSounds = true;
			}
			if (e.getKeyCode() == panel.KEY_G) {
				panel.drawGrid = !panel.drawGrid;
			}
		}
		if (e.getKeyCode() == panel.KEY_E) {// inventory
			panel.auswahlMenu = !panel.auswahlMenu;
			if (panel.auswahlMenu) {
				panel.setToAuswahlMenu();
			} else {
				panel.setToGameScreen();
			}
		}
		if (e.getKeyCode() == panel.KEY_H) {// toggle helpmenu
			panel.helpMenu = !panel.helpMenu;
			if (panel.helpMenu) {
				panel.setToHelpMenu();
			} else {
				panel.setToGameScreen();
			}
		}
		if (e.getKeyCode() == panel.KEY_S) {// toggle settingsmenu
			panel.settingsMenu = !panel.settingsMenu;
			if (panel.settingsMenu) {
				panel.setToSettingsMenu();
			} else {
				panel.setToGameScreen();
			}
		}

		if (e.getKeyCode() == panel.KEY_M) {// toggle settingsmenu
			panel.muteSound = !panel.muteSound;
			if (panel.muteSound) {
				panel.muteBox.imgIndex = 158;
			} else {
				panel.muteBox.imgIndex = 159;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}


package mainPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Pixel {
	MyPanel panel;

	public int posX;
	public int posY;

	public String name;
	public Color color;

	// element eigenschaften
	public boolean flammable;
	public boolean gravity;
	public boolean fallUp;
	public boolean slide;
	public boolean flow;
	public boolean conductor;
	public int lifecount;
	public boolean onFire;
	public boolean explodable;
	public int electricityStatus;// <=0 -> free / >=1 -> spark
	public int density;// 1,2,3,4,5 = gas | 6,7,8,9,10 = liquid | 11,12,13,14,15 = solid
	public boolean warm;
	public int repeaterValue;
	public int dir;// 0,1,2 | 3,4,5 | 6,7,8
	public int otherPixelListIndex;
	public int fallDamage;
	public int transmissionData;

	public Pixel(int _x, int _y, MyPanel panel, String name) {
		this.panel = panel;
		lifecount = 0;

		this.posX = _x;
		this.posY = _y;

		setDataByName(name, true);

	}

	public void setDataByName(String name, boolean startwerte) {
		this.name = name;
		flammable = false;
		fallUp = false;
		slide = false;
		gravity = false;
		onFire = false;
		flow = false;
		warm = false;
		conductor = false;
		explodable = false;
		electricityStatus = 0;
		dir = 0;
		repeaterValue = 1;
		otherPixelListIndex = 0;
		fallDamage = 0;
		transmissionData = 0;

		if (name == "Coming Soon") {
			density = 0;
			color = new Color(20, 0, 0);
			if (startwerte) {
				lifecount = 0;
			}
		} else if (name == "Air") {
			density = 1;
			color = new Color(0, 0, 0);
			if (startwerte) {
				lifecount = 1;
			}
		} else if (name == "Dirt") {
			gravity = true;
			density = 13;
			color = new Color(110, 50, 0);
			if (startwerte) {
				lifecount = panel.dirt_lifecount;
			}
		} else if (name == "Sand") {
			gravity = true;
			density = 12;
			slide = true;
			color = new Color(240, 190, 90);
			if (startwerte) {
				lifecount = panel.sand_lifecount;
			}
		} else if (name == "Water") {
			gravity = true;
			density = 8;
			slide = true;
			flow = true;
			color = new Color(10, 10, 240);
			if (startwerte) {
				lifecount = panel.water_lifecount;
			}
		} else if (name == "Lava") {
			gravity = true;
			density = 10;
			slide = true;
			onFire = true;
			flow = true;
			color = new Color(240, 40, 0);
			if (startwerte) {
				lifecount = panel.lava_lifecount;
			}
		} else if (name == "Fire") {
			fallUp = true;
			slide = true;
			density = 2;
			onFire = true;
			color = new Color(255, 150, 0);
			if (startwerte) {
				lifecount = panel.fire_lifecount;
			}
		} else if (name == "Steam") {
			fallUp = true;
			density = 2;
			slide = true;
			color = new Color(200, 200, 200);
			if (startwerte) {
				lifecount = panel.steam_lifecount;
			}
		} else if (name == "Wood") {
			flammable = true;
			density = 13;
			color = new Color(55, 40, 20);
			if (startwerte) {
				lifecount = panel.wood_lifecount;
			}
		} else if (name == "Cloud") {
			fallUp = true;
			slide = true;
			density = 2;
			flow = true;
			color = new Color(190, 190, 220);
			if (startwerte) {
				lifecount = panel.wood_lifecount;
			}
		} else if (name == "Smoke") {
			fallUp = true;
			slide = true;
			flow = true;
			density = 5;
			color = new Color(70, 70, 70);
			if (startwerte) {
				lifecount = panel.smoke_lifecount;
			}
		} else if (name == "Stone") {
			density = 14;
			color = new Color(50, 50, 50);
			if (startwerte) {
				lifecount = panel.stone_lifecount;
			}
		} else if (name == "Leaf") {
			flammable = true;
			density = 11;
			color = new Color(10, 120, 10);
			if (startwerte) {
				lifecount = panel.leaf_lifecount;
			}
		} else if (name == "Oil") {
			flammable = true;
			gravity = true;
			slide = true;
			density = 6;
			flow = true;
			color = new Color(50, 10, 0);
			if (startwerte) {
				lifecount = panel.oil_lifecount;
			}
		} else if (name == "Fuse") {
			flammable = true;
			density = 12;
			color = new Color(200, 200, 140);
			if (startwerte) {
				lifecount = panel.fuse_lifecount;
			}
		} else if (name == "Gas") {
			flammable = true;
			fallUp = true;
			slide = true;
			flow = true;
			density = 3;
			color = new Color(200, 150, 150);
			if (startwerte) {
				lifecount = panel.gas_lifecount;
			}
		} else if (name == "TNT") {
			explodable = true;
			flammable = true;
			gravity = true;
			density = 12;
			color = new Color(255, 0, 0);
			if (startwerte) {
				lifecount = panel.tnt_lifecount;
			}
		} else if (name == "Bird") {
			flammable = true;
			density = 12;
			color = new Color(110, 110, 135);
			if (startwerte) {
				lifecount = panel.bird_lifecount;
				dir = 5;
			}
		} else if (name == "Acid") {
			gravity = true;
			density = 8;
			slide = true;
			flow = true;
			color = new Color(80, 255, 0);
			if (startwerte) {
				lifecount = panel.acid_lifecount;
			}
		} else if (name == "Glass") {
			density = 12;
			color = new Color(200, 200, 200);
			if (startwerte) {
				lifecount = panel.glass_lifecount;
			}
		} else if (name == "Ash") {
			gravity = true;
			slide = true;
			density = 12;
			color = new Color(75, 75, 75);
			if (startwerte) {
				lifecount = panel.ash_lifecount;
			}
		} else if (name == "Bee") {
			flammable = true;
			density = 12;
			color = new Color(200, 170, 0);
			if (startwerte) {
				lifecount = panel.bee_lifecount;
				dir = 5;
			}
		} else if (name == "Wax") {
			density = 12;
			color = new Color(255, 160, 50);
			if (startwerte) {
				lifecount = panel.wax_lifecount;
			}
		} else if (name == "Metal") {
			conductor = true;
			density = 14;
			color = new Color(110, 110, 110);
			if (startwerte) {
				lifecount = panel.metal_lifecount;
			}
		} else if (name == "Spark") {
			density = 3;
			gravity = true;
			slide = true;
			onFire = true;
			color = new Color(255, 200, 0);
			if (startwerte) {
				lifecount = panel.spark_lifecount;
			}
		} else if (name == "Cloner") {
			density = 15;
			color = new Color(200, 100, 120);
			if (startwerte) {
				lifecount = panel.cloner_lifecount;
			}
		} else if (name == "Ice") {
			density = 12;
			color = new Color(110, 180, 255);
			if (startwerte) {
				lifecount = panel.ice_lifecount;
			}
		} else if (name == "Nitro") {
			explodable = true;
			gravity = true;
			slide = true;
			flow = true;
			flammable = true;
			density = 7;
			color = new Color(50, 120, 10);
			if (startwerte) {
				lifecount = panel.nitro_lifecount;
			}
		} else if (name == "Salt") {
			gravity = true;
			slide = true;
			density = 12;
			color = new Color(220, 220, 220);
			if (startwerte) {
				lifecount = panel.salt_lifecount;
			}
		} else if (name == "Saltwater") {
			conductor = true;
			gravity = true;
			slide = true;
			flow = true;
			density = 9;
			color = new Color(50, 120, 220);
			if (startwerte) {
				lifecount = panel.saltwater_lifecount;
			}
		} else if (name == "Lufter") {
			density = 15;
			color = new Color(130, 30, 30);
			if (startwerte) {
				lifecount = 1000000;
			}
		} else if (name == "Battery") {
			density = 13;
			color = new Color(180, 120, 0);
			if (startwerte) {
				lifecount = panel.Battery_lifecount;
			}
		} else if (name == "Grass") {
			gravity = true;
			flammable = true;
			density = 13;
			color = new Color(40, 100, 0);
			if (startwerte) {
				lifecount = panel.grass_lifecount;
			}
		} else if (name == "Repeater") {
			conductor = true;
			density = 14;
			repeaterValue = 1;
			color = new Color(150, 70, 70);
			if (startwerte) {
				lifecount = panel.metal_lifecount;
			}
		} else if (name == "Barrier") {
			density = 14;
			color = new Color(240, 0, 0);
			if (startwerte) {
				lifecount = 999999;
			}
		} else if (name == "Fish") {
			slide = true;
			gravity = true;
			density = 12;
			color = new Color(0, 150, 255);
			if (startwerte) {
				lifecount = panel.fish_lifecount;
				dir = 3;
			}
		} else if (name == "Pig") {
			gravity = true;
			density = 13;
			flammable = true;
			color = new Color(240, 70, 130);
			if (startwerte) {
				lifecount = panel.pig_lifecount;
				dir = 3;
			}
		} else if (name == "Cweeper") {
			explodable = true;
			gravity = true;
			flammable = true;
			density = 13;
			color = new Color(40, 120, 0);
			if (startwerte) {
				lifecount = panel.Cweeper_lifecount;
				dir = 3;
			}
		} else if (name == "Uran") {
			gravity = true;
			slide = true;
			density = 13;
			color = new Color(60, 80, 60);
			if (startwerte) {
				lifecount = panel.uran_lifecount;
			}
		} else if (name == "Napalm") {
			gravity = true;
			slide = true;
			flow = true;
			density = 7;
			color = new Color(200, 180, 20);
			if (startwerte) {
				lifecount = panel.napalm_lifecount;
			}
		} else if (name == "Gravitychanger") {
			density = 13;
			color = new Color(255, 150, 240);
			if (startwerte) {
				lifecount = panel.gravitychanger_lifecount;
			}
		} else if (name == "Blood") {
			gravity = true;
			flow = true;
			slide = true;
			density = 7;
			color = new Color(170, 0, 20);
			if (startwerte) {
				lifecount = panel.gravitychanger_lifecount;
			}
		} else if (name == "Lead") {
			conductor = true;
			density = 14;
			color = new Color(85, 90, 85);
			if (startwerte) {
				lifecount = panel.lead_lifecount;
			}
		} else if (name == "Transmitter") {
			density = 14;
			color = new Color(255, 100, 170);
			if (startwerte) {
				lifecount = panel.transmitter_lifecount;
			}
		} else if (name == "Receiver") {
			density = 14;
			color = new Color(90, 80, 255);
			if (startwerte) {
				lifecount = panel.receiver_lifecount;
			}
		}
	}

	void info(Graphics2D g2D) {
		int w = 300;
		w = panel.constrain(w, 250, 2000);
		int h = 560;

		int dx = 5;
		int dy = 5;

		if (panel.mouseX < panel.offsetLeft + w + dx && panel.mouseX > panel.offsetLeft + dx
				&& panel.mouseY > panel.offsetUp + dy && panel.mouseY < panel.offsetUp + h + dy) {
			dx = w + 50;
		}

		g2D.setStroke(new BasicStroke(4));
		g2D.setColor(new Color(37, 37, 57));
		g2D.fillRect(panel.offsetLeft + dx, panel.offsetUp + dy, w, h);
		g2D.setColor(new Color(90, 90, 130));
		g2D.drawRect(panel.offsetLeft + dx, panel.offsetUp + dy, w, h);

		g2D.setFont(new Font("Bauhaus", Font.ITALIC, 35));
		g2D.setFont(panel.myFont);
		g2D.setColor(Color.white);
		if (name == "Gravitychanger") {
			g2D.drawString("G-Changer", panel.offsetLeft + 20 + dx, panel.offsetUp + 40 + dy);
		} else {
			g2D.drawString(name, panel.offsetLeft + 20 + dx, panel.offsetUp + 40 + dy);
		}

		g2D.setFont(new Font("Dialoge", Font.ITALIC, 16));
		g2D.setColor(Color.white);
		g2D.drawString("X: " + Integer.toString(panel.mouseOverPixelIndex % panel.anzahlPixelWidth),
				panel.offsetLeft + 70 + dx, panel.offsetUp + 520 + dy);
		g2D.drawString("Y: " + Integer.toString((int) (panel.mouseOverPixelIndex / panel.anzahlPixelWidth)),
				panel.offsetLeft + 150 + dx, panel.offsetUp + 520 + dy);

		g2D.setColor(new Color(90, 90, 130));
		g2D.drawLine(panel.offsetLeft + dx, panel.offsetUp + 60 + dy, panel.offsetLeft + w + dx,
				panel.offsetUp + 60 + dy);

		// ===========

		g2D.setFont(new Font("Dialog", Font.ITALIC, 20));
		g2D.setColor(Color.white);

		g2D.drawString("1. Lifecount: " + Integer.valueOf(lifecount), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 2 / 20);

		g2D.drawString("2. Gravitation: " + Boolean.valueOf(gravity), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 3 / 20);

		g2D.drawString("3. Fall up: " + Boolean.valueOf(fallUp), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 4 / 20);

		g2D.drawString("4. Slide: " + Boolean.valueOf(slide), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 5 / 20);

		g2D.drawString("5. Liquid: " + Boolean.valueOf(flow), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 6 / 20);

		g2D.drawString("6. Direction: " + Integer.valueOf(dir), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 7 / 20);

		g2D.drawString("7. Density: " + Integer.valueOf(density), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 8 / 20);

		g2D.drawString("8. Flammable: " + Boolean.valueOf(flammable), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 9 / 20);

		g2D.drawString("9. Burning: " + Boolean.valueOf(onFire), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 10 / 20);

		g2D.drawString("10. Warm: " + Boolean.valueOf(warm), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 11 / 20);

		g2D.drawString("11. Electricitystatus: " + Integer.valueOf(electricityStatus), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 12 / 20);

		g2D.drawString("12. Clone Block: " + panel.listOfAllItems[otherPixelListIndex], panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 13 / 20);

		g2D.drawString("13. Delay: " + Integer.valueOf(repeaterValue), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 14 / 20);

		g2D.drawString("14. Explodable: " + Boolean.valueOf(explodable), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 15 / 20);

		g2D.drawString("15. Conductor: " + Boolean.valueOf(conductor), panel.offsetLeft + 20 + dx,
				panel.offsetUp + 40 + dy + h * 16 / 20);

		// kasten
		g2D.setStroke(new BasicStroke(3));
		g2D.setColor(new Color(180, 180, 180));

		if (panel.ausgewaehlteInfoNummer > 15) {
			panel.ausgewaehlteInfoNummer = 15;
		}
		g2D.drawRect(panel.offsetLeft + 10 + dx, panel.offsetUp + 16 + dy + h * (panel.ausgewaehlteInfoNummer + 1) / 20,
				w - 20, 30);

		g2D.setFont(new Font("Dialog", Font.BOLD, 12));
		g2D.drawString("up / down     |     - / + or left / right", panel.offsetLeft + 60 + dx,
				panel.offsetUp + 40 + dy + h * 18 / 20);

	}

	public boolean mouseOverPixel(float mouseX, float mouseY) {
		if (mouseX > posX && mouseX <= posX + panel.pixelWidth * panel.zoomFactor && mouseY > posY
				&& mouseY <= posY + panel.pixelHeight * panel.zoomFactor) {
			return true;
		}
		return false;
	}

	void draw(Graphics2D g2D) {
		g2D.setColor(color);
		if (name == "Steam") {
			g2D.setColor(new Color(panel.constrain(20 * lifecount, 0, 255), panel.constrain(20 * lifecount, 0, 255),
					panel.constrain(20 * lifecount, 0, 255)));
		} else if (name == "Fire") {
			// old flame
//			g2D.setColor(new Color(panel.constrain(100 * (6 - lifecount) + 80, 0, 255),
//					panel.constrain(24 * (6 - lifecount), 0, 255), 0));

			// r 255-130 | g 170-0 | b 40-0
			g2D.setColor(
					new Color(130 + panel.constrain((int) (125 * ((float) lifecount / panel.fire_lifecount)), 0, 255),
							panel.constrain((int) (-200 + 370 * ((float) lifecount / panel.fire_lifecount)), 0, 255),
							panel.constrain((int) (40 * ((float) lifecount / panel.fire_lifecount)), 0, 255)));

			// pink flame
			if (panel.pixelArray[0].name == "Glass") {
				g2D.setColor(new Color(
						130 + panel.constrain((int) (125 * ((float) lifecount / panel.fire_lifecount)), 0, 255),
						panel.constrain((int) (-200 + 370 * ((float) lifecount / panel.fire_lifecount)), 0, 255),
						panel.constrain((int) (255 * ((float) lifecount / panel.fire_lifecount)), 0, 255)));
			}

		} else if (name == "Lava") {
			g2D.setColor(new Color(panel.constrain(lifecount * 30 + 100, 0, 255), 0, 0));
		} else if (name == "Wood" && onFire) {
			g2D.setColor(new Color(120, 60, 40));
		} else if (name == "Cloud") {
			g2D.setColor(new Color(panel.constrain(20 * lifecount, 0, 255), panel.constrain(20 * lifecount, 0, 255),
					panel.constrain(20 * lifecount, 0, 255)));
		} else if (name == "Smoke") {
			g2D.setColor(new Color(panel.constrain(5 * lifecount, 0, 255), panel.constrain(5 * lifecount, 0, 255),
					panel.constrain(5 * lifecount, 0, 255)));
		} else if (name == "Fuse" && onFire) {
			g2D.setColor(new Color(panel.constrain(140 * (panel.fuse_lifecount - lifecount) + 80, 0, 255),
					panel.constrain(40 * (panel.fuse_lifecount - lifecount), 0, 255), 0));
		} else if (name == "Oil" && onFire) {
			g2D.setColor(new Color(120, 20, 0));
		} else if (name == "Bird" && onFire) {
			g2D.setColor(new Color(60, 60, 75));
		} else if (name == "Bee" && onFire) {
			g2D.setColor(new Color(140, 100, 0));
		} else if (name == "Wax" && flow) {
			g2D.setColor(new Color(180, 100, 20));
		} else if (name == "Barrier" && panel.ausgewaehlterPixel.name != "Barrier") {
			g2D.setColor(new Color(0, 0, 0));
			if (panel.drawGrid) {
				g2D.setColor(new Color(30, 0, 0));
			}
		} else if (name == "Cweeper" && onFire) {
			g2D.setColor(new Color((lifecount % 2 == 0) ? 255 : 40, (lifecount % 2 == 0) ? 255 : 120,
					(lifecount % 2 == 0) ? 255 : 0));
		} else if (name == "TNT" && onFire) {
			g2D.setColor(new Color((lifecount % 2 == 0) ? 255 : 255, (lifecount % 2 == 0) ? 255 : 0,
					(lifecount % 2 == 0) ? 255 : 0));
		}

		if (conductor && electricityStatus >= 1) {
			g2D.setColor(new Color(240, 180, 0));
		}

		g2D.fillRect(posX, posY, panel.pixelWidth * panel.zoomFactor, panel.pixelHeight * panel.zoomFactor);

		if (transmissionData > 0) {
			int a = panel.constrain((long) (255 * ((float) transmissionData / panel.maxTransmissionData)), 0, 255);
			g2D.setColor(new Color(a, a, a, a));
			g2D.fillRect(posX, posY, panel.pixelWidth * panel.zoomFactor, panel.pixelHeight * panel.zoomFactor);
		}
	}

	void switchPixels(int i, int nachbarPixelIndex) {

		// nachbar nextpixel auf this nextPixel
		panel.nextPixelArray[i].setDataByName(panel.nextPixelArray[nachbarPixelIndex].name, false);
		// individual data
		panel.nextPixelArray[i].setIndividualData(panel.nextPixelArray[nachbarPixelIndex].getIndividualData());

		// this pixel auf nachbar nextplatz
		panel.nextPixelArray[nachbarPixelIndex].setDataByName(panel.pixelArray[i].name, false);
		// individual data
		panel.nextPixelArray[nachbarPixelIndex].setIndividualData(panel.pixelArray[i].getIndividualData());

	}

	public int[] getIndividualData() {
		int[] data = { lifecount, gravity ? 1 : 0, fallUp ? 1 : 0, slide ? 1 : 0, flow ? 1 : 0, dir, density,
				flammable ? 1 : 0, onFire ? 1 : 0, warm ? 1 : 0, electricityStatus, otherPixelListIndex, repeaterValue,
				fallDamage, explodable ? 1 : 0, conductor ? 1 : 0, transmissionData };
		return data;
	}

	public void setIndividualData(int[] data) {
		lifecount = data[0];
		gravity = data[1] == 1;
		fallUp = data[2] == 1;
		slide = data[3] == 1;
		flow = data[4] == 1;
		dir = data[5];
		density = data[6];
		flammable = data[7] == 1;
		onFire = data[8] == 1;
		warm = data[9] == 1;
		electricityStatus = data[10];
		otherPixelListIndex = data[11];
		repeaterValue = data[12];
		fallDamage = data[13];
		explodable = data[14] == 1;
		conductor = data[15] == 1;
		transmissionData = data[16];
	}

	void setAngrenzenderNachbar(int i, String name, String ausnahme) {
		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].name != ausnahme) {// up
			panel.pixelArray[i - panel.anzahlPixelWidth].setDataByName("Air", true);
			panel.nextPixelArray[i - panel.anzahlPixelWidth].setDataByName("Air", true);
		}
		if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].name != ausnahme) {// left
			panel.pixelArray[i - 1].setDataByName("Air", true);
			panel.nextPixelArray[i - 1].setDataByName("Air", true);
		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].name != ausnahme) {// right
			panel.pixelArray[i + 1].setDataByName("Air", true);
			panel.nextPixelArray[i + 1].setDataByName("Air", true);
		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].name != ausnahme) {// down
			panel.pixelArray[i + panel.anzahlPixelWidth].setDataByName("Air", true);
			panel.nextPixelArray[i + panel.anzahlPixelWidth].setDataByName("Air", true);
		}
	}

	int getAngrenzenderNachbar(int i, String nachbarName) {

		// get angrenzenden nachbar mit spezifischem namen

		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].name == nachbarName) {// up
			return i - panel.anzahlPixelWidth;
		}
		if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].name == nachbarName) {// left
			return i - 1;
		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].name == nachbarName) {// right
			return i + 1;
		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].name == nachbarName) {// down
			return i + panel.anzahlPixelWidth;
		}

		return -1;
	}

	int getAngrenzenderCloner(int i) {

		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].name == "Cloner"
				&& panel.pixelArray[i - panel.anzahlPixelWidth].otherPixelListIndex != 0) {// up
			return i - panel.anzahlPixelWidth;
		}
		if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].name == "Cloner"
				&& panel.pixelArray[i - 1].otherPixelListIndex != 0) {// left
			return i - 1;
		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].name == "Cloner"
				&& panel.pixelArray[i + 1].otherPixelListIndex != 0) {// right
			return i + 1;
		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].name == "Cloner"
				&& panel.pixelArray[i + panel.anzahlPixelWidth].otherPixelListIndex != 0) {// down
			return i + panel.anzahlPixelWidth;
		}

		return -1;
	}

	int getAngrenzenderNachbar_Conductor(int i, int eStatus) {

		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].conductor
				&& panel.pixelArray[i - panel.anzahlPixelWidth].electricityStatus == eStatus) {// up

			return i - panel.anzahlPixelWidth;
		}
		if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].conductor
				&& panel.pixelArray[i - 1].electricityStatus == eStatus) {// left

			return i - 1;
		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].conductor
				&& panel.pixelArray[i + 1].electricityStatus == eStatus) {// right

			return i + 1;
		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].conductor
				&& panel.pixelArray[i + panel.anzahlPixelWidth].electricityStatus == eStatus) {// down

			return i + panel.anzahlPixelWidth;

		}

		return -1;
	}

	int getAngrenzenderNachbar_Conductor_withMinEStatus(int i, int eStatus) {

		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].conductor
				&& panel.pixelArray[i - panel.anzahlPixelWidth].electricityStatus >= eStatus) {// up

			return i - panel.anzahlPixelWidth;
		}
		if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].conductor
				&& panel.pixelArray[i - 1].electricityStatus >= eStatus) {// left

			return i - 1;
		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].conductor
				&& panel.pixelArray[i + 1].electricityStatus >= eStatus) {// right

			return i + 1;
		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].conductor
				&& panel.pixelArray[i + panel.anzahlPixelWidth].electricityStatus >= eStatus) {// down

			return i + panel.anzahlPixelWidth;

		}

		return -1;
	}

	int getAngrenzenderNachbar_Conductor_lowestIndex(int i, int eStatus) {
		int lowestStatusIndex = -1;
		int lowestStatus = 1;

		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].conductor
				&& panel.pixelArray[i - panel.anzahlPixelWidth].electricityStatus <= eStatus) {// up

			if (panel.pixelArray[i - panel.anzahlPixelWidth].electricityStatus < lowestStatus) {
				lowestStatusIndex = i - panel.anzahlPixelWidth;
				lowestStatus = panel.pixelArray[i - panel.anzahlPixelWidth].electricityStatus;
			}
		}
		if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].conductor
				&& panel.pixelArray[i - 1].electricityStatus <= eStatus) {// left

			if (panel.pixelArray[i - 1].electricityStatus < lowestStatus) {
				lowestStatusIndex = i - 1;
				lowestStatus = panel.pixelArray[i - 1].electricityStatus;
			}
		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].conductor
				&& panel.pixelArray[i + 1].electricityStatus <= eStatus) {// right

			if (panel.pixelArray[i + 1].electricityStatus < lowestStatus) {
				lowestStatusIndex = i + 1;
				lowestStatus = panel.pixelArray[i + 1].electricityStatus;
			}
		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].conductor
				&& panel.pixelArray[i + panel.anzahlPixelWidth].electricityStatus <= eStatus) {// down

			if (panel.pixelArray[i + panel.anzahlPixelWidth].electricityStatus < lowestStatus) {
				lowestStatusIndex = i + panel.anzahlPixelWidth;
			}
		}

		return lowestStatusIndex;
	}

	int getAngrenzenderNachbarOnFire(int i) {
		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].onFire) {// up
			return i - panel.anzahlPixelWidth;
		} else if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].onFire) {// left
			return i - 1;
		} else if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].onFire) {// right
			return i + 1;
		} else if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].onFire) {// down
			return i + panel.anzahlPixelWidth;
		}

		return -1;
	}

	int getAngrenzenderNachbarWarmOrOnFire(int i) {
		if (i > panel.anzahlPixelWidth - 1 && (panel.pixelArray[i - panel.anzahlPixelWidth].warm
				|| panel.pixelArray[i - panel.anzahlPixelWidth].onFire)) {// up
			return i - panel.anzahlPixelWidth;
		} else if (i % panel.anzahlPixelWidth != 0
				&& (panel.pixelArray[i - 1].warm || panel.pixelArray[i - 1].onFire)) {// left
			return i - 1;
		} else if ((i + 1) % panel.anzahlPixelWidth != 0
				&& (panel.pixelArray[i + 1].warm || panel.pixelArray[i + 1].onFire)) {// right
			return i + 1;
		} else if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& (panel.pixelArray[i + panel.anzahlPixelWidth].warm
						|| panel.pixelArray[i + panel.anzahlPixelWidth].onFire)) {// down
			return i + panel.anzahlPixelWidth;
		}

		return -1;
	}

	int getAnzahlAnSpecificNachbarn(int i, String nachbarName) {
		int anzahl = 0;
		if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].name == nachbarName) {// up
			anzahl++;

		}
		if (i % panel.anzahlPixelWidth != 0 && panel.pixelArray[i - 1].name == nachbarName) {// left
			anzahl++;

		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.pixelArray[i + 1].name == nachbarName) {// right
			anzahl++;

		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.pixelArray[i + panel.anzahlPixelWidth].name == nachbarName) {// down
			anzahl++;
		}

		return anzahl;
	}

	int getAnzahlAnSpecificNachbarnNextgen(int i, String nachbarName) {
		int anzahl = 0;
		if (i > panel.anzahlPixelWidth - 1 && panel.nextPixelArray[i - panel.anzahlPixelWidth].name == nachbarName) {// up
			anzahl++;

		}
		if (i % panel.anzahlPixelWidth != 0 && panel.nextPixelArray[i - 1].name == nachbarName) {// left
			anzahl++;

		}
		if ((i + 1) % panel.anzahlPixelWidth != 0 && panel.nextPixelArray[i + 1].name == nachbarName) {// right
			anzahl++;

		}
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth
				&& panel.nextPixelArray[i + panel.anzahlPixelWidth].name == nachbarName) {// down
			anzahl++;
		}

		return anzahl;
	}

	int getIndexOfNachbar(int thisIndex, int pos) {// 0,1,2 ,3,4,5 ,6,7,8
		if (pos == 4) {
			return thisIndex;
		} else if (thisIndex > panel.anzahlPixelWidth - 1 && pos == 1) {// up
			return thisIndex - panel.anzahlPixelWidth;
		} else if (thisIndex % panel.anzahlPixelWidth != 0 && pos == 3) {// left
			return thisIndex - 1;
		} else if ((thisIndex + 1) % panel.anzahlPixelWidth != 0 && pos == 5) {// right
			return thisIndex + 1;
		} else if (thisIndex < panel.pixelArray.length - panel.anzahlPixelWidth && pos == 7) {// down
			return thisIndex + panel.anzahlPixelWidth;
		} else if (thisIndex < panel.pixelArray.length - panel.anzahlPixelWidth
				&& thisIndex % panel.anzahlPixelWidth != 0 && pos == 6) {// down left
			return thisIndex + panel.anzahlPixelWidth - 1;
		} else if (thisIndex < panel.pixelArray.length - panel.anzahlPixelWidth
				&& (thisIndex + 1) % panel.anzahlPixelWidth != 0 && pos == 8) {// down right
			return thisIndex + panel.anzahlPixelWidth + 1;
		} else if (thisIndex % panel.anzahlPixelWidth != 0 && thisIndex > panel.anzahlPixelWidth - 1 && pos == 0) {// up
																													// left
			return thisIndex - panel.anzahlPixelWidth - 1;
		} else if (thisIndex > panel.anzahlPixelWidth - 1 && (thisIndex + 1) % panel.anzahlPixelWidth != 0
				&& pos == 2) {// up right
			return thisIndex - panel.anzahlPixelWidth + 1;
		}

		return -1;
	}

	boolean getChanceToFallThrough(int thisdensity, int nachbardensity, float rate) {
		// rate - niedrig:wahrscheinlichkeit steigt , hoch:wahrscheinlichkeit sinkt
		if (panel.zufall((int) (100 - (100 * Math.pow(rate, thisdensity - nachbardensity)))))
			return true;
		return false;
	}

	void explode(int index, int explosionRadius, boolean explodeNeighbor) {
		String blockName = name;

		int tntPointIndexList[] = { index };
		int new_tntPointIndexList[];

		boolean again = true;

		while (again) {
			again = false;
			new_tntPointIndexList = null;

			for (int u = 0; u < tntPointIndexList.length; u++) {// for every tnt in list

				int minX = ((index % panel.anzahlPixelWidth) - explosionRadius < 0) ? 0
						: (index % panel.anzahlPixelWidth) - explosionRadius;
				int maxX = ((index % panel.anzahlPixelWidth) + explosionRadius >= panel.anzahlPixelWidth)
						? panel.anzahlPixelWidth - 1
						: (index % panel.anzahlPixelWidth) + explosionRadius;

				int minY = (Math.floorDiv(index, panel.anzahlPixelWidth) - explosionRadius < 0) ? 0
						: Math.floorDiv(index, panel.anzahlPixelWidth) - explosionRadius;
				int maxY = (Math.floorDiv(index, panel.anzahlPixelWidth) + explosionRadius >= panel.anzahlPixelHeight)
						? panel.anzahlPixelHeight - 1
						: Math.floorDiv(index, panel.anzahlPixelWidth) + explosionRadius;

				for (int posy = minY; posy <= maxY; posy++) {
					for (int posx = minX; posx <= maxX; posx++) {

						int i = posx + (posy * panel.anzahlPixelWidth);

						if (panel.pixelArray[i].name != "Fire" && panel.pixelArray[i].name != "Smoke") {

							boolean inRange = false;

							if (panel.getDist(panel.pixelArray[i].posX + panel.pixelWidth / 2,
									panel.pixelArray[i].posY + panel.pixelHeight / 2,
									panel.pixelArray[tntPointIndexList[u]].posX + panel.pixelWidth / 2,
									panel.pixelArray[tntPointIndexList[u]].posY
											+ panel.pixelHeight / 2) <= explosionRadius * panel.zoomFactor) {
								inRange = true;

							}

							if (inRange) {

								if (panel.pixelArray[i].explodable) {
									if (explodeNeighbor) {
										again = true;
									}

									// add to tnt list
									if (new_tntPointIndexList == null) {
										new_tntPointIndexList = new int[1];
										new_tntPointIndexList[0] = i;
									} else {
										int[] temp_tntPointIndexList = new_tntPointIndexList;

										new_tntPointIndexList = new int[new_tntPointIndexList.length + 1];
										for (int o = 0; o < temp_tntPointIndexList.length; o++) {
											new_tntPointIndexList[o] = temp_tntPointIndexList[o];
										}
										new_tntPointIndexList[new_tntPointIndexList.length - 1] = i;
									}

								}

								String newElement = "Air";
								if (panel.zufall(60)) {
									newElement = "Fire";
								} else if (panel.zufall(50)) {
									newElement = "Smoke";
								}
								panel.pixelArray[i].setDataByName(newElement, true);
								panel.nextPixelArray[i].setDataByName(newElement, true);

							}

						}
					}

				}

			}

			tntPointIndexList = new_tntPointIndexList;

		}

		if (panel.checkMuteAndMaxSize()) {
			int ind = getIndexInList("TNT");

			if (panel.soundCountForEachBlock[ind] + 1 > panel.maxSoundCountForEachBlock[ind]) {
				return;
			} else {
				panel.soundCountForEachBlock[ind] += 1;
			}
			if (blockName == "Cweeper") {
				panel.playSound("cweeper_boom.wav", ind);
			} else {
				panel.playSound("Explosion.wav", ind);
			}
//			if (blockName == "Cweeper") {
//				int ind = getIndexInList(blockName);
//
//				if (panel.soundCountForEachBlock[ind] + 1 > panel.maxSoundCountForEachBlock[ind]) {
//					return;
//				} else {
//					panel.soundCountForEachBlock[ind] += 1;
//				}
//				panel.playSound("cweeper_boom.wav", ind);
//			} else {
//				int ind = getIndexInList(blockName);
//
//				if (panel.soundCountForEachBlock[ind] + 1 > panel.maxSoundCountForEachBlock[ind]) {
//					return;
//				} else {
//					panel.soundCountForEachBlock[ind] += 1;
//				}
//				panel.playSound("Explosion.wav", ind);
//			}
		}

	}

	public void radioActiveArea(int index, int radius) {

		int minX = ((index % panel.anzahlPixelWidth) - radius < 0) ? 0 : (index % panel.anzahlPixelWidth) - radius;
		int maxX = ((index % panel.anzahlPixelWidth) + radius >= panel.anzahlPixelWidth) ? panel.anzahlPixelWidth - 1
				: (index % panel.anzahlPixelWidth) + radius;

		int minY = (Math.floorDiv(index, panel.anzahlPixelWidth) - radius < 0) ? 0
				: Math.floorDiv(index, panel.anzahlPixelWidth) - radius;
		int maxY = (Math.floorDiv(index, panel.anzahlPixelWidth) + radius >= panel.anzahlPixelHeight)
				? panel.anzahlPixelHeight - 1
				: Math.floorDiv(index, panel.anzahlPixelWidth) + radius;

		for (int posy = minY; posy <= maxY; posy++) {
			for (int posx = minX; posx <= maxX; posx++) {
				int i = posx + (posy * panel.anzahlPixelWidth);

				for (String n : panel.animalList) {
					if (n == panel.nextPixelArray[i].name) {
						if (panel.zufall(panel.mutationChance)) {
							int randomAnimalIndex = panel.rand.nextInt(panel.animalList.length);
							panel.pixelArray[i].setDataByName(panel.animalList[randomAnimalIndex], true);
							panel.nextPixelArray[i].setDataByName(panel.animalList[randomAnimalIndex], true);
							break;
						}
					}
				}

			}
		}
	}

	public int getIndexInList(String name) {

		for (int i = 0; i < panel.listOfAllItems.length; i++) {
			if (panel.listOfAllItems[i] == name) {
				return i;
			}
		}

		return -1;
	}

	public void playSound() {
		if (name == "Air") {
			return;
		}

		if (panel.checkMuteAndMaxSize()) {

			int index = getIndexInList(name);
			if (index == -1)
				return;

			if (panel.soundCountForEachBlock[index] + 1 > panel.maxSoundCountForEachBlock[index]) {
				return;
			} else {
				panel.soundCountForEachBlock[index] += 1;
			}

			if (name == "Bee" && panel.zufall(0.01f)) {
				if (panel.zufall(70)) {
					panel.playSound("Biene1.wav", index);
				} else {
					panel.playSound("Biene2.wav", index);
				}
			} else

			if (name == "Fire" && panel.zufall(0.2f)) {
				if (panel.zufall(60)) {
					panel.playSound("Feuer1.wav", index);
				} else {
					panel.playSound("Feuer2.wav", index);
				}
			} else

			if (name == "Oil" && panel.zufall(0.02f)) {
				if (panel.zufall(70)) {
					panel.playSound("Oil1.wav", index);
				} else {
					panel.playSound("Oil2.wav", index);
				}
			} else

			if (name == "Bird" && panel.zufall(0.02f)) {
				if (panel.zufall(50)) {
					panel.playSound("Vogel1.wav", index);
				} else {
					panel.playSound("Vogel2.wav", index);
				}
			} else

			if ((name == "Water" || name == "Saltwater") && panel.zufall(0.006f)) {
				if (panel.zufall(50)) {
					panel.playSound("Wasser1.wav", index);
				} else {
					panel.playSound("Wasser2.wav", index);
				}
			} else if (name == "Cloud" && panel.zufall(0.003f)) {
				if (panel.zufall(10f)) {
					panel.playSound("Wind.wav", index);
				} else if (panel.zufall(60)) {
					panel.playSound("Donner1.wav", index);
				} else {
					panel.playSound("Donner2.wav", index);
				}
			} else if (name == "Acid" && panel.zufall(0.01f)) {
				if (panel.zufall(60)) {
					panel.playSound("acid.wav", index);
				} else {
					panel.playSound("acid2.wav", index);
				}
			} else if (name == "Fish" && panel.zufall(0.04f)) {
				if (panel.zufall(60)) {
					panel.playSound("fisch.wav", index);
				} else {
					panel.playSound("fish2.wav", index);
				}
			} else if (name == "Sand" && panel.zufall(0.01f)) {
				panel.playSound("sand.wav", index);
			} else if (name == "Pig" && panel.zufall(0.04f)) {
				if (panel.zufall(50f)) {
					panel.playSound("schwei.wav", index);
				} else {
					panel.playSound("schwei2.wav", index);
				}
			} else if (name == "Spark" && panel.zufall(0.1f)) {
				if (panel.zufall(33)) {
					panel.playSound("spark.wav", index);
				} else if (panel.zufall(50)) {
					panel.playSound("spark2.wav", index);
				} else {
					panel.playSound("spark3.wav", index);
				}
			} else if (name == "Steam" && panel.zufall(0.1f)) {
				panel.playSound("steam.wav", index);
			} else if (name == "Wood" && panel.zufall(0.006f)) {
				if (panel.zufall(50)) {
					panel.playSound("wood.wav", index);
				} else {
					panel.playSound("wood2.wav", index);
				}
			}
			/// ELSE ///
			else {
				// to not change the value if no sound is played
				panel.soundCountForEachBlock[index] -= 1;
			}
		}
	}

	public void update(int i) {

		// transmission
		if(transmissionData > 1) {
//			if(getIndexOfNachbar(i, 1) >= 0 && panel.pixelArray[i - panel.anzahlPixelWidth].transmissionData) {
//				
//			}
		}

		// if air -> skip
		if (name == "Air") {
			otherPixelListIndex = 0;
			return;
		}

		if (name != panel.nextPixelArray[i].name) {// if this pixel != next Pixel -> skip
			return;
		}

		if (name == "Lufter") {
			if (getAnzahlAnSpecificNachbarnNextgen(i, "Air") + getAnzahlAnSpecificNachbarnNextgen(i, "Lufter") != 4) {
				if (panel.zufall(30) && panel.checkMuteAndMaxSize()) {
					int index = getIndexInList(name);
					if (index == -1)
						return;
					if (panel.soundCountForEachBlock[index] + 1 <= panel.maxSoundCountForEachBlock[index]) {
						panel.playSound("Lufter.wav", 0.72f, index);
						panel.soundCountForEachBlock[index] += 1;
					}

				}
			}
			setAngrenzenderNachbar(i, "Air", "Lufter");
			return;
		}

		if (name == "Napalm") {
			if (getAngrenzenderNachbar(i, "Air") >= 0) {

				if (panel.zufall(20)) {
					panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")].setDataByName("Smoke", true);
				} else {
					panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")].setDataByName("Fire", true);
				}
			}
		} else

		if (name == "Uran") {
			radioActiveArea(i, 10);
			if (panel.zufall(2f)) {
				panel.nextPixelArray[i].lifecount--;
				lifecount--;
			}
		} else

		if (name == "Gravitychanger") {
			int ind = i - panel.anzahlPixelWidth;
			if (i > panel.anzahlPixelWidth - 1) {// up
				if (panel.nextPixelArray[ind].gravity && !panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = false;
					panel.nextPixelArray[ind].fallUp = true;
					panel.pixelArray[ind].gravity = false;
					panel.pixelArray[ind].fallUp = true;
				} else if (!panel.nextPixelArray[ind].gravity && panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = true;
					panel.nextPixelArray[ind].fallUp = false;
					panel.pixelArray[ind].gravity = true;
					panel.pixelArray[ind].fallUp = false;
				}
			}

			ind = i - 1;
			if (i % panel.anzahlPixelWidth != 0) {// left
				if (panel.nextPixelArray[ind].gravity && !panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = false;
					panel.nextPixelArray[ind].fallUp = true;
					panel.pixelArray[ind].gravity = false;
					panel.pixelArray[ind].fallUp = true;
				} else if (!panel.nextPixelArray[ind].gravity && panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = true;
					panel.nextPixelArray[ind].fallUp = false;
					panel.pixelArray[ind].gravity = true;
					panel.pixelArray[ind].fallUp = false;
				}
			}

			ind = i + 1;
			if ((i + 1) % panel.anzahlPixelWidth != 0) {// right
				if (panel.nextPixelArray[ind].gravity && !panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = false;
					panel.nextPixelArray[ind].fallUp = true;
					panel.pixelArray[ind].gravity = false;
					panel.pixelArray[ind].fallUp = true;
				} else if (!panel.nextPixelArray[ind].gravity && panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = true;
					panel.nextPixelArray[ind].fallUp = false;
					panel.pixelArray[ind].gravity = true;
					panel.pixelArray[ind].fallUp = false;
				}
			}

			ind = i + panel.anzahlPixelWidth;
			if (i < panel.pixelArray.length - panel.anzahlPixelWidth) {// down
				if (panel.nextPixelArray[ind].gravity && !panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = false;
					panel.nextPixelArray[ind].fallUp = true;
					panel.pixelArray[ind].gravity = false;
					panel.pixelArray[ind].fallUp = true;
				} else if (!panel.nextPixelArray[ind].gravity && panel.nextPixelArray[ind].fallUp) {
					panel.nextPixelArray[ind].gravity = true;
					panel.nextPixelArray[ind].fallUp = false;
					panel.pixelArray[ind].gravity = true;
					panel.pixelArray[ind].fallUp = false;
				}
			}
			return;

		} else

		if (name == "Cloner") {

			if (panel.listOfAllItems[otherPixelListIndex] == "Air"
					|| panel.listOfAllItems[otherPixelListIndex] == "Cloner") {// set clonepixel

				if (getIndexOfNachbar(i, 1) >= 0 && panel.pixelArray[getIndexOfNachbar(i, 1)].name != "Air"
						&& panel.pixelArray[getIndexOfNachbar(i, 1)].name != "Cloner") {// up

					panel.nextPixelArray[i].otherPixelListIndex = getIndexInList(
							panel.pixelArray[getIndexOfNachbar(i, 1)].name);
					return;
				}
				if (getIndexOfNachbar(i, 3) >= 0 && panel.pixelArray[getIndexOfNachbar(i, 3)].name != "Air"
						&& panel.pixelArray[getIndexOfNachbar(i, 3)].name != "Cloner") {// left
					panel.nextPixelArray[i].otherPixelListIndex = getIndexInList(
							panel.pixelArray[getIndexOfNachbar(i, 3)].name);
					return;
				}
				if (getIndexOfNachbar(i, 5) >= 0 && panel.pixelArray[getIndexOfNachbar(i, 5)].name != "Air"
						&& panel.pixelArray[getIndexOfNachbar(i, 5)].name != "Cloner") {// right
					panel.nextPixelArray[i].otherPixelListIndex = getIndexInList(
							panel.pixelArray[getIndexOfNachbar(i, 5)].name);
					return;
				}
				if (getIndexOfNachbar(i, 7) >= 0 && panel.pixelArray[getIndexOfNachbar(i, 7)].name != "Air"
						&& panel.pixelArray[getIndexOfNachbar(i, 7)].name != "Cloner") {// down
					panel.nextPixelArray[i].otherPixelListIndex = getIndexInList(
							panel.pixelArray[getIndexOfNachbar(i, 7)].name);
					return;
				}

				// check cloner nachbar
				if (getAngrenzenderCloner(i) >= 0) {
					panel.nextPixelArray[i].otherPixelListIndex = panel.pixelArray[getAngrenzenderCloner(
							i)].otherPixelListIndex;
					return;
				}

			} else {
				if (getAngrenzenderNachbar_Conductor_withMinEStatus(i, 1) >= 0
						|| getAnzahlAnSpecificNachbarn(i, "Battery") > 0) {
					if (getAngrenzenderNachbar(i, "Air") >= 0) {// draw clonepixel
						panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")]
								.setDataByName(panel.listOfAllItems[otherPixelListIndex], true);
					}
				}
			}

			return;

		} else {
			otherPixelListIndex = 0;
		}

		// if flammable & nachbar onFire -> burn
		if (!onFire && flammable && getAngrenzenderNachbarOnFire(i) >= 0) {
			int chanceToBurn = 100;// standard chance

			if (name == "Wood") {
				chanceToBurn = 30;
			} else if (name == "Oil") {
				chanceToBurn = 80;
			} else if (name == "Gas") {
				chanceToBurn = 80;
			} else if (name == "Leaf") {
				chanceToBurn = 80;
			}

			if (panel.zufall(chanceToBurn)) {
				panel.nextPixelArray[i].onFire = true;
				panel.pixelArray[getAngrenzenderNachbarOnFire(i)].lifecount--;
				panel.nextPixelArray[getAngrenzenderNachbarOnFire(i)].lifecount--;
			}
			return;
		}

		// if burning -> create fire (& smoke)
		if (flammable && onFire) {
			panel.nextPixelArray[i].lifecount--;
			lifecount--;

			if (name != "Fuse") {// if can burn
				if (getAngrenzenderNachbar(i, "Air") >= 0) {

					if (panel.zufall(20)) {
						panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")].setDataByName("Smoke", true);
					} else {
						panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")].setDataByName("Fire", true);
					}
				}
			}

		}

		// get warm
		if (name == "Metal" || name == "Stone") {
			if (getAngrenzenderNachbarOnFire(i) > 0) {
				panel.nextPixelArray[i].warm = true;
			} else {
				panel.nextPixelArray[i].warm = false;
			}
		}

		if (conductor) {
			if (electricityStatus == 1) {
				int index_lowest_index = getAngrenzenderNachbar_Conductor_lowestIndex(i, -1);
				if (index_lowest_index >= 0) {

					if (panel.nextPixelArray[index_lowest_index].name == "Repeater") {
						panel.nextPixelArray[index_lowest_index].electricityStatus = panel.nextPixelArray[index_lowest_index].repeaterValue
								+ 1;
					} else {
						panel.nextPixelArray[index_lowest_index].electricityStatus = 1;
					}
				}

			}
			if (electricityStatus > -99999
					&& !(panel.nextPixelArray[i].electricityStatus >= 1 && panel.pixelArray[i].electricityStatus < 1)) {
				panel.nextPixelArray[i].electricityStatus--;

			}
		} else

		if (name == "Spark") {
			if (getAngrenzenderNachbar_Conductor_lowestIndex(i, -1) >= 0) {
				if (panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(i, -1)].name == "Repeater") {
					panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(i,
							-1)].electricityStatus = panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(
									i, -1)].repeaterValue + 1;
				} else {
					panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(i, -1)].electricityStatus = 1;
				}
				panel.nextPixelArray[i].lifecount = 0;

			}

		} else

		if (name == "Battery") {

			if (getAngrenzenderNachbar_Conductor_lowestIndex(i, -1) >= 0) {
				if (panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(i, -1)].name == "Repeater") {
					panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(i,
							-1)].electricityStatus = panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(
									i, -1)].repeaterValue + 1;
				} else {
					panel.nextPixelArray[getAngrenzenderNachbar_Conductor_lowestIndex(i, -1)].electricityStatus = 1;
				}
			}

		} else

		if (name == "Oil" && onFire) {
			if (getAnzahlAnSpecificNachbarn(i, "Water") > 0) {
				onFire = false;
				panel.nextPixelArray[i].onFire = false;
			}
		} else

		if (name == "Wax") {

			// wax (solid) && nachbar.onFire -> liquid wax
			if (getAngrenzenderNachbarOnFire(i) >= 0 && !flow) {
				panel.nextPixelArray[i].gravity = true;
				panel.nextPixelArray[i].flow = true;
				panel.nextPixelArray[i].slide = true;
				panel.nextPixelArray[i].lifecount = panel.wax_lifecount;
				panel.nextPixelArray[i].density = 7;

				panel.nextPixelArray[getAngrenzenderNachbarOnFire(i)].lifecount--;
				panel.pixelArray[getAngrenzenderNachbarOnFire(i)].lifecount--;

				return;

			} else if (getAngrenzenderNachbar(i, "Lava") >= 0 && flow) {
				onFire = true;
				panel.nextPixelArray[i].onFire = true;
			}

			if (getAngrenzenderNachbar(i, "Air") >= 0 && onFire && flow) {// burning wax
				panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")].setDataByName("Fire", true);
			}

			if (getAngrenzenderNachbar(i, "Water") >= 0 && onFire) {
				explode(i, panel.tnt_sprengradius / 3, false);
				return;
			}
		}

		// ice + onFire = water
		if (name == "Ice" && getAngrenzenderNachbarWarmOrOnFire(i) >= 0) {

			panel.nextPixelArray[i].setDataByName("Water", true);

			panel.nextPixelArray[getAngrenzenderNachbarWarmOrOnFire(i)].lifecount -= 4;
			panel.pixelArray[getAngrenzenderNachbarWarmOrOnFire(i)].lifecount -= 4;

			return;

		}

		if (name == "Water") {

			// salt + water = saltwater
			if (getAngrenzenderNachbar(i, "Salt") >= 0) {
				panel.nextPixelArray[i].setDataByName("Saltwater", true);

				panel.nextPixelArray[getAngrenzenderNachbar(i, "Salt")].setDataByName("Air", true);
				panel.pixelArray[getAngrenzenderNachbar(i, "Salt")].setDataByName("Air", true);
				return;
			}

			// ice + water = ice
			if (panel.zufall(getAnzahlAnSpecificNachbarn(i, "Ice") * 10)) {
				panel.pixelArray[i].setDataByName("Ice", true);
				panel.nextPixelArray[i].setDataByName("Ice", true);
				return;
			}

			// water + onfire = steam
			if (getAngrenzenderNachbarWarmOrOnFire(i) >= 0) {
				int index = getAngrenzenderNachbarWarmOrOnFire(i);

				if (panel.zufall(50)) {
					panel.nextPixelArray[i].setDataByName("Cloud", true);
				} else {
					panel.nextPixelArray[i].setDataByName("Steam", true);
				}

				if (panel.pixelArray[index].warm) {
					if (getAngrenzenderNachbarOnFire(getAngrenzenderNachbarWarmOrOnFire(i)) >= 0) {
						index = getAngrenzenderNachbarOnFire(getAngrenzenderNachbarWarmOrOnFire(i));
						panel.nextPixelArray[index].lifecount--;
						panel.pixelArray[index].lifecount--;

						panel.nextPixelArray[index].warm = false;
						panel.pixelArray[index].warm = false;
					}
				} else {
					panel.nextPixelArray[index].lifecount--;
					panel.pixelArray[index].lifecount--;

					// loescht brennenden pixel
//					if (panel.zufall(20)) {
//						panel.nextPixelArray[index].onFire = false;
//						panel.pixelArray[index].onFire = false;
//					}
				}
				return;

			}

		}

		if (name == "Dirt") {
			if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].name == "Air") {// up
				if ((i < panel.pixelArray.length - panel.anzahlPixelWidth
						&& panel.nextPixelArray[i + panel.anzahlPixelWidth].name != "Air")
						|| i >= panel.pixelArray.length - panel.anzahlPixelWidth) {// down

					if (panel.zufall(15)) {
						panel.nextPixelArray[i].setDataByName("Grass", true);
						return;
					}
				}
			}
		}

		if (name == "Grass") {
			if (i > panel.anzahlPixelWidth - 1 && panel.pixelArray[i - panel.anzahlPixelWidth].name != "Air"
					&& panel.pixelArray[i - panel.anzahlPixelWidth].name != "Leaf") {// up
				if (panel.zufall(40)) {
					panel.nextPixelArray[i].setDataByName("Dirt", true);
					return;
				}
			}
		}

		if (name == "Saltwater" && getAngrenzenderNachbarWarmOrOnFire(i) >= 0) {// saltwater + onfire = steam + salt

			if (panel.zufall(30)) {
				panel.nextPixelArray[i].setDataByName("Salt", true);

				if (getAngrenzenderNachbar(i, "Air") >= 0) {

					if (panel.zufall(50)) {
						panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")].setDataByName("Cloud", true);
					} else {
						panel.nextPixelArray[getAngrenzenderNachbar(i, "Air")].setDataByName("Steam", true);
					}
				}
			} else {
				if (panel.zufall(50)) {
					panel.nextPixelArray[i].setDataByName("Cloud", true);
				} else {
					panel.nextPixelArray[i].setDataByName("Steam", true);
				}
			}
			if (!panel.nextPixelArray[getAngrenzenderNachbarWarmOrOnFire(i)].warm) {
				panel.nextPixelArray[getAngrenzenderNachbarWarmOrOnFire(i)].lifecount--;
				panel.pixelArray[getAngrenzenderNachbarWarmOrOnFire(i)].lifecount--;
			}
			return;

		}

		if (name == "Sand" && getAngrenzenderNachbar(i, "Lava") >= 0) {// sand + lava = glass

			panel.nextPixelArray[i].setDataByName("Glass", true);

			panel.nextPixelArray[getAngrenzenderNachbar(i, "Lava")].lifecount--;
			panel.pixelArray[getAngrenzenderNachbar(i, "Lava")].lifecount--;
			return;

		}

		if (name == "Cloud") {// rain

			if (panel.zufall((float) (getAnzahlAnSpecificNachbarn(i, "Cloud") * 0.2))) {
				if (panel.zufall(20)) {
					panel.nextPixelArray[i].setDataByName("Spark", true);
				} else {
					panel.nextPixelArray[i].setDataByName("Water", true);
				}
				return;
			}
		}

		if (name == "Blood") {
			if (getAngrenzenderNachbarOnFire(i) >= 0) {
				lifecount -= 8;
				panel.nextPixelArray[i].lifecount -= 8;

				panel.nextPixelArray[getAngrenzenderNachbarOnFire(i)].lifecount--;
				panel.pixelArray[getAngrenzenderNachbarOnFire(i)].lifecount--;
			}
		}

		if (name == "TNT") {// tnt ignite
			if (getAngrenzenderNachbar_Conductor_withMinEStatus(i, 1) >= 0
					|| getAngrenzenderNachbar(i, "Battery") >= 0) {
				panel.nextPixelArray[i].onFire = true;
			}
		}

		if (name == "Bee") {// bee drop honey
			if (panel.zufall(0.1f)) {
				if (getIndexOfNachbar(i, 7) >= 0 && panel.pixelArray[getIndexOfNachbar(i, 7)].name == "Air") {
					panel.nextPixelArray[getIndexOfNachbar(i, 7)].setDataByName("Wax", false);

					panel.nextPixelArray[getIndexOfNachbar(i, 7)].gravity = true;
					panel.nextPixelArray[getIndexOfNachbar(i, 7)].flow = true;
					panel.nextPixelArray[getIndexOfNachbar(i, 7)].slide = true;
					panel.nextPixelArray[getIndexOfNachbar(i, 7)].lifecount = panel.wax_lifecount;
					panel.nextPixelArray[getIndexOfNachbar(i, 7)].density = 7;

				}
			}
		}

		// lifecount-- for some elements
		if (name == "Steam") {
			lifecount--;
			panel.nextPixelArray[i].lifecount--;
		} else if (name == "Fire") {
			lifecount--;
			panel.nextPixelArray[i].lifecount--;
		} else if (name == "Cloud") {
			lifecount--;
			panel.nextPixelArray[i].lifecount--;
		} else if (name == "Smoke") {
			lifecount--;
			panel.nextPixelArray[i].lifecount--;
		} else if (name == "Wax" && flow) {
			lifecount--;
			panel.nextPixelArray[i].lifecount--;
		}

		if (panel.nextPixelArray[i].lifecount <= 0) {
			// pig to blood
			if (name == "Pig") {
				if (panel.zufall(50)) {
					panel.nextPixelArray[i].setDataByName("Blood", true);
				} else {
					panel.nextPixelArray[i].setDataByName("Air", true);
				}
				return;
			}

			if (name == "Cweeper" && !onFire) {
				if (panel.zufall(50)) {
					panel.nextPixelArray[i].setDataByName("Blood", true);
				} else {
					panel.nextPixelArray[i].setDataByName("Air", true);
				}
				return;
			}

			// blood to metal/air
			if (name == "Blood") {
				if (panel.zufall(1)) {
					panel.nextPixelArray[i].setDataByName("Metal", true);
				} else {
					panel.nextPixelArray[i].setDataByName("Air", true);
				}
				return;
			}

			// if wood tot -> ash
			if (name == "Wood" && panel.zufall(25)) {
				panel.nextPixelArray[i].setDataByName("Ash", true);
				setDataByName("Ash", true);
				return;
			}

			// if lava tot -> stone
			if (name == "Lava" && panel.zufall(20)) {
				if (panel.zufall(20)) {
					panel.nextPixelArray[i].setDataByName("Stone", true);
				} else {
					panel.nextPixelArray[i].setDataByName("Ash", true);
				}
				setDataByName("Stone", true);
				return;
			}

			// if explodable -> boom
			if (panel.nextPixelArray[i].explodable) {
				if (name == "Nitro") {
					explode(i, (int) (panel.tnt_sprengradius * 2 / 3), true);
				} else if (name == "Cweeper") {
					explode(i, panel.tnt_sprengradius, false);
				} else {
					explode(i, panel.tnt_sprengradius, true);
				}
				return;
			}

			// wax (liquid) tot -> wax (solid)
			if (name == "Wax" && flow) {
				panel.nextPixelArray[i].gravity = false;
				panel.nextPixelArray[i].flow = false;
				panel.nextPixelArray[i].slide = false;
				panel.nextPixelArray[i].onFire = false;
				panel.nextPixelArray[i].lifecount = panel.wax_lifecount;
				panel.nextPixelArray[i].density = 12;

				return;
			}

			// everything else -> to air
			panel.nextPixelArray[i].setDataByName("Air", true);
			setDataByName("Air", true);
			return;
		}

		// ===========================================================================
		// iterate through nachbarpixel
		// ===========================================================================

		int nachbarPixelIndex = i;

		// if animal on land
		if (name == "Pig" || name == "Cweeper") {
			int pixelUnterIndex = getIndexOfNachbar(i, 7);

			if (name == "Cweeper" && getAngrenzenderNachbarOnFire(i) >= 0) {
				onFire = true;

				// play tsss sounds
				if (panel.checkMuteAndMaxSize()) {
					int ind = getIndexInList("Cweeper");
					if (panel.soundCountForEachBlock[ind] + 1 > panel.maxSoundCountForEachBlock[ind]) {
						return;
					} else {
						panel.soundCountForEachBlock[ind] += 1;
					}
					panel.playSound("cweeper_tssss.wav", ind);
				}
			}

			// drown
			if (getIndexOfNachbar(i, 1) >= 0 && panel.nextPixelArray[i - panel.anzahlPixelWidth].density >= 6
					&& panel.nextPixelArray[i - panel.anzahlPixelWidth].density <= 10
					&& panel.nextPixelArray[i - panel.anzahlPixelWidth].name != "Pig"
					&& panel.nextPixelArray[i - panel.anzahlPixelWidth].name != "Cweeper") {
				panel.nextPixelArray[i].lifecount--;

				if (panel.zufall(70)) {
					switchPixels(i, i - panel.anzahlPixelWidth);
				}
				return;
			}

			// fall down
			if (gravity) {
				int maxCanFallHeight = 5;

				if (pixelUnterIndex > -1) {
					if (panel.nextPixelArray[pixelUnterIndex].density < 11) {// dichte <= fluessig
						if (panel.nextPixelArray[pixelUnterIndex].name == "Air") {
							fallDamage++;
						} else {// fall in zB water/lava
							fallDamage = 0;
						}

						if (fallDamage == 0
								&& getChanceToFallThrough(density, panel.nextPixelArray[pixelUnterIndex].density, 0.9f))
							pixelUnterIndex = i;

						switchPixels(i, pixelUnterIndex);
						return;
					} else {// take fall damage
						if (panel.nextPixelArray[i].fallDamage >= maxCanFallHeight) {
							lifecount -= panel.nextPixelArray[i].fallDamage - maxCanFallHeight;
						}
						fallDamage = 0;
					}
				} else {// take fall damage
					if (panel.nextPixelArray[i].fallDamage >= maxCanFallHeight) {
						lifecount -= panel.nextPixelArray[i].fallDamage - maxCanFallHeight;
					}
					fallDamage = 0;
				}
			}

			// move
			int nachbarIndex = i;

			if (panel.zufall(8)) {// stay
				dir = 4;
				switchPixels(i, nachbarPixelIndex);
				return;
			}

			if (panel.zufall(10)) {// change dir

				if (panel.zufall(50)) {// left / right
					dir = 3;
				} else {
					dir = 5;
				}

			}

			int waagrechterNachbarIndex = getIndexOfNachbar(i, dir);

			if (waagrechterNachbarIndex >= 0 && dir != 4) {

				// move left or right up
				// if solid pixel left or right
				if (panel.nextPixelArray[waagrechterNachbarIndex].density >= 11
						&& panel.nextPixelArray[waagrechterNachbarIndex].name != "Pig"
						&& panel.nextPixelArray[waagrechterNachbarIndex].name != "Cweeper") {
					int pixelUeberWaagrechterNachbarIndex = getIndexOfNachbar(waagrechterNachbarIndex, 1);

					// pixel ueber left or right is not solid
					if (pixelUeberWaagrechterNachbarIndex >= 0
							&& panel.nextPixelArray[pixelUeberWaagrechterNachbarIndex].density < 11) {
						nachbarIndex = getIndexOfNachbar(i, dir - 3);
					}

				}
				// move left or right
				// left or right pixel is not solid and not pig
				else if (panel.nextPixelArray[waagrechterNachbarIndex].name != "Pig"
						&& panel.nextPixelArray[waagrechterNachbarIndex].name != "Cweeper") {

					int pixelUnterWaagrechterNachbarIndex = getIndexOfNachbar(waagrechterNachbarIndex, 7);

					// if pixel unter left or right pixel is solid
					if ((pixelUnterIndex >= 0 && (panel.nextPixelArray[pixelUnterIndex].name == "Pig"
							|| panel.nextPixelArray[pixelUnterIndex].name == "Cweeper"))
							|| pixelUnterWaagrechterNachbarIndex < 0
							|| (pixelUnterWaagrechterNachbarIndex >= 0
									&& panel.nextPixelArray[pixelUnterWaagrechterNachbarIndex].density >= 11
									&& panel.nextPixelArray[pixelUnterWaagrechterNachbarIndex].name != "Pig"
									&& panel.nextPixelArray[pixelUnterWaagrechterNachbarIndex].name != "Cweeper")) {
						nachbarIndex = getIndexOfNachbar(i, dir);
					}
					// move left or right down
					else if (pixelUnterWaagrechterNachbarIndex >= 0
							&& panel.nextPixelArray[pixelUnterWaagrechterNachbarIndex].name != "Pig"
							&& panel.nextPixelArray[pixelUnterWaagrechterNachbarIndex].name != "Cweeper") {
						int pixelUnterUnterWaagrechterNachbarIndex = getIndexOfNachbar(
								pixelUnterWaagrechterNachbarIndex, 7);

						// if pixel unter unter left or right pixel is solid
						if (pixelUnterUnterWaagrechterNachbarIndex >= 0
								&& panel.nextPixelArray[pixelUnterUnterWaagrechterNachbarIndex].density >= 11
								&& panel.nextPixelArray[pixelUnterUnterWaagrechterNachbarIndex].name != "Pig"
								&& panel.nextPixelArray[pixelUnterUnterWaagrechterNachbarIndex].name != "Cweeper") {
							nachbarIndex = getIndexOfNachbar(i, dir + 3);
						}

					}

				}

			}

			if (nachbarIndex < 0)
				nachbarIndex = i;

			switchPixels(i, nachbarIndex);

			return;
		}

		// if canswim
		if (name == "Fish") {

			if (dir != 3 && dir != 5) {// if no dir
				if (panel.zufall(50)) {
					dir = 3;
				} else {
					dir = 5;
				}
			}

			if (panel.zufall(5)) {// change dir
				if (dir == 3) {
					dir = 5;
				} else if (dir == 5) {
					dir = 3;
				}
			}

			int other_dir = 5;
			if (dir == 3) {
				other_dir = 5;
			} else if (dir == 5) {
				other_dir = 3;
			}

			// left - middle - right
			if (getIndexOfNachbar(i, dir) >= 0 && panel.nextPixelArray[getIndexOfNachbar(i, dir)].name != "Water") {// if
																													// block
																													// in
																													// front
																													// ->
																													// change
																													// dir

				if (getIndexOfNachbar(i, other_dir) >= 0
						&& panel.nextPixelArray[getIndexOfNachbar(i, other_dir)].name != "Water") {// if both sides
																									// block
					dir = 4;
				} else {
					dir = other_dir;
				}
			} else if (getIndexOfNachbar(i, dir) == -1) {
				if (panel.nextPixelArray[getIndexOfNachbar(i, other_dir)].name == "Water") {// if both sides
																							// block
					dir = other_dir;
				}
			}

			int upOrDown = 0; // -anzahlPixelWidth / 0 / anzahlPixelWidth

			if (panel.zufall(30) || dir == 4) {

				if (panel.zufall(50)) {
					upOrDown = -3;// up
				} else {
					upOrDown = 3;// down
				}

			}

			// up - middle - down
			if (getIndexOfNachbar(i, dir + upOrDown) >= 0
					&& panel.nextPixelArray[getIndexOfNachbar(i, dir + upOrDown)].name != "Water") {// if block up ->
				// change dir

				if (getIndexOfNachbar(i, dir + upOrDown) >= 0
						&& panel.nextPixelArray[getIndexOfNachbar(i, dir + upOrDown)].name != "Water") {// if both sides
					// block
					upOrDown = 0;
				} else {
					upOrDown *= -1;
				}
			}

			if (getAnzahlAnSpecificNachbarn(i, "Water") <= 0 && getAnzahlAnSpecificNachbarn(i, "Fish") <= 3) {

				if (panel.zufall(80)) {
					lifecount--;
					if (getIndexOfNachbar(i, dir + upOrDown) == i || getIndexOfNachbar(i, dir + upOrDown) < 0) {
						panel.nextPixelArray[i].lifecount = lifecount;
					}
				}
			}

			if (getIndexOfNachbar(i, dir + upOrDown) >= 0 && getIndexOfNachbar(i, dir + upOrDown) != i) {
				switchPixels(i, getIndexOfNachbar(i, dir + upOrDown));
				return;
			}

		}

		// if canfly
		if (name == "Bird" || name == "Bee") {

			if (onFire) {
				if (getIndexOfNachbar(i, 7) > -1) {
					if (panel.nextPixelArray[getIndexOfNachbar(i, 7)].density < density) {
						switchPixels(i, getIndexOfNachbar(i, 7));
						return;
					}
				}
			} else {

				if (panel.zufall(0.1f) && name == "Bird") {// sturzflug
//					if (dir == 3)
//						dir = 6; 
//
//					if (dir == 5)
//						dir = 8;

					dir = 7;
				}

				// swim
				if (getIndexOfNachbar(i, 1) >= 0 && panel.nextPixelArray[i - panel.anzahlPixelWidth].density >= 6
						&& panel.nextPixelArray[i - panel.anzahlPixelWidth].density <= 10
						&& panel.nextPixelArray[i - panel.anzahlPixelWidth].name != name) {
					panel.nextPixelArray[i].lifecount--;

					if (name == "Bird" && panel.zufall(70)) {
						switchPixels(i, i - panel.anzahlPixelWidth);
					} else if (name == "Bee" && panel.zufall(20)) {
						switchPixels(i, i - panel.anzahlPixelWidth);
					}
					return;
				}

				if (dir == 4) {
					if (panel.zufall(50)) {
						dir = 3;
					} else {
						dir = 5;
					}
				}

				// left and right
				if (panel
						.zufall((float) (100 * Math.pow(0.7, panel.anzahlPixelWidth - (i % panel.anzahlPixelWidth))))) {// left
					dir = 3;
				} else if (panel.zufall((float) (100 * Math.pow(0.7, i % panel.anzahlPixelWidth)))) {// right
					dir = 5;
				}

				float aufenthalt = (float) 1 / 3;
				float aufenthaltProzent = 20f;
				int dVertical = 0;

				if (name == "Bee") {
					aufenthalt = (float) 2 / 3;
				}

				if (panel.zufall((float) (100 * Math.pow(
						(Math.pow(aufenthaltProzent / 100f, (1f / panel.anzahlPixelHeight) * 1f / (1f - aufenthalt))),
						panel.anzahlPixelHeight - (i / panel.anzahlPixelWidth))))) {// up
					dVertical = -3;
				} else if (panel.zufall((float) (100
						* Math.pow(Math.pow(aufenthaltProzent / 100f, (1 / aufenthalt) / panel.anzahlPixelHeight),
								i / panel.anzahlPixelWidth)))) {// down
					dVertical = 3;
				}

				for (int n = 0; n < 3; n++) {// left - right - smiddle

					if (n == 1) {
						// change from left-right
						if (dir == 3) {
							dir = 5;
						} else if (dir == 5) {
							dir = 3;
						}
					} else if (n == 2) {// middle
						dir = 4;
					}

					for (int j = 0; j < 3; j++) {// up - down - middle

						if (j == 0) {
							if (getIndexOfNachbar(i, dir + dVertical) > -1) {
								if (panel.nextPixelArray[getIndexOfNachbar(i, dir + dVertical)].name == "Air") {

									switchPixels(i, getIndexOfNachbar(i, dir + dVertical));
									return;
								}
							}

							if (dVertical == 0) {
								dVertical = -3;
								if (getIndexOfNachbar(i, dir + dVertical) > -1) {
									if (panel.nextPixelArray[getIndexOfNachbar(i, dir + dVertical)].name == "Air") {

										switchPixels(i, getIndexOfNachbar(i, dir + dVertical));
										return;
									}
								}
							}

						} else if (j == 1) {// down - up

							if (getIndexOfNachbar(i, dir + dVertical * -1) > -1) {
								if (panel.nextPixelArray[getIndexOfNachbar(i, dir + dVertical * -1)].name == "Air") {

									switchPixels(i, getIndexOfNachbar(i, dir + dVertical * -1));
									return;
								}
							}
						} else if (j == 2) {// middle
							if (getIndexOfNachbar(i, dir) > -1) {
								if (panel.nextPixelArray[getIndexOfNachbar(i, dir)].name == "Air") {
									switchPixels(i, getIndexOfNachbar(i, dir));
									return;
								}
							}
						}

					}

				}
			}

			return;
		}

		boolean sparkLeftOrRight = false;
		if (name == "Spark") {
			sparkLeftOrRight = panel.zufall(50);
		}

		// down
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth) {// must have condition
			nachbarPixelIndex = getIndexOfNachbar(i, 7);

			if (gravity && !sparkLeftOrRight) {// wenn runter fallen kann && !sparkgoleftorright

				if (panel.nextPixelArray[nachbarPixelIndex].name == "Air") {// if nachbar == air

					switchPixels(i, nachbarPixelIndex);
					return;

				} else {
					if (name == "Acid" && panel.nextPixelArray[i + panel.anzahlPixelWidth].name != "Acid"
							&& panel.nextPixelArray[i + panel.anzahlPixelWidth].name != "Glass") {// acid thingy
						if (panel.zufall(panel.acid_chance_to_remove)) {
							lifecount--;
							panel.nextPixelArray[i].lifecount--;

							panel.pixelArray[nachbarPixelIndex].lifecount--;
							panel.nextPixelArray[nachbarPixelIndex].lifecount--;
							return;
						}
					}

					if (density > panel.nextPixelArray[nachbarPixelIndex].density) {// if nachbar leichter

						if (getChanceToFallThrough(density, panel.nextPixelArray[nachbarPixelIndex].density, 0.6f)
								&& (panel.nextPixelArray[nachbarPixelIndex].gravity
										|| panel.nextPixelArray[nachbarPixelIndex].fallUp)) {// chance mit nachbar zu
																								// switchen
							switchPixels(i, nachbarPixelIndex);
						}
						return;
					}

				}
			}
		}

		// =====================================================================================

		boolean down_right = false;
		boolean down_left = false;
		boolean acid_through_left = false;
		boolean acid_through_right = false;

		// down left
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth && i % panel.anzahlPixelWidth != 0) {// must
																										// have
																										// condition
			if (gravity && slide) {// if runter fallen & slidedown

				if (panel.nextPixelArray[i + panel.anzahlPixelWidth - 1].name == "Air") {// if air -> switch

					down_left = true;

				} else {

					if (name == "Acid" && panel.nextPixelArray[i + panel.anzahlPixelWidth - 1].name != "Acid"
							&& panel.nextPixelArray[i + panel.anzahlPixelWidth - 1].name != "Glass") {// acid thingy

						acid_through_left = true;
					}

					if (density > panel.nextPixelArray[i + panel.anzahlPixelWidth - 1].density) {// if nachbar leichter

						// not air -> probability to fall
						if (getChanceToFallThrough(density,
								panel.nextPixelArray[i + panel.anzahlPixelWidth - 1].density, 0.6f)
								&& (panel.nextPixelArray[i + panel.anzahlPixelWidth - 1].gravity
										|| panel.nextPixelArray[i + panel.anzahlPixelWidth - 1].fallUp))
							down_left = true;
					}
				}
			}
		}
		// -----------------

		// down right
		if (i < panel.pixelArray.length - panel.anzahlPixelWidth && (i + 1) % panel.anzahlPixelWidth != 0) {// must
																											// have
																											// condition

			if (gravity && slide) {// if runter fallen & slidedown

				if (panel.nextPixelArray[i + panel.anzahlPixelWidth + 1].name == "Air") {// if air -> switch

					down_right = true;

				} else {

					if (name == "Acid" && panel.nextPixelArray[i + panel.anzahlPixelWidth + 1].name != "Acid"
							&& panel.nextPixelArray[i + panel.anzahlPixelWidth + 1].name != "Glass") {// acid thingy

						acid_through_right = true;
					}

					if (density > panel.nextPixelArray[i + panel.anzahlPixelWidth + 1].density) {// if nachbar leichter

						// not air -> probability to fall
						if (getChanceToFallThrough(density,
								panel.nextPixelArray[i + panel.anzahlPixelWidth + 1].density, 0.6f)
								&& (panel.nextPixelArray[i + panel.anzahlPixelWidth + 1].gravity
										|| panel.nextPixelArray[i + panel.anzahlPixelWidth + 1].fallUp))
							down_right = true;
					}
				}

			}

		}

		if (down_left || down_right) {

			if (down_left && !down_right) {// down left
				nachbarPixelIndex = getIndexOfNachbar(i, 6);

			} else if (down_right && !down_left) {// down right
				nachbarPixelIndex = getIndexOfNachbar(i, 8);

			} else if (down_left && down_right) {// both

				if (panel.zufall(50)) {
					nachbarPixelIndex = getIndexOfNachbar(i, 6);
				} else {
					nachbarPixelIndex = getIndexOfNachbar(i, 8);

				}

			}

			switchPixels(i, nachbarPixelIndex);

			return;
		}

		if (name == "Spark") {// spark on ground -> tot
			lifecount--;
			panel.nextPixelArray[i].lifecount--;
		}

		if (name == "Acid" && (acid_through_left || acid_through_right)) {// acid thingy
			if (panel.zufall(panel.acid_chance_to_remove)) {

				if (acid_through_left && !acid_through_right) {// down left
					nachbarPixelIndex = getIndexOfNachbar(i, 6);

				} else if (acid_through_right && !acid_through_left) {// down right
					nachbarPixelIndex = getIndexOfNachbar(i, 8);

				} else if (acid_through_left && acid_through_right) {// both

					if (panel.zufall(50)) {
						nachbarPixelIndex = getIndexOfNachbar(i, 6);
					} else {
						nachbarPixelIndex = getIndexOfNachbar(i, 8);

					}

				}

				lifecount--;
				panel.nextPixelArray[i].lifecount--;

				panel.pixelArray[nachbarPixelIndex].lifecount--;
				panel.nextPixelArray[nachbarPixelIndex].lifecount--;
			}
			acid_through_left = false;
			acid_through_right = false;

			return;
		}

		// =====================================================================================

		// up
		if (i > panel.anzahlPixelWidth - 1) {// must have condition

			nachbarPixelIndex = getIndexOfNachbar(i, 1);

			if (fallUp) {

				if ((density < panel.nextPixelArray[nachbarPixelIndex].density
						&& panel.nextPixelArray[nachbarPixelIndex].fallUp)
						|| panel.nextPixelArray[nachbarPixelIndex].name == "Air") {

					switchPixels(i, nachbarPixelIndex);
					return;

				}
			}
		}

		// ==============

		boolean up_left = false;
		boolean up_right = false;

		// up left
		if (i % panel.anzahlPixelWidth != 0 && i > panel.anzahlPixelWidth - 1) {// must have condition

			nachbarPixelIndex = getIndexOfNachbar(i, 0);

			if (fallUp && slide) {

				if ((density < panel.nextPixelArray[nachbarPixelIndex].density
						&& panel.nextPixelArray[nachbarPixelIndex].fallUp)
						|| panel.nextPixelArray[nachbarPixelIndex].name == "Air") {
					up_left = true;
				}

			}
		}
		// -----------------

		// up right
		if (i > panel.anzahlPixelWidth - 1 && (i + 1) % panel.anzahlPixelWidth != 0) {// must have condition

			nachbarPixelIndex = getIndexOfNachbar(i, 2);

			if (fallUp && slide) {

				if ((density < panel.nextPixelArray[nachbarPixelIndex].density
						&& panel.nextPixelArray[nachbarPixelIndex].fallUp)
						|| panel.nextPixelArray[nachbarPixelIndex].name == "Air") {
					up_right = true;
				}

			}
		}

		if (up_left || up_right) {

			if (up_left && !up_right) {// up left
				nachbarPixelIndex = getIndexOfNachbar(i, 0);

			} else if (up_right && !up_left) {// up right
				nachbarPixelIndex = getIndexOfNachbar(i, 2);

			} else if (up_left && up_right) {// both

				if (panel.zufall(50)) {
					nachbarPixelIndex = getIndexOfNachbar(i, 0);
				} else {
					nachbarPixelIndex = getIndexOfNachbar(i, 2);
				}

			}

			switchPixels(i, nachbarPixelIndex);

			return;
		}

		// =====================================================================================

		boolean left = false;
		boolean right = false;
		acid_through_left = false;
		acid_through_right = false;

		// left
		if (i % panel.anzahlPixelWidth != 0) {// must have condition

			if (gravity && flow) {// is liquid

				if (panel.nextPixelArray[i - 1].name == "Air") {
					left = true;
				} else {

					if (name == "Acid" && panel.nextPixelArray[i - 1].name != "Acid"
							&& panel.nextPixelArray[i - 1].name != "Glass") {// acid thingy

						acid_through_left = true;

					}

					if (panel.nextPixelArray[i].density > panel.nextPixelArray[i - 1].density) {

						if (getChanceToFallThrough(density, panel.nextPixelArray[i - 1].density, 0.5f)) {
							left = true;
						}
					}
				}

			} else if (flow && panel.nextPixelArray[i - 1].name == "Air") {
				if (panel.zufall(80)) {
					left = true;
				}
			}
		}
		// -----------------

		// right
		if ((i + 1) % panel.anzahlPixelWidth != 0) {// must have condition

			if (gravity && flow) {// is liquid

				if (panel.nextPixelArray[i + 1].name == "Air") {
					right = true;
				} else {

					if (name == "Acid" && panel.nextPixelArray[i + 1].name != "Acid"
							&& panel.nextPixelArray[i + 1].name != "Glass") {// acid thingy

						acid_through_right = true;

					}

					if (panel.nextPixelArray[i].density > panel.nextPixelArray[i + 1].density) {

						if (getChanceToFallThrough(density, panel.nextPixelArray[i + 1].density, 0.5f)) {
							right = true;
						}
					}
				}

			} else if (flow && panel.nextPixelArray[i + 1].name == "Air") {
				if (panel.zufall(80)) {
					right = true;
				}
			}
		}

		if (left || right) {

			if (left && !right) {// left
				nachbarPixelIndex = i - 1;

			} else if (right && !left) {// right
				nachbarPixelIndex = i + 1;

			} else if (left && right) {// both

				if (panel.zufall(50)) {
					nachbarPixelIndex = i - 1;
				} else {
					nachbarPixelIndex = i + 1;
				}

			}

			switchPixels(i, nachbarPixelIndex);
			return;
		}

		if (name == "Acid" && (acid_through_left || acid_through_right)) {// acid thingy
			if (panel.zufall(panel.acid_chance_to_remove)) {

				if (acid_through_left && !acid_through_right) {// left
					nachbarPixelIndex = getIndexOfNachbar(i, 3);

				} else if (acid_through_right && !acid_through_left) {// right
					nachbarPixelIndex = getIndexOfNachbar(i, 5);

				} else if (acid_through_left && acid_through_right) {// both

					if (panel.zufall(50)) {
						nachbarPixelIndex = getIndexOfNachbar(i, 3);
					} else {
						nachbarPixelIndex = getIndexOfNachbar(i, 5);

					}

				}

				lifecount--;
				panel.nextPixelArray[i].lifecount--;

				panel.pixelArray[nachbarPixelIndex].lifecount--;
				panel.nextPixelArray[nachbarPixelIndex].lifecount--;
			}

			return;
		}

		// =====================================================================================

	}

}

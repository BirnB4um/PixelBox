
package mainPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class AuswahlPixel extends Pixel {

	public int w, h;
	public Animation animation;

	public AuswahlPixel(int _x, int _y, int _w, int _h, MyPanel panel, String name) {
		super(_x, _y, panel, name);
		w = _w;
		h = _h;

		loadAnimation();
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

		loadAnimation();
	}

	void loadAnimation() {
		if (name == "Fire") {
			animation = new Animation(panel.fireSprite, 20, 20);
		} else if (name == "Air") {
			animation = new Animation(panel.airSprite, 20, 20);
		} else if (name == "Cweeper") {
			animation = new Animation(panel.cweeperSprite, 20, 20);
		} else if (name == "Pig") {
			animation = new Animation(panel.pigSprite, 20, 20);
		} else if (name == "Fish") {
			animation = new Animation(panel.fishSprite, 20, 20);
		} else if (name == "Bee") {
			animation = new Animation(panel.beeSprite, 20, 20);
		} else if (name == "Bird") {
			animation = new Animation(panel.birdSprite, 20, 20);
		} else if (name == "Water") {
			animation = new Animation(panel.waterSprite, 20, 20);
		} else if (name == "Fuse") {
			animation = new Animation(panel.fuseSprite, 20, 20);
		} else if (name == "Leaf") {
			animation = new Animation(panel.leafSprite, 20, 20);
		} else if (name == "Glass") {
			animation = new Animation(panel.glassSprite, 20, 20);
		} else if (name == "Ice") {
			animation = new Animation(panel.iceSprite, 20, 20);
		} else if (name == "Uran") {
			animation = new Animation(panel.uranSprite, 20, 20);
		} else if (name == "Grass") {
			animation = new Animation(panel.grassSprite, 20, 20);
		} else if (name == "Spark") {
			animation = new Animation(panel.sparkSprite, 20, 20);
		} else if (name == "Oil") {
			animation = new Animation(panel.oilSprite, 20, 20);
		} else if (name == "Acid") {
			animation = new Animation(panel.acidSprite, 20, 20);
		} else if (name == "Blood") {
			animation = new Animation(panel.bloodSprite, 20, 20);
		} else if (name == "Cloud") {
			animation = new Animation(panel.cloudSprite, 20, 20);
		} else if (name == "Gravitychanger") {
			animation = new Animation(panel.gchangerSprite, 20, 20);
		} else if (name == "Repeater") {
			animation = new Animation(panel.repeaterSprite, 20, 20);
		} else if (name == "Battery") {
			animation = new Animation(panel.batterySprite, 20, 20);
		} else if (name == "Lava") {
			animation = new Animation(panel.lavaSprite, 20, 20);
		} else if (name == "Napalm") {
			animation = new Animation(panel.napalmSprite, 20, 20);
		} else if (name == "Nitro") {
			animation = new Animation(panel.nitroSprite, 20, 20);
		} else if (name == "Saltwater") {
			animation = new Animation(panel.saltwaterSprite, 20, 20);
		} else if (name == "Smoke") {
			animation = new Animation(panel.smokeSprite, 20, 20);
		} else if (name == "Steam") {
			animation = new Animation(panel.steamSprite, 20, 20);
		} else if (name == "Gas") {
			animation = new Animation(panel.gasSprite, 20, 20);
		} else if (name == "Wax") {
			animation = new Animation(panel.waxSprite, 20, 20);
		} else {
			animation = null;
		}
	}

	void draw(Graphics2D g2d) {
		if (animation == null) {
			loadAnimation();
		}
		if (animation != null) {
			animation.draw(g2d, panel.globalAnimationCount, posX, posY, w, h);
			return;
		}

		Image img = panel.sprite;

		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		int W = 20;
		int H = 20;
		int anzahlImgWInSprite = (int) (imgW / W);
		int anzahlImgHInSprite = (int) (imgH / H);
		anzahlImgHInSprite = anzahlImgHInSprite + 1 - 1;// nur um warnung wegzumachen

		int dx = 0;
		int dy = 0;

		int index = 0;

		// with index in sprite

		if (name == "Air") {
			index = 0;
		} else if (name == "Dirt") {
			index = 1;
		} else if (name == "Sand") {
			index = 2;
		} else if (name == "Water") {
			index = 3;
		} else if (name == "Lava") {
			index = 4;
		} else if (name == "Fire") {
			index = 5;
		} else if (name == "Steam") {
			index = 6;
		} else if (name == "Wood") {
			index = 7;
		} else if (name == "Cloud") {
			index = 8;
		} else if (name == "Smoke") {
			index = 9;
		} else if (name == "Stone") {
			index = 10;
		} else if (name == "Leaf") {
			index = 11;
		} else if (name == "Oil") {
			index = 12;
		} else if (name == "Fuse") {
			index = 13;
		} else if (name == "Gas") {
			index = 14;
		} else if (name == "TNT") {
			index = 15;
		} else if (name == "Bird") {
			index = 16;
		} else if (name == "Acid") {
			index = 17;
		} else if (name == "Glass") {
			index = 18;
		} else if (name == "Ash") {
			index = 19;
		}
		// === new line ==
		else if (name == "Bee") {
			index = 20;
		} else if (name == "Wax") {
			index = 21;
		} else if (name == "Metal") {
			index = 22;
		} else if (name == "Spark") {
			index = 23;
		} else if (name == "Cloner") {
			index = 24;
		} else if (name == "Ice") {
			index = 25;
		} else if (name == "Nitro") {
			index = 26;
		} else if (name == "Salt") {
			index = 27;
		} else if (name == "Saltwater") {
			index = 28;
		} else if (name == "Lufter") {
			index = 29;
		} else if (name == "Battery") {
			index = 30;
		} else if (name == "Grass") {
			index = 31;
		} else if (name == "Repeater") {
			index = 32;
		} else if (name == "Barrier") {
			index = 33;
		} else if (name == "Fish") {
			index = 34;
		} else if (name == "Pig") {
			index = 35;
		} else if (name == "Cweeper") {
			index = 36;
		} else if (name == "Uran") {
			index = 37;
		} else if (name == "Napalm") {
			index = 38;
		} else if (name == "Gravitychanger") {
			index = 39;
		}
		// === new line ==
		else if (name == "Blood") {
			index = 40;
		} else if (name == "") {
			index = 41;
		} else if (name == "") {
			index = 42;
		} else if (name == "") {
			index = 43;
		} else if (name == "") {
			index = 44;
		} else if (name == "") {
			index = 45;
		} else if (name == "") {
			index = 46;
		} else if (name == "") {
			index = 47;
		} else if (name == "") {
			index = 48;
		} else if (name == "") {
			index = 49;
		} else if (name == "") {
			index = 50;
		} else if (name == "") {
			index = 51;
		} else if (name == "") {
			index = 52;
		} else if (name == "") {
			index = 53;
		} else if (name == "") {
			index = 54;
		} else if (name == "") {
			index = 55;
		} else if (name == "") {
			index = 56;
		} else if (name == "") {
			index = 57;
		} else if (name == "") {
			index = 58;
		} else if (name == "") {
			index = 59;
		}

		// other
		else if (name == "gas") {
			index = 140;
		} else if (name == "liquid") {
			index = 141;
		} else if (name == "solid") {
			index = 142;
		} else if (name == "technic") {
			index = 143;
		} else if (name == "animals") {
			index = 144;
		}

		dx = (index % anzahlImgWInSprite) * W;
		dy = (int) (index / anzahlImgWInSprite) * H;
		g2d.drawImage(img, posX, posY, posX + w, posY + h, dx, dy, dx + W, dy + H, null);
	}

	public boolean mouseOverPixel(float mouseX, float mouseY) {
		if (mouseX > posX && mouseX <= posX + w && mouseY > posY && mouseY <= posY + h) {
			return true;
		}
		return false;
	}

	void info(Graphics2D g2D) {
		int dx = 20;
		int infoDy = 85;
		g2D.setStroke(new BasicStroke(4));

		int wX, wY, wW, wH;

		if (name == "Dirt") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Sand") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Water") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Lava") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Fire") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Air") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 130;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Steam") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Wood") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Cloud") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Smoke") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Stone") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Leaf") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Oil") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Fuse") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Gas") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "TNT") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Bird") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Acid") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Glass") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Ash") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Bee") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Wax") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Metal") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 180;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Spark") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Cloner") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 210;
			wH = 100;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("set first touched block", wX + 15, wY + infoDy);

		} else if (name == "Ice") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Nitro") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Salt") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Saltwater") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 310;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Lufter") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 210;
			wH = 100;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("weird name", wX + 15, wY + infoDy);

		} else if (name == "Battery") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 240;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Repeater") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 270;
			wH = 100;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("Delay can be changed", wX + 15, wY + infoDy);

		} else if (name == "Barrier") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 240;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Fish") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Pig") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 140;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Cweeper") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 250;
			wH = 100;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("Originelle Idee", wX + 15, wY + infoDy);

		} else if (name == "Uran") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 160;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Napalm") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 210;
			wH = 100;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("explodiert nicht!", wX + 15, wY + infoDy);

		} else if (name == "Grass") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Gravitychanger") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 460;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		} else if (name == "Blood") {
			wX = (int) panel.mouseX + dx;
			wY = (int) panel.mouseY + dx;
			wW = 200;
			wH = 60;

			if (wX + wW >= panel.width) {
				wX -= 2 * dx + wW;
			}

			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect(wX, wY, wW, wH);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(wX, wY, wW, wH);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString(name, wX + 20, wY + 40);

			g2D.setFont(panel.myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("", wX + 15, wY + infoDy);

		}

		// ===== Categories =====

		else if (name == "gas") {
			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 130, 60);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 130, 60);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Gas", panel.mouseX + dx + 20, panel.mouseY + dx + 40);
		} else if (name == "liquid") {
			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 220, 60);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 220, 60);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Liquid", panel.mouseX + dx + 20, panel.mouseY + dx + 40);

		} else if (name == "solid") {
			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 190, 60);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 190, 60);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Solid", panel.mouseX + dx + 20, panel.mouseY + dx + 40);

		} else if (name == "technic") {
			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 250, 60);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 250, 60);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Technic", panel.mouseX + dx + 20, panel.mouseY + dx + 40);

		} else if (name == "animals") {
			g2D.setColor(new Color(40, 40, 60));
			g2D.fillRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 240, 60);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect((int) panel.mouseX + dx, (int) panel.mouseY + dx, 240, 60);

			g2D.setFont(panel.myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Animals", panel.mouseX + dx + 20, panel.mouseY + dx + 40);

		}

	}

}

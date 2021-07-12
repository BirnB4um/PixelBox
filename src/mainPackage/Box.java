package mainPackage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Box {
	public int posX;
	public int posY;
	public int boxWidth;
	public int boxHeight;
	public boolean fillRect;
	public int r, g, b, a;
	public int imgIndex;
	private boolean drawImage = false;
	MyPanel panel = null;

	public Box(int posX, int posY, int width, int height, Color color, boolean fillRect) {
		this.posX = posX;
		this.posY = posY;
		boxWidth = width;
		boxHeight = height;
		this.r = color.getRed();
		this.g = color.getGreen();
		this.b = color.getBlue();
		this.a = color.getAlpha();
		this.fillRect = fillRect;
	}

	public Box(MyPanel panel, int posX, int posY, int width, int height, int imgIndex) {
		this.panel = panel;
		this.posX = posX;
		this.posY = posY;
		boxWidth = width;
		boxHeight = height;
		this.imgIndex = imgIndex;
		drawImage = true;
	}

	void draw(Graphics2D g2D) {
		if (!drawImage) {
			g2D.setColor(new Color(r, g, b, a));
			if (fillRect) {
				g2D.fillRect(posX, posY, boxWidth, boxHeight);
			} else {
				g2D.drawRect(posX, posY, boxWidth, boxHeight);
			}
		} else {
			Image img = panel.sprite;

			int imgW = img.getWidth(null);
			int W = 20;
			int H = 20;
			int anzahlImgWInSprite = (int) (imgW / W);

			int dx = 0;
			int dy = 0;

			dx = (imgIndex % anzahlImgWInSprite) * W;
			dy = (int) (imgIndex / anzahlImgWInSprite) * H;
			g2D.drawImage(img, posX, posY, posX + boxWidth, posY + boxHeight, dx, dy, dx + W, dy + H, null);
		}
	}

	private int constrain(long nr, int min, int max) {
		if (nr > max) {
			return max;
		} else if (nr < min) {
			return min;
		}
		return (int) nr;
	}

	void darken(int darkenSpeed) {
		if (a > 0)
			a = constrain(a - darkenSpeed, 0, 255);
	}

	public void setAlpha(int a) {
		this.a = a;
	}

	public void setColor(int r, int g, int b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public boolean mouseOverPixel(float mouseX, float mouseY) {
		if (mouseX > posX && mouseX <= posX + boxWidth && mouseY > posY && mouseY <= posY + boxHeight) {
			return true;
		}
		return false;
	}

}

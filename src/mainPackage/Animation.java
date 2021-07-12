package mainPackage;

import java.awt.Graphics2D;
import java.awt.Image;

public class Animation {

	/*
	 * Spriteframes immer untereinander
	 */

	Image sprite;
	private int nr;
	private int imgW, imgH;
	private int  rows;

	public Animation(Image sprite, int w, int h) {
		this.sprite = sprite;
		nr = 0;
		imgW = w;
		imgH = h;

		if (sprite.getWidth(null) % w != 0 || sprite.getHeight(null) % h != 0) {
			System.out.println("ERROR: false spriteformat!");
		}

//		cols = sprite.getWidth(null) / imgW;// y
		rows = sprite.getHeight(null) / imgH;// x

	}

	public int nextFrame() {
		nr = (nr == rows - 1) ? 0 : nr + 1;
		return nr;
	}

	public void draw(Graphics2D g2D, int posX, int posY, int w, int h) {
		g2D.drawImage(sprite, posX, posY, posX + w, posY + h, 0, imgH * nr, imgW, imgH * (nr + 1), null);

	}

	public void draw(Graphics2D g2D, int nr, int posX, int posY, int w, int h) {
		nr = nr % rows;
		g2D.drawImage(sprite, posX, posY, posX + w, posY + h, 0, imgH * nr, imgW, imgH * (nr + 1), null);

	}

}

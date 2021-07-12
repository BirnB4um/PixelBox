package mainPackage;

import java.awt.Graphics2D;
import java.awt.Image;

public class MainSprite {
	MyPanel panel;

	public MainSprite(MyPanel p) {
		panel = p;

	}

	public void drawPartOfSprite(Graphics2D g2D, int posX, int posY, int width, int height, int index) {
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

		dx = (index % anzahlImgWInSprite) * W;
		dy = (int) (index / anzahlImgWInSprite) * H;
		g2D.drawImage(img, posX, posY, posX + width, posY + height, dx, dy, dx + W, dy + H, null);
	}

}

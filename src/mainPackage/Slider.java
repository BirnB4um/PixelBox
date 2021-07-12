package mainPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Slider {
	public MyPanel panel;

	public final int posX, posY;
	public final int WIDTH;
	public final int PointWIDTH, PointHEIGHT;

	public boolean moveWithMouse = false;

	public float value;

	public Slider(int x, int y, int width, int PointRadius, float value, MyPanel p) {
		this.posX = x;
		this.posY = y;
		this.WIDTH = width;
		if (value < 0f)
			value = 0f;
		if (value > 1f)
			value = 1f;
		this.value = value;
		this.PointWIDTH = PointRadius * 2;
		this.PointHEIGHT = PointRadius * 2;
		this.panel = p;

	}

	public void draw(Graphics2D g2D) {
		if (moveWithMouse) {
			update();
		}

		// line
		g2D.setColor(Color.white);
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine(posX, posY, posX + WIDTH, posY);

		// point
		g2D.fillOval((int) (posX + WIDTH * value - PointWIDTH / 2), posY - PointHEIGHT / 2, PointWIDTH, PointHEIGHT);

	}

	public boolean mouseOverPoint(float mouseX, float mouseY) {

		if (mouseX >= posX + WIDTH * value - PointWIDTH / 2 && mouseX <= posX + WIDTH * value + PointWIDTH / 2
				&& mouseY >= posY - PointHEIGHT / 2 && mouseY <= posY + PointWIDTH / 2) {
			moveWithMouse = true;
			return true;
		}
		moveWithMouse = false;
		return false;

	}

	void update() {

		value = ((float) panel.mouseX - posX) / WIDTH;
		if (value < 0f)
			value = 0f;
		if (value > 1f)
			value = 1f;

		panel.placeVolume = value;
	}

}

package Listeners;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import mainPackage.MyPanel;

public class mouseWheelListener implements MouseWheelListener {

	MyPanel panel;

	public mouseWheelListener(MyPanel panel) {
		this.panel = panel;
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (!panel.drawLine && !panel.drawRect) {
			if (e.isControlDown()) {
				if (e.getWheelRotation() <= 0) {
					panel.zoomFactor++;
					if (panel.zoomFactor > panel.maxZoomFactor) {
						panel.zoomFactor = panel.maxZoomFactor;
					} else {
						// zoom in
						panel.offsetX -= (panel.mouseX - panel.offsetLeft)
								* ((panel.zoomFactor) - (panel.zoomFactor - 1));//
						panel.offsetY -= (panel.mouseY - panel.offsetUp)
								* ((panel.zoomFactor) - (panel.zoomFactor - 1));
					}

				}
				if (e.getWheelRotation() >= 0 && panel.zoomFactor > 1) {
					panel.zoomFactor--;

					// zoom out
					panel.offsetX += (panel.mouseX - panel.offsetLeft) * ((panel.zoomFactor) - (panel.zoomFactor - 1));
					panel.offsetY += (panel.mouseY - panel.offsetUp) * ((panel.zoomFactor) - (panel.zoomFactor - 1));

				}

			} else {

				if (e.getWheelRotation() <= 0 && panel.brushSize <= panel.maxBrushSize - panel.brushSizeChangeSpeed) {// increase
																														// brushsize
					panel.brushSize += panel.brushSizeChangeSpeed;
				} else if (e.getWheelRotation() >= 0) {// decrease brushsize
					panel.brushSize -= panel.brushSizeChangeSpeed;
				}

				if (panel.brushSize < panel.minBrushSize)
					panel.brushSize = panel.minBrushSize;
				if (panel.brushSize > panel.maxBrushSize)
					panel.brushSize = panel.maxBrushSize;

				panel.brushColor = 300;
			}
		}

	}

}

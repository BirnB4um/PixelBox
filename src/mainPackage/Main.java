package mainPackage;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Listeners.keyListener;
import Listeners.mouseListener;
import Listeners.mouseMotionListener;
import Listeners.mouseWheelListener;

public class Main {

	/*
	 * Sorry for messy/inconsistent code. This is my first game made in Java. Hope you like it :)
	 */

	static MyPanel panel;
	static JFrame jf;
	static JFrame fjf;

	private static int width = 450;
	private static int height = 380;

	private static int anzahlPixelWidth;

	static boolean fullscreen;
	static boolean startGame = false;
	static boolean drawimg;

	public static void playSound(String filepath) {

		try {
			File musicPath = new File(filepath);
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.loop(3);

				// JOptionPane.showMessageDialog(null, "Press OK to stop playing");
			} else {
				System.out.println("cant find file");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Starting...");

		fjf = new JFrame();
		fjf.setTitle("Choose Settings");
		fjf.setResizable(false);
		fjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fjf.setSize(250, 200);
		fjf.setLocationRelativeTo(null);

//		int screen = 1;
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		GraphicsDevice[] gde = ge.getScreenDevices();
//		int width = 0, height = 0;
//		if (screen > -1 && screen < gde.length) {
//			width = gde[screen].getDefaultConfiguration().getBounds().width;
//			height = gde[screen].getDefaultConfiguration().getBounds().height;
//			fjf.setLocation(
//					((width / 2) - (fjf.getSize().width / 2)) + gde[screen].getDefaultConfiguration().getBounds().x,
//					((height / 2) - (fjf.getSize().height / 2)) + gde[screen].getDefaultConfiguration().getBounds().y);
//			fjf.setVisible(true);
//		} else {
//			throw new RuntimeException("No Screens Found");
//		}

		JPanel p = new JPanel();

		String pixelAnzahlListe[] = { "10 pixel breit", "20 pixel breit", "50 pixel breit", "100 pixel breit",
				"Pixelbreite = 4" };
		JComboBox<String> pixelAnzahlAuswahl = new JComboBox<String>(pixelAnzahlListe);
		p.add(pixelAnzahlAuswahl);
		pixelAnzahlAuswahl.setSelectedIndex(3);

		String screenSizeListe[] = { "950 x 700", "Fullscreen" };
		JComboBox<String> ScreenSizeAuswahl = new JComboBox<String>(screenSizeListe);
		p.add(ScreenSizeAuswahl);
		ScreenSizeAuswahl.setSelectedIndex(0);

//		JCheckBox checkBox = new JCheckBox("use images", true);
//		p.add(checkBox);

		JButton runButton = new JButton("Run Game");

		p.add(runButton);
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame = true;
			}
		});

		fjf.add(p);
		fjf.setVisible(true);

		while (true) {

			if (startGame) {
				// playSound("res/song.wav");
				if (pixelAnzahlAuswahl.getSelectedItem() == "10 pixel breit") {
					anzahlPixelWidth = 10;
				} else if (pixelAnzahlAuswahl.getSelectedItem() == "20 pixel breit") {
					anzahlPixelWidth = 20;
				} else if (pixelAnzahlAuswahl.getSelectedItem() == "50 pixel breit") {
					anzahlPixelWidth = 50;
				} else if (pixelAnzahlAuswahl.getSelectedItem() == "100 pixel breit") {
					anzahlPixelWidth = 100;
				} else if (pixelAnzahlAuswahl.getSelectedItem() == "Pixelbreite = 4") {
					anzahlPixelWidth = 1000;
				} else if (pixelAnzahlAuswahl.getSelectedItem() == "MAXIMALE PIXEL BREITE!!!") {
					anzahlPixelWidth = 10000;
				}

				if (ScreenSizeAuswahl.getSelectedItem() == "950 x 700") {
					width = 950;
					height = 700;
					fullscreen = false;
				} else if (ScreenSizeAuswahl.getSelectedItem() == "Fullscreen") {
					fullscreen = true;
				}

//				if (checkBox.isSelected()) {
//					drawimg = true;
//				} else {
//					drawimg = false;
//				}

				startGame = false;
				fjf.setVisible(false);
				fjf.dispose();

				GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

				jf = new JFrame();

				if (fullscreen) {
					jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
					jf.setUndecorated(true);
					panel = new MyPanel(jf, gd.getDisplayMode().getWidth() * 4 / 5,
							gd.getDisplayMode().getHeight() * 4 / 5, anzahlPixelWidth, fullscreen);
				} else {
					jf.setSize(width + 15, height + 38);
					panel = new MyPanel(jf, width, height, anzahlPixelWidth, fullscreen);// 182 = max
				}

				jf.setTitle("PixelBox");
				jf.setResizable(false);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setLocationRelativeTo(null);
				jf.add(panel);
				jf.addKeyListener(new keyListener(panel));
				jf.addMouseListener(new mouseListener(panel));
				jf.addMouseMotionListener(new mouseMotionListener(panel));
				jf.addMouseWheelListener(new mouseWheelListener(panel));
				jf.setVisible(true);

				break;
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Thread.sleep error");
				e.printStackTrace();
			}
		}
	}

}

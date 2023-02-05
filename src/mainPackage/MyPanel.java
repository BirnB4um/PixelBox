
package mainPackage;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	// info/credits
	private final String version = "1.2";
	private final String programmer = "Thimo Thorandt";
	private final String graphicDesigner = "Thimo Thorandt";
	private final String soundArtist = "Joe der krasse";

	// ?
	private static final long serialVersionUID = 1L;

	// keys
	public int KEY_BACK = 8;
	public int KEY_ENTER = 10;
	public int KEY_SHIFT = 16;
	public int KEY_CTRL = 17;
	public int KEY_ALT = 18;
	public int KEY_ESC = 27;
	public int KEY_SPACE = 32;
	public int KEY_LEFT = 37;
	public int KEY_UP = 38;
	public int KEY_RIGHT = 39;
	public int KEY_DOWN = 40;
	public int KEY_MINUS = 45;
	public int KEY_PLUS = 521;

	public int KEY_0 = 48;
	public int KEY_1 = 49;
	public int KEY_2 = 50;
	public int KEY_3 = 51;
	public int KEY_4 = 52;
	public int KEY_5 = 53;
	public int KEY_6 = 54;
	public int KEY_7 = 55;
	public int KEY_8 = 56;
	public int KEY_9 = 57;

	public int KEY_A = 65;
	public int KEY_B = 66;
	public int KEY_C = 67;
	public int KEY_D = 68;
	public int KEY_E = 69;
	public int KEY_F = 70;
	public int KEY_G = 71;
	public int KEY_H = 72;
	public int KEY_I = 73;
	public int KEY_J = 74;
	public int KEY_K = 75;
	public int KEY_L = 76;
	public int KEY_M = 77;
	public int KEY_N = 78;
	public int KEY_O = 79;
	public int KEY_P = 80;
	public int KEY_Q = 81;
	public int KEY_R = 82;
	public int KEY_S = 83;
	public int KEY_T = 84;
	public int KEY_U = 85;
	public int KEY_V = 86;
	public int KEY_W = 87;
	public int KEY_X = 88;
	public int KEY_Y = 89;
	public int KEY_Z = 90;

	// startingvalue for pixels
	public int wood_lifecount = 70;
	public int steam_lifecount = 12;
	public int lava_lifecount = 4;
	public int fire_lifecount = 6;
	public int cloud_lifecount = 1000;
	public int smoke_lifecount = 24;
	public int leaf_lifecount = 4;
	public int oil_lifecount = 14;
	public int fuse_lifecount = 3;
	public int gas_lifecount = 2;
	public int tnt_lifecount = 20;
	public int bird_lifecount = 25;
	public int acid_lifecount = 12;
	public int stone_lifecount = 10;
	public int water_lifecount = 2;
	public int sand_lifecount = 3;
	public int dirt_lifecount = 4;
	public int glass_lifecount = 2;
	public int ash_lifecount = 1;
	public int bee_lifecount = 15;
	public int wax_lifecount = 60;
	public int metal_lifecount = 20;
	public int spark_lifecount = 3;
	public int cloner_lifecount = 999;
	public int ice_lifecount = 6;
	public int nitro_lifecount = 3;
	public int salt_lifecount = 12;
	public int saltwater_lifecount = 6;
	public int grass_lifecount = 6;
	public int Battery_lifecount = 10;
	public int fish_lifecount = 12;
	public int pig_lifecount = 12;
	public int Cweeper_lifecount = 30;
	public int uran_lifecount = 16;
	public int napalm_lifecount = 16;
	public int gravitychanger_lifecount = 16;
	public int lead_lifecount = 15;
	public int transmitter_lifecount = 15;
	public int receiver_lifecount = 15;

	public int tnt_sprengradius;
	public int acid_chance_to_remove = 70;

	public int maxTransmissionData = 30;
	public float mutationChance = 0.5f;

	// other stuff
	JFrame jf;
	public Random rand;
	public int width, height;
	public int offsetRight = 20;
	public int offsetLeft = 20;// changeable
	public int offsetUp = 90;// changeable
	public int offsetDown = 20;
	public int offsetX, offsetY;
	public long startFrameTime;
	public int gridAbstand;
	public int zoomFactor;
	public int maxZoomFactor;
	public boolean fullscreen;
	public boolean devMode = false;// strg + alt Gr + Enter
	boolean firstFrame = true;
	public int ausgewaehlteInfoNummer = 1;
	public int mem = 0;
	public int maxMemMB;
	private int clearMemCounter = 0;
	Runtime runtime = Runtime.getRuntime();

	// mouse
	public int mouseX, mouseY;
	public int[] startMousePos;
	public int mouseOverPixelIndex;
	public int mouseButtonPressed = 0;

	// Brush
	public int brushSize;
	public int minBrushSize;
	public int maxBrushSize;
	public int brushSizeChangeSpeed;
	public int brushColor;
	private int brushColorFadeSpeed;

	// fps
	public int frameRate;
	public int fps;
	private long fpsUpdateTimeNow;
	private int fpsUpdateTime;

	// fps gamestep
	int stepFrameRate = 12;// normal gamerate
	public float stepFrameRateFactor = 1.0f;
	long time = System.currentTimeMillis();
	int stepTime = (int) (1000 / (stepFrameRate * stepFrameRateFactor));

	// pixels
	public int anzahlPixelWidth;
	public int anzahlPixelHeight;
	public int pixelWidth;
	public int pixelHeight;
	public int pixelAbstand;
	public Pixel[] pixelArray;
	public Pixel[] nextPixelArray;

	public ArrayList<Integer> changeIndexList = new ArrayList<Integer>();

	// modes/screens
	public boolean pause = false;
	public boolean oneStep = false;
	public boolean drawGrid = false;
	public boolean fillMode = false;
	public boolean drawPasteFrame = false;
	public boolean replaceBlocks = true;
	public boolean drawLine = false;
	public boolean drawRect = false;
	public boolean showInfo = false;

	public boolean auswahlMenu = false;
	public boolean helpMenu = false;
	public boolean settingsMenu = false;
	public boolean gameScreen = true;

	// Boxes
	public Box auswahlPixelBox;
	public Box stepSpeedBox;
	public Box brushSizeBox;
	public Box zoomBox;
	public Box fillBox;
	public Box replaceBlocksBox;
	public Box copyBox;
	public Box copyInnerBox;
	public Box settingsBox;
	public Box muteBox;
	public Box mutePlaceSoundBox;

	// selected pixel
	public AuswahlPixel ausgewaehlterPixel;

	// copy area
	public boolean copyMode = false;
	public Pixel[][] copyPixelList;
	public Pixel copyStartpoint;
	public Pixel copyEndpoint;

	// Animation
	public int globalAnimationCount;
	public int animationFPS = 7;
	private long animationTimer = 0;

	// animation Images
	Image sprite;
	Image fireSprite;
	Image airSprite;
	Image cweeperSprite;
	Image pigSprite;
	Image fishSprite;
	Image beeSprite;
	Image birdSprite;
	Image waterSprite;
	Image fuseSprite;
	Image leafSprite;
	Image glassSprite;
	Image iceSprite;
	Image uranSprite;
	Image grassSprite;
	Image sparkSprite;
	Image oilSprite;
	Image acidSprite;
	Image bloodSprite;
	Image cloudSprite;
	Image gchangerSprite;
	Image repeaterSprite;
	Image batterySprite;
	Image lavaSprite;
	Image napalmSprite;
	Image nitroSprite;
	Image saltwaterSprite;
	Image smokeSprite;
	Image steamSprite;
	Image gasSprite;
	Image waxSprite;

	// Diagrams
	ArrayList<Integer> memHistory = new ArrayList<Integer>();
	public final int maxMemCount = 40;
	ArrayList<Integer> fpsHistory = new ArrayList<Integer>();
	public final int maxFpsCount = 40;

	// Items/Categories
	public AuswahlPixel[] auswahlPixelArray;
	public String listOfAllItems[] = { "Air", "Dirt", "Sand", "Water", "Lava", "Fire", "Steam", "Wood", "Cloud",
			"Smoke", "Stone", "Oil", "Fuse", "Leaf", "Gas", "TNT", "Bird", "Acid", "Glass", "Ash", "Bee", "Wax",
			"Metal", "Spark", "Cloner", "Ice", "Nitro", "Salt", "Saltwater", "Lufter", "Battery", "Grass", "Repeater",
			"Barrier", "Fish", "Pig", "Cweeper", "Uran", "Napalm", "Gravitychanger", "Blood", "Lead", "Transmitter",
			"Receiver" };
	public AuswahlPixel[] categoryPixels;
	public int showWhichCategoryItems = -1; // 0:Gas 1:liquid 2:solid 3:technic 4:animals
	public String[] allCategories = { "gas", "liquid", "solid", "technic", "animals" };
	public String animalList[] = { "Bird", "Bee", "Fish", "Pig", "Cweeper" };
	public String solidItems[] = { "Dirt", "Sand", "Wood", "Stone", "Fuse", "Leaf", "TNT", "Glass", "Ash", "Wax", "Ice",
			"Salt", "Grass", "Uran", "Metal" };
	public String liquidItems[] = { "Water", "Saltwater", "Oil", "Acid", "Lava", "Nitro", "Napalm", "Blood" };
	public String gasItems[] = { "Air", "Steam", "Cloud", "Smoke", "Gas", "Fire" };
	public String technicItems[] = { "Spark", "Cloner", "Metal", "Lufter", "Battery", "Repeater", "Barrier",
			"Gravitychanger" };

	// Sounds
	public int maxAnzahlSounds = 100;
	public ArrayList<Sound> runningSound = new ArrayList<Sound>();
	public boolean playPlaceSound = true;
	public long playSoundTimer = 0L;
	public int playSoundChecktime = 200; // 5 fps
	public boolean muteSound = false;
	public int soundCountForEachBlock[] = new int[listOfAllItems.length];
	public int maxSoundCountForEachBlock[] = new int[listOfAllItems.length];

	// Sound-Volume
	public float masterVolume;
	public float placeVolume;
	public float place2Volume;
	public float changeSpeedVolume;
	public float explosionVolume;
	public float copyVolume;

	// Fonts
	Font myFont = null;
	Font myFontLittle = null;

	// undo
	public int maxHistorySize = 21;
	public ArrayList<Pixel[]> historyPixelList = new ArrayList<Pixel[]>();
	public int undoPosition = 0;

	// trash
//	MainSprite mainSprite = new MainSprite(this);

	/*
	 * =============================================================================
	 * =============================================================================
	 * =============================================================================
	 */

	// Konstruktor
	public MyPanel(JFrame jf, int _width, int _height, int anzahlPixelWidth, boolean fullscreen) {

		System.out.println();
		System.out.println("Version: " + version);
		System.out.println("Programmer: " + programmer);
		System.out.println("Graphic designer: " + graphicDesigner);
		System.out.println("Sound artist: " + soundArtist);
		System.out.println();

		this.jf = jf;
		this.fullscreen = fullscreen;
		this.width = _width;
		this.height = _height;

		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.load("/fonts/BlockFont.ttf")).deriveFont(30f);
			myFontLittle = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.load("/fonts/MC_Font.ttf"))
					.deriveFont(20f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		// check if liste stimmt
//		if (listOfAllItems.length != liquidItems.length + gasItems.length + solidItems.length + technicItems.length
//				+ animalList.length)
//			System.out.println("laenge der liste stimmt nicht");

//		// hide cursor
//		// Transparent 16 x 16 pixel cursor image.
//		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
//		// Create a new blank cursor.
//		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
//		// Set the blank cursor to the JFrame.
//		jf.getContentPane().setCursor(blankCursor);

		startMousePos = new int[2];

		// max sounds
		for (int i = 0; i < maxSoundCountForEachBlock.length; i++) {

			if (listOfAllItems[i] == "TNT") {
				maxSoundCountForEachBlock[i] = 10;
				continue;
			} else if (listOfAllItems[i] == "Lufter") {
				maxSoundCountForEachBlock[i] = 16;
				continue;
			} else if (listOfAllItems[i] == "Cweeper") {
				maxSoundCountForEachBlock[i] = 10;
				continue;
			}

			// default
			maxSoundCountForEachBlock[i] = 3;
		}

		try {
//			File f = new File("res/images/sprite.png");
//			if (f.exists()) {
//				sprite = new ImageIcon("res/images/sprite.png").getImage();
//			} else {
//				this.drawImg = false;
//				System.out.println("nonono file");
//			}

			sprite = ImageIO.read(ResourceLoader.load("images/sprite.png"));
			fireSprite = ImageIO.read(ResourceLoader.load("images/fire.png"));
			airSprite = ImageIO.read(ResourceLoader.load("images/air.png"));
			cweeperSprite = ImageIO.read(ResourceLoader.load("images/cweeper.png"));
			pigSprite = ImageIO.read(ResourceLoader.load("images/pig.png"));
			fishSprite = ImageIO.read(ResourceLoader.load("images/fish.png"));
			beeSprite = ImageIO.read(ResourceLoader.load("images/bee.png"));
			birdSprite = ImageIO.read(ResourceLoader.load("images/bird.png"));
			waterSprite = ImageIO.read(ResourceLoader.load("images/water.png"));
			fuseSprite = ImageIO.read(ResourceLoader.load("images/fuse.png"));
			leafSprite = ImageIO.read(ResourceLoader.load("images/leaf.png"));
			glassSprite = ImageIO.read(ResourceLoader.load("images/glass.png"));
			iceSprite = ImageIO.read(ResourceLoader.load("images/ice.png"));
			uranSprite = ImageIO.read(ResourceLoader.load("images/uran.png"));
			grassSprite = ImageIO.read(ResourceLoader.load("images/grass.png"));
			sparkSprite = ImageIO.read(ResourceLoader.load("images/spark.png"));
			oilSprite = ImageIO.read(ResourceLoader.load("images/oil.png"));
			acidSprite = ImageIO.read(ResourceLoader.load("images/acid.png"));
			bloodSprite = ImageIO.read(ResourceLoader.load("images/blood.png"));
			cloudSprite = ImageIO.read(ResourceLoader.load("images/cloud.png"));
			gchangerSprite = ImageIO.read(ResourceLoader.load("images/gchanger.png"));
			repeaterSprite = ImageIO.read(ResourceLoader.load("images/repeater.png"));
			batterySprite = ImageIO.read(ResourceLoader.load("images/battery.png"));
			lavaSprite = ImageIO.read(ResourceLoader.load("images/lava.png"));
			napalmSprite = ImageIO.read(ResourceLoader.load("images/napalm.png"));
			nitroSprite = ImageIO.read(ResourceLoader.load("images/nitro.png"));
			saltwaterSprite = ImageIO.read(ResourceLoader.load("images/saltwater.png"));
			smokeSprite = ImageIO.read(ResourceLoader.load("images/smoke.png"));
			steamSprite = ImageIO.read(ResourceLoader.load("images/steam.png"));
			gasSprite = ImageIO.read(ResourceLoader.load("images/gas.png"));
			waxSprite = ImageIO.read(ResourceLoader.load("images/wax.png"));

		} catch (Exception e) {
			System.out.println("Sprite nicht gefunden");
			e.printStackTrace();

		}

		globalAnimationCount = -1;

		// if >0 might break the game :)
		this.pixelAbstand = 0;// 0 -> no space / 3 -> a bit space | 3 is a bit weird

		if (anzahlPixelWidth == 10000) {
			this.pixelWidth = 1;
			this.pixelHeight = this.pixelWidth;

			this.anzahlPixelWidth = (int) (width - (offsetRight + offsetLeft)) / (pixelWidth + pixelAbstand);
			this.anzahlPixelHeight = (int) (height - (offsetUp + offsetDown)) / (pixelHeight + pixelAbstand);

		} else if (anzahlPixelWidth == 1000) {
			this.pixelWidth = 4;// 1
			this.pixelHeight = this.pixelWidth;

			this.anzahlPixelWidth = (int) (width - (offsetRight + offsetLeft)) / (pixelWidth + pixelAbstand);
			this.anzahlPixelHeight = (int) (height - (offsetUp + offsetDown)) / (pixelHeight + pixelAbstand);

		} else {
			this.anzahlPixelWidth = anzahlPixelWidth;
			this.pixelWidth = (int) (width - (offsetRight + offsetLeft)) / (this.anzahlPixelWidth);

			this.pixelHeight = pixelWidth;
			this.anzahlPixelHeight = (int) (height - (offsetUp + offsetDown)) / (pixelHeight + pixelAbstand);
		}

		System.out.println(this.anzahlPixelHeight * this.anzahlPixelWidth + " Pixel");

		for (int i = 0; i < this.anzahlPixelWidth; i++) {
			changeIndexList.add(i);
		}

		masterVolume = 1.0f;
		placeVolume = 1.0f;
		place2Volume = 0.68f;
		changeSpeedVolume = 1.0f;
		explosionVolume = 1.0f;
		copyVolume = 1.0f;

		zoomFactor = 1;
		maxZoomFactor = 20;
		offsetX = 0;
		offsetY = 0;

//		offsetRight = offsetLeft + (pixelWidth * zoomFactor + pixelAbstand) * anzahlPixelWidth + gridAbstand;
//		offsetDown = offsetUp + (pixelHeight * zoomFactor + pixelAbstand) * anzahlPixelHeight + gridAbstand;

		if (fullscreen) {
			if (pixelWidth == 4) {
				maxMemMB = 900;
			} else {
				maxMemMB = 160;
			}
		} else {
			if (pixelWidth == 4) {
				maxMemMB = 600;
			} else {
				maxMemMB = 160;
			}
		}
		//System.out.println(maxMemMB + " MB RAM allowed");

		copyMode = false;
		copyStartpoint = null;
		copyEndpoint = null;

		gameScreen = true;
		helpMenu = false;
		settingsMenu = false;

		tnt_sprengradius = 15 * this.pixelWidth;

		frameRate = 60;
		fpsUpdateTime = 2000;

		brushSize = 1;
		minBrushSize = 1;
		maxBrushSize = 40;
		brushSizeChangeSpeed = 1;
		brushColor = 0;
		brushColorFadeSpeed = 5;

		this.setPreferredSize(new Dimension(_width, _height));
		rand = new Random();
		ausgewaehlterPixel = new AuswahlPixel(width - 84, 16, 58, 58, this, "Dirt");
		auswahlPixelBox = new Box(width - 84, 16, 58, 58, new Color(220, 220, 220, 255), false);
		stepSpeedBox = new Box(this, 80, 18, 60, 60, 120);
		copyBox = new Box(150, 20, 55, 55, new Color(255, 255, 255), false);
		copyInnerBox = new Box(copyBox.posX, copyBox.posY, copyBox.boxWidth, copyBox.boxWidth,
				new Color(255, 255, 255, 0), true);
		brushSizeBox = new Box(225, 50, 80, 20, new Color(255, 255, 255), false);
		zoomBox = new Box(320, 50, 80, 20, new Color(255, 255, 255), false);
		fillBox = new Box(420, 45, 30, 30, new Color(255, 255, 255), false);
		replaceBlocksBox = new Box(480, 45, 30, 30, new Color(255, 255, 255), true);

		settingsBox = new Box(width / 2 - 115, 60, 265, 60, Color.white, true);
		muteBox = new Box(this, 280, 180, 60, 60, 159);
		mutePlaceSoundBox = new Box(this, 530, 260, 60, 60, 159);

		int auswahlPixelAbstand = 20;
		int auswahlPixelWidth = 68;
		int auswahlPixelHeight = auswahlPixelWidth;
		int dx = (int) (width / 2 - (auswahlPixelWidth + auswahlPixelAbstand) * allCategories.length * 0.5);
		int dy = 80;
		int howManyAuswahlPixelsInWidth = (width - 2 * dx) / (auswahlPixelWidth + auswahlPixelAbstand);

		categoryPixels = new AuswahlPixel[allCategories.length];
		for (int i = 0; i < categoryPixels.length; i++) {
			int posX = dx + (i % howManyAuswahlPixelsInWidth) * (auswahlPixelWidth + auswahlPixelAbstand);
			int posY = dy + (i / howManyAuswahlPixelsInWidth) * (auswahlPixelHeight + auswahlPixelAbstand);

			categoryPixels[i] = new AuswahlPixel(posX, posY, auswahlPixelWidth, auswahlPixelHeight, this,
					allCategories[i]);

		}

		pixelArray = new Pixel[this.anzahlPixelWidth * this.anzahlPixelHeight];
		nextPixelArray = new Pixel[this.anzahlPixelWidth * this.anzahlPixelHeight];
		for (int i = 0; i < pixelArray.length; i++) {
			pixelArray[i] = new Pixel(
					(i % this.anzahlPixelWidth) * (pixelWidth * zoomFactor + pixelAbstand) + offsetLeft,
					(i / this.anzahlPixelWidth) * (pixelHeight * zoomFactor + pixelAbstand) + offsetUp, this, "Air");
		}

		// clone pixel array in nextPixelArray
		for (int i = 0; i < pixelArray.length; i++) {
			nextPixelArray[i] = new Pixel(0, 0, this, "test");
			nextPixelArray[i].setDataByName(pixelArray[i].name, false);
			nextPixelArray[i].lifecount = pixelArray[i].lifecount;// hmm
			nextPixelArray[i].posX = pixelArray[i].posX;
			nextPixelArray[i].posY = pixelArray[i].posY;
		}

		// running sound thread
		Thread soundListenerThread = new Thread(new Runnable() {
			public void run() {

				while (true) {
					try {
//						if (resetSounds) {
//							resetSounds = false;
//							System.out.println("reseting...");
//							for (int i = runningSound.size() - 1; i >= 0; i--) {
//								// stop clip
//								runningSound.get(i).stop();
//								runningSound.remove(i);
//							}
//
//							for (int i = 0; i < soundCountForEachBlock.length; i++) {
//								soundCountForEachBlock[i] = 0;
//							}
//
//							System.out.println("finish reset");
//						} else {
						for (int i = runningSound.size() - 1; i >= 0; i--) {
							if (!runningSound.get(i).clip.isRunning() || muteSound) {
								// remove from soundlist
								if (runningSound.get(i).indexInList >= 0) {
									soundCountForEachBlock[runningSound.get(i).indexInList]--;
								}

								// stop clip
								runningSound.get(i).stop();
								runningSound.remove(i);
							}
						}
//					}
						Thread.sleep(200);
//						System.out.println(runningSound.size());
					} catch (InterruptedException e) {
						System.out.println("SoundListener Thread error!");
						e.printStackTrace();
					}
				}

			}
		});
		soundListenerThread.setDaemon(true);
		soundListenerThread.start();

	}

	public boolean zufall(float prozent) {
		if (rand.nextFloat() <= (prozent / 100)) {
			return true;
		}
		return false;
	}

	int getRandomInt(int min, int max) {
		if (max - min < 0)
			return 0;
		return this.rand.nextInt(max - min) + min;
	}

	public int constrain(long nr, int min, int max) {
		if (nr > max) {
			return max;
		} else if (nr < min) {
			return min;
		}
		return (int) nr;
	}

	public float getDist(float xI, float yI, float xII, float yII) {
		return (float) Math.sqrt(Math.pow(xII - xI, 2) + Math.pow(yII - yI, 2));
	}

	public boolean onPixelScreen() {
		if (mouseX >= offsetLeft && mouseX <= offsetLeft + (pixelWidth * zoomFactor + pixelAbstand) * anzahlPixelWidth
				&& mouseY >= offsetUp
				&& mouseY <= offsetUp + (pixelHeight * zoomFactor + pixelAbstand) * anzahlPixelHeight) {
			return true;
		}
		return false;
	}

	// ========================================
	public void setToGameScreen() {
		auswahlMenu = false;
		gameScreen = true;
		helpMenu = false;
		settingsMenu = false;
	}

	public void setToHelpMenu() {
		auswahlMenu = false;
		gameScreen = false;
		helpMenu = true;
		settingsMenu = false;
	}

	public void setToSettingsMenu() {
		auswahlMenu = false;
		gameScreen = false;
		helpMenu = false;
		settingsMenu = true;
	}

	public void setToAuswahlMenu() {
		auswahlMenu = true;
		gameScreen = false;
		helpMenu = false;
		settingsMenu = false;
	}

	// ========================================
	public boolean checkMuteAndMaxSize() {
		// true -> play sound
		return !muteSound && runningSound.size() < maxAnzahlSounds;
	}

	public void setAreaEstatus(int startIndex, String nameToFill) {

		pixelArray[startIndex].name = "fill";

		boolean again = true;
		int n = 0;
		while (again) {
			again = false;
			if (n % 2 == 0) {
				// rigth to left & down to up
				for (int i = pixelArray.length - 1; i >= 0; i--) {

					// search for next
					if (pixelArray[i].name == "fill") {
						if (i > anzahlPixelWidth - 1 && pixelArray[i - anzahlPixelWidth].name == nameToFill) {// up
							pixelArray[i - anzahlPixelWidth].name = "fill";
							again = true;
						}

						if (i % anzahlPixelWidth != 0 && pixelArray[i - 1].name == nameToFill) {// left
							pixelArray[i - 1].name = "fill";
							again = true;
						}

						if ((i + 1) % anzahlPixelWidth != 0 && pixelArray[i + 1].name == nameToFill) {// right
							pixelArray[i + 1].name = "fill";
							again = true;
						}

						if (i < pixelArray.length - anzahlPixelWidth
								&& pixelArray[i + anzahlPixelWidth].name == nameToFill) {// down
							pixelArray[i + anzahlPixelWidth].name = "fill";
							again = true;
						}
					}

				}
			} else {
				// left to rigth & up to down
				for (int i = 0; i < pixelArray.length; i++) {

					// search for next
					if (pixelArray[i].name == "fill") {
						if (i > anzahlPixelWidth - 1 && pixelArray[i - anzahlPixelWidth].name == nameToFill) {// up
							pixelArray[i - anzahlPixelWidth].name = "fill";
							again = true;
						}

						if (i % anzahlPixelWidth != 0 && pixelArray[i - 1].name == nameToFill) {// left
							pixelArray[i - 1].name = "fill";
							again = true;
						}

						if ((i + 1) % anzahlPixelWidth != 0 && pixelArray[i + 1].name == nameToFill) {// right
							pixelArray[i + 1].name = "fill";
							again = true;
						}

						if (i < pixelArray.length - anzahlPixelWidth
								&& pixelArray[i + anzahlPixelWidth].name == nameToFill) {// down
							pixelArray[i + anzahlPixelWidth].name = "fill";
							again = true;
						}
					}

				}
			}
			n++;

			if (!again) {
				for (int i = pixelArray.length - 1; i >= 0; i--) {
					if (pixelArray[i].name == "fill") {
						pixelArray[i].setDataByName(ausgewaehlterPixel.name, false);
						pixelArray[i].setIndividualData(ausgewaehlterPixel.getIndividualData());

						nextPixelArray[i].setDataByName(ausgewaehlterPixel.name, false);
						nextPixelArray[i].setIndividualData(ausgewaehlterPixel.getIndividualData());
					}

				}
			}
		}

	}

	public void fillArea(int startIndex, String nameToFill) {

		pixelArray[startIndex].name = "fill";

		boolean again = true;
		int n = 0;
		while (again) {
			again = false;
			if (n % 2 == 0) {
				// rigth to left & down to up
				for (int i = pixelArray.length - 1; i >= 0; i--) {

					// search for next
					if (pixelArray[i].name == "fill") {
						if (i > anzahlPixelWidth - 1 && pixelArray[i - anzahlPixelWidth].name == nameToFill) {// up
							pixelArray[i - anzahlPixelWidth].name = "fill";
							again = true;
						}

						if (i % anzahlPixelWidth != 0 && pixelArray[i - 1].name == nameToFill) {// left
							pixelArray[i - 1].name = "fill";
							again = true;
						}

						if ((i + 1) % anzahlPixelWidth != 0 && pixelArray[i + 1].name == nameToFill) {// right
							pixelArray[i + 1].name = "fill";
							again = true;
						}

						if (i < pixelArray.length - anzahlPixelWidth
								&& pixelArray[i + anzahlPixelWidth].name == nameToFill) {// down
							pixelArray[i + anzahlPixelWidth].name = "fill";
							again = true;
						}
					}

				}
			} else {
				// left to rigth & up to down
				for (int i = 0; i < pixelArray.length; i++) {

					// search for next
					if (pixelArray[i].name == "fill") {
						if (i > anzahlPixelWidth - 1 && pixelArray[i - anzahlPixelWidth].name == nameToFill) {// up
							pixelArray[i - anzahlPixelWidth].name = "fill";
							again = true;
						}

						if (i % anzahlPixelWidth != 0 && pixelArray[i - 1].name == nameToFill) {// left
							pixelArray[i - 1].name = "fill";
							again = true;
						}

						if ((i + 1) % anzahlPixelWidth != 0 && pixelArray[i + 1].name == nameToFill) {// right
							pixelArray[i + 1].name = "fill";
							again = true;
						}

						if (i < pixelArray.length - anzahlPixelWidth
								&& pixelArray[i + anzahlPixelWidth].name == nameToFill) {// down
							pixelArray[i + anzahlPixelWidth].name = "fill";
							again = true;
						}
					}

				}
			}
			n++;

			if (!again) {
				for (int i = pixelArray.length - 1; i >= 0; i--) {
					if (pixelArray[i].name == "fill") {
						pixelArray[i].setDataByName(ausgewaehlterPixel.name, false);
						pixelArray[i].setIndividualData(ausgewaehlterPixel.getIndividualData());

						nextPixelArray[i].setDataByName(ausgewaehlterPixel.name, false);
						nextPixelArray[i].setIndividualData(ausgewaehlterPixel.getIndividualData());
					}

				}
			}
		}

	}

	public void copySelectedArea() {
		if (copyStartpoint != null && copyEndpoint != null) {

			copyPixelList = new Pixel[(copyEndpoint.posX - copyStartpoint.posX) / (pixelWidth * zoomFactor)
					+ 1][(copyEndpoint.posY - copyStartpoint.posY) / (pixelHeight * zoomFactor) + 1];

			int copyStartingPixelIndex = (copyStartpoint.posX - offsetLeft - offsetX) / (pixelWidth * zoomFactor)
					+ (copyStartpoint.posY - offsetUp - offsetY) / (pixelHeight * zoomFactor) * anzahlPixelWidth;

			for (int x = 0; x < copyPixelList.length; x++) {
				for (int y = 0; y < copyPixelList[0].length; y++) {

					copyPixelList[x][y] = new Pixel(0, 0, this, "Dirt");

					copyPixelList[x][y]
							.setDataByName(pixelArray[copyStartingPixelIndex + x + y * anzahlPixelWidth].name, false);
					copyPixelList[x][y].setIndividualData(
							pixelArray[copyStartingPixelIndex + x + y * anzahlPixelWidth].getIndividualData());
				}
			}

		}
	}

	public void drawCopyList(int copyStartingPixelIndex) {

		if (copyPixelList != null && copyStartingPixelIndex >= 0) {

			for (int x = 0; x < constrain(anzahlPixelWidth - mouseOverPixelIndex % anzahlPixelWidth, 0,
					copyPixelList.length); x++) {
				for (int y = 0; y < constrain(anzahlPixelHeight - mouseOverPixelIndex / anzahlPixelWidth, 0,
						copyPixelList[0].length); y++) {

					pixelArray[copyStartingPixelIndex + x + y * anzahlPixelWidth]
							.setDataByName(copyPixelList[x][y].name, false);
					pixelArray[copyStartingPixelIndex + x + y * anzahlPixelWidth]
							.setIndividualData(copyPixelList[x][y].getIndividualData());

					nextPixelArray[copyStartingPixelIndex + x + y * anzahlPixelWidth]
							.setDataByName(copyPixelList[x][y].name, false);
					nextPixelArray[copyStartingPixelIndex + x + y * anzahlPixelWidth]
							.setIndividualData(copyPixelList[x][y].getIndividualData());

				}
			}
		}

	}

	public void devView(Graphics2D g2D) {

		// setup
		g2D.setStroke(new BasicStroke(1));
		g2D.setColor(new Color(0, 0, 0, 160));
		g2D.fillRect(80, 150, 800, 500);
		g2D.setColor(new Color(50, 50, 50, 150));
		g2D.drawRect(80, 150, 800, 500);

		g2D.setColor(new Color(255, 255, 255));
		g2D.setFont(new Font("default", Font.BOLD, 13));

		// mem diagram
		int xI = 100;
		int xII = 300;
		int yI = 350;
		int yII = 450;

		int dx = (xII - xI) / maxMemCount;
		int dy = yII - yI;
		int maxMem = maxMemMB * 5000 / 3;

		for (int i = memHistory.size() - 1; i > 1; i--) {
			g2D.setColor(new Color(constrain((int) ((float) memHistory.get(i) / maxMem * 255), 0, 255),
					constrain((int) (255 - (float) memHistory.get(i) / maxMem * 255), 0, 255), 0));
			int y = (int) (yII - (float) dy * ((float) memHistory.get(i) / maxMem));
			g2D.fillRect(xI + (i - 1) * dx, y, dx, yII - y);
		}

		g2D.setColor(new Color(255, 60, 0, 100));
		g2D.setStroke(new BasicStroke(2));
		g2D.drawLine(xI, (int) (yII - dy * (float) maxMemMB / maxMem * 1000), xII,
				(int) (yII - dy * (float) maxMemMB / maxMem * 1000));

		g2D.setColor(Color.white);
		g2D.setStroke(new BasicStroke(2));
		g2D.drawLine(xI, yI, xI, yII);
		g2D.drawLine(xI, yII, xII, yII);

		g2D.drawString(Integer.toString(maxMem / 1000) + "MB RAM", xI - 10, yI - 10);

		// fps diagram
		xI = 100;
		xII = 300;
		yI = 500;
		yII = 600;

		dx = (xII - xI) / maxMemCount;
		dy = yII - yI;
		int maxFps = 60;

		for (int i = fpsHistory.size() - 1; i > 1; i--) {
			g2D.setColor(new Color(constrain((int) (255 - (float) fpsHistory.get(i) / maxFps * 255), 0, 255),
					constrain((int) ((float) fpsHistory.get(i) / maxFps * 255), 0, 255), 0));

			int y = (int) (yII - (float) dy * ((float) fpsHistory.get(i) / maxFps));
			g2D.fillRect(xI + (i - 1) * dx, y, dx, yII - y);
		}

		g2D.setColor(Color.white);
		g2D.setStroke(new BasicStroke(2));
		g2D.drawLine(xI, yI, xI, yII);
		g2D.drawLine(xI, yII, xII, yII);

		g2D.drawString("60 fps", xI - 10, yI - 10);

		// left
		g2D.drawString("FPS: " + Integer.toString(fps), 100, 180);
		g2D.drawString("Pixelanzahl: " + Integer.toString(pixelArray.length), 100, 200);
		g2D.drawString("RAM: " + mem + " KB", 100, 220);
		g2D.drawString("Prozessoren: " + Integer.toString(runtime.availableProcessors()), 100, 240);
		g2D.drawString("Sounds: " + runningSound.size() + " / 100", 100, 260);
		g2D.drawString(
				"Undo-Step: " + Integer.toString(-undoPosition) + " / " + Integer.toString(historyPixelList.size() - 1),
				100, 280);

		// middle
		g2D.drawString("Block Sounds: ", 300, 180);
		int firstY = 200;
		for (int i = 0; i < soundCountForEachBlock.length; i++) {
			if (soundCountForEachBlock[i] > 0) {
				g2D.drawString(listOfAllItems[i] + ": " + soundCountForEachBlock[i], 300, firstY);
				firstY += 20;
			}
		}

		// right
		g2D.drawString("Version: " + version, 760, 180);

	}

	public void removeNewestStepsFromHistoryList() {
		int size = historyPixelList.size();
		if (size > 0) {
			for (int i = size - 1; i > size - 1 + undoPosition; i--) {
				historyPixelList.remove(i);
			}
		}
		undoPosition = 0;
	}

	public void addOneHistoryList() {
		if (historyPixelList.size() >= maxHistorySize)
			return;
		Pixel[] undoList = new Pixel[pixelArray.length];
		for (int i = 0; i < pixelArray.length; i++) {
			undoList[i] = new Pixel(pixelArray[i].posX, pixelArray[i].posY, this, "Air");
			undoList[i].setDataByName(pixelArray[i].name, false);
			undoList[i].setIndividualData(pixelArray[i].getIndividualData());
		}
		historyPixelList.add(undoList);
	}

	// ===========================================================

	/*
	 * Sounds:
	 * 
	 * -Only Path
	 * 
	 * -Path & Vol
	 * 
	 * -Path & Index
	 * 
	 * -Path & Vol & Index
	 * 
	 */

	public final void playSound(String SoundPath) {
		if (checkMuteAndMaxSize()) {
			Sound s = new Sound("/sounds/" + SoundPath);
			s.play();
			runningSound.add(s);
		}
	}

	public final void playSound(String SoundPath, float vol) {
		if (checkMuteAndMaxSize()) {
			Sound s = new Sound("/sounds/" + SoundPath, vol);
			s.play();
			runningSound.add(s);
		}
	}

	public final void playSound(String SoundPath, int indexInList) {
		if (checkMuteAndMaxSize()) {
			Sound s = new Sound("/sounds/" + SoundPath, indexInList);
			s.play();
			runningSound.add(s);
		}
	}

	public final void playSound(String SoundPath, float vol, int indexInList) {
		if (checkMuteAndMaxSize()) {
			Sound s = new Sound("/sounds/" + SoundPath, vol, indexInList);
			s.play();
			runningSound.add(s);
		}
	}

	// =========================================================================

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		super.paintComponent(g2D);

		// animation timing
		if (System.currentTimeMillis() > animationTimer + 1000 / animationFPS) {
			animationTimer = System.currentTimeMillis();
			globalAnimationCount++;
			if (globalAnimationCount < 0)
				globalAnimationCount = 0;
		}

		if (firstFrame) {
			firstFrame = false;
		}

		startFrameTime = System.currentTimeMillis();

		if (helpMenu) {
			super.setBackground(new Color(15, 15, 35));

			// title kasten
			g2D.setStroke(new BasicStroke(4));
			g2D.setColor(new Color(30, 30, 50));
			g2D.fillRect(width / 10 - 20, height / 10 - 40, 330, 60);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(width / 10 - 20, height / 10 - 40, 330, 60);

			// bg kasten
			g2D.setColor(new Color(22, 22, 42));
			g2D.fillRect(50, 110, width - 100, height - 110 - 20);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(50, 110, width - 100, height - 110 - 20);

			g2D.setColor(Color.white);
			g2D.setFont(myFont);
			g2D.drawString("Help-menu:", width / 10, height / 10);

			g2D.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 20));
			g2D.drawString("> Space: pause the game", width / 10, height * 8 / 40);
			g2D.drawString("> Mousewheel: change brushsize", width / 10, height * 10 / 40);
			g2D.drawString("> Ctrl + Mousewheel: zooming", width / 10, height * 12 / 40);
//			g2D.drawString("> ", width / 10, height * 14 / 40);

			g2D.drawString("> Right mousebutton: get pixel", width - width * 1 / 2, height * 8 / 40);
			g2D.drawString("> C-Box: copy marked area", width - width * 1 / 2, height * 10 / 40);
			g2D.drawString("> Shift + Mouse: draw rectangle", width - width * 1 / 2, height * 12 / 40);
			g2D.drawString("> Ctrl + Mouse: draw line", width - width * 1 / 2, height * 14 / 40);

			g2D.drawString("=== Keys: ===", width * 2 / 5, height * 18 / 40);
			g2D.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 17));
			g2D.drawString("> E: open Inventory", width / 10, height * 20 / 40);
			g2D.drawString("> Esc: close game", width / 10, height * 22 / 40);
			g2D.drawString("> C: toggle Copy-Mode", width / 10, height * 24 / 40);
			g2D.drawString("        + left mousebutton: set upper left corner", width / 10, height * 26 / 40);
			g2D.drawString("        + right mousebutton: set lower right corner", width / 10, height * 28 / 40);
			g2D.drawString("> X: deletes pixels", width / 10, height * 30 / 40);
			g2D.drawString("> V: paste", width / 10, height * 32 / 40);
			g2D.drawString("> M: mute sounds", width / 10, height * 34 / 40);
			g2D.drawString("> F: toggle Fill-Mode", width / 10, height * 36 / 40);
			g2D.drawString("> G: show grid", width / 10, height * 38 / 40);

			g2D.drawString("> right arrow: one step", width - width * 2 / 5, height * 20 / 40);
			g2D.drawString("> R: random", width - width * 2 / 5, height * 22 / 40);
			g2D.drawString("> I: info about pixel", width - width * 2 / 5, height * 24 / 40);
			g2D.drawString("> S: settings", width - width * 2 / 5, height * 26 / 40);
			g2D.drawString("> Z: undo  (max " + Integer.toString(maxHistorySize - 1) + " steps)", width - width * 2 / 5,
					height * 28 / 40);
			g2D.drawString("> Y: redo", width - width * 2 / 5, height * 30 / 40);
			g2D.drawString("> B: toggle Replace-mode", width - width * 2 / 5, height * 32 / 40);
//			g2D.drawString("> ", width - width * 2 / 5, height * 34 / 40);
//			g2D.drawString("> ", width - width * 2 / 5, height * 36 / 40);
//			g2D.drawString("> ", width - width * 2 / 5, height * 38 / 40);

			// dev mode
			g2D.setFont(new Font("default", Font.BOLD, 10));
			g2D.setColor(new Color(150, 150, 150));
			g2D.drawString("Dev-Mode: Ctrl+AltGr+Enter", width - 190, height - 30);

		} else if (settingsMenu) {
			super.setBackground(new Color(15, 15, 35));

			// Settings title
			g2D.setStroke(new BasicStroke(4));

			g2D.setColor(new Color(30, 30, 50));
			g2D.fillRect(settingsBox.posX, settingsBox.posY, settingsBox.boxWidth, settingsBox.boxHeight);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(settingsBox.posX, settingsBox.posY, settingsBox.boxWidth, settingsBox.boxHeight);

			g2D.setFont(myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Settings", width / 2 - 100, 100);

			// bg kasten
			g2D.setColor(new Color(30, 30, 50));
			g2D.fillRect(20, 160, width - 40, height - 160 - 40);
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(20, 160, width - 40, height - 160 - 40);

			// mute all
			muteBox.draw(g2D);
			g2D.setFont(myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Mute all", muteBox.posX - 240, muteBox.posY + 40);

			// mute place-sound
			mutePlaceSoundBox.draw(g2D);
			g2D.setFont(myFont);
			g2D.setColor(Color.white);
			g2D.drawString("Mute Place-Sound", mutePlaceSoundBox.posX - 490, mutePlaceSoundBox.posY + 40);

		} else if (gameScreen) {

			stepTime = (int) (1000 / (stepFrameRate * stepFrameRateFactor));

			// step timer
			boolean doStep = false;
			if (System.currentTimeMillis() > time + stepTime) {
				time = System.currentTimeMillis();
				doStep = true;
			}
			if (pause) {
				time = System.currentTimeMillis();
			}

			// playsound timer
			boolean playSound = false;
			if (System.currentTimeMillis() > playSoundTimer + playSoundChecktime && !pause) {
				playSoundTimer = System.currentTimeMillis();
				playSound = true;

			}

			offsetX = constrain(offsetX, -(pixelWidth + pixelAbstand) * anzahlPixelWidth * (zoomFactor - 1), 0);
			offsetY = constrain(offsetY, -(pixelHeight + pixelAbstand) * anzahlPixelHeight * (zoomFactor - 1), 0);

			super.setBackground(new Color(15, 15, 35));// bg
			g2D.setColor(Color.black);
			g2D.fillRect(offsetLeft, offsetUp, anzahlPixelWidth * pixelWidth, anzahlPixelHeight * pixelHeight);

			/*
			 * ========================== Main loop ================================
			 */
			Pixel[] undoList = new Pixel[pixelArray.length];
			for (int y = anzahlPixelHeight - 1; y >= -4; y--) {// each row in pixelArray + buffer

				@SuppressWarnings("unchecked")
				ArrayList<Integer> this_changeIndexList = (ArrayList<Integer>) changeIndexList.clone();

				for (int x = anzahlPixelWidth - 1; x >= 0; x--) {// col in row
					int i = y * anzahlPixelWidth + x;

					// ===================================================================================================

					// draw
					if (i >= 0) {

						pixelArray[i].posX = offsetLeft + offsetX + (pixelWidth * zoomFactor) * (i % anzahlPixelWidth);
						pixelArray[i].posY = offsetUp + offsetY + (pixelHeight * zoomFactor) * (i / anzahlPixelWidth);
						if (pixelArray[i].name != "Air") {
							pixelArray[i].draw(g2D);
						}

						if (pixelArray[i].mouseOverPixel(mouseX, mouseY)) {
							mouseOverPixelIndex = i;
						}

						// play sound
						if (playSound)
							pixelArray[i].playSound();

					}

					// ===================================================================================================

					if (!pause && doStep) {

						// copy pixelArray in nextPixelArray
						if (i >= 0) {

//							if (undoPosition < 0) {
//
//								// step forward in historyList
//								pixelArray[i].setDataByName(
//										historyPixelList.get(historyPixelList.size() - 1 + undoPosition + 1)[i].name,
//										false);
//								pixelArray[i].setIndividualData(
//										historyPixelList.get(historyPixelList.size() - 1 + undoPosition + 1)[i]
//												.getIndividualData());
//
//							} else {
							nextPixelArray[i].setDataByName(pixelArray[i].name, false);
							nextPixelArray[i].setIndividualData(pixelArray[i].getIndividualData());
//							}

						}

						// ===================================================================================================

//						if (undoPosition == 0) {
						// update
						if (y <= anzahlPixelHeight - 3 && y >= -2) {
							int index = rand.nextInt(this_changeIndexList.size());// random
							// index = this_changeIndexList.size() - 1;// right -> left

							int n = (y + 2) * anzahlPixelWidth + this_changeIndexList.get(index);

							pixelArray[n].update(n);

							this_changeIndexList.remove(index);

						}

						// ===================================================================================================

						// copy nextPixelArray in pixelArray
						if (y <= anzahlPixelHeight - 5) {
							int n = (y + 4) * anzahlPixelWidth + x;

							pixelArray[n].setDataByName(nextPixelArray[n].name, false);
							pixelArray[n].setIndividualData(nextPixelArray[n].getIndividualData());

							// fill undoPixelList
							undoList[n] = new Pixel(pixelArray[n].posX, pixelArray[n].posY, this, "Air");
							undoList[n].setDataByName(pixelArray[n].name, false);
							undoList[n].setIndividualData(pixelArray[n].getIndividualData());

						}

//						}
						// ===================================================================================================

					}

				}

			}

			// add undoList to historyPixelsList
			if (!pause && doStep) {
				removeNewestStepsFromHistoryList();
				undoPosition = 0;

//				if (undoPosition == 0) {
				historyPixelList.add(undoList);

				// remove oldest list if max size
				while (historyPixelList.size() > maxHistorySize) {
					historyPixelList.remove(0);
				}
//				} 
//				else {
//					undoPosition++;
//				}
			}

			/*
			 * ========================== end of Main loop ================================
			 */

			// draw grid
			g2D.setColor(new Color(50, 50, 50, 100));
			gridAbstand = 2;

			if (drawGrid) {
				int linePosYUp = offsetY + offsetUp - gridAbstand;
				int linePosXleft = offsetX + offsetLeft - gridAbstand;
				int linePosX;
				int linePosY;

				for (int i = 1; i < anzahlPixelWidth; i++) {

					linePosX = offsetX + offsetLeft + (pixelWidth * zoomFactor + pixelAbstand) * i;

					if (linePosX >= offsetLeft && linePosX <= width - offsetRight) {
						// senkrecht
						g2D.fillRect(linePosX, linePosYUp, 1, pixelHeight * zoomFactor * anzahlPixelHeight);
					}

					if (i < this.anzahlPixelHeight) {
						linePosY = offsetY + offsetUp + (pixelHeight * zoomFactor + pixelAbstand) * i;

						if (linePosY <= height - offsetDown && linePosY >= offsetUp) {
							// horizontal
							g2D.fillRect(linePosXleft, linePosY, pixelWidth * zoomFactor * anzahlPixelWidth, 1);
						}
					}
				}
			}

			if (drawGrid && mouseOverPixelIndex >= 0) {// draw selected pixel surrounding
				g2D.setColor(Color.white);
				g2D.setStroke(new BasicStroke(2));
				g2D.drawRect(pixelArray[mouseOverPixelIndex].posX, pixelArray[mouseOverPixelIndex].posY,
						pixelWidth * zoomFactor, pixelHeight * zoomFactor);

				// draw x/y axis
				g2D.setColor(new Color(150, 150, 150, 50));
				g2D.fillRect(offsetLeft, pixelArray[mouseOverPixelIndex].posY,
						pixelWidth * zoomFactor * anzahlPixelWidth, pixelHeight * zoomFactor);// x

				g2D.fillRect(pixelArray[mouseOverPixelIndex].posX, offsetUp, pixelWidth * zoomFactor,
						pixelHeight * zoomFactor * anzahlPixelHeight);// y

			}

			// paste frame
			if (drawPasteFrame) {
				g2D.setColor(Color.white);
				g2D.drawRect(pixelArray[mouseOverPixelIndex].posX, pixelArray[mouseOverPixelIndex].posY,
						copyPixelList.length * pixelWidth * zoomFactor,
						copyPixelList[0].length * pixelHeight * zoomFactor);
			}

			// copy frame
			if (copyMode) {
				g2D.setColor(new Color(120, 120, 120));

				int x1, x2, y1, y2;
				if (copyStartpoint != null) {
					x1 = copyStartpoint.posX;
					y1 = copyStartpoint.posY;
				} else {
					x1 = mouseX;
					y1 = mouseY;
				}

				if (copyEndpoint != null) {
					x2 = copyEndpoint.posX + pixelWidth * zoomFactor;
					y2 = copyEndpoint.posY + pixelHeight * zoomFactor;
				} else {
					x2 = mouseX;
					y2 = mouseY;
				}

				g2D.drawRect(x1, y1, x2 - x1, y2 - y1);

			}

			if (drawLine) {// draw line (lineal)
				g2D.setColor(Color.red);
				g2D.drawLine(startMousePos[0], startMousePos[1], mouseX, mouseY);
			}

			if (drawRect) {
				g2D.setColor(Color.red);

				int w, h;

				if (mouseX < startMousePos[0]) {
					w = 0;
				} else {
					w = mouseX - startMousePos[0];
				}

				if (mouseY < startMousePos[1]) {
					h = 0;
				} else {
					h = mouseY - startMousePos[1];
				}

				g2D.drawRect(startMousePos[0], startMousePos[1], w, h);
			}

			// draw brushsize
			if (brushColor >= brushColorFadeSpeed) {
				g2D.setColor(new Color(255, 255, 255, constrain(brushColor, 0, 255)));
				if (brushSize == 1) {
					int minRadius = 4;
					g2D.drawOval(mouseX - (int) minRadius / 2, mouseY - (int) minRadius / 2, minRadius, minRadius);
				} else {
					g2D.drawOval(mouseX - brushSize * pixelWidth / 2 * zoomFactor,
							mouseY - brushSize * pixelWidth / 2 * zoomFactor,
							brushSize * pixelWidth / 2 * zoomFactor * 2, brushSize * pixelWidth / 2 * zoomFactor * 2);
				}
				brushColor -= brushColorFadeSpeed;
			}

			// draw surrounding rects
			g2D.setColor(getBackground());
			g2D.fillRect(offsetLeft + (pixelWidth + pixelAbstand) * anzahlPixelWidth + gridAbstand, 0, width / 10,
					height);// rechts
			g2D.fillRect(0, offsetUp + (pixelHeight + pixelAbstand) * anzahlPixelHeight + gridAbstand, width,
					height / 10);// unten
			g2D.fillRect(0, 0, width, offsetUp);// oben
			g2D.fillRect(0, 0, offsetLeft - gridAbstand, height);// links

			// draw aussenlinien
			g2D.setColor(Color.white);
			g2D.drawLine(offsetLeft - gridAbstand, offsetUp - gridAbstand, offsetLeft - gridAbstand,
					offsetUp + (pixelHeight + pixelAbstand) * anzahlPixelHeight + gridAbstand);// links

			g2D.drawLine(offsetLeft + (pixelWidth + pixelAbstand) * anzahlPixelWidth + gridAbstand,
					offsetUp - gridAbstand, offsetLeft + (pixelWidth + pixelAbstand) * anzahlPixelWidth + gridAbstand,
					offsetUp + (pixelHeight + pixelAbstand) * anzahlPixelHeight + gridAbstand);// rechts

			g2D.drawLine(offsetLeft - gridAbstand, offsetUp - gridAbstand,
					offsetLeft + (pixelWidth + pixelAbstand) * anzahlPixelWidth + gridAbstand, offsetUp - gridAbstand);// oben

			g2D.drawLine(offsetLeft - gridAbstand,
					offsetUp + (pixelHeight + pixelAbstand) * anzahlPixelHeight + gridAbstand,
					offsetLeft + (pixelWidth + pixelAbstand) * anzahlPixelWidth + gridAbstand,
					offsetUp + (pixelHeight + pixelAbstand) * anzahlPixelHeight + gridAbstand);// unten

			if (showInfo) {
				pixelArray[mouseOverPixelIndex].info(g2D);
			}

			// draw pause button
			if (pause) {
				g2D.setColor(new Color(220, 220, 220, 200));
				g2D.fillRect(25, 25, 15, 45);
				g2D.fillRect(50, 25, 15, 45);
//				mainSprite.drawPartOfSprite(g2D, 25, 25, 45, 45, 0);
			}

			// draw ausgewaehlter pixel in ecke (top right)
			ausgewaehlterPixel.draw(g2D);// g2D, width - 84, 16, 58, 58

			g2D.setStroke(new BasicStroke(2));
			auswahlPixelBox.draw(g2D);

//			g2D.setFont(new Font("Bauhaus", Font.ITALIC, 35));
			g2D.setFont(myFont);
			g2D.setColor(Color.white);
			if (ausgewaehlterPixel.name == "Gravitychanger") {
				g2D.drawString("G-Changer", width - 360, 55);
			} else if (ausgewaehlterPixel.name == "Transmitter") {
				g2D.drawString("Transmit.", width - 360, 55);
			} else {
				g2D.drawString(ausgewaehlterPixel.name, width - 130 - 25 * ausgewaehlterPixel.name.length(), 55);
			}

			// stepSpeedBox
			if (stepFrameRateFactor == 0.5) {
				stepSpeedBox.imgIndex = 120;
			} else if (stepFrameRateFactor == 1) {
				stepSpeedBox.imgIndex = 121;
			} else if (stepFrameRateFactor == 2) {
				stepSpeedBox.imgIndex = 122;
			} else if (stepFrameRateFactor == 4) {
				stepSpeedBox.imgIndex = 123;
			} else if (stepFrameRateFactor == 8) {
				stepSpeedBox.imgIndex = 124;
			} else if (stepFrameRateFactor == 16) {
				stepSpeedBox.imgIndex = 125;
			}

			stepSpeedBox.draw(g2D);

			// copy box
			copyInnerBox.draw(g2D);
			copyBox.draw(g2D);
			copyInnerBox.darken(20);

//			g2D.setFont(new Font("Comic Sans", Font.ITALIC, 40));
			g2D.setFont(myFont);
			g2D.setColor(Color.white);
			g2D.drawString("C", copyBox.posX + copyBox.boxWidth * 1 / 5 + 5,
					copyBox.posY + copyBox.boxHeight * 6 / 8 - 2);

			// brushSize Box
			brushSizeBox.draw(g2D);
			g2D.setColor(Color.white);
			g2D.fillRect(brushSizeBox.posX, brushSizeBox.posY, brushSizeBox.boxWidth * brushSize / maxBrushSize + 2,
					brushSizeBox.boxHeight);

//			g2D.setFont(new Font("Bauhaus", Font.ITALIC, 20));
			g2D.setFont(myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("Brushsize", brushSizeBox.posX - 5, brushSizeBox.posY - brushSizeBox.boxHeight / 2);

			// Zoom Box
			zoomBox.draw(g2D);
			g2D.setColor(Color.white);
			g2D.fillRect(zoomBox.posX, zoomBox.posY, zoomBox.boxWidth * (zoomFactor - 1) / (maxZoomFactor - 1),
					zoomBox.boxHeight);

//			g2D.setFont(new Font("Bauhaus", Font.ITALIC, 24));
			g2D.setFont(myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("Zoom", zoomBox.posX + zoomBox.boxWidth / 10 + 5, zoomBox.posY - zoomBox.boxHeight / 2);

			// fill Box
			fillBox.draw(g2D);

			g2D.setFont(myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("Fill", fillBox.posX + fillBox.boxWidth / 10, fillBox.posY - fillBox.boxHeight / 3);

			// replace Block Box
			replaceBlocksBox.draw(g2D);

			g2D.setFont(myFontLittle);
			g2D.setColor(Color.white);
			g2D.drawString("Replace", replaceBlocksBox.posX + replaceBlocksBox.boxWidth / 2 - 35,
					replaceBlocksBox.posY - replaceBlocksBox.boxHeight / 3);

			// different Modes
			g2D.setFont(myFontLittle);
			g2D.setColor(Color.white);
			if (copyMode) {
				g2D.drawString("Copy-Mode", 540, 70);
			}

		} else if (auswahlMenu) { // draw auswahlmenu
			super.setBackground(new Color(15, 15, 35));

			g2D.setColor(new Color(10, 10, 20));
			g2D.fillRect(50, 170, width - 100, height - 200);

			g2D.setStroke(new BasicStroke(4));
			g2D.setColor(new Color(90, 90, 130));
			g2D.drawRect(50, 170, width - 100, height - 200);

			if (showWhichCategoryItems == -1) {
				g2D.setFont(myFontLittle);
				g2D.setColor(Color.white);
				g2D.drawString("Select Category", width / 2 - 80, height / 2 + 60);
			} else {
				g2D.setFont(myFont);
				g2D.setColor(Color.white);
				g2D.drawString(categoryPixels[showWhichCategoryItems].name,
						width / 2 - categoryPixels[showWhichCategoryItems].name.length() * 12, 60);

				boolean drawInfo = false;
				int drawInfoIndex = 0;
				for (int i = 0; i < auswahlPixelArray.length; i++) {
					auswahlPixelArray[i].draw(g2D);
					if (!drawInfo && auswahlPixelArray[i].mouseOverPixel(mouseX, mouseY)) {
						drawInfo = true;
						drawInfoIndex = i;
					}
				}
				if (drawInfo) {
					auswahlPixelArray[drawInfoIndex].info(g2D);
				}
			}

			for (int i = 0; i < categoryPixels.length; i++) {
				categoryPixels[i].draw(g2D);

			}
			for (int i = 0; i < categoryPixels.length; i++) {
				if (categoryPixels[i].mouseOverPixel(mouseX, mouseY)) {
					categoryPixels[i].info(g2D);
				}
			}

		}

		// fps
		if (fullscreen) {
			g2D.setFont(new Font("default", Font.ITALIC, 12));
			g2D.setColor(Color.white);
			g2D.drawString(String.valueOf(fps), 8, 15);
		}

		// =============================================

		// manage framerate
		try {
			Thread.sleep(constrain((1000 / frameRate) - (System.currentTimeMillis() - startFrameTime), 0, 100000));
		} catch (InterruptedException e) {
			System.out.println("Thread.sleep error");
			e.printStackTrace();
		}

		// fps anzeige
		if (System.currentTimeMillis() > fpsUpdateTimeNow + fpsUpdateTime) {
			clearMemCounter++;
			fps = 1000 / constrain(System.currentTimeMillis() - startFrameTime, 1, 100000);
			fpsUpdateTimeNow = System.currentTimeMillis();

			String str = "druecke H fuer Hilfe";

			jf.setTitle("PixelBox!  " + Integer.valueOf(pixelArray.length) + "pixel   " + String.valueOf(fps)
					+ " fps   " + str);

			// clear memory if more then 120 mb used???

			mem = (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024));// factor
																											// 1000 or
																											// 1024???
			if (mem / 1024 > maxMemMB && clearMemCounter >= 10) {
				clearMemCounter = 0;
				System.gc();
				System.out.println("Clear Mem");
			}

			// add to mem history (diagram)
			memHistory.add(mem);
			if (memHistory.size() > maxMemCount) {
				memHistory.remove(0);
			}

			// add to fps history (diagram)
			fpsHistory.add(fps);
			if (fpsHistory.size() > maxFpsCount) {
				fpsHistory.remove(0);
			}

		}

		// developer view
		if (devMode) {
			devView(g2D);
		}

		// draw next frame
		repaint();

	}

}

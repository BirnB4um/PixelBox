package mainPackage;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

	public Clip clip;

	public int indexInList = -1;

	public static final Sound PLACE = new Sound("/sounds/place.wav", 0.85f);
	public static final Sound PLACE2 = new Sound("/sounds/place2.wav", 0.7f);
	public static final Sound EXPLOSION = new Sound("/sounds/boom.wav");
	public static final Sound COPY = new Sound("/sounds/copy.wav");
	public static final Sound CHANGESPEED1 = new Sound("/sounds/changeSpeed_1.wav");
	public static final Sound CHANGESPEED2 = new Sound("/sounds/changeSpeed_2.wav");
	public static final Sound CHANGESPEED3 = new Sound("/sounds/changeSpeed_3.wav");
	public static final Sound CHANGESPEED4 = new Sound("/sounds/changeSpeed_4.wav");
	public static final Sound CHANGESPEED5 = new Sound("/sounds/changeSpeed_5.wav");
	public static final Sound CHANGESPEED6 = new Sound("/sounds/changeSpeed_6.wav");

	public Sound(String path, float vol, int index_in_list) {
		indexInList = index_in_list;

		try {

			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResource(path)));

			// maybe???
//			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//			float dB = (float) (Math.log(lautstaerke) / Math.log(10.0) * 20.0);
//			gainControl.setValue(dB);

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			if (vol < 0)
				vol = 0;
			if (vol > 1)
				vol = 1;
			gainControl
					.setValue((gainControl.getMaximum() - gainControl.getMinimum()) * vol + gainControl.getMinimum());

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public Sound(String path, int index_in_list) {
		indexInList = index_in_list;
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResource(path)));
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public Sound(String path, float vol) {
		try {

			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResource(path)));

			// maybe???
//			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//			float dB = (float) (Math.log(lautstaerke) / Math.log(10.0) * 20.0);
//			gainControl.setValue(dB);

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			if (vol < 0)
				vol = 0;
			if (vol > 1)
				vol = 1;
			gainControl
					.setValue((gainControl.getMaximum() - gainControl.getMinimum()) * vol + gainControl.getMinimum());

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public Sound(String path) {
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getClass().getResource(path)));
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		if (clip.isRunning())
			clip.stop();

		// Rewind clip to beginning
		clip.setFramePosition(0);

		// Play clip
		clip.start();

	}

	public void stop() {
		clip.stop();
		clip.close();
	}

}

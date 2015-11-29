package dev.wonderland.gameDev.snd;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

	private HashMap<String, Clip> clips = new HashMap<String, Clip>();

	public boolean registered(String name) {
		return clips.get(name) != null;
	}

	public void unregister(String name) {
		if (clips.get(name) != null) {
			System.out.println("Sound: " + name + " never registered");
			return;
		}
		clips.remove(name);
	}

	public void register(String fileName, String name) {
		if (clips.get(name) != null) {
			System.out.println("Sound: " + name + " already registered");
			return;
		}
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(new File(fileName));
			clip.open(inputStream);
			clips.put(name, clip);
			System.out.println("Registered new Sound {Name=\"" + name
					+ "\", Path=\"" + fileName + "\"}");
		} catch (Exception e) {
			System.out.println("Error loading sound: " + e.getMessage());
		}
	}

	public synchronized void stop(final String name) {
		new Thread(new Runnable() {
			public void run() {
				if (clips.get(name) != null) {
					Clip clip = clips.get(name);
					clip.stop();
				} else
					System.out.println("Unregistered sound name: " + name);
			}
		}).start();
	}

	public synchronized void play(final String name) {
		new Thread(new Runnable() {
			public void run() {
				if (clips.get(name) != null) {
					System.out.println("Started Sound: " + name);
					Clip clip = clips.get(name);
					clip.stop();
					clip.setFramePosition(0);
					clip.start();
				} else
					System.out.println("Unregistered sound name: " + name);
			}
		}).start();
	}

	public synchronized void stopAll() {
		Iterator<Entry<String, Clip>> i = clips.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, Clip> pair = i.next();
	        this.stop((String) pair.getKey());
	    }
	}
}

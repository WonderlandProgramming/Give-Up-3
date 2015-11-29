package dev.wonderland.gameDev.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private long duration;
	private long lastTickTimer = System.currentTimeMillis();
	private int index = 0;
	private BufferedImage[] textures;

	public Animation(long duration, BufferedImage... textures) {
		this.duration = duration;
		this.textures = textures;
	}


	public void tick() {
		long now = System.currentTimeMillis();
		if (lastTickTimer + duration <= now) {
			index++;
			lastTickTimer = now;
			if (index >= textures.length) {
				index = 0;
			}
		}
	}

	public void setIndex(int index) {
		if (index > textures.length) {
			new IndexOutOfBoundsException(
					"Index out of Bounds. Can't set Index highter than Texteres in Image Buffer!");
		} else {
			this.index = index;
		}
	}

	public void resetAnimation() {
		index = 0;
	}

	public BufferedImage getTexture() {
		return textures[index];
	}

	public int getIndex() {
		return index;
	}

}

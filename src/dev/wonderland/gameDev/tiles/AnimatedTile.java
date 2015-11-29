package dev.wonderland.gameDev.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.wonderland.gameDev.gfx.Animation;

public class AnimatedTile extends Tile{

	private Animation animation;
	
	public AnimatedTile(int id, long duration, BufferedImage ...texture) {
		super(texture[0], id);
		animation = new Animation(duration, texture);
	}
	
	public AnimatedTile(int id, long duration, boolean solid, BufferedImage ...texture) {
		super(texture[0], id);
		this.isSolid = solid;
		animation = new Animation(duration, texture);
	}
	
	@Override
	public void tick(){
		animation.tick();
		this.texture = animation.getTexture();
	}
	
	public Animation getAnimation(){
		return animation;
	}

	public void renderAnimationInfo(Graphics g, int x, int y) {
		g.setColor(Color.blue);
		g.drawString(String.valueOf(getAnimation().getIndex()), x + 1, y + g.getFont().getSize());
	}
}

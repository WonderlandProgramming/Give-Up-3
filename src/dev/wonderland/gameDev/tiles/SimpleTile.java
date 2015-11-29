package dev.wonderland.gameDev.tiles;

import java.awt.image.BufferedImage;

public class SimpleTile extends Tile{

	public SimpleTile(BufferedImage texture, int id) {
		super(texture, id);
	}
	
	public SimpleTile(BufferedImage texture, int id, boolean isSolid) {
		super(texture, id);
		this.isSolid = isSolid;
	}
	
	@Override
	public boolean isSolid(){
		return isSolid;
	}
}

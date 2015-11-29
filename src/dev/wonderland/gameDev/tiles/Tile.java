package dev.wonderland.gameDev.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.wonderland.gameDev.gfx.Assets;

public class Tile {
	
	//Tiledefinition here
	
	public static Tile[] tiles = new Tile[256];
	public static SimpleTile grassTile = new SimpleTile(Assets.grass, 0, false);
	public static SimpleTile dirtTile = new SimpleTile(Assets.dirt, 1);
	public static SimpleTile rockTile = new SimpleTile(Assets.stone, 2, true);
	
	public static AnimatedTile waterTile = new AnimatedTile(9, 1500, true, Assets.waterAnim1, Assets.waterAnim2, Assets.waterAnim3);
	public static AnimatedTile testTile = new AnimatedTile(8, 1500, Assets.waterAnim1, Assets.waterAnim2, Assets.waterAnim3);

	//CLASS 
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	protected boolean isSolid;
	protected int movementCost = 1;
	
	protected Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		this.isSolid = false;
		tiles[id] = this;
	}
	
	public void tick(){
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public void renderBounds(Graphics g, int x, int y){
		g.setColor(Color.RED);
		g.drawRect(x, y, TILEWIDTH -1, TILEHEIGHT -1);
	}
	
	public boolean isSolid(){
		return isSolid;
	}
	
	public int getId(){
		return id;
	}
	
	@Override
	public String toString() {
		return "Tile [id=" + id + ", isSolid=" + isSolid + "]";
	}

	public BufferedImage getTexture(){
		return texture;
	}
	
	public static Tile[] getTiles(){
		return tiles;
	}

	public int getMoveCost() {
		return movementCost;
	}
	
}

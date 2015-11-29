package dev.wonderland.gameDev.worlds;

import java.awt.Graphics;

import dev.wonderland.gameDev.Handler;
import dev.wonderland.gameDev.tiles.AnimatedTile;
import dev.wonderland.gameDev.tiles.Tile;
import dev.wonderland.gameDev.utils.DebugVars;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;

	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}

	public void tick() {
		Tile[] tickList = Tile.getTiles();
		for (int i = 0; i < tickList.length; i++) {
			if (tickList[i] != null)
				tickList[i].tick();
		}
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()
				/ Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth())
						/ Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset()
				/ Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight())
						/ Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				
				getTile(x, y).render(
						g,
						(int) (x * Tile.TILEWIDTH - handler.getGameCamera()
								.getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera()
								.getyOffset()));
				if (DebugVars.debugMode) {
					if (getTile(x, y).isSolid()) {
						getTile(x, y).renderBounds(
								g,
								(int) (x * Tile.TILEWIDTH - handler
										.getGameCamera().getxOffset()),
								(int) (y * Tile.TILEHEIGHT - handler
										.getGameCamera().getyOffset()));
					} else if (getTile(x, y) instanceof AnimatedTile) {
						((AnimatedTile) getTile(x, y)).renderAnimationInfo(g,
								(int) (x * Tile.TILEWIDTH - handler
										.getGameCamera().getxOffset()),
								(int) (y * Tile.TILEHEIGHT - handler
										.getGameCamera().getyOffset()));
					}
				}
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		//TODO load World
	}

	public boolean inBounds(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return false;
		return true;
	}

	public Handler getHandler() {
		return handler;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public int[][] getTiles() {
		return tiles;
	}
}

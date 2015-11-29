package dev.wonderland.gameDev.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.wonderland.gameDev.Handler;
import dev.wonderland.gameDev.tiles.Tile;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;

	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle(0, 0, width, height);
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public Rectangle getBounds() {
		return bounds;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getxTile() {
		return ((int)((getX() + (getWidth()/2)) / Tile.TILEWIDTH));
	}
	
	public int getyTile() {
		return ((int)((getY() + (getHeight()/2)) / Tile.TILEHEIGHT));
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void renderBounds(Graphics g) {
		g.setColor(Color.red);
		g.drawRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
	}

	public Rectangle getCurrentBounds() {
		return new Rectangle((int) (this.x + bounds.x), (int) (this.y + bounds.y), bounds.width, bounds.height);
	}

}

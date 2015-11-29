package dev.wonderland.gameDev.gfx;

import dev.wonderland.gameDev.Game;
import dev.wonderland.gameDev.entities.Entity;

public class GameCamera {
	
	private Game game;
	private float xOffset, yOffset;
	
	private Entity centerPoint;
	
	public GameCamera(Game game, float xOffset, float yOffset){
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void setCenterEntity(Entity e){
		this.centerPoint = e;
	}
	
	public void update(){
		if(centerPoint != null){
			centerOnEntity(centerPoint);
		}
	}
	
	public void centerOnEntity(Entity e){
		if(e != centerPoint) centerPoint = null;
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}

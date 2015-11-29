package dev.wonderland.gameDev.entities.creatures;

import java.awt.Graphics;

import dev.wonderland.gameDev.Handler;
import dev.wonderland.gameDev.gfx.Animation;
import dev.wonderland.gameDev.tiles.Tile;

public class Player extends Creature {
	
	private boolean moving = false;
	
	private Animation direction;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		handler.getGameCamera().setCenterEntity(this);
	}

	@Override
	public void tick() {
		getInput();
		move();
		
		if(moving) direction.tick();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().left){
			xMove = -speed;
			//direction = left;
		}
		if(handler.getKeyManager().right){
			xMove = speed;
			//direction = right;
		}
		
		if(xMove != 0 || yMove != 0 || xMove != 0 && yMove != 0){
			moving = true;
		}else{
			moving = false;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(direction.getTexture(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
}

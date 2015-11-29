package dev.wonderland.gameDev.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import dev.wonderland.gameDev.Handler;
import dev.wonderland.gameDev.entities.creatures.Player;
import dev.wonderland.gameDev.tiles.Tile;
import dev.wonderland.gameDev.utils.DebugVars;
import dev.wonderland.gameDev.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;

	public GameState(Handler handler){
		super(handler);
		
		world = new World(handler, "PATH_TO_WORLD");
		handler.setWorld(world);
		
		player = new Player(handler, 1, 1);
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
		handler.getGameCamera().update();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		
		if (DebugVars.debugMode)
			player.renderBounds(g);

		if (DebugVars.debugMode) {
			g.setFont(new Font("temp", 1, 25));
			g.setColor(Color.magenta);
			g.drawString(
					"xTile: "
							+ ((int) ((player.getX() + (player.getWidth() / 2)) / Tile.TILEWIDTH))
							+ " yTile: "
							+ ((int) ((player.getY() + (player.getHeight() / 2)) / Tile.TILEHEIGHT)),
					5, g.getFont().getSize() + 5);
			g.drawString("X: " + player.getX() + " Y: " + player.getY(), 5,
					2 * (g.getFont().getSize() + 5));

		}
	}

	public Player getPlayer() {
		return player;
	}
}

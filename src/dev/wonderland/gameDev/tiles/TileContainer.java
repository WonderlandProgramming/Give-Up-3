package dev.wonderland.gameDev.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TileContainer extends Tile {

	private Tile[] tiles;

	public TileContainer(int id, Tile... tiles) {
		super(null, id);
		this.tiles = tiles;

		calculateNewImage();
	}

	@Override
	public boolean isSolid() {
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i].isSolid())
				return true;
		}
		return false;
	}

	private void calculateNewImage() {
		texture = new BufferedImage(Tile.TILEWIDTH, Tile.TILEHEIGHT,
				BufferedImage.TYPE_INT_ARGB);

		Graphics g = texture.getGraphics();

		for (int i = 0; i < tiles.length; i++) {
			g.drawImage(tiles[i].texture, 0, 0, Tile.TILEWIDTH,
					Tile.TILEHEIGHT, null);
		}
	}

	@Override
	public void tick() {
		for (int i = 0; i < tiles.length; i++) {
			BufferedImage old = tiles[i].texture;
			tiles[i].tick();
			if (old != tiles[i].texture)
				calculateNewImage();
		}
	}
}

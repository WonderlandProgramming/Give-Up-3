package dev.wonderland.gameDev.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import dev.wonderland.gameDev.tiles.Tile;

public class ImageLoader {

	private static HashMap<String, BufferedImage> imageList;
	
	public static BufferedImage loadImage(String path){
		if(imageList == null){
			imageList = new HashMap<>();
			BufferedImage nullObject = new BufferedImage(Tile.TILEWIDTH, Tile.TILEHEIGHT, 2);
			imageList.put("nullObject", nullObject);
		}
		BufferedImage toReturn = imageList.get(path);
		if(toReturn == null){
			try {
				toReturn = ImageIO.read(new File("./" + path));
				imageList.put(path, toReturn);
				System.out.println("Registerd new Image: " + path);
				return toReturn;
			} catch (Exception e) {
				System.out.println("Image not found: " + path);
			}
			return imageList.get("nullObject");
		}
		else{
			return toReturn;
		}
	}
}

package dev.wonderland.gameDev.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;

	public static BufferedImage[] player_down = new BufferedImage[3];
	public static BufferedImage[] player_up = new BufferedImage[3];
	public static BufferedImage[] player_right = new BufferedImage[3];
	public static BufferedImage[] player_left = new BufferedImage[3];
	
	public static BufferedImage player, dirt, grass, stone, tree;
	
	public static BufferedImage waterAnim1, waterAnim2, waterAnim3;

	public static void init(){
		SpriteSheet  sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/sheet.png"));
		
		player_down[0] = sheet.crop(width * 3, height * 6, width, height);
		player_down[1] = sheet.crop(width * 4, height * 6, width, height);
		player_down[2] = sheet.crop(width * 5, height * 6, width, height);
		
		player_right[0] = sheet.crop(width * 0, height * 6, width, height);
		player_right[1] = sheet.crop(width * 1, height * 6, width, height);
		player_right[2] = sheet.crop(width * 2, height * 6, width, height);
		
		player_up[0] = sheet.crop(width * 0, height * 7, width, height);
		player_up[1] = sheet.crop(width * 1, height * 7, width, height);
		player_up[2] = sheet.crop(width * 2, height * 7, width, height);
		
		player_left[0] = sheet.crop(width * 3, height * 7, width, height);
		player_left[1] = sheet.crop(width * 4, height * 7, width, height);
		player_left[2] = sheet.crop(width * 5, height * 7, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width * 2, 0, width, height);
		stone = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, 0, width, height);
		
		waterAnim1 = sheet.crop(width * 0, height * 1, width, height);
		waterAnim2 = sheet.crop(width * 1, height * 1, width, height);
		waterAnim3 = sheet.crop(width * 2, height * 1, width, height);
	}
	
}

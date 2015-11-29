package dev.wonderland.gameDev.utils;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public static BufferedImage insertTextintoTexture(BufferedImage source, String insert, int ins_x, int ins_y) {
		BufferedImage rt = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
		Graphics g = rt.getGraphics();
		g.drawImage(source, 0, 0, source.getWidth(), source.getHeight(), null);
		g.drawString(insert, ins_x, ins_y);
		
		return rt;
	}

}

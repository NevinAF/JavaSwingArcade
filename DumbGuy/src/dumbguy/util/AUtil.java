package dumbguy.util;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class AUtil
{
	private static ImageCashe imageCashe;
	private static FontCashe fontCashe;
	
	public static void init(String gameFolderPath)
	{
		imageCashe = new ImageCashe(gameFolderPath);
		imageCashe.loadAll("", true);
		fontCashe = new FontCashe(gameFolderPath);
	}
	
	public static BufferedImage getImage(String image)
	{
		return imageCashe.get(image);
	}

	public static Font getFont(String font, float fontSize)
	{
		// TODO Auto-generated method stub
		return fontCashe.get(font, fontSize);
	}
}

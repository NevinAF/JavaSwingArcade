package dumbguy.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FontCashe
{
	private HashMap<String, Font> map = new HashMap<String, Font>();
	private String fontFolderPath;
	
	public FontCashe(String gameFolderPath)
	{
		fontFolderPath = gameFolderPath + "resorces\\fonts";
		map.put("default", new Font("Serif", Font.PLAIN, 20));
	}
	
	public Font get(String font, float fontSize)
	{
		Font fnt;
		
		fnt = map.get(font);
		if (fnt != null)
			return copy(fnt, fontSize);
		
		else
		{
			try
			{
				fnt = Font.createFont(Font.PLAIN, new File(fontFolderPath + "\\" + font));
			} catch (IOException | FontFormatException e)
			{
				e.printStackTrace();
				return null;
			}
			
			map.put(font, fnt);
			return copy(fnt, fontSize);
		}
	}

	private Font copy(Font font, float fontSize)
	{
		return font.deriveFont(fontSize);
	}
	
	public void loadAll(String folder, boolean allFolders)
	{
//		File[] files = new File(fontFolderPath + "\\" + folder).listFiles();
//		for(File file : files)
//		{
//			if (file.isFile())
//			{
//				if(file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) TODO
//				{
//					try
//					{
//						BufferedImage image = ImageIO.read(file);
//						map.put(folder + "\\" + file.getName(), image);
//					} catch (IOException e) {e.printStackTrace();}
//				}
//			} else if (file.isDirectory() && allFolders)
//			{
//				loadAll(folder + "\\" + file.getName(), allFolders);
//			}
//		}
	}
}

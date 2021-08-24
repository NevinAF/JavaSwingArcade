package dumbguy.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageCashe
{
	private HashMap<String, BufferedImage> map = new HashMap<String, BufferedImage>();
	private String imageFolderPath;
	
	public ImageCashe(String gameFolderPath)
	{
		imageFolderPath = gameFolderPath + "resorces\\images";
	}
	
	public BufferedImage get(String image)
	{
		BufferedImage img;
		
		img = map.get(image);
		if (img != null)
			return copy(img);
		
		else
		{
			try
			{
				img = ImageIO.read(new File(imageFolderPath + "\\" + image));
			} catch (IOException e)
			{
				e.printStackTrace();
				return null;
			}
			
			map.put(image, img);
			return copy(img);
		}
	}

	private BufferedImage copy(BufferedImage image)
	{
		BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = copy.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return copy;
	}
	
	public void loadAll(String folder, boolean allFolders)
	{
		File[] files = new File(imageFolderPath + "\\" + folder).listFiles();
		for(File file : files)
		{
			if (file.isFile())
			{
				if(file.getName().endsWith(".png") || file.getName().endsWith(".jpg"))
				{
					try
					{
						BufferedImage image = ImageIO.read(file);
						map.put(folder + "\\" + file.getName(), image);
					} catch (IOException e) {e.printStackTrace();}
				}
			} else if (file.isDirectory() && allFolders)
			{
				loadAll(folder + "\\" + file.getName(), allFolders);
			}
		}
	}
}

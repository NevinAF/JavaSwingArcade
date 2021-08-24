package arcade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader
{
	public static String filesPath = "";
	
	public static class Pictures
	{
		public static BufferedImage loadImage(File file)
		{
			BufferedImage b = null, f = null;
			try
			{
				b = ImageIO.read(file);
				f = new BufferedImage(b.getWidth(), b.getHeight(), BufferedImage.TYPE_INT_ARGB);
				f.getGraphics().drawImage(b, 0, 0, null);

			} catch (IOException e)
			{
				e.printStackTrace();
			}
			return f;
		}
		
		public static BufferedImage loadImage(String file)
		{
			return Pictures.loadImage(new File(filesPath + file));
		}
		
		public static BufferedImage resize(BufferedImage image, int width, int height) { 
//		    Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		    BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		    
		    Graphics2D g2d = dimg.createGraphics();
		    g2d.drawImage(image, 0, 0, width, height, null);
		    g2d.dispose();

		    return dimg;
		}
	}
	
	/**
	 * sets the default file path for 
	 * @param path
	 */
	public static void setPath(String path)
	{
		filesPath = path;
	}
}

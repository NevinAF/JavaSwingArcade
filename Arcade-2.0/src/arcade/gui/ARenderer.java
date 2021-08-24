package arcade.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ARenderer
{
	private BufferedImage bufferedImage;
	private Graphics bufferedGraphics;
	private Rectangle camera;
	private Dimension view;
	
	public ARenderer(Dimension canvasSize, Dimension fixedBufferedSize) 
	{
		//define width and height of bufferedImage
		int imageWidth = fixedBufferedSize.width;
		int imageHeight = fixedBufferedSize.height;
		
		//Create a BufferedImage that will represent the view.
		bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
		bufferedGraphics = bufferedImage.getGraphics();
		
		camera = new Rectangle(0, 0, imageWidth, imageHeight);
		
		//define the window size
		view = new Dimension(canvasSize.width, canvasSize.height);
	}

	public void render(Graphics canvasGraphics)
	{
		canvasGraphics.drawImage
		(
			bufferedImage,
			0, 0, view.width, view.height,
			camera.x, camera.y, camera.width, camera.height,
			null
		);
	}

	public void resizeView(int width, int height)
	{
		view = new Dimension(width, height);
	}

	public void renderImage(BufferedImage image, int x, int y, int w, int h)
	{
		bufferedGraphics.drawImage(image, x, y, w, h, null);
	}

	public Graphics getBufferedGraphics()
	{
		return bufferedGraphics;
	}

	public Rectangle getCamera()
	{
		return camera;
	}

	public Dimension getView()
	{
		return view;
	}

	public void renderText(String text, Font font, Color color, int textX, int textY)
	{
		// TODO Auto-generated method stub
		
	}
}

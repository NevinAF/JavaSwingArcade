package arcade.gui;

import java.awt.image.BufferedImage;

import arcade.Loader;

public class AImage implements DrawAble
{
	public static final int ALIGN_LEFT = 0, ALIGN_TOP = 0;
	public static final int ALIGN_CENTER = 1;
	public static final int ALIGN_RIGHT = 2, ALIGN_BOTTOM = 2;
	
	protected int x, y, w, h;
	protected BufferedImage image;
	protected boolean isFixed;
	protected int x_alignment;
	protected int y_alignment;
	
	protected ALabel label;
	
	public AImage(String file, double xpercent, double ypercent, double width, double height)
	{
		if (width < 1)
			width = 1.00;
		if (height < 1)
			height = 1.00;
		w = (int) (AFrame.BUFFERED_SIZE.getWidth() * width);
		h = (int) (AFrame.BUFFERED_SIZE.getHeight() * height);
		
		x = (int) (AFrame.BUFFERED_SIZE.getWidth() * xpercent);
		y = (int) (AFrame.BUFFERED_SIZE.getHeight() * ypercent);
		
		image = Loader.Pictures.loadImage(file);
		
		isFixed = false;
		
		x_alignment = ALIGN_LEFT;
		y_alignment = ALIGN_TOP;
		
		label = null;
	}
	
	
	public AImage(double xpercent, double ypercent, double width, double height)
	{
		this(null, xpercent, ypercent, width, height);
	}
	
	public void setLabel(String text)
	{
		label = new ALabel(text, w, h);
	}
	
	public void setFixed(boolean isFixed)
	{
		this.isFixed = isFixed;
	}
	
	public void setHorizontalAlignment(int align)
	{
		switch(x_alignment)
		{
		case 1:
			x += w / 2;
			break;
		case 2:
			x += w;
			break;
		}
		
		switch(align)
		{
		case 1:
			x -= w / 2;
			break;
		case 2:
			x -= w;
			break;
		}
		
		x_alignment = align;
	}
	
	public void setVerticalAlignment(int align)
	{
		switch(y_alignment)
		{
		case 1:
			y += h / 2;
			break;
		case 2:
			y += h;
			break;
		}
		
		switch(align)
		{
		case 1:
			y -= h / 2;
			break;
		case 2:
			y -= h;
			break;
		}
		
		y_alignment = align;
	}

	@Override
	public void render(ARenderer renderer)
	{
		if (isFixed)
		{
			if (image != null)
				renderer.renderImage(image, x + renderer.getCamera().x, y + renderer.getCamera().y, w, h);
			if (label != null)
				renderer.renderText(label.text, label.font, label.color, label.x, label.y);
		}
		else
		{
			if (image != null)
				renderer.renderImage(image, x, y, w, h);
		}
	}

	@Override
	public void update(AFrame frame)
	{
		
	}

}

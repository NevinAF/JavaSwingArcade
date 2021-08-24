package dumbguy.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dumbguy.util.AUtil;

public class AImage
{
	public static final int ALIGN_LEFT = 0, ALIGN_TOP = 0;
	public static final int ALIGN_CENTER = 1;
	public static final int ALIGN_RIGHT = 2, ALIGN_BOTTOM = 2;
	
	private int w, h;
	private BufferedImage image;
	private int x_alignment;
	private int y_alignment;
	
	public AImage(String file, double width, double height)
	{
		if (width < 1)
			width = 1.00;
		if (height < 1)
			height = 1.00;
		w = (int) (AScreen.BUFFERED_WIDTH * width);
		h = (int) (AScreen.BUFFERED_HEIGHT * height);
		
		image = AUtil.getImage(file);
		
		x_alignment = ALIGN_LEFT;
		y_alignment = ALIGN_TOP;
	}
	
	public AImage(String file, int width, int height)
	{
		w = width;
		h = height;
		
		image = AUtil.getImage(file);
		
		x_alignment = ALIGN_LEFT;
		y_alignment = ALIGN_TOP;
	}
	
	public void setHorizontalAlignment(int align)
	{
		x_alignment = align;
	}
	
	public void setVerticalAlignment(int align)
	{
		y_alignment = align;
	}

	public void render(Graphics g, int x, int y)
	{
		switch(x_alignment)
		{
		case 1:
			x -= w / 2;
			break;
		case 2:
			x -= w;
			break;
		}
		
		switch(y_alignment)
		{
		case 1:
			y -= h / 2;
			break;
		case 2:
			y -= h;
			break;
		}
		
		g.drawImage(image, x, y, w, h, null);
	}
	
	public void render(Graphics g, double xpercent, double ypercent)
	{
		int x = (int) (AScreen.BUFFERED_WIDTH * xpercent);
		int y = (int) (AScreen.BUFFERED_HEIGHT * ypercent);
		
		switch(x_alignment)
		{
		case 1:
			x -= w / 2;
			break;
		case 2:
			x -= w;
			break;
		}
		
		switch(y_alignment)
		{
		case 1:
			y -= h / 2;
			break;
		case 2:
			y -= h;
			break;
		}
		
		g.drawImage(image, x, y, w, h, null);
	}

}

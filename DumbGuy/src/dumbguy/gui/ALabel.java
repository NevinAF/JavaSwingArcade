package dumbguy.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dumbguy.AElement;
import dumbguy.util.AUtil;

public  ALabel
{
	public static final int ALIGN_LEFT = 0, ALIGN_TOP = 0;
	public static final int ALIGN_CENTER = 1;
	public static final int ALIGN_RIGHT = 2, ALIGN_BOTTOM = 2;
	
	private String text;
	private boolean focus;
	public int x, y;
	private int x_alignment;
	private int y_alignment;
	private Color color;
	private Font font;
	
	public ALabel()
	{
		text = "";
		focus = true;
		color = Color.BLACK;
		font = AUtil.getFont("default", 50);
		
		x_alignment = ALIGN_LEFT;
		y_alignment = ALIGN_TOP;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public void setFont(Font font)
	{
		this.font = font;
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
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		
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
		case 0:
			y += h;
			break;
		case 1:
			y += h/2;
			break;
		}
		g.setColor(color);
		g.setFont(font);
		g.drawString(text, x, y);
	}

	public String getText()
	{
		return text;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
}


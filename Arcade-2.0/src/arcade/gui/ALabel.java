package arcade.gui;

import java.awt.Color;
import java.awt.Font;

import arcade.AFonts;

public class ALabel
{
	public String text;
	public Font font;
	public Color color;
	public boolean fill;
	
	public int x, y;
	public int x_alignment;
	public int y_alignment;
	
	
	public ALabel(String text, int width, int height)
	{
		this.text = text;
		font = AFonts.DEFAULT;
		color = Color.BLACK;
		fill = true;
		
		x = 0;
		y = 0;
		x_alignment = AImage.ALIGN_CENTER;
		y_alignment = AImage.ALIGN_CENTER;
	}
	
	public void setFill(boolean fill)
	{
		this.fill = fill;
	}
	
	public void setPadding(int top, int right, int bottom, int left)
	{
		
	}
	
}

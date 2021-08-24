package dumbguy.tiles;

import java.awt.image.BufferedImage;

public abstract class Tile
{
	public int x, y, r;
	public BufferedImage image;
	public char type;
	
	public Tile(int x, int y, int r)
	{
		this.x = x;
		this.y = y;
		this.r = r;
	}
}

package dumbguy.tiles;

import dumbguy.util.AUtil;

public class Brick extends Tile
{
	
	public Brick(int x, int y, int r)
	{
		super(x, y, r);
		image = AUtil.getImage("DGBrick.png");
		type = 'b';
	}

}

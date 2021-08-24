package dumbguy.tiles;

import dumbguy.util.AUtil;

public class Player extends Tile
{

	public Player(int x, int y, int r)
	{
		super(x, y, r);
		image = AUtil.getImage("DGplayer.png");
		type = 'd';
	}

}

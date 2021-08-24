package dumbguy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dumbguy.gui.AScreen;
import dumbguy.tiles.Brick;
import dumbguy.tiles.Player;
import dumbguy.tiles.Tile;

public class Mapp
{
	public static String levelPath;
	public ArrayList<Tile> tiles;
	
	public Mapp(int level) throws IOException
	{
		tiles = new ArrayList<Tile>();
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				levelPath + "\\Level" + ((level-1) % 10 + 1) + "World" + (int)Math.ceil((double)(level)/10) + ".txt"
				)));
		
		ArrayList<String> lines = new ArrayList<String>();
		while(true)
		{
			String line = reader.readLine();
			if(line == null)
			{
				reader.close();
				break;
			}
			if(!line.startsWith("!"))
				lines.add(line);
		}
		createTileList(lines);
	}

	private void createTileList(ArrayList<String> lines)
	{
		for (String line : lines)
		{
			System.out.println(line);
			int x = Integer.parseInt(line.substring(1, 3));
			int y = Integer.parseInt(line.substring(3, 5));
			int r = Integer.parseInt(line.substring(5, 6));
			System.out.println(x + "   " + y + "   " + r);
			switch(line.charAt(0))
			{
			case 'b':
				tiles.add(new Brick(x,y,r));
				break;
			case 'd':
				tiles.add(new Player(x,y,r));
				break;
			default:
				System.out.println("Error in mapp, heres the line: " + line);
				break;
			}
		}
	}

	public static void setLevelPath(String levelPath)
	{
		Mapp.levelPath = levelPath;
	}

	public BufferedImage getImage()
	{
		BufferedImage image = new BufferedImage(AScreen.BUFFERED_WIDTH, AScreen.BUFFERED_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = image.getGraphics();
		int width = image.getWidth()/Main.MAP_SIZE.width;
		int height = image.getHeight()/Main.MAP_SIZE.height;
		for(Tile tile : tiles)
		{
			g.drawImage(
					tile.image,
					tile.x/Main.MAP_SIZE.width * image.getWidth(),
					tile.y/Main.MAP_SIZE.height * image.getHeight(),
					width,
					height,
					null);
		}
		
		g.dispose();
		return image;
	}
}

package dumbguy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dumbguy.gui.AScreen;
import dumbguy.tiles.Brick;
import dumbguy.tiles.Player;
import dumbguy.tiles.Tile;

public class LevelMaker extends AScreen
{
	public ArrayList<Tile> tiles;
	
	public LevelMaker(int level)
	{
		if(level <= 0)
			tiles =  new ArrayList<Tile>();
		else
			try
			{
				tiles = new Mapp(level).tiles;
			} catch (IOException e)
			{
				e.printStackTrace();
				
				tiles =  new ArrayList<Tile>();
			}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int x = (int) Math.floor(mouseInfo.getMouse().x * Main.MAP_SIZE.width / AScreen.BUFFERED_WIDTH);
		int y = (int) Math.floor(mouseInfo.getMouse().y * Main.MAP_SIZE.width / AScreen.BUFFERED_WIDTH);
		int r = keyInfo.keys['1'] ? 1 : keyInfo.keys['2'] ? 2 : keyInfo.keys['3'] ? 3 : 0;
		switch (e.getKeyChar())
		{
		case 'b':
			tiles.add(new Brick(x,y,r));
			break;
		case 'd':
			tiles.add(new Player(x,y,r));
			break;
		case 'q':
			for (Tile tile : tiles)
				if(tile.x == x && tile.y == y)
					tiles.remove(tile);
			break;
		case '\\':
			saveMap();
			break;
		case ']':
			setScreen(new Home());
			return;
		}
		repaint();
	}
	
	
	private void saveMap()
	{
		System.out.println("Enter Level");
		int l = new Scanner(System.in).nextInt();
		try
		{
			File file = new File(
					Mapp.levelPath + "\\Level" + ((l-1) % 10 + 1) + "World" + (int)Math.ceil((double)(l)/10) + ".txt"
					);
			if (file.createNewFile())
			{
				file.delete();
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			for(Tile tile : tiles)
			{
				String w = "";
				w += tile.type;
				w += tile.x < 10 ? "0" + tile.x : tile.x;
				w += tile.y < 10 ? "0" + tile.y : tile.y;
				w += tile.r;
				writer.write(w);
				writer.write(System.lineSeparator());
				
			}
			writer.close();
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, BUFFERED_WIDTH, BUFFERED_HEIGHT);
		int width = BUFFERED_WIDTH/Main.MAP_SIZE.width;
		int height = BUFFERED_HEIGHT/Main.MAP_SIZE.height;
		for(Tile tile : tiles)
		{
			g.drawImage(
					tile.image,
					(int)((double)(tile.x)/Main.MAP_SIZE.getWidth() * BUFFERED_WIDTH),
					(int)((double)(tile.y)/Main.MAP_SIZE.getHeight() * BUFFERED_HEIGHT),
					width,
					height,
					null);
			System.out.println("x: " + tile.x + "    y: " + tile.y);
		}
	}
	
}

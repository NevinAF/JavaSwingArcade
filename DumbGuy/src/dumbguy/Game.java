package dumbguy;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;

import dumbguy.gui.AScreen;

public class Game extends AScreen
{
	private Mapp map;
	private int level;
	
	public Game(int level)
	{
		this.level = level;
		loadLevel(level);
	}
	
	private void loadLevel(int level)
	{
		try
		{
			map = new Mapp(level);
		} 
		catch (IOException e) {e.printStackTrace();}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyChar())
		{
		case 'w':
		case 'a':
		case 's':
		case 'd':
			tick(e.getKeyChar());
			break;
		}
	}

	private void tick(char keyChar)
	{
		
	}

	@Override
	public void render(Graphics g)
	{
		
	}
}

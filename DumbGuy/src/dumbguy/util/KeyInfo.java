package dumbguy.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInfo implements KeyListener
{

	public boolean[] keys;
	
	public KeyInfo()
	{
		keys = new boolean[200];
		for(boolean key : keys)
		{
			key = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyChar()<=200)
			keys[e.getKeyChar()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar()<=200)
			keys[e.getKeyChar()] = true;
	}
	
}

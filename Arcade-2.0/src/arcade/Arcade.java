package arcade;

import arcade.games.Screen;
import arcade.gui.AFrame;

public class Arcade
{
	public static final String AUTHOR = "Nevin";
	public static final String FRAME_TITLE = "Arcade";
	public static final String VERSION = "1.0";
	
	public static void main(String[] args)
	{
		new Arcade();
	}
	
	private Arcade()
	{
		AFrame frame = new AFrame();
		Screen.setFrame(frame);
		new Home();
	}
}

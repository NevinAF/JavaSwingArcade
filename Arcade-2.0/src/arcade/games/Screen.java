package arcade.games;

import java.util.ArrayList;

import arcade.gui.AFrame;
import arcade.gui.DrawAble;

public class Screen
{
	protected static Thread frameThread;
	protected static AFrame frame;
	public ArrayList<DrawAble> objects;

	public static void setFrame(AFrame frame)
	{
		Screen.frame = frame;
		frameThread = new Thread(frame);
	}
	
	protected Screen()
	{
		objects = new ArrayList<DrawAble>();
		frame.setScreen(this);
	}
}

package arcade;

import arcade.games.Screen;
import arcade.gui.AButton;
import arcade.gui.AImage;

public class Home extends Screen
{
	public Home()
	{
		super();
		
		objects.add(new AImage("C:\\Users\\nevin\\Desktop\\Arcade\\Arcade-2.0\\files\\pictures\\ArcadeHomeBackground.png", 0.00, 0.00, -1, -1));
		
		AButton testButton = new AButton(.50, .50, ) {};
		objects.add(testButton);
		frameThread.start();
	}
}

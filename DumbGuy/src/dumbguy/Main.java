package dumbguy;

import java.awt.Dimension;
import java.io.File;
import java.util.Scanner;

import dumbguy.core.AccountHandler;
import dumbguy.core.LoadFrame;
import dumbguy.gui.AScreen;
import dumbguy.util.AUtil;
import dumbguy.util.KeyInfo;
import dumbguy.util.MouseInfo;

public class Main
{
	public static void main(String[] args)
	{
		gameFolderPath = new File(
				Main.class.getProtectionDomain().getCodeSource().getLocation().getFile()
							 ).getParent() + "\\";

		new Main();
		
	}
	
	public static final String GAME_TITLE = "DumbGuy";
	public static final String GAME_VERSION = "1.0.0";
	public static final String LOADIMAGE_FILE = "LoadImage.jpg";
	public static final Dimension MAP_SIZE = new Dimension(30,20);
	
	private AFrame frame;
	public static String gameFolderPath;
	
	private Main()
	{
		LoadFrame loadFrame = new LoadFrame(gameFolderPath + LOADIMAGE_FILE);
		
		
		frame = new AFrame();
		AUtil.init(gameFolderPath);
		AScreen.init(frame);
		Mapp.setLevelPath(gameFolderPath + "resorces\\levels");
		AccountHandler.init(gameFolderPath);
		
		
		AScreen.setScreen(new Home());
		
		try
		{
			Thread.sleep(1000);
			loadFrame.dispose();
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.setVisible(true);
		frame.requestFocus();
	}
	
	public static KeyInfo getKeyInfo()
	{
		return AScreen.getKeyInfo();
	}
	
	public static MouseInfo getKMouseInfo()
	{
		return AScreen.getMouseInfo();
	}
}

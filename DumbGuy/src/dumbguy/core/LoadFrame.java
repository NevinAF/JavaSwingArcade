package dumbguy.core;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import dumbguy.Main;

public class LoadFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private BufferedImage loadingImage;
	
	public LoadFrame(String loadingImage)
	{
		super(Main.GAME_TITLE + " Starter: Loading...");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 500);
		setLocationRelativeTo(null);
	    setUndecorated(true);
	    
	    try
		{
			this.loadingImage = ImageIO.read(new File(loadingImage));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	    setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(loadingImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}

package dumbguy;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import dumbguy.gui.ACanvas;

public class AFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private boolean fullScreen;
	private ACanvas canvas;
	private Dimension lastSize;
	private Point lastLocation;

	public AFrame()
	{
		super(Main.GAME_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		
		lastSize = getSize();
		lastLocation = getLocation();
		fullScreen = false;
		
		canvas = new ACanvas();
		add(canvas);
	}

	public ACanvas getCanvas()
	{
		return this.canvas;
	}

	public void toggleFullScreen()
	{
		dispose();
		if(fullScreen)
		{
			setUndecorated(false);
			setSize(lastSize);
			setLocation(lastLocation);
		} else
		{
			lastSize = getSize();
			lastLocation = getLocation();
			setUndecorated(true);
			
			setExtendedState(MAXIMIZED_BOTH);
		}
		
		fullScreen = !fullScreen;
		setVisible(true);
	}
}

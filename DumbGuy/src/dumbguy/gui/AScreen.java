package dumbguy.gui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dumbguy.AFrame;
import dumbguy.AElement;
import dumbguy.util.KeyInfo;
import dumbguy.util.MouseInfo;

public abstract class AScreen extends AElement
{
	/*-------------------STATIC METHODS AND FIELDS-------------------*/
	
	public static final int BUFFERED_WIDTH = 3000;
	public static final int BUFFERED_HEIGHT = 2000;
	private static AFrame frame;
	protected static ACanvas canvas;
	private static AScreen screen;
	private static Thread thread;
	
	public static void init(AFrame frame)
	{
		keyInfo = new KeyInfo()
				{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyChar() == KeyEvent.VK_ESCAPE)
				{
					frame.toggleFullScreen();
					return;
				}
				
				for(AElement element : screen.elements)
					element.keyPressed(e);
			}
				};
		mouseInfo = new MouseInfo()
				{
			@Override
			public void mouseMoved(MouseEvent e)
			{
				
				int x = (int)(((double)e.getX() / canvas.getWidth()) * BUFFERED_WIDTH);
				int y = (int)(((double)e.getY() / canvas.getHeight()) * BUFFERED_HEIGHT);
				mouseInfo.setMouse(new Point(x,y));
				
				for(AElement element : screen.elements)
					element.mouseMoved();;
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				System.out.println("MouseEnter");
				setFocus(true);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				System.out.println("MouseExit");
				setFocus(false);
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				for(AElement element : screen.elements)
					element.mousePressed();
			}
				};
				
		thread = new Thread()
				{
			@Override
			public void run()
			{
				
				long lastTime = System.currentTimeMillis();
				double conversion = 1000.0/60;
				double changeInSeconds = 0;
				
				while(true)
				{
					long now = System.currentTimeMillis();
					changeInSeconds += (now - lastTime) / conversion;
					while(changeInSeconds >= 1)
					{
						for(AElement element : screen.elements)
							element.update();
						changeInSeconds--;
					}
					screen.repaint();
				}
				
			}
				};
		
		AScreen.frame = frame;
		canvas = frame.getCanvas();
		
		frame.addKeyListener(keyInfo);
		canvas.addMouseListener(mouseInfo);
		canvas.addMouseMotionListener(mouseInfo);
	}
	
	protected void startThread()
	{
		thread.start();
	}
	
	/*-------------------INSTANCE METHODS AND FIELDS-------------------*/
	
	private ArrayList<AElement> elements;
	protected BufferedImage lastImage = null;
	
	protected AScreen()
	{
		AScreen.screen = this;
		elements = new ArrayList<AElement>();
		addElement(this);
	}

	public void update()
	{
		
	}
	
	public abstract void render(Graphics g);

	protected void repaint()
	{
		BufferedImage image = new BufferedImage(AScreen.BUFFERED_WIDTH, AScreen.BUFFERED_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = image.getGraphics();
		
		for(AElement element : screen.elements)
			element.render(g);
		
		canvas.setImage(image);
		canvas.repaint();
		canvas.repaint();
		
		lastImage = image;
	}
	
	protected void addElement(AElement element)
	{
		elements.add(element);
	}
	
	protected static void setFocus(boolean focus)
	{
		if(focus)
		{
			
		} else
		{
			
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		
	}
	
	protected void mouseMoved(MouseEvent e)
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}

	public static void setScreen(AScreen screen)
	{
		AScreen.screen = screen;
	}

	public static KeyInfo getKeyInfo()
	{
		return keyInfo;
	}

	public static MouseInfo getMouseInfo()
	{
		return mouseInfo;
	}
}

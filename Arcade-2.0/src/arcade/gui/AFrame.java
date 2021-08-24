package arcade.gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.Renderer;

import arcade.Arcade;
import arcade.games.Screen;

public class AFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public static final Dimension WINDOW_SIZE = new Dimension(1000, 1000);
	public static Dimension BUFFERED_SIZE = new Dimension(3200, 2000);
	
	private Canvas canvas;
	private ARenderer renderer;
	private Screen screen;
	private MouseMotionListener mouseMotion;
	private MouseListener mouse;
	private KeyListener keys;
	
	public AFrame()
	{
		//frame defaults
		setTitle(Arcade.FRAME_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(WINDOW_SIZE);
		setVisible(true);
		
		//set up graphics for screen
		canvas = new Canvas();
		add(canvas);
		canvas.createBufferStrategy(3);
		
		renderer = new ARenderer(new Dimension(canvas.getWidth(), canvas.getHeight()), BUFFERED_SIZE);
		
		//listeners
		addComponentListener
		(
			new ComponentAdapter()
			{
				@Override
				public void componentResized(ComponentEvent e)
				{
					resizeComponents();
				}
			}
		);
		
		mouseMotion = new MouseMotionListener()
				{
					@Override
					public void mouseDragged(MouseEvent arg0) {}

					@Override
					public void mouseMoved(MouseEvent arg0)
					{
						
					}
				};
	}
	
	public void update()
	{
		for(int i = 0; i < screen.objects.size(); i++) 
			screen.objects.get(i).update(this);
	}
	
	public void render()
	{
		
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics graphics = bufferStrategy.getDrawGraphics();
		super.paint(graphics);
		
		
		for(int i = 0; i < screen.objects.size(); i++) 
			screen.objects.get(i).render(renderer);

		renderer.render(graphics);

		graphics.dispose();
		bufferStrategy.show();
	}
	
	@Override
	public void run()
	{
		long lastTime = System.nanoTime(); //long 2^63
		double nanoSecondConversion = 1000000000.0 / 60; //60 frames per second
		double changeInSeconds = 0;

		while(true) 
		{
			long now = System.nanoTime();

			changeInSeconds += (now - lastTime) / nanoSecondConversion;
			while(changeInSeconds >= 1) {
				update();
				changeInSeconds--;
			}

			render();
			lastTime = now;
		}
	}
	
	private void resizeComponents()
	{
		renderer.resizeView(canvas.getWidth(), canvas.getHeight());
	}

	public void setScreen(Screen screen)
	{
		this.screen = screen;
	}
}

package dumbguy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import dumbguy.gui.AScreen;
import dumbguy.util.AUtil;

public class Home extends AScreen
{

	public Home()
	{
		super();
		repaint();
		
		
		Font f = AUtil.getFont("default", 10);
		Font h = AUtil.getFont("default", 1000);
		
		System.out.println("Font f size: " + f.getSize() + "   ");
		System.out.println("Font h size: " + h.getSize() + "   " + h.getSize2D());
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(AUtil.getImage("HomeBackground.jpg"), 0, 0, BUFFERED_WIDTH, BUFFERED_HEIGHT, null);
		g.setColor(Color.BLACK);
		g.setFont(AUtil.getFont("default", 100));
		String s = "start new game: press 'n'";
		g.drawString(s, BUFFERED_WIDTH/2 - g.getFontMetrics().stringWidth(s)/2, 200);
		
		s = "load account: press 'l'";
		g.drawString(s, BUFFERED_WIDTH/2 - g.getFontMetrics().stringWidth(s)/2, 400);
		
		s = "create account: press 'c'";
		g.drawString(s, BUFFERED_WIDTH/2 - g.getFontMetrics().stringWidth(s)/2, 600);
		
		for(int i = 0x30; i <= 0x5A; i++)
		{
			s = KeyEvent.getKeyText(i).toLowerCase();
			System.out.println("'" + s + "' is this long at font size 100: " + g.getFontMetrics().stringWidth(s));
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyChar())
		{
		case 'n':
			setScreen(new Game(1));
			break;
		case 'l':
			setScreen(new Accounts(lastImage));
			break;
		case 'c':
			setScreen(new AccountCreator(lastImage));
		default:
			break;
		}
	}
}

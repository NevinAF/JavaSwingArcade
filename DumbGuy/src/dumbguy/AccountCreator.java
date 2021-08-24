package dumbguy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import dumbguy.core.AccountHandler;
import dumbguy.gui.AScreen;
import dumbguy.gui.InputBox;
import dumbguy.util.AUtil;

public class AccountCreator extends AScreen
{
	public BufferedImage backgroundImage;
	public InputBox textBox;
	public String error = "";
	
	public AccountCreator(BufferedImage backgroundImage)
	{
		super();
		textBox = new InputBox(1500, 150);
		textBox.setHorizontalAlignment(InputBox.ALIGN_CENTER);
		addElement(textBox);
		this.backgroundImage = backgroundImage;
		startThread();
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(backgroundImage, 0, 0, null);
		g.setColor(new Color(255,255,255,160));
		g.fillRect(0, 0, BUFFERED_WIDTH, BUFFERED_HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(AUtil.getFont("default", 40));
		
		String s = "enter your username for account";
		g.drawString(s, BUFFERED_WIDTH/2 - g.getFontMetrics().stringWidth(s)/2, 150);
		
		
		
		g.setColor(Color.BLACK);
		s = error;
		g.drawString(s, BUFFERED_WIDTH/2 - g.getFontMetrics().stringWidth(s)/2, 300);
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		
			switch(e.getKeyChar())
			{
			case KeyEvent.VK_ENTER:
				try
				{
					AccountHandler.createAccount(textBox.getText());
				} catch (Exception e1)
				{
					error = "error: " + e1.getMessage();
					e1.printStackTrace();
				}
				break;
			}
		repaint();
		
	}
}

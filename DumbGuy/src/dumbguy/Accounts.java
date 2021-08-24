package dumbguy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dumbguy.gui.AScreen;
import dumbguy.util.AUtil;

public class Accounts extends AScreen
{
	public BufferedImage backgroundImage;
	
	public Accounts(BufferedImage backgroundImage)
	{
		this.backgroundImage = backgroundImage;
		repaint();
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(backgroundImage, 0, 0, null);
		g.setColor(new Color(255,255,255,110));
		g.fillRect(0, 0, BUFFERED_WIDTH, BUFFERED_HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(AUtil.getFont("defult", 40));
		String s = "T";
		g.drawString(s, BUFFERED_WIDTH/2 - g.getFontMetrics().stringWidth(s)/2, 150);
	}
	
}

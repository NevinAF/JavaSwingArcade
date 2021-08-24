package dumbguy.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ACanvas extends JPanel
{
	private static final long serialVersionUID = 1L;
	public BufferedImage image = null;
	
	@Override
	public void paintComponent(Graphics g)
	{
		if(image != null)
		{
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), getParent());
		}
	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
	}
}

package dumbguy;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dumbguy.util.KeyInfo;
import dumbguy.util.MouseInfo;

public abstract class AElement
{
	public static KeyInfo keyInfo;
	public static MouseInfo mouseInfo;
	
	public void keyPressed(KeyEvent e) {}
	
	public void mouseMoved() {}
	
	public void mousePressed() {}
	
	public void render(Graphics g) {};
	public void update() {};
}

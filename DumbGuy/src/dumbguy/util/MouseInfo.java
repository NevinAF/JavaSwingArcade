package dumbguy.util;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInfo implements MouseListener, MouseMotionListener
{
	/**Mouse point is adjusted in AScreen to match BufferedCanvas*/
	private Point mouse = new Point(0,0);
	private boolean clicked;
	private Point dragStart = null;
	
	/**UNNECESSARY BECAUSE IT CREATES IT'S OWN DRAG EVENT*/
	public void mouseDragged(MouseEvent arg0) {}

	/**THIS IS OVERRIDEN BY ASCREEN*/
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		clicked = true;
		dragStart = mouse;
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		clicked = false;
		dragStart = null;
	}

	/**THIS IS OVERRIDEN BY ASCREEN*/
	public void mouseEntered(MouseEvent arg0) {}

	/**THIS IS OVERRIDEN BY ASCREEN*/
	public void mouseExited(MouseEvent arg0) {}

	/**THIS IS OVERRIDEN BY ASCREEN*/
	public void mousePressed(MouseEvent arg0) {}

	public Point getMouse()
	{
		return mouse;
	}

	public void setMouse(Point mouse)
	{
		this.mouse = mouse;
	}

	public boolean isClicked()
	{
		return clicked;
	}

	public Point getDragStart()
	{
		return dragStart;
	}

	public boolean isDrag()
	{
		return mouse != dragStart;
	}

	

}

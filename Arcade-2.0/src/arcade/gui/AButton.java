package arcade.gui;

public class AButton extends AImage implements ActivateAble
{
	public AButton(String file, double xpercent, double ypercent, double width, double height)
	{
		super(file, xpercent, ypercent, width, height);
	}
	
	public AButton(double xpercent, double ypercent, double width, double height)
	{
		super(xpercent, ypercent, width, height);
	}
	
	public void action()
	{
		//override if something should happen
	}

	@Override
	public void render(ARenderer renderer)
	{
		super.render(renderer);
	}

	@Override
	public void update(AFrame frame)
	{
		
	}

	@Override
	public void activate(AFrame frame)
	{
		
	}

}

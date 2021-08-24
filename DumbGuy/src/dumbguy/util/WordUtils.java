package dumbguy.util;

import java.awt.Font;
import java.awt.Graphics;

public class WordUtils
{
	public static String extendedWrap(final String string, final int wrapLength, Graphics g) 
	{
		if(string == null)
			return null;
		String wrappedString = "";
		String[] words = string.split(" ");
		String seporator = System.lineSeparator();
		
		int currentWrap = 0;
		for(String word : words)
		{
			currentWrap += g.getFontMetrics().stringWidth(word + " ");
			if(currentWrap > wrapLength)
			{
				currentWrap = 0;
				wrappedString += seporator;
			}
			wrappedString += word + " ";
		}
		System.out.println(wrappedString);
		return wrappedString;
	}
}

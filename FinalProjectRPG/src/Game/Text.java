package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* Class Description
 * This class manages the on screen dialogue and the fonts in the game.
 */
public class Text
{
	static Font fnt0 = new Font("MS UI Gothic", Font.BOLD,20);
	static Font fnt1 = new Font("Calibri", Font.BOLD,15);
	static Font fnt2 = new Font("Calibri", Font.BOLD,30);
	static Font fnt5 = new Font("Calibri", Font.BOLD,40);
	static Font fnt3 = new Font("Bookman Old Style", Font.BOLD,50);
	static Font fnt4 = new Font("Franklin Gothic Medium", Font.LAYOUT_LEFT_TO_RIGHT, 20);
	public int writeText(Graphics g,String str) 
	{
		int count=1;
		boolean containsMess = true; 
		String messageHold = null;
		int messLength;
		int lastIndexOfSpace;
		String message = null;
		String name=null;
		try
		{
			message=str.substring(str.indexOf('-')+1);
			name=str.substring(0,str.indexOf('-'));
		}
		catch(StringIndexOutOfBoundsException e)
		{
			return 0;
		}
		g.setColor(Color.GRAY);
		g.fillRect(25, 380, 100, 50);
		g.fillRect(25,430,600,200);
		containsMess = true;
		messLength=message.length();
		while(containsMess)
		{
			if(messLength>60)
			{
				messageHold=message.substring(0, 59);
				lastIndexOfSpace=messageHold.lastIndexOf(' ');
				messageHold=message.substring(0, lastIndexOfSpace);
				message=message.substring(lastIndexOfSpace+1);
				messLength=message.length();
			}
			else
			{
				messageHold=message;
				containsMess=false;
			}
			g.setColor(Color.BLACK);
			g.setFont(fnt4);
			g.drawString(name, 40, 430);
			if(count==1)
				g.drawString(messageHold, 50, 475);
			else if(count==2)
				g.drawString(messageHold, 50, 515);
			else if(count==3)
				g.drawString(messageHold, 50, 555); 
			else if(count==4)
				g.drawString(messageHold, 50, 595);
			count++;
		}
		return 1;
	}
}
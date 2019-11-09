package lab_1;

import java.awt.Color;
import java.awt.Graphics;

public class OvalGuns implements IGuns {
	
	guns guns;
	Color colorGun;
	public OvalGuns(guns guns, Color _colorGun) 
	{
		this.colorGun=_colorGun;
		this.guns=guns;
	}
	
	public void draw(Graphics g, int startX, int startY) {
		int size=5;
		g.setColor(colorGun);
		switch (guns)
		{
		case ultra_superGun:
			
			g.drawOval( startX + 5, startY + size, 85, 5);
			
			g.fillOval( startX + 5, startY + size, 85, 5);			
			size+=9;
			
		case superGun:
			
			
			g.drawOval( startX + 5, startY + size, 85, 5);
			
			g.fillOval( startX + 5, startY + size, 85, 5);
			
			
			size+=9;
			
		
		case powerGun:
			
			
			g.drawOval( startX + 5, startY + size, 85, 5);
			
			g.fillOval( startX + 5, startY + size, 85, 5);
				
			break;
						
		}	
	}
	
	
	

}

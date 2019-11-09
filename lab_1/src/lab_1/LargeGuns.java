package lab_1;

import java.awt.Color;
import java.awt.Graphics;

public class LargeGuns {
	
	
	guns guns;
	Color colorGun;
	public  LargeGuns(guns guns, Color _colorGun) 
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
			g.drawRect( startX + 5, startY + size, 85, 5);

			g.fillRect( startX + 5, startY + size, 85, 5);	
			
			g.fillRect( startX + 70, startY + size-2, 35, 10);
			size+=9;

		case superGun:


			g.drawRect( startX + 5, startY + size, 85, 5);

			g.fillRect( startX + 5, startY + size, 85, 5);
			
			g.fillRect( startX + 70, startY + size-2, 35, 10);

			size+=9;


		case powerGun:


			g.drawRect( startX + 5, startY + size, 85, 5);

			g.fillRect( startX + 5, startY + size, 85, 5);
			
			g.fillRect( startX + 70, startY + size-2, 35, 10);
			

			break;

		}	
	}

}

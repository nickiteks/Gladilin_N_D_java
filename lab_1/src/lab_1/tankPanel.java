package lab_1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class tankPanel extends javax.swing.JPanel {



	static int x;
	static int y;
	int guns;// 3 parametr
	Color MainColor= new Color(141, 182, 0); 

	Color DopColor=new Color(253, 233, 16);   


	public tankPanel(int positionX,int poitionY,int _guns) 
	{
		x=positionX;
		y=poitionY;
		guns=_guns;

	}


	public void paint(Graphics g) 
	{	
		super.paint(g);

		DrawTank(g,x,y,true,false,false,3);
	}


	public  void DrawTank(Graphics g, int _startPosX, int _startPosY ,boolean firstGun , boolean secondGun , boolean thirdGun,int _guns)
	{
		int size=5;
		if (firstGun)
		{
			g.setColor(DopColor);
			g.drawRect( _startPosX + 5, _startPosY + 10, 85, 10);

			g.fillRect( _startPosX + 5, _startPosY + 10, 85, 10);
			g.drawRect( _startPosX + 5, _startPosY + 10, 85, 10);
		}
		if (secondGun)
		{
			g.setColor(DopColor);
			g.drawRect( _startPosX + 5, _startPosY + 40, 85, 6);

			g.fillRect( _startPosX + 5, _startPosY + 40, 85, 6);

			g.drawRect( _startPosX + 5, _startPosY + 40, 85, 6);

		}
		if (thirdGun)
		{ g.setColor(DopColor);

		g.drawRect( _startPosX - 35, _startPosY + 32, 80, 6);
		g.fillRect( _startPosX - 35, _startPosY + 32, 80, 6);
		g.drawRect( _startPosX - 35, _startPosY + 32, 80, 6);
		}
		
		for(int i=1;i<=_guns;i++) 
		{
		
		g.setColor(DopColor);
		
		g.drawRect( _startPosX + 5, _startPosY + size, 85, 5);
		
		g.fillRect( _startPosX + 5, _startPosY + size, 85, 5);
		
		
		size+=9;
		
		}
		
		g.setColor(MainColor);
		g.drawRect(_startPosX + 10, _startPosY - 5, 20, 10);
		g.fillRect( _startPosX + 10, _startPosY - 5, 20, 10);
		g.drawRect( _startPosX + 10, _startPosY - 5, 20, 10);
		g.fillOval( _startPosX, _startPosY, 52, 31);
		g.fillOval( _startPosX - 10, _startPosY + 30, 75, 40);
		g.fillOval( _startPosX, _startPosY, 52, 31);
		g.fillOval( _startPosX - 10, _startPosY + 30, 75, 40);
		g.fillOval( _startPosX, _startPosY, 52, 31);
		g.fillOval( _startPosX - 10, _startPosY + 30, 75, 40);
		int plase = 10;
		g.setColor(Color.BLACK);
		for (int i = 0; i < 4; i++)
		{
			g.drawOval( _startPosX - plase, _startPosY + 40, 19, 20);
			plase -= 19;
		}
		g.drawRect(_startPosX + 10, _startPosY + 10, 25, 10);
		g.drawRect( 0, 0, 826, 338);
	}




}

package lab_1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class tank extends WarCar  {
	static Random random= new Random();



	public Color DopColor ;

	public boolean firstGun ;

	public boolean secondGun ;

	public boolean thirdGun;
	
	private guns guns;
	
	Random rnd =new Random();
	
	private int typeGun = rnd.nextInt(3)+1;

	public tank(int maxSpeed,
			guns guns, 
			float weight, 
			Color mainColor, 
			Color dopColor,
			boolean frontSpoiler, 
			boolean sideSpoiler, 
			boolean backSpoiler)
	{
		super(
		maxSpeed,
		weight,
		mainColor
		);
		this.guns =guns;
		DopColor = dopColor;
		firstGun = frontSpoiler;
		secondGun = sideSpoiler;
		thirdGun = backSpoiler;
	}

	
	
	public  void DrawTransport(Graphics g)
	{
		
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
		
		
		switch (typeGun)
		{
		case 1:
		new gunsDraw(guns,DopColor).draw(g,_startPosX,_startPosY);
		break;
		case 2 : 
			new OvalGuns(guns, DopColor).draw(g, _startPosX, _startPosY);
			break;
		case 3:
			new LargeGuns(guns, DopColor).draw(g, _startPosX, _startPosY);
			break;
			
		}
		
		g.setColor(MainColor);
		g.drawRect(_startPosX + 10, _startPosY - 5, 20, 10);
		g.fillRect( _startPosX + 10, _startPosY - 5, 20, 10);
		g.drawRect( _startPosX + 10, _startPosY - 5, 20, 10);
		g.fillOval( _startPosX, _startPosY, 52, 31);
	
		
		
		g.fillOval( _startPosX, _startPosY, 52, 31);
	
		g.setColor(Color.black);//// рамки///
		g.drawRect(_startPosX + 10, _startPosY + 10, 25, 10);
		g.drawRect( 0, 0, 826, 338);
		super.DrawTransport(g);
	}

	

}


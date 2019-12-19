package lab_1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class tank {
	static Random random= new Random();

	private int _startPosX;

	private int _startPosY;

	private int _pictureWidth;

	private int _pictureHeight;

	private static int tankWidth = 100;

	private static int tankHeight = 60;

	public int MaxSpeed;

	public float Weight ;

	public Color MainColor ;

	public Color DopColor ;

	public boolean firstGun ;

	public boolean secondGun ;

	public boolean thirdGun;
	
	private guns guns;

	public tank(int maxSpeed,guns guns, float weight, Color mainColor, Color dopColor,
			boolean frontSpoiler, boolean sideSpoiler, boolean backSpoiler)
	{
		MaxSpeed = maxSpeed;
		this.guns=guns;
		Weight = weight;
		MainColor = mainColor;
		DopColor = dopColor;
		firstGun = frontSpoiler;
		secondGun = sideSpoiler;
		thirdGun = backSpoiler;
	}

	public void SetPosition(int x, int y, int width, int height)
	{
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}
		
	public void moveTank(Direction direction)
	{
		float step = MaxSpeed * 100 / Weight;
		
		switch (direction)
		{
		case Right:
			if (_startPosX + step < _pictureWidth - tankWidth)
			{
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0)
			{
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step > 0)
			{
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - tankHeight)
			{
				_startPosY += step;
			}
			break;
		}
	}
	
	public  void DrawTank(Graphics g)
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
		new gunsDraw(guns,DopColor).draw(g,_startPosX,_startPosY);
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


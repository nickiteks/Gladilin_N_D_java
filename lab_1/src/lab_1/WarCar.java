package lab_1;

import java.awt.Color;
import java.awt.Graphics;

public class WarCar extends Vehicle {
	
	 protected static int tankWidth = 100;
	 
	  protected static int tankHeight = 60;
	
	  public WarCar(int maxSpeed, float weight, Color mainColor)
      {
          MaxSpeed = maxSpeed;
          Weight = weight;
          MainColor = mainColor;
      }
	  

	public WarCar(String string) {
		
		String[] strs = string.split(";");
		if (strs.length == 3) {
			MaxSpeed = Integer.parseInt(strs[0]);
			Weight = Float.parseFloat(strs[1]);
			this.MainColor = new Color(Integer.parseInt(strs[2]));
		}
		
	}


	public void MoveTransport(Direction direction)
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
	  public void DrawTransport(Graphics g)
      {        
          	g.setColor(MainColor);
          g.fillRect(_startPosX + 60, _startPosY + 35, 50, 45);
          	g.setColor(Color.BLACK);
          g.fillRect(_startPosX + 80, _startPosY + 40, 30, 30);
          	g.setColor(MainColor);
          g.fillRect(_startPosX - 20, _startPosY + 30, 80, 50);
          	g.setColor(Color.BLACK);
          g.drawRect(_startPosX - 20, _startPosY + 30, 80, 50);
          g.drawRect(_startPosX - 15, _startPosY + 35, 60, 30);
          g.drawRect(_startPosX + 60, _startPosY + 35, 50, 45);

          g.fillOval(_startPosX - 18, _startPosY + 70, 40, 40);
          g.fillOval(_startPosX + 55, _startPosY + 70, 40, 40);
          
          g.setColor(Color.black);//// рамки///
  		 // g.drawRect( 0, 0, 826, 338);
  			
      }

	@Override
	public String ToString() {
		return  MaxSpeed + ";" + Weight + ";" + MainColor.getRGB() + ";";
	}
}

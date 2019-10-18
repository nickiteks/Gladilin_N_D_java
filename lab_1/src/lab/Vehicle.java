package lab;



public abstract class Vehicle implements ITransport {
	
	  protected float _startPosX;
      /// <summary>
      /// Правая кооридната отрисовки автомобиля
      /// </summary>
      protected float _startPosY;
	
      protected int _pictureWidth;
      //Высота окна отрисовки
      protected int _pictureHeight;
      
      public void SetPosition(int x, int y, int width, int height)
      {
          _startPosX = x;
          _startPosY = y;
          _pictureWidth = width;
          _pictureHeight = height;
      }
      
	
	
	

}

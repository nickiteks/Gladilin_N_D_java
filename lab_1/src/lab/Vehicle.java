package lab;



public abstract class Vehicle implements ITransport {
	
	  protected float _startPosX;
      /// <summary>
      /// ������ ���������� ��������� ����������
      /// </summary>
      protected float _startPosY;
	
      protected int _pictureWidth;
      //������ ���� ���������
      protected int _pictureHeight;
      
      public void SetPosition(int x, int y, int width, int height)
      {
          _startPosX = x;
          _startPosY = y;
          _pictureWidth = width;
          _pictureHeight = height;
      }
      
	
	
	

}

package lab;

import java.awt.Graphics;

public interface ITransport {
	

   

        /// <summary>
        /// ��������� ������� ����������
        /// </summary>
        /// <param name="x">���������� X</param>
        /// <param name="y">���������� Y</param>
        /// /// <param name="width">������ ��������</param>
        /// <param name="height">������ ��������</param>
        void SetPosition(int x, int y, int width, int height);
        /// <summary>
        /// ��������� ����������� ����������
        /// </summary>
        /// <param name="direction">�����������</param>
 
        /// <summary>
        /// ��������� ����������
        /// </summary>
        /// <param name="g"></param>
        void drawWarCar(Graphics g);
	
	
	

}

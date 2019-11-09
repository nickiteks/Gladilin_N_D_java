package lab_1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class tankPanel extends javax.swing.JPanel {
	
 Random rnd = new Random();



 tank tank ;
public tankPanel(tank tank) 
{
	
	this.tank = tank;
		
}
public void setTank(tank tank)
{
	
this.tank = tank;	
	
	
}
	
	public void paint(Graphics g) 
	{	
		super.paint(g);
		
		tank.DrawTank(g);
	}
}

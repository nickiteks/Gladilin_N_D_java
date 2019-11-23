package lab_1;

import java.awt.Graphics;

import javax.swing.JPanel;

public class WarBasePanel extends JPanel {
	
	
	
	MultyLevelParking base;
	
	int index;
	
	public WarBasePanel(MultyLevelParking parking,int index) {
		this.base = parking;
		this.index=index;
	}
	
	public void get_index(int index){
		this.index=index;		
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		base.parkingStages.get(index).Draw(g);;
		repaint();
	}
	
	

}

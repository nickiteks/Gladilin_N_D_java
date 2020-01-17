package lab_1;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ExitPanel extends JPanel {	
	ITransport transport;	
	public void addTransport(ITransport transport) 
	{
		this.transport=transport;		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(transport != null ) {
			transport.DrawTransport(g);			
		}		
		repaint();	
	}
}

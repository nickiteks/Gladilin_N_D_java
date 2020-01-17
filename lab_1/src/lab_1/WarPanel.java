package lab_1;

import java.awt.Color;
import java.awt.Graphics;

public class WarPanel extends javax.swing.JPanel {
	
ITransport transport;
 
public WarPanel(ITransport transport) 
{	
	this.transport=transport;		
}
public void setTransport(ITransport transport)
{	
	this.transport=transport;		
}
	
	public void paint(Graphics g) 
	{	
		super.paint(g);
		transport.DrawTransport(g);
		repaint();
	}
}


package lab_1;

import java.awt.Graphics;

import javax.swing.JPanel;

public class WarBasePanel extends JPanel {
	
	
	
	WarBase<ITransport, IGuns> base;
	

	
	public WarBasePanel(WarBase<ITransport, IGuns> base) {
		this.base = base;
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		base.Draw(g);
		repaint();
	}
	
	

}

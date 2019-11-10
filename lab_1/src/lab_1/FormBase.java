package lab_1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FormBase {

	private JFrame frame;
	private WarBasePanel pictureBoxBig;
	Random rnd = new Random();
	private JTextField textField;
	ITransport transport=null;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBase window = new FormBase();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormBase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 988, 776);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		WarBase<ITransport, IGuns> base= new WarBase<ITransport ,IGuns>(20, 663, 440);
		
		pictureBoxBig = new WarBasePanel(base);
		pictureBoxBig.setBounds(22, 21, 719, 705);
		frame.getContentPane().add(pictureBoxBig);
		
		JButton button = new JButton("\u043C\u0430\u0448\u0438\u043D\u0430");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			   Color mainColor = JColorChooser.showDialog(pictureBoxBig, "chose", Color.BLACK);
				transport = new WarCar(rnd.nextInt(20)+100, rnd.nextInt(1000)+1000, mainColor);		
				 base.clone(mainColor, null, 0);
				base.add(transport);
				
				
				
							
			}
		});
		button.setBounds(829, 55, 126, 40);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u0442\u0430\u043D\u043A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color mainColor = JColorChooser.showDialog(pictureBoxBig, "chose", Color.BLACK);
				Color DopColor = JColorChooser.showDialog(pictureBoxBig, "chose", Color.BLACK);
				
				 base.clone(mainColor, DopColor, 1);
				 
				 
				transport = new tank(rnd.nextInt(20)+100,
						guns.superGun, 
						rnd.nextInt(1000)+1000, 
						mainColor,
						DopColor,
				        false, 
				        false, 
				        false);
				
				
				
	guns _guns = guns.superGun;
								
	IGuns gunsForm = new gunsDraw(_guns, DopColor); ;
				
				switch (rnd.nextInt() % 3)
				{
				case 1:
				gunsForm = new gunsDraw(_guns, DopColor);
				break;
				case 2 : 
				gunsForm = new OvalGuns(_guns, DopColor);
					break;
				case 3:
				gunsForm = new LargeGuns(_guns, DopColor);
					break;					
				}
				
				
				
				
							
				base.add(transport,gunsForm);           
				
				
			}
		});
		button_1.setBounds(829, 106, 126, 40);
		frame.getContentPane().add(button_1);
		
		JPanel panel_Exit = new ExitPanel();
		panel_Exit.setBounds(751, 367, 205, 158);
		frame.getContentPane().add(panel_Exit);
		
		
		JButton button_TakeCar = new JButton("\u0437\u0430\u0431\u0440\u0430\u0442\u044C");
		button_TakeCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
								
				transport = base.sub(Integer.valueOf(textField.getText()));
				
				transport.SetPosition(40, 10, ExitPanel.WIDTH, ExitPanel.HEIGHT);

				 ((ExitPanel) panel_Exit).addTransport(transport);
							
				
			}
		});
		button_TakeCar.setBounds(847, 327, 89, 23);
		frame.getContentPane().add(button_TakeCar);
		
		textField = new JTextField();
		textField.setBounds(847, 296, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton Button_multy = new JButton("\u0443\u043C\u043D\u043E\u0436\u0435\u043D\u0438\u0435");
		Button_multy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			
				
	
		base.mylty(2);
		pictureBoxBig.repaint();
		
		
		
		
		
				
			}
		});
		Button_multy.setBounds(829, 157, 126, 40);
		frame.getContentPane().add(Button_multy);
		
		JButton Button_Del = new JButton("\u0434\u0435\u043B\u0435\u043D\u0438\u0435");
		Button_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				base.del(2);
				pictureBoxBig.repaint();
			}
		});
		Button_Del.setBounds(829, 205, 126, 40);
		frame.getContentPane().add(Button_Del);
		
		
	}
}

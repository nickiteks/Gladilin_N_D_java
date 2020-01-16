package lab_1;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormBase {

	private JFrame frame;
	MultyLevelParking parking ; 
	private WarBasePanel pictureBoxBig;
	Random rnd = new Random();
	private JTextField textField;
	ITransport transport=null;
	private int index;
	ArrayList deleted_machine = new ArrayList();
	private static int countLevel = 5;	
	private  String[] data = {"Уровень 1" ,"Уровень 2" ,"Уровень 3" ,"Уровень 4" ,"Уровень 5" };
	JList list_box_levels =  new JList(data);
	
	class Delegate extends WarDeligate {
		public void induce(ITransport transport) {
			parking.parkingStages.get(index).add(transport);
			pictureBoxBig.repaint();			
		}
	}

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
		parking =  new MultyLevelParking(countLevel,pictureBoxBig.WIDTH, pictureBoxBig.HEIGHT);	
		WarBase<ITransport, IGuns> base= new WarBase<ITransport ,IGuns>(20, 663, 440);		
		pictureBoxBig = new WarBasePanel(parking,index);
		pictureBoxBig.setBounds(22, 21, 719, 705);
		frame.getContentPane().add(pictureBoxBig);		
		JButton button_Car = new JButton("\u043C\u0430\u0448\u0438\u043D\u0430");
		button_Car.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
			   Color mainColor = JColorChooser.showDialog(pictureBoxBig, "chose", Color.BLACK);
				transport = new WarCar(rnd.nextInt(20)+100, rnd.nextInt(1000)+1000, mainColor);		
				base.clone(mainColor, null, 0);
			parking.parkingStages.get(index).add(transport) ;			
			}
		});
		button_Car.setBounds(829, 55, 126, 40);
		frame.getContentPane().add(button_Car);
		
		JButton button_Tank = new JButton("\u0442\u0430\u043D\u043A");
		button_Tank.addActionListener(new ActionListener() {
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
				        false,
				        rnd.nextInt(3)+1);				
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
				parking.parkingStages.get(index).add(transport, gunsForm);	          			
			}
		});
		button_Tank.setBounds(829, 106, 126, 40);
		frame.getContentPane().add(button_Tank);
		
		JPanel panel_Exit = new ExitPanel();
		panel_Exit.setBounds(751, 367, 205, 158);
		frame.getContentPane().add(panel_Exit);		
		JButton button_TakeCar = new JButton("\u0437\u0430\u0431\u0440\u0430\u0442\u044C");
		button_TakeCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				deleted_machine.add(transport);					
				transport = parking.parkingStages.get(index).sub(Integer.valueOf(textField.getText()));				
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
		list_box_levels.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				 if (list_box_levels.getSelectedIndex() != -1) {
					index = list_box_levels.getSelectedIndex();	
					pictureBoxBig.get_index(index);
					pictureBoxBig.repaint();
				 }				
			}
		});		
		list_box_levels.setBounds(773, 559, 189, 126);
		frame.getContentPane().add(list_box_levels);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormWarConfig config = new FormWarConfig(new Delegate());
			}
		});
		btnAdd.setBounds(749, 256, 89, 23);
		frame.getContentPane().add(btnAdd);
	}
}

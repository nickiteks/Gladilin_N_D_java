package lab_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class lab {
	

	JFrame frame;

	final Random rnd = new Random();
	
	ITransport transport;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					lab window = new lab();
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
	public lab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		transport = new tank(rnd.nextInt(20)+100,guns.powerGun, rnd.nextInt(1000)+1000, Color.green,
		        Color.yellow, false, false, false,1);
		
		WarPanel panel = new WarPanel(transport);
		panel.setBounds(30, 45, 827, 339);
		frame.getContentPane().add(panel);


		JButton buttomUp = new JButton("");
		buttomUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				transport.MoveTransport(Direction.Up);
				panel.setTransport(transport);
				panel.repaint();
			}
		});
		buttomUp.setBounds(721, 406, 20, 20);
		frame.getContentPane().add(buttomUp);

		JButton ButtonRight = new JButton("");
		ButtonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport.MoveTransport(Direction.Right);
				panel.setTransport(transport);
				panel.repaint();
			}
			
		});
		ButtonRight.setBounds(743, 427, 20, 20);
		frame.getContentPane().add(ButtonRight);

		JButton buttonLeft = new JButton("");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport.MoveTransport(Direction.Left);
				panel.setTransport(transport);
				panel.repaint();
				
				
			}
		});
		buttonLeft.setBounds(698, 427, 20, 20);
		frame.getContentPane().add(buttonLeft);

		JButton buttonDown = new JButton("");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport.MoveTransport(Direction.Down);
				panel.setTransport(transport);
				panel.repaint();

			}
		});
		buttonDown.setBounds(721, 427, 20, 20);
		frame.getContentPane().add(buttonDown);
		

		JButton btnDop = new JButton("Dop");
		btnDop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				transport = new tank(rnd.nextInt(20)+100,guns.ultra_superGun, rnd.nextInt(1000)+1000, Color.green,
				        Color.yellow, false, false, false,1);
												
				transport.SetPosition(rnd.nextInt(50), rnd.nextInt(50), 827, 339);
				panel.setTransport(transport);
				panel.repaint();				
			}
		});
		btnDop.setBounds(420, 11, 89, 23);
		frame.getContentPane().add(btnDop);
		
		JButton button_main = new JButton("\u043E\u0441\u043D\u043E\u0432\u0430");
		button_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				transport = new WarCar(rnd.nextInt(20)+100, rnd.nextInt(1000)+1000, Color.green);
				transport.SetPosition(rnd.nextInt(50), rnd.nextInt(50), 827, 339);
				panel.setTransport(transport);
				panel.repaint();
				
				
			}
		});
		button_main.setBounds(522, 11, 89, 23);
		frame.getContentPane().add(button_main);
		
		
		

	}
}

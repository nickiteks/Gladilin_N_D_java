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
	private JFrame frame;
	final Random rnd = new Random();
	 tank tank=new tank(rnd.nextInt(20)+100,guns.powerGun, rnd.nextInt(1000)+1000, Color.green,
		        Color.yellow, false, false, false);
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
		tankPanel panel = new tankPanel(tank);
		panel.setBounds(30, 45, 827, 339);
		frame.getContentPane().add(panel);
		JButton buttomUp = new JButton("");
		buttomUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				tank.moveTank(Direction.Up);
				panel.setTank(tank);
				panel.repaint();
			}
		});
		buttomUp.setBounds(721, 406, 20, 20);
		frame.getContentPane().add(buttomUp);
		JButton ButtonRight = new JButton("");
		ButtonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tank.moveTank(Direction.Right);
				panel.setTank(tank);
				panel.repaint();
			}
			
		});
		ButtonRight.setBounds(743, 427, 20, 20);
		frame.getContentPane().add(ButtonRight);

		JButton buttonLeft = new JButton("");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tank.moveTank(Direction.Left);
				panel.setTank(tank);
				panel.repaint();			
			}
		});
		buttonLeft.setBounds(698, 427, 20, 20);
		frame.getContentPane().add(buttonLeft);

		JButton buttonDown = new JButton("");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tank.moveTank(Direction.Down);
				panel.setTank(tank);
				panel.repaint();
			}
		});
		buttonDown.setBounds(721, 427, 20, 20);
		frame.getContentPane().add(buttonDown);



		JButton button = new JButton("\u0441\u043E\u0437\u0434\u0430\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				tank.SetPosition(rnd.nextInt(50), rnd.nextInt(50), 827, 339);
				panel.setTank(tank);
				panel.repaint();				
			}
		});
		button.setBounds(420, 11, 89, 23);
		frame.getContentPane().add(button);
	}
}

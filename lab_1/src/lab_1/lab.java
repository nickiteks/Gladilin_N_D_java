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

	final Random random = new Random();

	private int _startPosX=random.nextInt(50);

	private int _startPosY=random.nextInt(50);
	
	private int guns=random.nextInt(4)+1;

	private int _pictureWidth=827;

	private int _pictureHeight=339;

	private static int tankWidth = 80;

	private static int tankHeight = 80;

	public int MaxSpeed=random.nextInt(20)+100;

	public float Weight=random.nextInt(1000)+1000;




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

		JPanel panel = new tankPanel(_startPosX,_startPosY,guns);
		panel.setBounds(30, 45, 827, 339);
		frame.getContentPane().add(panel);

		float step = MaxSpeed * 100 / Weight;

		JButton buttomUp = new JButton("");
		buttomUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tankPanel.y - step > 0)
				{
					tankPanel.y -= step;
					panel.repaint();
				}

			}
		});
		buttomUp.setBounds(721, 406, 20, 20);
		frame.getContentPane().add(buttomUp);

		JButton ButtonRight = new JButton("");
		ButtonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tankPanel.x + step < _pictureWidth - tankWidth)
				{
					tankPanel.x += step;
					panel.repaint();
				}
			}
		});
		ButtonRight.setBounds(743, 427, 20, 20);
		frame.getContentPane().add(ButtonRight);

		JButton buttonLeft = new JButton("");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tankPanel.x - step > 30)
				{

					tankPanel.x -= step;
					panel.repaint();
				}
			}
		});
		buttonLeft.setBounds(698, 427, 20, 20);
		frame.getContentPane().add(buttonLeft);

		JButton buttonDown = new JButton("");
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tankPanel.y + step < _pictureHeight - tankHeight)
				{
					tankPanel.y += step;
					panel.repaint();
				}
			}
		});
		buttonDown.setBounds(721, 427, 20, 20);
		frame.getContentPane().add(buttonDown);



		JButton button = new JButton("\u0441\u043E\u0437\u0434\u0430\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tankPanel.x=random.nextInt(50);
				tankPanel.y=random.nextInt(50);
				panel.repaint();				
			}
		});
		button.setBounds(420, 11, 89, 23);
		frame.getContentPane().add(button);


	}
}

package lab_1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FormWarConfig {

	private JFrame frame;
	private JFrame frame_1;
	Color WorkColor = Color.WHITE;
	Color WorkDopColor = Color.WHITE;
	Random rnd =new Random();
	private ITransport transport = new tank(rnd.nextInt(20)+100,
			guns.superGun, 
			rnd.nextInt(1000)+1000, 
			Color.white,
			Color.white,
	        false, 
	        false, 
	        false,1);
	int gun = 1;
	int WorkGun = 1;
	private Color color = null;
	WarDeligate AddTransport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormWarConfig window = new FormWarConfig(null);
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormWarConfig(WarDeligate delegate) {
		AddTransport = delegate;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame_1 = new JFrame();
		frame_1.setBounds(100, 100, 645, 352);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);

		frame_1.setVisible(true);

		
		JPanel panelWhite = new JPanel();
		panelWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.white;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelWhite.setBackground(Color.WHITE);
		panelWhite.setBounds(429, 42, 40, 40);
		frame_1.getContentPane().add(panelWhite);

		JPanel panelBlack = new JPanel();
		panelBlack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.black;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelBlack.setBackground(Color.BLACK);
		panelBlack.setBounds(379, 42, 40, 40);
		frame_1.getContentPane().add(panelBlack);

		JPanel panelRed = new JPanel();
		panelRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.red;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelRed.setBackground(Color.RED);
		panelRed.setBounds(379, 141, 40, 40);
		frame_1.getContentPane().add(panelRed);

		JPanel panelGray = new JPanel();
		panelGray.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.gray;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelGray.setBackground(Color.GRAY);
		panelGray.setBounds(379, 190, 40, 40);
		frame_1.getContentPane().add(panelGray);

		JPanel panelBlue = new JPanel();
		panelBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.blue;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelBlue.setBackground(Color.BLUE);
		panelBlue.setBounds(429, 90, 40, 40);
		frame_1.getContentPane().add(panelBlue);

		JPanel panelYellow = new JPanel();
		panelYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.yellow;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelYellow.setBackground(Color.YELLOW);
		panelYellow.setBounds(429, 141, 40, 40);
		frame_1.getContentPane().add(panelYellow);

		JPanel panelOrange = new JPanel();
		panelOrange.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.orange;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelOrange.setBackground(Color.ORANGE);
		panelOrange.setBounds(429, 190, 40, 40);
		frame_1.getContentPane().add(panelOrange);

		JPanel panelGreen = new JPanel();
		panelGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				color = Color.green;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				color = null;
			}
		});
		panelGreen.setBackground(Color.GREEN);
		panelGreen.setBounds(379, 90, 40, 40);
		frame_1.getContentPane().add(panelGreen);
		
		JButton btnOk = new JButton("ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddTransport.induce(transport);
				frame_1.dispose();
			}
		});
		btnOk.setBounds(10, 279, 89, 23);
		frame_1.getContentPane().add(btnOk);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame_1.dispose();
				}
		});
		btnCancel.setBounds(109, 279, 89, 23);
		frame_1.getContentPane().add(btnCancel);
		
		WarPanel panel = new WarPanel(transport);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (transport != null) {
					transport.SetPosition(20, 20, 500, 500);
					panel.setTransport(transport);
					panel.repaint();
				}
			}			
		});
		
		panel.setBounds(10, 11, 327, 201);
		frame_1.getContentPane().add(panel);
		
		JLabel lblMainColor = new JLabel("main color");
		lblMainColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (color != null) {
					WorkColor =color;
					color = null;
					panel.repaint();
				}
			}
		});
		lblMainColor.setBounds(497, 42, 100, 28);
		frame_1.getContentPane().add(lblMainColor);
		
		JLabel lblDopColor = new JLabel("dop color");
		lblDopColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (color != null) {
					WorkDopColor =color;
					color = null;
					panel.repaint();
				}
			}
		});
		lblDopColor.setBounds(497, 81, 100, 28);
		frame_1.getContentPane().add(lblDopColor);
		
		JLabel lblTank = new JLabel("tank");
		lblTank.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				transport = new tank(rnd.nextInt(20)+100,
						guns.superGun, 
						rnd.nextInt(1000)+1000, 
						WorkColor,
						WorkDopColor,
				        false, 
				        false, 
				        false,WorkGun);
			}	
		});
		lblTank.setBounds(51, 243, 48, 14);
		frame_1.getContentPane().add(lblTank);
		
		JLabel lblCar = new JLabel("car");
		lblCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				transport = new WarCar(rnd.nextInt(20)+100, rnd.nextInt(1000)+1000, WorkColor);	
			}
		});
		lblCar.setBounds(121, 243, 48, 14);
		frame_1.getContentPane().add(lblCar);
		
		JLabel lblTypeGun = new JLabel("type gun1");
		lblTypeGun.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				gun=1;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				gun=0;
			}
		});
		lblTypeGun.setBounds(274, 255, 63, 14);
		frame_1.getContentPane().add(lblTypeGun);
		
		JLabel lblTypeGun_1 = new JLabel("type gun 2");
		lblTypeGun_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				gun=2;
			}
			public void mouseReleased(MouseEvent e) {
				gun=0;
			}
		});
		lblTypeGun_1.setBounds(355, 255, 64, 14);
		frame_1.getContentPane().add(lblTypeGun_1);
		
		JLabel lblTypegun = new JLabel("type gun 3");
		lblTypegun.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				gun=3;
			}
			public void mouseReleased(MouseEvent e) {
				gun=0;
			}
		});
		lblTypegun.setBounds(436, 255, 75, 14);
		frame_1.getContentPane().add(lblTypegun);
		
		JLabel lblGunType = new JLabel("gun type");
		lblGunType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (gun != 0) {
				WorkGun = gun;
				gun = 0;
				}
			}
		});
		lblGunType.setBounds(492, 120, 69, 23);
		frame_1.getContentPane().add(lblGunType);
			
	}
}

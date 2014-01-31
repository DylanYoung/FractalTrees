package LabJan28;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Lab1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab1 window = new Lab1();
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
	public Lab1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setBackground(Color.BLUE);
	
		
		LabComponent lc = new LabComponent();
		frame.addMouseMotionListener(lc);
		frame.addMouseListener(lc);
		lc.setBounds(100, 100, 450, 300);
		lc.setColour(Color.WHITE);
		
		frame.getContentPane().add(lc, BorderLayout.CENTER);
		
		
	}

}

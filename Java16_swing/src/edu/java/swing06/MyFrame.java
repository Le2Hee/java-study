package edu.java.swing06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame {

	private JPanel contentPane;
	private Component parent;

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MyFrame frame = new MyFrame(parent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private MyFrame(Component parent) {
		this.parent = parent;
		initialize();
	}
	
	public void initialize() {
		setTitle("My Frame");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX();
			y = parent.getY();
			setBounds(x, y, 450, 300);
		} else {
			setBounds(x, y, 450, 300);
		}
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}

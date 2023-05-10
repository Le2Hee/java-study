package edu.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginMain {

	static JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnLogin;
	private JButton btnCreated;
	static LoginMain window;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoginMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void LoginMainEnd() {
		window.frame.setVisible(false);
	}

	/**
	 * Create the application.
	 */
	public LoginMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 400, 816, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 290);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnCreated = new JButton("");
		btnCreated.setSelectedIcon(new ImageIcon("image\\Loginbtn2.png"));
		btnCreated.setIcon(new ImageIcon("image\\Loginbtn2.png"));
		btnCreated.setForeground(Color.YELLOW);
		btnCreated.setFont(new Font("D2Coding", Font.BOLD, 39));
		btnCreated.setBounds(650, 234, 138, 46);
		btnCreated.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterFrame.showRegiserFrame(frame);
			}
		});
		
		btnExit = new JButton("나 가 기");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("D2Coding", Font.BOLD, 24));
		btnExit.setBounds(650, 10, 138, 46);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		panel.add(btnExit);
		panel.add(btnCreated);
		
		btnLogin = new JButton();
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame.showLoginFrame(frame);
			}
		});
		
		btnLogin.setSelectedIcon(new ImageIcon("image\\Loginbtn.png"));
		btnLogin.setIcon(new ImageIcon("image\\Loginbtn.png"));
		btnLogin.setForeground(Color.YELLOW);
		btnLogin.setFont(new Font("D2Coding", Font.BOLD, 39));
		btnLogin.setBounds(12, 234, 138, 46);
		panel.add(btnLogin);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\photo.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 290);
		panel.add(lblNewLabel);
	}
}

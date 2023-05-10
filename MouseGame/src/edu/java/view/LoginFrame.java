package edu.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import edu.java.controller.MouseDaoImpl;
import edu.java.model.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textID;
	private JTextField textPWD;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	private MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private static LoginFrame frame;
	private Component parent;
	private JButton btnselect_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void showLoginFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginFrame(parent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String PasswordText(JPasswordField passwordField) {
		char[] pwChar = passwordField.getPassword();
		String pw = "";
		pw = String.valueOf(pwChar);
		
		return pw;
	}
	
	public LoginFrame(Component parent) {
		this.parent = parent;
		initialize();
		
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("LOGIN");
		
		int x = 100;
		int y = 100;
		
		if (parent != null) {
			x = parent.getX() + 148;
			y = parent.getY();
		}
		
		setBounds(x, y, 580, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user = dao.UserLogin(textID.getText(), PasswordText(passwordField));
				if (user != null) {
					JOptionPane.showMessageDialog(frame,
							"로그인 되었습니다.",
							"LOGIN",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					LoginMain.LoginMainEnd();
					MouseGameMain.MouseGameMain(user);
				} else {
					JOptionPane.showMessageDialog(frame,
							"없는 아이디 및 비밀번호 입니다.",
							"오 류",
							JOptionPane.ERROR_MESSAGE);
					textID.setText("");
					passwordField.setText("");
				}
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon("image\\btnr1.png"));
		btnNewButton.setIcon(new ImageIcon("image\\btnr1.png"));
		btnNewButton.setBounds(439, 385, 113, 42);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 562, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnselect_1 = new JButton("");
		btnselect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnselect_1.setSelectedIcon(new ImageIcon("image\\exit130.jpg"));
		btnselect_1.setIcon(new ImageIcon("image\\exit130.jpg"));
		btnselect_1.setBounds(420, 10, 130, 33);
		panel.add(btnselect_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("D2Coding", Font.PLAIN, 26));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.BLACK);
		passwordField.setColumns(10);
		passwordField.setBounds(92, 312, 392, 60);
		panel.add(passwordField);
		
		textID = new JTextField();
		textID.setBackground(Color.BLACK);
		textID.setForeground(Color.WHITE);
		textID.setFont(new Font("D2Coding", Font.PLAIN, 26));
		textID.setBounds(92, 229, 392, 60);
		panel.add(textID);
		textID.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\LoginFrame.png"));
		lblNewLabel.setBounds(0, 0, 562, 382);
		panel.add(lblNewLabel);
	}
}

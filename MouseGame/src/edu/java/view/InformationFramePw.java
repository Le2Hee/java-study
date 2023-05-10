package edu.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.java.controller.MouseDaoImpl;
import edu.java.model.User;
import javax.swing.JPasswordField;
import java.awt.Font;

public class InformationFramePw extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblPwd;
	private JTextField textField;
	private JButton btnNewButton;
	
	private Component parent;
	private User user;
	
	MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private static InformationFramePw frame;
	private JButton btnselect_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void showInformationFramePw(Component parent, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InformationFramePw(parent, user);
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
	
	public InformationFramePw(Component parent, User user) {
		this.user = user;
		this.parent = parent;
		initialize();
	}
	
	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("비밀번호 확인");
		
		int x = 100;
		int y = 100;
		
		if(parent != null) {
			x = parent.getX() + 458;
			y = parent.getY() + 150;
		}
		
		setBounds(x, y, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("D2Coding", Font.BOLD, 24));
		passwordField.setBounds(95, 112, 288, 45);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setForeground(Color.WHITE);
		passwordField.setColumns(10);
		panel.add(passwordField);
		
		lblPwd = new JLabel("");
		lblPwd.setIcon(new ImageIcon("image\\registerpwd.png"));
		lblPwd.setBounds(53, 101, 330, 66);
		panel.add(lblPwd);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User users = dao.MyInformation(PasswordText(passwordField), user.getUserPW());
				if (users != null) {
					JOptionPane.showMessageDialog(frame,
							"비밀번호를 확인되었습니다.",
							"내 정보",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					InformationFrame.showInformationFrame(frame, user);
					
				} else {
					JOptionPane.showMessageDialog(frame,
							"비밀번호를 확인해주세요.",
							"오 류",
							JOptionPane.ERROR_MESSAGE);
					textField.setText("");
				}
			}
		});
		
		btnNewButton.setSelectedIcon(new ImageIcon("image\\btnr.png"));
		btnNewButton.setIcon(new ImageIcon("image\\btnr.png"));
		btnNewButton.setBounds(309, 209, 113, 42);
		panel.add(btnNewButton);
		
		btnselect_1 = new JButton("");
		btnselect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnselect_1.setSelectedIcon(new ImageIcon("image\\exit130.jpg"));
		btnselect_1.setIcon(new ImageIcon("image\\exit130.jpg"));
		btnselect_1.setBounds(292, 10, 130, 33);
		panel.add(btnselect_1);
	}

}

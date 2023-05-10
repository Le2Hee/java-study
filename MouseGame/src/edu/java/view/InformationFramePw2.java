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

public class InformationFramePw2 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblPwd;
	private JTextField textField;
	private JButton btnNewButton;
	
	private Component parent;
	private User user;
	
	MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private static InformationFramePw2 frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void showInformationFramePw2(Component parent, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InformationFramePw2(parent, user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InformationFramePw2(Component parent, User user) {
		this.user = user;
		this.parent = parent;
		initialize();
	}
	
	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("계정 인증");
		
		int x = 100;
		int y = 100;
		
		if(parent != null) {
			x = parent.getX() + 113;
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
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(95, 51, 288, 45);
		panel.add(textField_1);
		
		textField = new JTextField();
		textField.setBackground(Color.DARK_GRAY);
		textField.setForeground(Color.WHITE);
		textField.setBounds(95, 112, 288, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		lblPwd = new JLabel("");
		lblPwd.setIcon(new ImageIcon("image\\register.png"));
		lblPwd.setBounds(53, 40, 330, 127);
		panel.add(lblPwd);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = dao.Delete(textField_1.getText(),textField.getText(), user);
				if (result == 0) {
					JOptionPane.showMessageDialog(frame,
							"비밀번호를 확인해 주세요.",
							"오 류",
							JOptionPane.ERROR_MESSAGE);
					lblPwd.setText("");
				} else {
					JOptionPane.showMessageDialog(frame,
							"계정이 삭제되었습니다.",
							"확 인",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					InformationFrame.frame.setVisible(false);
					MouseGameMain.window.frame.setVisible(false);
					LoginMain.main(null);
				}
			}
		});
		
		btnNewButton.setSelectedIcon(new ImageIcon("image\\btnr.png"));
		btnNewButton.setIcon(new ImageIcon("image\\btnr.png"));
		btnNewButton.setBounds(309, 209, 113, 42);
		panel.add(btnNewButton);
	}
}

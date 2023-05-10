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

public class UserSelectIdFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNIC;
	private JTextField textSelectNIC;
	private JButton btnselect;
	
	private Component parent;
	
	MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private static UserSelectIdFrame frame;
	private JButton btnselect_1;

	/**
	 * Launch the application.
	 */
	public static void showUserSelectIdFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserSelectIdFrame(parent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UserSelectIdFrame(Component parent) {
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
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textSelectNIC = new JTextField();
		textSelectNIC.setBackground(Color.DARK_GRAY);
		textSelectNIC.setForeground(Color.WHITE);
		textSelectNIC.setBounds(93, 106, 288, 57);
		panel.add(textSelectNIC);
		textSelectNIC.setColumns(10);
		
		lblNIC = new JLabel("");
		lblNIC.setIcon(new ImageIcon("image\\registe3.jpg"));
		lblNIC.setBounds(34, 106, 345, 57);
		panel.add(lblNIC);
		
		btnselect = new JButton("");
		btnselect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User selectuser = dao.SelectUserRead(textSelectNIC.getText());
				if (selectuser == null) {
					JOptionPane.showMessageDialog(frame,
							"닉네임을 다시 확인해 주세요.",
							"오 류",
							JOptionPane.ERROR_MESSAGE);
					textSelectNIC.setText("");
				} else {
					JOptionPane.showMessageDialog(frame,
							"닉네임이 확인되었습니다.",
							"확 인",
							JOptionPane.INFORMATION_MESSAGE);
					SelectUserInformationFrame.showSelectUserInformationFrame(frame,
							textSelectNIC.getText(),
							selectuser);
					frame.setVisible(false);
				}
			}
		});
		btnselect.setSelectedIcon(new ImageIcon("image\\btnr.png"));
		btnselect.setIcon(new ImageIcon("image\\btnr.png"));
		btnselect.setBounds(309, 209, 113, 42);
		panel.add(btnselect);
		
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

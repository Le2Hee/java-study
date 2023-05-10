package edu.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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

public class InformationUpdateFrameNIC extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblPwd;
	private JTextField textField;
	private JButton btnNewButton;
	
	private Component parent;
	private User user;
	
	MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private static InformationUpdateFrameNIC frame;

	/**
	 * Launch the application.
	 */
	public static void showInformationUpdateFramePw2(Component parent, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InformationUpdateFrameNIC(parent, user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InformationUpdateFrameNIC(Component parent, User user) {
		this.user = user;
		this.parent = parent;
		initialize();
	}
	
	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("비밀번호 입력");
		
		int x = 100;
		int y = 100;
		
		if(parent != null) {
			x = parent.getX() + 58;
			y = parent.getY();
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
		
		textField = new JTextField();
		textField.setBackground(Color.DARK_GRAY);
		textField.setForeground(Color.WHITE);
		textField.setBounds(97, 105, 274, 58);
		panel.add(textField);
		textField.setColumns(10);
		
		lblPwd = new JLabel("");
		lblPwd.setIcon(new ImageIcon("image\\registe3.jpg"));
		lblPwd.setBounds(41, 105, 330, 58);
		panel.add(lblPwd);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = dao.UpdateNIC(textField.getText(), user);
				if (result == 0) {
					JOptionPane.showMessageDialog(frame,
							"알맞지 않은 닉네임 입니다.",
							"오 류",
							JOptionPane.ERROR_MESSAGE);
					textField.setText("");
				} else {
					JOptionPane.showMessageDialog(frame,
							"닉네임이 변경되었습니다.",
							"알 림",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
				}
			}
		});
		
		btnNewButton.setSelectedIcon(new ImageIcon("image\\btnr.png"));
		btnNewButton.setIcon(new ImageIcon("image\\btnr.png"));
		btnNewButton.setBounds(309, 209, 113, 42);
		panel.add(btnNewButton);
	}

}

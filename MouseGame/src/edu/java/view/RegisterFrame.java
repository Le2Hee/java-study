package edu.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import edu.java.controller.MouseDaoImpl;
import edu.java.model.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textID;
	private JTextField textPWD;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	
	private MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private JLabel lblNewLabel_1;
	private JTextField textNic;
	
	private static RegisterFrame frame;
	private Component parent;
	private JButton btnselect_1;
	
	/**
	 * Launch the application.
	 */
	public static void showRegiserFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RegisterFrame(parent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public RegisterFrame(Component parent) {
		this.parent = parent;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("회원 가입");
		
		int x = 100;
		int y = 100;
		
		if (parent != null) {
			x = parent.getX() + 148;
			y = parent.getY();
		}
		
		setBounds(x, y, 580, 561);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dao.CreatedUser(new User(textID.getText(), textPWD.getText(), textNic.getText()));
				JOptionPane.showMessageDialog(
						frame,
						"가입완료했습니다.",
						"가 입",
						JOptionPane.INFORMATION_MESSAGE);
				
				frame.setVisible(false);
			}
		});
		
		textNic = new JTextField();
		textNic.setForeground(Color.WHITE);
		textNic.setFont(new Font("D2Coding", Font.PLAIN, 26));
		textNic.setColumns(10);
		textNic.setBackground(Color.BLACK);
		textNic.setBounds(92, 392, 392, 60);
		contentPane.add(textNic);
		btnNewButton.setSelectedIcon(new ImageIcon("image\\btnr1.png"));
		btnNewButton.setIcon(new ImageIcon("image\\btnr1.png"));
		btnNewButton.setBounds(439, 470, 113, 42);
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
		
		textPWD = new JTextField();
		textPWD.setFont(new Font("D2Coding", Font.PLAIN, 26));
		textPWD.setForeground(Color.WHITE);
		textPWD.setBackground(Color.BLACK);
		textPWD.setColumns(10);
		textPWD.setBounds(92, 312, 392, 60);
		panel.add(textPWD);
		
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
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image\\registe3.jpg"));
		lblNewLabel_1.setBounds(31, 374, 460, 84);
		contentPane.add(lblNewLabel_1);
	}

}

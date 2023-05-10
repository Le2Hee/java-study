package edu.java.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.model.User;
import edu.java.model.Score;
import edu.java.controller.MouseDaoImpl;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseGameMain {
	private static final String IMAGE = 
			"image/2.png";

	JFrame frame;
	private JLabel lblBackGround;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnMyUser;
	
	private User user;
	private Score score;
	static MouseGameMain window;
	
	private MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private JButton btnRangking;
	private JButton btnLogout;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void MouseGameMain(User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MouseGameMain(user);
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
	public MouseGameMain(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(325, 190, 1366, 600);
		frame.setTitle("Mouse Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1350, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameFrame.showGameFrame(user);
				window.frame.setVisible(false);
			}
		});
		
		btnRangking = new JButton("랭킹 보기");
		btnRangking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RangKingFrame.showRangKingFrame(frame, user);
			}
		});
		
		JButton btnSelect = new JButton("유저 검색");
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserSelectIdFrame.showUserSelectIdFrame(frame);
			}
		});
		btnSelect.setOpaque(false);
		btnSelect.setForeground(Color.WHITE);
		btnSelect.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnSelect.setContentAreaFilled(false);
		btnSelect.setBorderPainted(false);
		btnSelect.setBounds(1132, 216, 190, 50);
		panel.add(btnSelect);
		btnRangking.setOpaque(false);
		btnRangking.setForeground(Color.WHITE);
		btnRangking.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnRangking.setContentAreaFilled(false);
		btnRangking.setBorderPainted(false);
		btnRangking.setBounds(1132, 130, 190, 50);
		panel.add(btnRangking);
		
		btnNewButton.setIcon(new ImageIcon("image\\button2.jpg"));
		btnNewButton.setSelectedIcon(new ImageIcon("image\\button2.jpg"));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setFont(new Font("D2Coding", Font.BOLD, 44));
		btnNewButton.setBounds(60, 471, 293, 59);
		panel.add(btnNewButton);
		
		btnMyUser = new JButton("내 정보");
		btnMyUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationFramePw.showInformationFramePw(frame, user);
			}
		});
		btnMyUser.setForeground(Color.WHITE);
		btnMyUser.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnMyUser.setBounds(1132, 36, 190, 50);
		btnMyUser.setBorderPainted(false);
		btnMyUser.setContentAreaFilled(false);
		btnMyUser.setOpaque(false);
		panel.add(btnMyUser);
		
		btnLogout = new JButton("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				JOptionPane.showMessageDialog(frame,
						"로그아웃 되었습니다.",
						"로그아웃",
						JOptionPane.INFORMATION_MESSAGE);
				LoginMain.window.frame.setVisible(true);
			}
		});
		btnLogout.setOpaque(false);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setBounds(919, 480, 190, 50);
		panel.add(btnLogout);
		
		btnExit = new JButton("종 료");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				System.exit(0);
			}
		});
		btnExit.setOpaque(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(1132, 480, 190, 50);
		panel.add(btnExit);
		
		lblBackGround = new JLabel(new ImageIcon(IMAGE));
		lblBackGround.setBounds(0, 0, 1350, 561);
		lblBackGround.setOpaque(true);
		panel.add(lblBackGround);
	}
}

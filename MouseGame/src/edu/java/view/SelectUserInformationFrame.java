package edu.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.java.model.Score;
import edu.java.model.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import edu.java.controller.MouseDaoImpl;
import javax.swing.JScrollPane;

// 유저 정보 수정(아이디 수정 안됨), 회원 탈퇴 기능 추가.

public class SelectUserInformationFrame extends JFrame {
	
	private static final String[] COLUM_NAMES = {"NICNAME", "TIME"};
	private DefaultTableModel model;
	private List<Score> ScoreList;
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblMyId;
	
	
	private MouseDaoImpl dao = MouseDaoImpl.getInstance();
	static SelectUserInformationFrame frame;
	private JLabel lblUserNICText;
	private JLabel lblUserIdText;
	private JLabel lblNic;
	private JTable table;
	private String nickname;
	private Component parent;
	private User user;
	private JButton btnExit;
	
	/**
	 * Launch the application.
	 */
	public static void showSelectUserInformationFrame(Component parent, String nickname, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SelectUserInformationFrame(parent, nickname, user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void loadScoreData() {
	      ScoreList = dao.SelectScoreRead(nickname);
	      for (Score c : ScoreList) {
	         Object[] row = {c.getNickname(), c.getTime()};
	         model.addRow(row);
	      }
	}
	
	public SelectUserInformationFrame(Component parent, String nickname, User user) {
		this.parent = parent;
		this.nickname = nickname;
		this.user = user;
		initialize();
		loadScoreData();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("유저 정보");
		
		int x = 100;
		int y = 100;
		
		if (parent != null) {
			x = parent.getX() - 114;
			y = parent.getY() - 50;
		}
		
		setBounds(x, y, 684, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 668, 530);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnExit = new JButton("나 가 기");
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setFont(new Font("D2Coding", Font.BOLD, 20));
		btnExit.setBounds(529, 482, 127, 38);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		panel.add(btnExit);
		
		lblMyId = new JLabel("ID");
		lblMyId.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblMyId.setForeground(Color.WHITE);
		lblMyId.setBounds(19, 25, 38, 50);
		panel.add(lblMyId);
		
		lblNic = new JLabel("NIC");
		lblNic.setForeground(Color.WHITE);
		lblNic.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblNic.setBounds(19, 98, 45, 50);
		panel.add(lblNic);
		
		lblUserIdText = new JLabel(user.getUserId());
		lblUserIdText.setForeground(Color.WHITE);
		lblUserIdText.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblUserIdText.setBounds(69, 25, 324, 50);
		panel.add(lblUserIdText);
		
		lblUserNICText = new JLabel(user.getNickname());
		lblUserNICText.setForeground(Color.WHITE);
		lblUserNICText.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblUserNICText.setBounds(76, 98, 324, 50);
		panel.add(lblUserNICText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 178, 644, 294);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("D2Coding", Font.BOLD, 24));
		table.setFillsViewportHeight(true);
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		model = new DefaultTableModel(null, COLUM_NAMES); 
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		
	}
}

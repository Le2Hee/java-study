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

public class InformationFrame extends JFrame {
	
	private static final String[] COLUM_NAMES = {"NICNAME", "TIME"};
	private DefaultTableModel model;
	private List<Score> ScoreList;
	
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblMyId;
	
	private User user;
	private Component parent;
	
	private MouseDaoImpl dao = MouseDaoImpl.getInstance();
	static InformationFrame frame;
	private JButton btnNICUpdate;
	private JButton btnPWDUpdate;
	private JButton btnDelete;
	private JLabel lblMyNICText;
	private JLabel lblMyPWDText;
	private JLabel lblMyIdText;
	private JLabel lblNic;
	private JLabel lblPwd;
	private JTable table;
	private JButton btnExit;
	
	/**
	 * Launch the application.
	 */
	public static void showInformationFrame(Component parent, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InformationFrame(parent, user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void loadScoreData() {
	      ScoreList = dao.MyScoreRead(user);
	      for (Score c : ScoreList) {
	         Object[] row = {c.getNickname(), c.getTime()};
	         model.addRow(row);
	      }
	}
	
	public InformationFrame(Component parent, User user) {
		this.parent = parent;
		this.user = user;
		initialize();
		loadScoreData();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("내 정보");
		
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
		
		lblMyId = new JLabel("ID");
		lblMyId.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblMyId.setForeground(Color.WHITE);
		lblMyId.setBounds(19, 10, 38, 50);
		panel.add(lblMyId);
		
		lblPwd = new JLabel("PWD");
		lblPwd.setForeground(Color.WHITE);
		lblPwd.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblPwd.setBounds(12, 77, 45, 50);
		panel.add(lblPwd);
		
		lblNic = new JLabel("NIC");
		lblNic.setForeground(Color.WHITE);
		lblNic.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblNic.setBounds(12, 156, 45, 50);
		panel.add(lblNic);
		
		lblMyIdText = new JLabel(user.getUserId());
		lblMyIdText.setForeground(Color.WHITE);
		lblMyIdText.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblMyIdText.setBounds(69, 10, 324, 50);
		panel.add(lblMyIdText);
		
		lblMyPWDText = new JLabel("******");
		lblMyPWDText.setForeground(Color.WHITE);
		lblMyPWDText.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblMyPWDText.setBounds(69, 77, 324, 50);
		panel.add(lblMyPWDText);
		
		lblMyNICText = new JLabel(user.getNickname());
		lblMyNICText.setForeground(Color.WHITE);
		lblMyNICText.setFont(new Font("D2Coding", Font.BOLD, 30));
		lblMyNICText.setBounds(69, 156, 324, 50);
		panel.add(lblMyNICText);
		
		btnDelete = new JButton("계정 삭제");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationFramePw2.showInformationFramePw2(frame, user);
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnDelete.setBounds(485, 10, 171, 50);
		btnDelete.setBorderPainted(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setOpaque(false);
		panel.add(btnDelete);
		
		btnPWDUpdate = new JButton("비밀번호 변경");
		btnPWDUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationUpdateFramePw.showInformationUpdateFramePw(parent, user);
			}
		});
		btnPWDUpdate.setForeground(Color.WHITE);
		btnPWDUpdate.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnPWDUpdate.setBounds(420, 77, 236, 50);
		btnPWDUpdate.setBorderPainted(false);
		btnPWDUpdate.setContentAreaFilled(false);
		btnPWDUpdate.setOpaque(false);
		panel.add(btnPWDUpdate);
		
		btnNICUpdate = new JButton("닉네임 변경");
		btnNICUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InformationUpdateFrameNIC.showInformationUpdateFramePw2(frame, user);
			}
		});
		btnNICUpdate.setForeground(Color.WHITE);
		btnNICUpdate.setFont(new Font("D2Coding", Font.BOLD, 30));
		btnNICUpdate.setBounds(447, 145, 209, 50);
		btnNICUpdate.setBorderPainted(false);
		btnNICUpdate.setContentAreaFilled(false);
		btnNICUpdate.setOpaque(false);
		panel.add(btnNICUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 216, 644, 251);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("D2Coding", Font.BOLD, 24));
		table.setFillsViewportHeight(true);
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		model = new DefaultTableModel(null, COLUM_NAMES); 
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
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
		
		
	}
}

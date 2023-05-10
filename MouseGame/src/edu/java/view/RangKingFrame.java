package edu.java.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.java.controller.MouseDaoImpl;
import edu.java.model.Score;
import edu.java.model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RangKingFrame extends JFrame {
	
	private static final String[] COLUM_NAMES = {"NICNAME", "TIME"};
	private DefaultTableModel model;
	private List<Score> ScoreList;

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTable table;
	private JScrollPane scrollPane;
	
	private MouseDaoImpl dao = MouseDaoImpl.getInstance();
	private Component parent;
	private User user;
	private JButton btnExit;
	private static RangKingFrame frame;
	
	/**
	 * Launch the application.
	 */
	
	public static void showRangKingFrame(Component parent, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RangKingFrame(parent, user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void loadScoreData() {
	      ScoreList = dao.ScoreRead();
	      for (Score c : ScoreList) {
	         Object[] row = {c.getNickname(), c.getTime()};
	         model.addRow(row);
	      }
	}
	
	public RangKingFrame(Component parent, User user) {
		this.parent = parent;
		this.user = user;
		initialize();
		loadScoreData();
	}
	

	/**
	 * Create the frame.
	 */
	private void initialize() {
		setTitle("랭 킹");
		
		int x = 100;
		int y = 100;
		if (parent != null) {
			x = parent.getX() + 475;
			y = parent.getY() + 82;
		}
		
		setBounds(x, y, 416, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 400, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnExit = new JButton("X");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setFont(new Font("D2Coding", Font.BOLD, 24));
		btnExit.setForeground(Color.BLACK);
		btnExit.setBounds(341, 10, 47, 38);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		panel.add(btnExit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 10, 273, 376);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("D2Coding", Font.BOLD, 24));
		model = new DefaultTableModel(null, COLUM_NAMES); 
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\rangking.png"));
		lblNewLabel.setBounds(0, 0, 400, 396);
		panel.add(lblNewLabel);
	}
}

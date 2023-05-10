package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AppMain07 {
	// JTable에서 사용할 컬럼 이름들
	private static final String[] COLUMN_NAMES = {"국 어", "영 어", "수 학", "총 점", "평 균"};
	Score score = new Score();
	
	private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체.
	private JFrame frame;
	private JLabel lblKorean;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMeth;
	private JLabel lblMath;
	private JLabel lblEnglish;
	private JButton btnInsert;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 153, 51));
		frame.setBounds(100, 100, 460, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblKorean = new JLabel("국 어");
		lblKorean.setForeground(Color.WHITE);
		lblKorean.setBackground(Color.WHITE);
		lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lblKorean.setBounds(12, 10, 140, 60);
		frame.getContentPane().add(lblKorean);
		
		lblEnglish = new JLabel("영 어");
		lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglish.setForeground(Color.WHITE);
		lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lblEnglish.setBackground(Color.WHITE);
		lblEnglish.setBounds(12, 80, 140, 60);
		frame.getContentPane().add(lblEnglish);
		
		lblMath = new JLabel("수 학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setForeground(Color.WHITE);
		lblMath.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lblMath.setBackground(Color.WHITE);
		lblMath.setBounds(12, 150, 140, 60);
		frame.getContentPane().add(lblMath);
		
		textKorean = new JTextField();
		textKorean.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textadd();
			}
		});
		textKorean.setHorizontalAlignment(SwingConstants.CENTER);
		textKorean.setFont(new Font("D2Coding", Font.PLAIN, 26));
		textKorean.setBounds(164, 10, 268, 60);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		textEnglish = new JTextField();
		textEnglish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textadd();
			}
		});
		textEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 26));
		textEnglish.setColumns(10);
		textEnglish.setBounds(164, 80, 268, 60);
		frame.getContentPane().add(textEnglish);
		
		textMeth = new JTextField();
		textMeth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textadd();
			}
		});
		textMeth.setHorizontalAlignment(SwingConstants.CENTER);
		textMeth.setFont(new Font("D2Coding", Font.PLAIN, 26));
		textMeth.setColumns(10);
		textMeth.setBounds(164, 150, 268, 60);
		frame.getContentPane().add(textMeth);
		
		btnInsert = new JButton("입 력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertButton();
			}
		});
		btnInsert.setBackground(UIManager.getColor("Button.highlight"));
		btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 26));
		btnInsert.setBounds(12, 220, 205, 50);
		frame.getContentPane().add(btnInsert);
		
		btnDelete = new JButton("삭 제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteButton();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 26));
		btnDelete.setBackground(UIManager.getColor("Button.highlight"));
		btnDelete.setBounds(229, 220, 205, 50);
		frame.getContentPane().add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 280, 420, 271);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[][] data = {}; // 테이블에 사용할 데이터.
		model = new DefaultTableModel(data, COLUMN_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
	private void textadd() {
		try {
			score.setKorean(Integer.parseInt(textKorean.getText()));
			score.setEnglish(Integer.parseInt(textEnglish.getText()));
			score.setMath(Integer.parseInt(textMeth.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(
					frame,
					"점수는 반드시 정수로 입력해야 됩니다.",
					"경 고",
					JOptionPane.WARNING_MESSAGE
					);
			
		}
		
	}
	
	private void insertButton() {
		textadd();
		Object[] row = {score.getKorean(), score.getEnglish(), score.getMath(),
				score.getTotal(), score.getMean()};
		model.addRow(row);
		score.setKorean(0);
		score.setEnglish(0);
		score.setMath(0);
		textKorean.setText("");
		textEnglish.setText("");
		textMeth.setText("");
	}
	
	private void deleteButton() {
		if (table.getSelectedRow() != -1) {
			model.removeRow(table.getSelectedRow());
		} else {
			try {
				model.removeRow(0);
			} catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(
						frame,
						"삭제할 점수가 없습니다.",
						"알 림",
						JOptionPane.WARNING_MESSAGE
						);
			}
		}
		
		
		
	}
}

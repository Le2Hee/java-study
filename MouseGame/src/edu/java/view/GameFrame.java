package edu.java.view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static edu.java.model.Score.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.java.model.Score;
import edu.java.model.User;
import edu.java.controller.MouseDaoImpl;

public class GameFrame extends JFrame {
	
	Random ran = new Random();
	
	int count = 0;
	long start = 0;
	long end = 0;
	
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private static GameFrame frame;
	private User user;
	
	MouseDaoImpl dao = MouseDaoImpl.getInstance();
	
	
	/**
	 * Launch the application.
	 */
	public static void showGameFrame(User user) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new GameFrame(user);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public GameFrame(User user) {
		this.user = user;
		start = System.currentTimeMillis();
		count = 0;
		initialize();

	}
	
	private void initialize() {
		setTitle("MouseGame");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1650, 1000);
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		int minbutx = 150;
		int maxbutx = 1550;
		
		int minbuty = 150;
		int maxbuty = 900;
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(1167,777, 50, 50);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton.setBounds(ran.nextInt(minbutx, maxbutx),
						ran.nextInt(minbuty, maxbuty), 50, 50);
				count++;
				lblNewLabel.setText(String.valueOf(count));
				if (count == 20) {
					end = System.currentTimeMillis();
					long result = end - start;
					int scresult = dao.CreatedScore(user.getNickname(), result);
					JOptionPane.showMessageDialog(
							frame,
							"시 간 : " + result + " ms",
							"결 과",
							JOptionPane.INFORMATION_MESSAGE);
					frame.setVisible(false);
					MouseGameMain.window.frame.setVisible(true);
				}
			}
		});
		panel.add(btnNewButton);
			
		lblNewLabel = new JLabel("0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 29));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(1443, 10, 179, 136);
		panel.add(lblNewLabel);
	}
	
	
	
	
	
}

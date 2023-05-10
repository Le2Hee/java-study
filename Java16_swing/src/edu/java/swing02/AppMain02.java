package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

	private JFrame frame;
	private JTextField textInput;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain02 window = new AppMain02();
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
	public AppMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblResult = new JLabel("입력하세요.");
		lblResult.setFont(new Font("D2Coding", Font.PLAIN, 32));
		lblResult.setBounds(12, 10, 596, 93);
		frame.getContentPane().add(lblResult);
		
		textInput = new JTextField();
		textInput.setFont(new Font("D2Coding", Font.PLAIN, 36));
		textInput.setBounds(12, 109, 596, 171);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		JButton btnInput = new JButton("입력 하기");
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(); // 내부 클래스에서 외부 클래스의 메서드를 호출할 수 있다.
			}
		});
		btnInput.setFont(new Font("D2Coding", Font.PLAIN, 36));
		btnInput.setBounds(12, 464, 596, 93);
		frame.getContentPane().add(btnInput);
	}

	private void handleButtonClick() {
		//JTextFileld 입력 내용을 읽음.
		String msg = textInput.getText();
		// 읽은 내용과 JLable에 씀.
		lblResult.setText(msg);
		// JTextField 내용을 지움.
		textInput.setText("");
		
	}
}

package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MySwingMain03 {

	private JFrame frame;
	private JTextField textInput1;
	private JTextField textInput2;
	private JTextArea textArea;
	private JButton btnAddition;
	private JButton btnSubtraction;
	private JButton btnMultiplication;
	private JButton btnDivision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwingMain03 window = new MySwingMain03();
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
	public MySwingMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 666);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("번호 입력");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 10, 130, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("번호 입력");
		lblNewLabel_1.setFont(new Font("D2Coding", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 80, 130, 60);
		frame.getContentPane().add(lblNewLabel_1);
		
		textInput1 = new JTextField();
		textInput1.setHorizontalAlignment(SwingConstants.CENTER);
		textInput1.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textInput1.setBounds(170, 10, 251, 60);
		frame.getContentPane().add(textInput1);
		textInput1.setColumns(10);
		
		textInput2 = new JTextField();
		textInput2.setHorizontalAlignment(SwingConstants.CENTER);
		textInput2.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textInput2.setColumns(10);
		textInput2.setBounds(170, 80, 251, 60);
		frame.getContentPane().add(textInput2);
		
		btnAddition = new JButton("+");
		btnAddition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
//				btnAddition();
			}
		});
		btnAddition.setFont(new Font("D2Coding", Font.PLAIN, 50));
		btnAddition.setBounds(12, 150, 95, 90);
		frame.getContentPane().add(btnAddition);
		
		btnSubtraction = new JButton("-");
		btnSubtraction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
//				btnSubtraction();
			}
		});
		btnSubtraction.setFont(new Font("굴림", Font.PLAIN, 50));
		btnSubtraction.setBounds(119, 150, 95, 90);
		frame.getContentPane().add(btnSubtraction);
		
		btnMultiplication = new JButton("x");
		btnMultiplication.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
//				btnMultiplication();
			}
		});
		btnMultiplication.setFont(new Font("굴림", Font.PLAIN, 50));
		btnMultiplication.setBounds(224, 150, 95, 90);
		frame.getContentPane().add(btnMultiplication);
		
		btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick(e);
//				btnDivision();
			}
		});
		btnDivision.setFont(new Font("굴림", Font.PLAIN, 50));
		btnDivision.setBounds(326, 150, 95, 90);
		frame.getContentPane().add(btnDivision);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.BLUE);
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 24));
		textArea.setBounds(12, 250, 409, 367);
		frame.getContentPane().add(textArea);
	}

	private void handleButtonClick(ActionEvent event) {
//		System.out.println(event.getSource());
		// argument로 전달된 ActionEvent 객체에서 이벤트가 발생한 GUI 컴포넌트 정보를 알 수 있다.
		
		// JTextField에 입력된 문자여을 읽어서 double 타입으로 변환.
		double number1 = 0;
		double number2 = 0;
		try {
			number1 = Double.parseDouble(textInput1.getText());
			number2 = Double.parseDouble(textInput2.getText());
			
			
			
		} catch (NumberFormatException e) {
			textArea.setText("숫자를 입력하세요.");
			return; // 메서드 종료.
		}
		
		double result = 0; // 사칙 연산 결과를 저장할 변수.
		String op = ""; // 사칙 연산 연산자 문자열을 저장할 변수. (+, -, *, /)
		
		Object source = event.getSource(); // 이벤트가 발생한 컴포넌트.
		
		if (source == btnAddition) {
			result = number1 + number2;
			op = "+";
		} else if (source == btnSubtraction) {
			result = number1 - number2;
			op = "-";
		} else if (source == btnMultiplication) {
			result = number1 * number2;
			op = "";
		} else if (source == btnDivision) {
			result = number1 / number2;
			op = "/";
		}
		
		String msg = String.format("%f %s %f = %f", number1, op, number2, result);
		textArea.setText(msg);
	}

//	protected void btnDivision() {
//		Double msg = Double.parseDouble(textInput1.getText()) / 
//				Double.parseDouble(textInput2.getText());
//		textArea.append(textInput1.getText() + " / " + textInput2.getText() + " : " + 
//				String.valueOf(msg) + "\n");
//	}
//
//	protected void btnMultiplication() {
//		Double msg = Double.parseDouble(textInput1.getText()) * 
//				Double.parseDouble(textInput2.getText());
//		textArea.append(textInput1.getText() + " * " + textInput2.getText() + " : " + 
//				String.valueOf(msg) + "\n");
//	}
//
//	protected void btnSubtraction() {
//		Double msg = Double.parseDouble(textInput1.getText()) - 
//				Double.parseDouble(textInput2.getText());
//		textArea.append(textInput1.getText() + " - " + textInput2.getText() + " : " + 
//				String.valueOf(msg) + "\n");
//	}
//
//	protected void btnAddition() {
//		Double msg = Double.parseDouble(textInput1.getText()) + 
//				Double.parseDouble(textInput2.getText());
//		textArea.append(textInput1.getText() + " + " + textInput2.getText() + " : " + 
//				String.valueOf(msg) + "\n");
//	}
}

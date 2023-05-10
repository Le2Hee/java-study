package edu.java.swing04;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.File;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MySwing04 {
	
	private static final String[] IMAGES = {
			"C:\\workspaces\\lab-java\\Java16_swing\\images\\photo1.jpg",
			"C:\\workspaces\\lab-java\\Java16_swing\\images\\photo2.jpg",
			"C:\\workspaces\\lab-java\\Java16_swing\\images\\photo3.jpg",
			"C:\\workspaces\\lab-java\\Java16_swing\\images\\photo4.jpg",
			"C:\\workspaces\\lab-java\\Java16_swing\\images\\photo5.jpg"
	}; // 이미지 파일을 경로들을 저장하는 배열.
	
	private int curIndex; // 현재 화면에 보여지는 이미지 파일의 인덱스.
	
	private JFrame frame;
	private JLabel lblPhoto;
	private JButton btnButton1;
	private JButton btnButton2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing04 window = new MySwing04();
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
	public MySwing04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblPhoto = new JLabel(new ImageIcon(IMAGES[curIndex]));
		//					  new ImageIcon("images/photo1.jpg")
		lblPhoto.setBounds(12, 10, 500, 500);
		frame.getContentPane().add(lblPhoto);
		
		btnButton1 = new JButton("<-");
		btnButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				handleButtonClick(e);
				showPrevImage();
			}
		});
		btnButton1.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnButton1.setBounds(12, 530, 97, 83);
		frame.getContentPane().add(btnButton1);
		
		btnButton2 = new JButton("->");
		btnButton2.addActionListener((e) -> showNextImage()); // 람다표현식을 사용한 액션.
		btnButton2.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnButton2.setBounds(402, 520, 97, 83);
		frame.getContentPane().add(btnButton2);
	}

	private void showNextImage() {
		if (curIndex < IMAGES.length - 1) {
			curIndex++;
		} else {
			curIndex = 0;
		}
		lblPhoto.setIcon(new ImageIcon(IMAGES[curIndex]));
		
	}

	protected void showPrevImage() {
		if (curIndex > 0) {
			curIndex--;
		} else {
			curIndex = 4;
		}
		lblPhoto.setIcon(new ImageIcon(IMAGES[curIndex]));
		if (curIndex == 0)
			curIndex = 5;
	}
	
	// 내 답.
//	int n = 2;
//	
//	protected void handleButtonClick(ActionEvent e) {
//		Object source = e.getSource();
//		if(source == btnButton1) {
//			ImageIcon o = new ImageIcon("C:\\workspaces\\lab-java\\Java16_swing\\images\\photo" + n + ".jpg");
//			lblPhoto.setIcon(o);
//			n++;
//			if(n == 6) {
//				n = 1;
//			}
//		} else if (source == btnButton2) {
//			ImageIcon o = new ImageIcon("C:\\workspaces\\lab-java\\Java16_swing\\images\\photo" + n + ".jpg");
//			lblPhoto.setIcon(o);
//			n--;
//			if(n == 0) {
//				n = 5;
//			}
//		}
//	}
	
	
	
	
}

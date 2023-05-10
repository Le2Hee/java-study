package edu.java.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AppMain05 {

	private JFrame frame;
	private JRadioButton rbPrivate;
	private JRadioButton rbPackage;
	private JRadioButton rbProtcted;
	private JRadioButton rbPublic;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox cbAbstract;
	private JCheckBox cbFinal;
	private JCheckBox cbStatic;
	private JComboBox<String> comboBox;
	private JButton btnInpo;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain05 window = new AppMain05();
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
	public AppMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rbPublic = new JRadioButton("public");
		rbPublic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPublic);
		rbPublic.setHorizontalAlignment(SwingConstants.CENTER);
		rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 28));
		rbPublic.setBounds(618, 6, 190, 63);
		frame.getContentPane().add(rbPublic);
		
		rbProtcted = new JRadioButton("protcted");
		rbProtcted.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbProtcted);
		rbProtcted.setHorizontalAlignment(SwingConstants.CENTER);
		rbProtcted.setFont(new Font("D2Coding", Font.PLAIN, 28));
		rbProtcted.setBounds(415, 6, 190, 63);
		frame.getContentPane().add(rbProtcted);
		
		rbPackage = new JRadioButton("package");
		rbPackage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPackage);
		rbPackage.setHorizontalAlignment(SwingConstants.CENTER);
		rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 28));
		rbPackage.setBounds(211, 6, 190, 63);
		frame.getContentPane().add(rbPackage);
		
		rbPrivate = new JRadioButton("prviate");
		rbPrivate.setSelected(true);
		rbPrivate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRadioButtonClick(e);
			}
		});
		buttonGroup.add(rbPrivate);
		rbPrivate.setHorizontalAlignment(SwingConstants.CENTER);
		rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 28));
		rbPrivate.setBounds(8, 6, 190, 63);
		frame.getContentPane().add(rbPrivate);
		
		cbAbstract = new JCheckBox("abstract");
		cbAbstract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 28));
		cbAbstract.setHorizontalAlignment(SwingConstants.CENTER);
		cbAbstract.setBounds(8, 71, 229, 63);
		frame.getContentPane().add(cbAbstract);
		
		cbFinal = new JCheckBox("final");
		cbFinal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbFinal.setHorizontalAlignment(SwingConstants.CENTER);
		cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 28));
		cbFinal.setBounds(294, 71, 229, 63);
		frame.getContentPane().add(cbFinal);
		
		cbStatic = new JCheckBox("static");
		cbStatic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleCheckBoxClick(e);
			}
		});
		cbStatic.setHorizontalAlignment(SwingConstants.CENTER);
		cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 28));
		cbStatic.setBounds(579, 71, 229, 63);
		frame.getContentPane().add(cbStatic);
		
		comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setEditable(true);
		String[] items = {"naver.com", "gmail.com", "kakao.com"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
		comboBox.setModel(model);
		comboBox.setFont(new Font("D2Coding", Font.PLAIN, 28));
		comboBox.setBounds(8, 140, 515, 63);
		frame.getContentPane().add(comboBox);
		
		btnInpo = new JButton("확 인");
		btnInpo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printInpo();
			}
		});
		btnInpo.setFont(new Font("D2Coding", Font.PLAIN, 24));
		btnInpo.setBounds(628, 140, 180, 64);
		frame.getContentPane().add(btnInpo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 213, 800, 346);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 24));
		scrollPane.setViewportView(textArea);
		
	}

	private void printInpo() {
		// 라디오버튼, 체크박스, 콤보박스의 상태를 JTextArea에 출력.
		
		StringBuffer buffer = new StringBuffer(); // textArea에 출력할 문자열을 저장하기 위해서.
		
		// 1. 어떤 라디오버튼이 선택됐는 지를 체크.
		if (rbPrivate.isSelected()) {
			buffer.append(rbPrivate.getText());
		} else if (rbPackage.isSelected()) {
			buffer.append(rbPackage.getText());
		} else if (rbProtcted.isSelected()) {
			buffer.append(rbProtcted.getText());
		} else if (rbPublic.isSelected()) {
			buffer.append(rbPublic.getText());
		}
		buffer.append("라디오 버튼 선택됨.\n");
		
		// 2. 체크박스들의 선택 여부를 확인.
		if (cbAbstract.isSelected()) {
			buffer.append(cbAbstract.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbFinal.getText()).append(" ");
		}
		if (cbFinal.isSelected()) {
			buffer.append(cbStatic.getText()).append(" ");
		}
		buffer.append("체크박스 선택됨.\n");
		
		// 3. 콤보박스에서 선택된 아이템 찾기.
		String item = (String) comboBox.getSelectedItem();
		buffer.append(item).append("콤보박스 선택됨.\n");
		
		// 4. 버퍼의 내용을 textArea에 출력.
		textArea.setText(buffer.toString());
		
		
	}

	private void handleCheckBoxClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스(체크박스)를 찾음.
		JCheckBox chbox = (JCheckBox) event.getSource();
		
		// 체크박스의 텍스트를 찾음.
		String text = chbox.getText();
		
		// 체크박스의 체크(선택) 여부 확인
		boolean selected = chbox.isSelected();
		
		// 정보 출력
		textArea.setText(text + " : " + selected);
		
	}

	private void handleRadioButtonClick(ActionEvent event) {
		// 클릭 이벤트가 발생한 이벤트 소스(라디오버튼)를 찾음.
		JRadioButton btn = (JRadioButton) event.getSource();
		
		// 라디오버튼의 텍스트를 찾음
		String btnText = btn.getText();
		
		// 라디오버튼의 선택(체크) 여부를 확인.
		boolean selected = btn.isSelected();
		
		// 결과를 JTextArea에 출력한다.
		textArea.setText(btnText + " : " + selected);
		
	}
}

package edu.java.contact06;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.model.Contact;
import edu.java.contact05.ContactDao;
import edu.java.contact05.ContactDaoImpl;
import java.awt.event.ActionListener;
import java.lang.StackWalker.Option;
import java.awt.event.ActionEvent;

public class ContactMain06 {
   // 테이블 컬럼 이름 (상수) 
   private static final String[] COLUM_NAMES = {"이름", "전화번호"};

   private JFrame frame;
   private JPanel bottonPanel;
   private JButton btnInsert;
   private JButton btnUpdate;
   private JButton btnDelete;
   private JButton btnSerch;
   private JScrollPane scrollPane;
   private JTable table;
   private DefaultTableModel model;   // 테이블의 데이터, 컬럼 이름 등을 관리하는 객체.
   
   // 연락처 정보 관리하는 객체(MVC Controller)
   private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
   
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ContactMain06 window = new ContactMain06();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   
   public void notifyContactUpdated() {
	   model = new DefaultTableModel(null, COLUM_NAMES);
	   loadContactData();
	   table.setModel(model);
	   JOptionPane.showMessageDialog(frame, "연락처를 수정했습니다.");
   }
   
   // ContactCreatFrame에서 새 연락처 저장을 성공했을 때 호출할 메서드.
   public void notifyContactCreated() { //생성된걸 알려준다는 뜻.
	   // JTable을 새로 그림.
	   // 데이터가 비워진 모델을 새로 생성
	   model = new DefaultTableModel(null, COLUM_NAMES);

	   // 파일에 저장된 데이터를 다시 읽고 테이블 모델에 추가.
	   loadContactData();
	   
	   // 새롭게 만들어진 테이블 모델을 테이블에 세팅한다.
	   table.setModel(model);
	   
	   JOptionPane.showMessageDialog(frame, "새 연락처 저장 성공");
   }

   /**
    * Create the application.
    */
   public ContactMain06() {
      initialize();   // 화면에 보여질 GUI 컴포넌트들을 생성하고 초기화.
      loadContactData();    // 파일에 저장된 연락처 데이터를 로딩(테이블 초기화).
   }
   
   private void loadContactData() {
      List<Contact> list = dao.read();
      for (Contact c : list) {
         Object[] row = {c.getName(), c.getPhone()};
         model.addRow(row);
      }
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 538, 598);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("연락처 v0.6");
      frame.getContentPane().setLayout(new BorderLayout(0, 0));
      
      bottonPanel = new JPanel();
      frame.getContentPane().add(bottonPanel, BorderLayout.NORTH);
      
      btnInsert = new JButton("새 연락처");
      btnInsert.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ContactCreateFrame.showContactCreateFrame(frame, ContactMain06.this);
            // 다른점 :         							-> ContactMain06 인스턴스 주소.
            // this  => (익명 클래스) ActionListener 타입의 익명 객체 => ActionListener 주소를 준다.
            // ContactMain06.this => ContactMain06 타입의 객체 => ContactMain06 주소를 준다.
         }
      });
      btnInsert.setFont(new Font("D2Coding", Font.PLAIN, 30));
      bottonPanel.add(btnInsert);
      
      btnUpdate = new JButton("수정");
      btnUpdate.addActionListener(new ActionListener() {
    	@Override
      	public void actionPerformed(ActionEvent e) {
    		UpdateContact();
      	}
      });
      btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 30));
      bottonPanel.add(btnUpdate);
      
      btnDelete = new JButton("삭제");
      btnDelete.addActionListener(new ActionListener() {
    	@Override
      	public void actionPerformed(ActionEvent e) {
    		deleteContact();
      	}
      });
      btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 30));
      bottonPanel.add(btnDelete);
      
      btnSerch = new JButton("검색");
      btnSerch.setFont(new Font("D2Coding", Font.PLAIN, 30));
      bottonPanel.add(btnSerch);
      
      scrollPane = new JScrollPane();
      frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
      
      table = new JTable();   // JTabel 타입 객체 생성
      model = new DefaultTableModel(null, COLUM_NAMES);   // TableModel 객체 생성
      table.setModel(model);   // TableModel 객체를 테이블에 세팅
      
      // TODO: 테이블에 컬럼 이름의 폰트를 변경.
      // TODO: 테이블에 데이터 행의 폰트를 변경.
      
      scrollPane.setViewportView(table);   // 테이블을 스크롤페인에 넣음.
   }

   private void UpdateContact() {
	   int row = table.getSelectedRow();
	   if (row == -1) {
		   JOptionPane.showMessageDialog(
				   frame,
				   "수정할 연락처를 선택해 주세요.",
				   "경 고",
				   JOptionPane.WARNING_MESSAGE
				   );
		   return;
	   }
	   
	   // ContactUpdateFrame을 생성해서 업데이트 창을 띄움.
	   // 새 창의 부모 컴포넌트. -> 업데이트 창을 띄울 좌표를 계산하기 위해서.
	   // 선택된 테이블 행 인덱스. -> 업데이트 창에서 수정전의 데이터를 출력하기 위해서.
	   // ContectMain 객체 주소. -> 업데이트 성공했을 때 업데이트 창이 main창에게 알려주기 위해.
	   ContactUpdateFrame.showContactUpdateFrame(frame, row, ContactMain06.this);
	   // 													 -> 이 this는 지금 현재 메서드가 만들어진 
	   //														위치가 main이기때문에 그냥 this도 
	   //														main this이다.
	   
	
}

   private void deleteContact() {
	   // 테이블에서 선택된 행의 인덱스를 찾기.
	   int row = table.getSelectedRow();
	   if (row == -1 ) {
		   JOptionPane.showMessageDialog(
				   frame,
				   "삭제할려는 행을 먼저 선택하세요",
				   "경 고",
				   JOptionPane.WARNING_MESSAGE
				   );
		   return;
	   }
	   
	   int confirm = JOptionPane.showConfirmDialog(
			   		frame,
			   		"정말로 삭제할까요?",
			   		"삭제 확인",
			   		JOptionPane.YES_NO_OPTION);
	   if (confirm == JOptionPane.YES_NO_OPTION) {
		   dao.delete(row); // 메모리에 있는 리스트에서 연락처 삭제, 파일 업데이트.
		   model.removeRow(row); // 화면에 있는 JTable에서 행 삭제.
		   // -> 파일에 저장되는 데이터와 화면에 보이는 데이터가 동기화가 맞다.
		   
		   JOptionPane.showMessageDialog(frame, "삭제 성공");
	   }
	   
   }

}
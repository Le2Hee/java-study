package edu.java.contact04;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.Menu;
import edu.java.contact.model.Contact;

// MVC(Mode-View-Controller) 아키텍쳐에서 View에 해당하는 클래스.
// UI(User Interface)를 담당하는 클래스.

public class ContactMain04 {
	
	private final Scanner scanner = new Scanner(System.in);
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	
	public static void main(String[] args) {
		System.out.println("================ 연락처 프로그램 v0.4 =================");
		
		ContactMain04 app = new ContactMain04();
		// -> ContactMain03의 static이 아닌 필드와 메서드들을 사용하기 위해서는 객체가 생성되어
		//    있어야된다.
		
		boolean run = true;
		while(run) {
			int n = app.showMainMenu();
			Menu menu = Menu.getValue(n);
			switch(menu) {
			case QUIT :
				run = false;
				break;
			case CREATE :
				app.insertNewContact();
				break;
			case READ_ALL :
				app.selectAllContacts();
				break;
			case READ_BY_INDEX :
				app.selectContactByIndex();
				break;
			case UPDATE :
				app.updateContact();
				break;
			case DELETE :
				app.deleteContact();
				break;
			default :
				System.out.println("============= 메인 메뉴 번호를 확인하세요. =============");
			}
		}
		
		
		System.out.println("\n===================== 프로그램 종료 =====================");
		
	}
	
	

	private int showMainMenu() {
		System.out.println();
		System.out.println("=========================================================");
		System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
		System.out.println("=========================================================");
		System.out.print("번호를 눌러주세요. >>> ");
		int n = inputNumber();
		
		return n;
	}
	
	private int inputNumber() {
		while(true) {
			try {
				int n = Integer.parseInt(scanner.nextLine());
				return n;
			} catch (NumberFormatException e) {
				System.out.print("정수를 다시 입력하세요. >>> ");
			}
		}
	}
	
	private void insertNewContact() { 
		System.out.println("\n========== 새 연락처 저장 ==========");
		
		System.out.print("이름을 입력 하세요. >>> ");
		String name = scanner.nextLine();
		System.out.print("전화번호를 입력 하세요. >>> ");
		String phone = scanner.nextLine();
		System.out.print("E-mail을 입력 하세요. >>> ");
		String email = scanner.nextLine();
		
		Contact contact = new Contact(0, name, phone, email); // 저장할 연락처 객체
		
		int result = dao.create(contact);
		
		System.out.println("\n====== 새 연락처가 저장되었습니다. ======");
	}
	
	private void selectAllContacts() {
		System.out.println("\n================= 연락처 전체 목록 =================");
		List<Contact> contacts = dao.read();
		
		int x = 0;
		for (Contact c : contacts) {
			System.out.println(c);
			x++;
		}
		System.out.println("\n=========== 총 연락처 개수는 " + x + "개 입니다. ===========");
	}
	
	private void selectContactByIndex() {
		System.out.println("\n=================== 연락처 검색 ===================");
		System.out.print("검색할 연락처의 인덱스를 입력하세요. >>> ");
		int index = inputNumber();
		
		Contact contact = dao.read(index);
		// -> View에서는 Controller의 메서드를 호출해서 인덱스 검색 결과를 리턴받음.
		
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("해당 인덱스에는 연락처가 없습니다.");
		}
	}
	
	private void updateContact() {
		System.out.println("\n=================== 연락처 수정 ===================");
		System.out.print("수정할 연락처 인덱스를 입력하세요. >>> ");
		int index = inputNumber();
		
		
		Contact before = dao.read(index);
		System.out.println("수정전 연락처 확인. >>>> " + before);
		if (before == null) {
			System.out.println("인덱스 번호를 다시 확인해주세요.");
			return;
		}
		System.out.print("이름을 입력하세요 >>> ");
		String name = scanner.nextLine();
		System.out.print("전화번호를 입력하세요 >>> ");
		String phone = scanner.nextLine();
		System.out.print("E-mail을 입력하세요 >>> ");
		String email = scanner.nextLine();
		
		Contact after = new Contact(0, name, phone, email);
		int result = dao.update(index, after);
		if (result == 1) {
			System.out.println("연락처 수정을 완료했습니다.");
		} else {
			System.out.println("연락처 수정을 실패했습니다.");
		}
		
	}
	
	private void deleteContact() {
		System.out.println("\n=================== 연락처 삭제 ===================");
		System.out.print("연락처에서 삭제할 인덱스 번호를 입력해주세요. >>> ");
		int index = inputNumber();
		
		Contact contact = dao.read(index);
		System.out.println("삭제할 연락처를 확인해주세여. >>> " + contact);
		
		int upContact = dao.delete(index);
		if (upContact == 1) {
			System.out.println("선택한 인덱스의 연락처가 삭제되었습니다.");
		} else {
			System.out.println("연락처 삭제에 실패했습니다. 인덱스 번호를 다시 확인해주세요.");
		}
		
	}
	
	
}

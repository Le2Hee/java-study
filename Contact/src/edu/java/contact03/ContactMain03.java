package edu.java.contact03;

import java.util.Scanner;

import edu.java.contact.menu.Menu;
import edu.java.contact.model.Contact;

// MVC(Mode-View-Controller) 아키텍쳐에서 View에 해당하는 클래스.
// UI(User Interface)를 담당하는 클래스.

public class ContactMain03 {
	
	private final Scanner scanner = new Scanner(System.in);
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	
	public static void main(String[] args) {
		System.out.println("================ 연락처 프로그램 v0.3 =================");
		
		ContactMain03 app = new ContactMain03();
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
		
		if(!dao.isMemoryAvailable()) { // 배열에 빈 공간이 없으면.
			System.out.println("\n===== 연락처를 저장할 공간이 부족합니다. =====");
			return; // 빈 공간이 없으면 메서드를 종료하겠다.
		}
		
		System.out.print("이름을 입력 하세요. >>> ");
		String name = scanner.nextLine();
		System.out.print("전화번호를 입력 하세요. >>> ");
		String phone = scanner.nextLine();
		System.out.print("E-mail을 입력 하세요. >>> ");
		String email = scanner.nextLine();
		
		Contact contact = new Contact(0, name, phone, email); // 저장할 연락처 객체
		
		int result = dao.create(contact);
		// -> 컨드롤러 객체의 메서드를 호출해서 연락처 저장 기능을 실행.
		
		if (result == 1) {
			System.out.println("\n====== 새 연락처가 저장되었습니다. ======");
		} else {
			System.out.println("\n===== 새 연락처가 저장에 실패했습니다. =====");
		}
		
	}
	
	private void selectAllContacts() {
		System.out.println("\n================= 연락처 전체 목록 =================");
		Contact[] contacts = dao.read();
		// -> View(UI)는 Controller의 메서드를 호출해서 출력에 필요한 데이터 리턴받음.
		
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
		
		if (!dao.isValidIndex(index)) {
			System.out.println("유효하지 않은 인덱스 입니다.");
			return;
		}
		
		Contact before = dao.read(index);
		System.out.println("수정전 연락처 확인. >>>> " + before);
		
		System.out.println("이름을 입력하세요 >>> ");
		String name = scanner.nextLine();
		System.out.println("전화번호를 입력하세요 >>> ");
		String phone = scanner.nextLine();
		System.out.println("E-mail을 입력하세요 >>> ");
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
			System.out.println("연락처 삭제에 실패했습니다.");
		}
		
	}
	
	
}

package edu.java.contact02;

import java.util.Scanner;

public class ContactMain02_My {
	// 상수(constant) 보통은 상수만들때 static final을 사용한다.
	private static final int MAX_LENGTH = 5; // 연락처 배열의 최대 길이(원소 개수)
	
	// field
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장할 배열.
	private int count = 0; // 연락처 배열에 현재까지 저장된 연락처의 개수.
	                       // 배열에 저장될 때마다 값 증가.
	private Scanner scanner = new Scanner(System.in); // 입력 도구
	
	
	
	public static void main(String[] args) {
		System.out.println("***************** 연락처 프로그램 v0.2 ******************");
		
		ContactMain02_My app = new ContactMain02_My();
		// -> static이 아닌 메서드들을 사용하기 위해서 참조 변수를 생성.
		
		boolean run = true;
		while(run) {
//			int n = app.showMainMenu();
//			Menu mean = Menu.getValue();
			Menu_My mean = Menu_My.showMainMenu();
			switch(mean) {
			case QUIT :  // 프로그램 종료
				run = false;
				break;
			case CREATE : // 새 연락처 저장
				app.insertNewContact();
				break;
			case READ_ALL : // 연락처 전체 목록 보여주기
				app.selectAllContacts();
				break;
			case READ_BY_INDEX : // 배열의 인덱스로 검색하기
				app.seletContactByIndex();
				break;
			case UPDATE : // 연락처 이름/전화번호/이메일 정보 수정하기
				app.updateContactByIndex();
				break;
			case DELETE : // 배열의 인덱스로 찾아서 삭제하기.
				app.deleteContactByIndex();
				break;
			default : 
				System.out.println("메인 메뉴에 없는 번호 입니다.\n메인 메뉴 번호를 확인하세요.");
			}
		}
		
		System.out.println();
		System.out.println("********************  프로그램 종료  ********************");
		
	}
	
//	public int showMainMenu() {
//		System.out.println();
//		System.out.println("=========================================================");
//		System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
//		System.out.println("=========================================================");
//		System.out.print("선 택 >>> ");
//		
//		// 콘솔 창에서 입력된 문자열 1개 라인을 정수(int)로 변환.
//		int result = Integer.parseInt(scanner.nextLine());
//		                  // 문자열을 int로 변환   // 한줄을 읽어 들이시오.(공백포함)
//		
//		return result;
//	}
	
//	public int inputNumber() {
//		while (true) {
//			try {
//				int n = Integer.parseInt(scanner.nextLine());
//				return n;
//			} catch (NumberFormatException e) {
//				System.out.println("정수를 입력하세요 >>> ");
//			}
//		}
//	}
	
	
	public void insertNewContact() {
		if (count < MAX_LENGTH) {
			System.out.println();
			System.out.println("*******************  새 연락처 저장  *******************");
		
		// 해석
//		if(count == MAX_LENGTH ) { //배열에 저장된 연라거 개수가 배열 길이와 같아면
//			System.out.println("연락처를 저장할 공간이 부족...");
//			return // 메서드 종료.
//		}   // void에서도 return을 사용할수 있다.
			
			System.out.print("이름을 입력하세요. >>> ");
			String name = scanner.nextLine();
			System.out.print("전화 번호를 입력하세요. >>> ");
			String phone = scanner.nextLine(); // 공백을 포함해서 엔터가 입력될 때까지 모든 문자열을 읽음.
			System.out.print("E-mail을 입력하세요. >>> ");
			String email = scanner.nextLine();
			
			// 입력받은 정보들로 Contact 타입의 객체를 생성.
			
			Contact c = new Contact(0, name, phone, email); // 배열에 저장하기 위해서.
			contacts[count] = c;  // 생성된 Contact 타입의 객체를 배열에 저장.
			count++;  // 배열에 저장된 원소(연락처) 개수를 1 증가.
		
			System.out.println("\n******************** 새 연락처를 저장했습니다. ********************");
		
		} else {
			System.out.println();
			System.out.println("********** 더 이상 번호를 추가할 수 없습니다. **********");
		}
		
	}
	
	public void selectAllContacts() {
		System.out.println();
		System.out.println("*************************  내 연락처 목록  *************************");
		for (int i = 0; i < count; i++) {
			System.out.println(contacts[i]);
		}
		System.out.println("****************** 현재 연락처 개수는 총 " + count + "개 입니다. ******************");
	}
	
	public void seletContactByIndex() {
		System.out.println("\n*************************  내 연락처 검색  *************************\n");
		System.out.print("검색할 인덱스를 입력하세요. >>> ");
		while(true) {
			try {
				int index = Integer.parseInt(scanner.nextLine());
				if (index < count && index >= 0) {
					System.out.print("\n검색한 연락처 : ");
					System.out.println(contacts[index]);
				} else {
					System.out.println("************ 연락처가 없는 인덱스 번호입니다. ***********");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("검색할 인덱스를 다시 입력하세요 >>> ");
			}
		}
	}
	
	public void updateContactByIndex() {
		System.out.println();
		System.out.println("***********************  연락처 수정  ***********************");
		System.out.print("수정할 연락처 인덱스를 입력하세요. >>> ");
		while (true) {
			try {
				int index = Integer.parseInt(scanner.nextLine());
				
				if (index < count && index >= 0) {
					System.out.println();
					System.out.print("수정 전 연락처 : ");
					System.out.println();
					System.out.println(contacts[index]); // 수정 전의 연락처 정보를 출력
					System.out.println();
				
					System.out.print("수정할 이름을 입력하세요. >>> ");
					String name = scanner.nextLine();
					System.out.print("수정할 전화번호를 입력하세요. >>> ");
					String phone = scanner.nextLine();
					System.out.print("수정할 E-mail를 입력하세요. >>> ");
					String email = scanner.nextLine();
					
					contacts[index].setName(name);
					contacts[index].setPhone(phone);
					contacts[index].setEmail(email);
					System.out.println();
					System.out.println("******** 선택한 인덱스의 번호가 변경되었습니다 ********");
					
					System.out.println();
					System.out.print("수정 된 연락처 : ");
					System.out.println(contacts[index]);
				} else {
					System.out.println();
					System.out.println("***************** 없는 인덱스 번호입니다. ****************");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.print("수정할 연락처 인덱스를 다시 입력하세요. >>> ");
			}
		}
	}
	
	public void deleteContactByIndex() {
		System.out.println("\n**************************  연락처 삭제  **************************\n");
		System.out.print("삭제할 연락처 인덱스를 입력하세요. >>> ");
		while (true) {
			try {
				int index = Integer.parseInt(scanner.nextLine());
				System.out.println();
				if (index >= MAX_LENGTH && index < 0) {
					System.out.println("***************** 없는 인덱스 번호입니다. ****************");
					return;
				}
				System.out.print("삭제 전 연락처  확인 : ");
				System.out.println(contacts[index]);
				
				System.out.println("************** 선택한 인덱스의 번호가 삭제되었습니다 **************");
				
				for (int i = index; i < count - 1; i++) {
					contacts[i] = contacts[i+1];  // 뒷쪽 연락처 정보를 한칸 앞으로
				}
				contacts[count-1] = new Contact(); // 삭제 전 배열의 마지막 원소를 null로 만들기.
				count--;
				
				System.out.println("************ 현재 연락처 개수는 총 " + count + "개 입니다. ************");
				break;
			} catch (NumberFormatException e) {
				System.out.print("삭제할 연락처 인덱스를 다시 입력하세요. >>> ");
			}
		}
	}
	
	
	
}

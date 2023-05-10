package edu.java.inner03;

import edu.java.inner03.Button.OnClickListener;

public class InnerMain03 {

	public static void main(String[] args) {
		// 1. 버튼 객체 생성.
		Button btnOpen = new Button("파일 열기");
		
		// 2. 버튼 클릭했을 때 할 일을 구현.
		OpenButtonListener l = new OpenButtonListener(); // 인터페이스를 구현 클래스 객체 생성
		
		// 3. 버튼에 버튼 클릭 기능을 연결한다.
		btnOpen.setOnClickListener(l);
		
		// 4. 버튼을 클릭한다.
		btnOpen.click();
		
		
		// 1. Button 타입 객체 생성.
		Button btnSave = new Button("파일 저장"); 
		
		// 2. 지역 (내부) 클래스 (local class) 선언.
		// -> 내부 클래스 인데 main안에서 만드는 것은 지역 내부 클래스(지역클래스) 라고 한다.
		class SaverButtonListener implements OnClickListener {

			@Override
			public void onClick() {
				System.out.println("파일 저장");
			}
			
		}
		
		// 3. OnClickListener 타입 객체 생성
		OnClickListener listener2 = new SaverButtonListener();
		
		// 4. OnclickListener를 버튼의 기능으로 설정.
		btnSave.setOnClickListener(listener2);
		
		// 5. btnSave의 click 메서드 사용.
		//  -> btnSave가 가지고 있는 listener의 onClick() 호출.
		btnSave.click();
		
		// 지역 클래스 : 선언된 메서드 안에서만 사용 가능(객체 생성).
		// -> 지역 클래스 선언 목적이 이름을 위해서 필요한거라면
		//    -> 이름이 없는 클래스를 생각 할 수 있지 않을까?
		//       -> 클래스를 정의 하면서 동시에 객체 생성까지 하는 클래스.
		//          -> 굳이 클래스의 이름을 만들려고 고민할 필요가 없다.
		
		// 종료하기
		Button btnExit = new Button("종료");
		
		// 익명 클래스. -> class의 이름이 없기때문에 익명 클래스라고 한다.
		// 					-> 이름이 곧 생성자이기 때문.
		//                  -> Java에서 부모 타입의 생성자로 만들어 버리자고 한 것.
		OnClickListener listener3 = new OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("프로그램 종료 합니다.");
			}
		};
		
		btnExit.setOnClickListener(listener3);
		btnExit.click();
		
		// 더 줄이는 경우.
		// setOnClickListener안에 새로운 익명 클래스를 생성한다.
		// 지역 내부 클래스를 압축하는 형태.
		
		Button btnHelp = new Button("도움말");
		btnHelp.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.println("도움말 보기");
			}
		});
		btnHelp.click();
		
		// 람다 표현식 : 
		// -> 추상 메서드가 오직 1개인 인터페이스 구현 클래스를 간단히 표현하는 방법.
		// (아규먼트) -> {바디 내용 그대로}
		// 아규먼트는 들고있지 않고 이 추상 메서드는 {}안에 내용을 실행한다.
		
		Button btnEdit = new Button("편집");
		btnEdit.setOnClickListener(() -> {System.out.println("파일 편집");});
		btnEdit.click();
		
		
		
		
	}

}

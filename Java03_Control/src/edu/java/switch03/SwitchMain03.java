package edu.java.switch03;

public class SwitchMain03 {

	public static void main(String[] args) {
		// enum 타입을 사용하는 switch-case 구문
		
		// enum Season 타입 변수를 선언하고 값을 겨울(WINTER)로 초기화.
		Season s= Season.FALL; // Season은 enum의 이름을 타입으로 사용, 저장하는 값은 Season. 을 붙여서 사용한다.
		switch (s) {  // enum을 만들어 놓으면 case + ctrl + 스페이스 만 해도 enum 안에 들어간 목록들이 바로 나온다.
		case SPRING :
			System.out.println("봄");
			break;
		case SUMMER :
			System.out.println("여름");
			break;
		case FALL :
			System.out.println("가을");
			break;
		case WINTER :
			System.out.println("겨울");
			break;
		} 
	}

}

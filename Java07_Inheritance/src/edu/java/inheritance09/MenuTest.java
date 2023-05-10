package edu.java.inheritance09;

import java.util.Scanner;

enum Menu {
	// enum 열겨형 상수(public static final (클래스이름) 변수) 선언.
	// enum은 선언하는 상수 순서가 중요하다.
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKONWN;
	// 0    1        2            3          4        5   -> 순서가 저장되어있다.
	//  메서드 이름으로 호출 -> static
	// 리턴 타입은 menu의 타입은 Menu이기 때문에 Menu
	/**
	 * 정수가 입력되면, 그 정수에 해당하는 열거형 상수를 리턴.
	 * 0 -> QUIT, 1 -> CREATE, 2 -> READ_ALL, ... , 5 -> DELETE,
	 *  0 ~ 5 그 이외의 정수들인 경우 -> UNKONWN
	 * @param n 정수(int).
	 * @return Meun 타입의 열거형 상수.
	 */
	public static Menu getValue(int n) {
		Menu[] x = Menu.values();  
//		if (n < 0 && n > 5) {
//			return UNKONWN;
//		} else {
//			return x[n];
//		}
//		풀이
		int len = x.length;
		if (n >= 0 && n < len) {
			return x[n];
		} else {
			return x[len - 1]; // return UNKONWN
		}
	}
}

public class MenuTest {
//	public static final int QUIT = 0;
	// -> 이 코드가 enum QUIT로 끝나는 것이다.

	public static void main(String[] args) {
		Singleton s = Singleton.INSTANCE;
		// -> enum 타입이 열거형 상수를 1개만 가지고 있으면,
		//    그 enum 타입에 할다알 수 있는 객체는 1개만 있게 된다.
		// -> 싱글톤 객체
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 >>> ");
		int n = Integer.parseInt(sc.nextLine()); // 콘솔창에서 입력받은 정수.
		
//		Menu m = Menu.CREATE;
		Menu menu = Menu.getValue(n); // int(정수)를 전달하면 Menu의 상수들 중 하나를 리턴.
		switch (menu) {
		case QUIT :
			System.out.println(menu.name());
			break;
		case CREATE : 
			System.out.println(menu.name());
			break;
		case READ_ALL :
			System.out.println(menu.name());
			break;
		case READ_BY_INDEX : 
			System.out.println(menu.name());
			break;
		case UPDATE : 
			System.out.println(menu.name());
			break;
		case DELETE : 
			System.out.println(menu.name());
			break;
		default : 
			System.out.println(menu.name());
			break;
		}
		
	}

}

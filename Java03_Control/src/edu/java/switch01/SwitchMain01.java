package edu.java.switch01;

public class SwitchMain01 {

	public static void main(String[] args) {
		String time = "점심";
		switch (time) {
		case "아침":
			System.out.println("breakfast");
			break;
		case "점심": //case는 실행한는 코드가 아니다.(default도 아님) 레이블이라고 한다.
			System.out.println("lunch");
			break;
		case "저녁":
			System.out.println("dinner");
			break;
		default : //위에있는 케이스에 아무것도 걸리지않는 경우 실행하는 문장 (default는 있얻 되고 없어도된다.)
			System.out.println("snack"); // default는 항상 마지막에 break를 쓰든 안쓰든 상관없다.
		}
		
		// switch-case 구문은 해당 case위치로 이동해서 break를 만나 때까지 코드들을 실행.
		// switch-case 구문에서 case에 사용 가능한 변수의 타입은 
		// (1) 정수 : byte, short, int, long, char
		// (2) 문자열 : String
		// (3) enum : 개발자가 정의하는 열거(나열)형 자료 타입.
		// (주의) switch-case 구문에서 실수 타입 : float, double(실수타입) 은 사용할수 없음.
		
		/*
		 * double 이 안되는 예
		double x = 1.0;
		switch (x) {
		case 1.0:
			break;
		case 2.0:
			break;
		}
		*/
		
	}
	
}

package edu.java.switch02;

public class SwitchMain02 {

	public static void main(String[] args) {
		// 정수를 사용하는 switch-case
		
		int n = 17;
		switch (n%2) {    // (n%2==0) 이라고 하면 에러가난다. boolean 타입이라서 안됨
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
		}
		
		
	}

}

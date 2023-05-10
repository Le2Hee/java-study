package edu.java.variable03;

public class VariableMain03 {

	public static void main(String[] args) {
		// 문자(character) : 문자 1개. 작은따옴표('')를 사용.
		// - 컴퓨터는 문자를 저장할 때, 문자에 해당하는 코드값(정수)을 저장.
		// 문자열(string) : 문자들의 배열. 큰따옴표("")를 사용.
		
		char ch1 = 'a';  // 문자 a의 코드값을 정수로 저장.
		System.out.println(ch1);  // char 타입 변수 ch1에 저장된 값을 문자로 출력.
		System.out.println("코드값 : "+(int) ch1);  // 변수 ch1에 저장된 값을 int 타입으로 출력. // a를 표준으로 97이라고 저장을 해놔서 97이 나오는것이다.(문자의 코드값)
		// casting : 강제 타입 변환. ()를 써주고 바꾸자고 하는 타입을 ()안에 넣으면 됨
		
		char ch2 = 98; // 이렇게도 가능은 해서 정수타입이라고 하지만 이렇게 사용하는 경우는 거의 없다.
		System.out.println(ch2); // 98에 해당하는 문자를 출력해라(ch2가 char이기 때문에 문자가 출력된다.)
		
		char ch3 = '이';  // 한글도 코드값이 있다.
		System.out.println(ch3);
		System.out.println("코드값 : "+(int) ch3);
		
	}

}

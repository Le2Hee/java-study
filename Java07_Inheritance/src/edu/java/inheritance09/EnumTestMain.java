package edu.java.inheritance09;

// enum 
// (1) 열거형 상수(들)을 정의하는 특별한 종류의 클래스.
// (2) java.lang.Enum 클래스를 상속하는 "특별한 하위 클래스". (문법적으로)
// (3) 필드, 생성자, 메서드를 선언(정의)할 수 있다.
// (4) enum 생성자는 반드시 private이어야 함.

// class Test extends Enu {}  -> 직접 서브클래스를 못만들게 막아놨다.
// 클래스의 한 종류.
// public이냐 아니냐 2종류가 있다.
// public enum을 만려면 class와 같기때문에 이름이 파일 이름과 같아야 가능하다.
// Object -> Enum -> Time 상속 순서.
// -> toString을 Enum이 Override을 했다.

class Test {
	public static final Test AM = new Test("오전");
	// -> 자기 자신을 변수로 설정.
	public static final Test PM = new Test("오후"); // 생성된 객체를 변수에 저장. (문자열)
	
	private String meaning;
	
	private Test(String meaning) { // private는 같은 클래스에서 사용가능.
		this.meaning = meaning;
	}
}
// 윗 Test 클래스 문법을 enum이라는 클라스를 사용해 AM("오전"), PM("오후"); 이렇게 하겠다 라는 것이다.

enum Time {
	AM("오전"), PM("오후"); // Time이라는 타입을 가지고있는 AM,PM은 객체이다.
	  						// 객체이면서도 호출할수 있는 생성자 코드이다.
	                        // -> 생성자 호출하는 코드다.
							// -> 생성자로 사용한다.
	// -> enum 타입의 열거형 상수들은 enum 타입으로 생성된 객체!
	
	// 필드.
	private String meaning;
	
	// 생성자 - public 생성자가 안된다.
	private Time(String meaning) {
		this.meaning = meaning;
	}
	
	
	// 메서드
	public String getMeaning() {
		return this.meaning;
	}
	
	
	
}

public class EnumTestMain {

	public static void main(String[] args) {
		Time t = Time.AM;
		System.out.println(t); // -> 그냥 t이라고 나온다.
		 						// -> am.toString()의 리턴 값을 출력했다.
		
		System.out.println(t.name()); // -> 일반적으로 toString()와 같다.
		
		System.out.println(t.ordinal()); // -> int를 리턴해준다.
		   								 // -> 선언된 객체에는 순서가 있다.
		// 윗 메서드들은 Enum 클래스에서 상속받은 메서드이다.
		
		System.out.println(Time.values());
		Time[] times = Time.values(); // -> Time이름을 가지는 배열
		for(Time x : times) {
			System.out.println(x + " : " + x.getMeaning());
		}
		// 윗 메서드는 Enum 클래스에서 상송받은 static 메서드이다.
		
		
		
	}

}

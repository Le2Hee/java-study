package edu.java.inheritance06;

class T {
	@Override // java.lang.Object 클래스에서 상속한 toString을 override한 것.
	public String toString() { // 바드시 리턴 타입이 문자열이다.
		// 객체를 문자열로(to String) 변환해서 리턴.
		return "T 타입 인스턴스";
	}
}

public class InheritanceMain06 {

	public static void main(String[] args) {
		// java.lang.Object 클래스 :
		  // 자바의 최상위 클래스
		  // 자바의 모든 클래스는 Object의 최소한 protected 또는 public으로 공개된 멤버(특히나 메서드)
		  //   를 상속받아서 사용 가능하고, 재정의(override)할 수 있다.
		// Object 클래스의 메서드 재정의 :
		  // toString, equals, hashCode, ... (가장 많이 재정의 하는 메서드들)
		
		  // toString : 
		    // 주로 명시적으로 호출하지 않아도 자동으로 호출되는 곳이 있는데 프린트문에 나온다.
		    // System.out.println(Object x);
		    //  -> argument로 전달된 객체의 toString() 메서드의 리턴하는 문자열을 콘솔창에 출력.
		    // 클래스를 정의할때, toString() 메서드를 override해서 
			// 원하는 문자열이 출력될 수 있도록 할 수 있다.
		
		T t = new T();
		System.out.println(t);
		
//		Point p1 = new Point();
//		System.out.println(p1);
//		
//		p1 = new Point(100, 50);
//		System.out.println(p1);
//		
//		p1.setX(20);
//		p1.setY(10);
//		System.out.println(p1);
		
		// 해석
		Point pt1 = new Point();
		System.out.println("pt1 : " + pt1);
		// -> Point 클래스에서 toString() 메서드를 override하지 않으면,
		//    Object 클래스에서 상속받은 toString() 메서드가 리턴하는 문자열을 콘솔창에 출력.
		// -> Point 클래스에서 toString() 메서드를 override하면,
		//    println은 Point 클래스에서 재정의된 toSrting 메서드가 리턴하는
		//    문자열을 콘솔창에 출력한다.
		
		Point pt2 = new Point(0, 0);
		System.out.println("pt2 : " + pt2); 
		
		System.out.println("== 연산자 : " + (pt1 == pt2)); // -> 연산자는 재정의할 수 없다.
		// -> == 연산자는 지역 변수 pt1의 값과 pt2의 값을 비교.(같으면 true, 다르면 false)
		// -> 클래스 타입의 지역 변수가 저장하는 값은 그 객체가 생성된 힙(Heep)의 주소.
		System.out.println("equals 메서드 : " + pt1.equals(pt2)); // -> 메서드는 재정의할 수 있다.
		// -> equal() 메서들를 override하면, 두 객체가 같은 지에 대한 정의를 새로 내릴 수 있다.
		// 변수에 들어가 있는 속성은 같지만 변수의 주소값은 다르다.(일반적인 equals는)
		// -> false가 나온다.
		
		// Point 클래스에서 equals를 override(재정의)하면,
		// equals() 메서드를 override를 했더니 false값이 true로 바뀌었다.
		
		System.out.println(pt1.getClass()); 
		// -> 정확하게는 클래스 이름을 리턴하는건 아니지만 클래스 이름을 알수있다. 
		
		// equals 설명
		String s1 = new String("안녕하세요."); // 설명을 위해서 일부로 생성자를 호출 
		String s2 = new String("안녕하세요.");
		System.out.println("== 연산자 : " + (s1 == s2));
		// -> 두 문자열이 생성된 "주소값"들을 비교
		System.out.println("equals 메서드 : " + s1.equals(s2));
		// String 클래스 처럼 이미 equals() 메서드를 override하고 있는 클래스가 많다.
		  // -> java.lang.String 클래스는 equals()를 override(재정의)하고 있다.
		  // -> 문자열의 내용이 같은 지를 비교하도록 재정의 되어 있다.
		// 결론 -> 비교를 할때는 ==연산자는 쓰지말고 equals()메서드를 사용해서 비교하자.
		  // -> ==연산자를 사용할때는 기본타입일때는 사용해도 되지만,
		  //    클래스타입을 사용할때에 equals() 메서드를 사용하자.
		
		
		System.out.println("pt1 hashCode : " + pt1.hashCode());
		System.out.println("pt2 hashCode : " + pt2.hashCode());
		// -> equals가 true를 리턴하는 두 객체(pt1, pt2)는 hashCode() 리턴 값이 같다.
		
		
		System.out.println();
		System.out.println("======================과 제======================");
		
		// userID는 같지만 password는 다른 경우
		User p1 = new User("work", "homework1212");
		User p2 = new User("work", "homework3434");
		System.out.println("p1 hashCode : " + p1.hashCode());
		System.out.println("p2 hashCode : " + p2.hashCode());
		System.out.println(p1.equals(p2));
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println("== 연산자 : " + (p1 == p2)); // -> false
		System.out.println("equals 메서드 : " + p1.equals(p2)); // -> true
		
		System.out.println("=================================================");
		
		// userID는 다르지만 password는 같은 경우
		User p3 = new User("work112", "homework3434");
		User p4 = new User("work122", "homework3434");
		System.out.println("p3 hashCode : " + p3.hashCode());
		System.out.println("p4 hashCode : " + p4.hashCode());
		System.out.println(p3.equals(p4));
		System.out.println(p3);
		System.out.println(p4);
		
		System.out.println("=================================================");
		
		// userID 와 password가 같은 경우
		User p5 = new User("work55", "homework5656");
		User p6 = new User("work55", "homework5656");
		System.out.println("p5 hashCode : " + p5.hashCode());
		System.out.println("p6 hashCode : " + p6.hashCode());
		System.out.println(p5.equals(p6));
		System.out.println(p5);
		System.out.println(p6);
		
		System.out.println("=================================================");
		
		// userID 와 password 둘다 다른 경우
		User p7 = new User("work515", "homework5656");
		User p8 = new User("work587", "homework7878");
		System.out.println("p7 hashCode : " + p7.hashCode());
		System.out.println("p8 hashCode : " + p8.hashCode());
		System.out.println(p7.equals(p8));
		System.out.println(p7);
		System.out.println(p8);
		
		
		
		
	}

}

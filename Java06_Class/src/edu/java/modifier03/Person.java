package edu.java.modifier03;

public class Person {
	// field
	private String name;
	private int age;
	// public String name;, ... 캡술화를 사용하지 않은 클래스.
	
	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// method
	// getter 메서드 (리턴을 하는 메서드), getter메서드는 파라미터를 선언하지 않는다.
	public String getName() {  // getter 메서드는 get+변수 를 관습으로 사용한다.
								 //   첫글자는 대문자로!
		return this.name;
		
	}
	
	public int getAge() {
		return this.age;
	}
	
	// setter 메서드
	  // 리턴 타입이 없다.
	  // 설정할려면 숫자가 필요하기 때문에 파라미터가 필요하다.
	// 나이 변경하는 메서드만 (가장 간단하게 만드는 setter메서드)
	public void setAge(int age) {
		if (age >= 0) {  // if를 사용해서 무결성을 만드는 것.
			this.age = age;
		} else {
			System.out.println("음수 나이는 허용되지 않음.");
		}
		
	}
	
	
}

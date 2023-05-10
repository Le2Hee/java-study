package edu.java.inheritance02;

public class Person {
	// field
	private String name;
	
	// constructor
	public Person() {
		System.out.println("Person() 생성자가 호출.");
	}
	// 기본 생성자가 없으면 하위 클래스가 오류가 생긴다.
	  // 에러 메세지 내용 : 
	    // -> 암시적으로 부모의 기본 생성자가 호출되고 있는데(코드가없어도),
	    //    부모의 기본 생성자가 없다. 그래서 다른 아규먼트가 들어가 있는 생성자를 만들어라.
	
	public Person(String name) {
		this.name = name;
		System.out.println("Person(name) 생성자 호출");
	}
	
	// method
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

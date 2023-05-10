package edu.java.inheritance02;

// 회사원은 사람이다.
  // -> 회사원은 사람을 확장한다.
public class BusinessPerson extends Person {
	// field
	private String company;
	
	// constructor
	public BusinessPerson() {
//		super();  // super가 생략된것. 생략해도 상관없음.
		// -> 상위 클래스의 기본 생성자 호출은 생략 가능.
		System.out.println("BusonessPerson() 생성자가 호출.");
	}
	
	public BusinessPerson(String company) {
//		super();
		this.company = company;
		System.out.println("BusinessPerson(company) 생성자가 호출.");
	}

	public BusinessPerson(String name, String company) {
		super(name); // 부모의 생성자를 호출할때 super를 사용하면 된다.
		// -> super가 Person클래스 내의 생성자를 알아서 찾아감.
		
		// 부모의 생성자를 명시적으로 호출.
		// -> 기본 생성자일때는 java가 알아서 생략하지만
		//    아규먼트가 있는 생성자는 java가 알수가 없다.  // -> java가 생략을 안해준다.
		this.company = company;
		// super라는 코드는 다른 코드보다 밑에서 입력되면 안된다.
//		super(name); // 항상! 무조건! 맨 윗줄에 생성해야 된다.
		// 에러 메세지 -> 생성자를 불러주는 것은 반드시 첫번째 문장이여야된다. 다른 생성자 안에서
		System.out.println("BusinessPerson(name, company) 생성자가 호출.");
	}
	
	
	
	
}

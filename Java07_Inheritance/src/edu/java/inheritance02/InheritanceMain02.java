package edu.java.inheritance02;

public class InheritanceMain02 {

	public static void main(String[] args) {
		// 상속 관계에서 생성자 호출 순서 : 
		BusinessPerson p1 = new BusinessPerson(); 
		// 회사원을 호출했더니 person이 만들어지고 회사원이 만들어진다.
		
		BusinessPerson p2 = new BusinessPerson("아이티윌");
		BusinessPerson p3 = new BusinessPerson("오쌤", "아이티윌");
		
		// 내용 정리
		
		// 하위 클래스의 객체를 생성하기 위해서 생성자를 호출하면,
		// 항상 상위 클래스의 생성자가 먼저 실행되고, 그 후엥 하위 클래스의 생성자가 실행된다.
		
		// 하위 클래스의 생성자에서 상위 클래스의 생성자를 호출하려면 super(아규먼트);를 사용하면된다. 
		
		// 하위 클래스이 생성자에서 상위 클래스의 생성자를 호출하지 않으면,
		// 상위 클래스의 "기본생성자(default constructor)"가 암묵적으로 호출된다.
		
		// 만약에 상위 클래스에 기본 생성자가 없으면,
		// 하위 클래스에서는 상위 클래스의 다른 생성자를 "반드시" 명시적으로 호출해야만 한다.
		  // -> 상위 클래스에 가서 기본 생성자를 만드는 방법도 있다.(못만드는 경우)  
		
		// this의 의미 : 
		  // (1) 생성된(자기자신) 객체(의 주소) : this.field, this.method
 		  // (2) 오버로딩된 다른 생성자 호출 : this(), this(아규먼트)
		  
		// super의 의미 : 
		  // (1) 생성된 상위 클래스의 객체(의 주소) : super.field, super.method()
		  // (2) 상위 클래스의 생성자 : super(), super(아규먼트)
		
		
	}

}

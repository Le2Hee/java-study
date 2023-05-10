package edu.java.inner02;

public class BuilderExample {

	public static void main(String[] args) {
		// Book 타입의 객체 생성
		Book book1 = new Book("하얼빈", "김훈", "문학동네");
		System.out.println(book1);
		
		Book book2 = new Book("홍길동", "허균", "조선");
		System.out.println(book2);
		
		Book book3 = new Book("허균", "홍길동전", "모름");
		System.out.println(book3);
		
		// builder 패턴
		Book book4 = Book.builder().author("허균").title("홍길동전").build(); 
		// 책을 만드는게 아니라 도구를 만드는 것.
		//->최종적으로 build()하나만 Book을 리턴하고 있다.
		System.out.println(book4);
		
		Book book5 = Book.builder().author("김훈").title("하얼빈").publisher("문학동네").build();
		System.out.println(book5);
		
		
	}

}

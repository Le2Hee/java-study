package edu.java.inner02;

public class Book {
	// field
	private String title; // 책 제목
	private String author;  // 책 저자
	private String publisher; // 출판사
	
	
	// constructor
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	
	// method
	@Override
	public String toString() {
		return String.format("Book(Title = %s, Author = %s, Publisher = %s)", 
				title, author, publisher);
	}
	
	// ---------- Factory(Builder) 디자인 패턴 ----------
	
	public static class BookBuilder {
		private String title;
		private String author;
		private String publisher;
		// 그대로 외부 필드를 생성한다.
		
		private BookBuilder() {}
		// 생성자를 private로 막는다.
		
		// setter랑 유사하다.
		// 다른점 : setter은 void이지만 이 것은 BookBuilder타입이다
		//          메서드 이름을 변수 이름과 똑같이 만든다.
		public BookBuilder title(String title) {
			this.title = title;
			return this;
			// -> this의 의미 : BookBuilder의 타입으로 생성된 객체(인스터스) 
		}
		
		public BookBuilder author(String author) {
			this.author = author;
			return this;
		}
		
		public BookBuilder publisher(String publisher) {
			this.publisher = publisher;
			return this;
		}
		
		// 외부 클래스 타입을 리턴하는 메서드를 만든다.
		public Book build() {
			return new Book(title, author, publisher);
		}
		
		
	}
	
	
	
	
	// method를 하나 만들고 리턴 타입을 BookBuilder로 선언
	public static BookBuilder builder() {
		return new BookBuilder();
		// -> 외부 클래스는 static으로 선언된 내부 클래스의 private 생성자를 호출할 수 있다.
	}
	
	
	
}

package edu.java.class04;

// 클래스의 멤버들 : 
// (1) 필드(멤버 변수)
// (2) 생성자
// (3) 메서드
public class Product {
	// 필드
	int productId; // 상품ID, 상품 코드
	String productName; // 상품 이름
	int productPrice; // 상품 가격
	
	// 생성자 : 
	// (1) 기본 생성자
	// (2) argument 3개를 갖는 생성자
	// (3) productId와 productName을 argument로 갖는 생성자 (기본값은 0으로)
	
	public Product() {}
	
	public Product(int productId, String productName, int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Product(int productId, String productName) {
		this(productId, productName, 0);
	}
	
	// 메서드 : 
	// (1) printProductInfo : 상품의 모든 정보를 콘솔에 출력
	// (2) setProductPrice : 상품의 가격을 전달받은 값으로 변경하는 메서드.
	
	public void printProductInfo () {
		System.out.printf("상품 코드 : %d\n상품 이름 : %s\n상품 가격 : %d원\n", productId, productName, productPrice);
		System.out.println();
		// 필드가 지역 변수 이름과 혼동되지 않으면 this를 생략해도 됨.
	}
	
	public void setProductPrice (int price) {
		this.productPrice = price;
	}
	
}

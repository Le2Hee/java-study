package edu.java.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		Product product1 = new Product();
		product1.printProductInfo();
		
		Product product2 = new Product(290625, "2022 메르세데스-벤츠 G클래스 G 400d 4MATIC", 183583636);
		product2.printProductInfo();
		
		Product product3 = new Product(270315, "2023 BMW Z4 sDrive20i M Sport");
		product3.printProductInfo();
		
		product3.setProductPrice(102534545);
		product3.printProductInfo();
		
		System.out.println("ID : " + product1.productId);
		// 메서드가 안만들어지면 이런 방법이 있다.
		
	}

}

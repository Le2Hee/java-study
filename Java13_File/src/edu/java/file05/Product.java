package edu.java.file05;

import java.io.Serializable;

// Model 클래스. VO(Value Object). 값만 저장하는 클래스.
// implements Serializable : Serializeable 인터페이스를 구현. 
//     -> 객체를 파이렝 쓰거나, 파일에서 읽기 위해서.
public class Product implements Serializable {
	private int id; // 상품 아이디
	private String name; // 상품 이름
	private int price; // 상품 가격
	
	public Product () {}

	public Product(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String.format("상품(아이디 : %d, 이름 : %s, 가격 : %d)", id, name, price);
	}
}
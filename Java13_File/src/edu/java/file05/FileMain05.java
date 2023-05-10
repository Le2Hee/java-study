package edu.java.file05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 프로그램 ==> ObjectOutputStram ==> FileOutputStream ==> 파일
 *  ObjectOutputStram 하는 역할 : 
 *   - Java 객체를 파일에 쓸 수 있는 형태로 변환(serialize, 직렬화)
 * 
 * 프로그램 <== ObjectInputStream <== FileInputStream <== 파일
 *  ObjectInputStream이 가지고 있는 read 메서드를 부른다 :
 *   - 파일에서 읽은 데이터를 자바 객체로 변환.(de-serialize, 역직렬화)
 *   
 * OIS, OOS에서 사용하는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야 함.
 *  
 */

public class FileMain05 {

	public static void main(String[] args) {
		// 객체 타입의 데이터를 파일에 쓰기, 읽기
		
		// Product 타입의 객체 생성
		Product p = new Product(1, "2023 BMW M135i xDrive_P1", 91685455);
		
		// 객체의 내용을 쓰고, 읽을 파일 경로, 이름.
		String file = "data/product.dat";
		
		// Product 타입의 Java 객체를 파일에 씀.
		try (
				FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream oout = new ObjectOutputStream(out);
		) {
			 oout.writeObject(p); // 직렬화 (serialize)
			 System.out.println("파일 작성 완료");
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일에 직렬화된 형태로 쓰여진 데이터를 읽어서 Java객체로 변환하겠다.
		FileInputStream in = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream(file);
			oin = new ObjectInputStream(in);
			
			Product result = (Product) oin.readObject();
			// -> 파일에 직렬화된 내용을 자바 객체 타입으로 변환 - 역직렬화(de-serialize)
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}

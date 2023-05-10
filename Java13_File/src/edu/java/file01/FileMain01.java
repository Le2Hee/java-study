package edu.java.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 입/출력 스트림(Input/Output Stream) : 프로그램이 값(데이터)을 입력받거나 출력하는 통로.
 *  (예) System.in : 입력 스트림 객체, System.out : 출력 스트림 객체.
 * 
 * 프로그램 입장에서 생각 / 화살표는 데이터가 흘러가는 방향.
 * 프로그램 <== InputStream <== 입력 장치(키보드, 마우스, 터치스크린, 파일, ...)
 * 프로그램 ==> OutputStram ==> 출력 장치(모니터, 프린터, 프로젝터, 파일, ...)
 * 
 * Stream -> 데이터들이 지나가는 통로라고 생각하자.
 * 
 * 프로그램 <== FileInputStream <== 파일 -> 파일에 있는 데이터를 프로그램으로 보내고 싶을때.
 * 프로그램 ==> FileOutputStream ==> 파일 -> 프로그램에 있는 데이터를 파일로 보내고 싶을때.
 * 
 * java.io.InputStream : 데이터를 읽어오는 통로.
 * |__ FileInputStream : 파일에서 데이터를 읽어오는 통로.
 * 
 * FileInputStream 사용법 :
 *  (1) FileInputStream 객체 생성
 *  (2) FileInputStream 객체의 read 관련 메서드를 사용.
 *  (3) 모든 데이터를 다 읽었으면 FileInputStream 객체를 close.
 *  
 * java.io.OutputStream : 데이터를 내보내는(쓰는, write) 통로.
 * |__ FileOutputStream : 파일에 데이터를 쓰는 통로.
 * 
 * FileOutputStream 사용법 :
 *  (1) FileOutputStream 객체 생성
 *  (2) FileOutputStream 객체의 write 관련 메서드를 사용.
 *  (3) FileOutputStream 객체를 close.
 * 
 */

public class FileMain01 {

	public static void main(String[] args) {
		String fileName = "data/hello.txt";
		      // 폴더이름(경로)/파일이름.구분자
		
		String copyFile = "data/hello-copy.txt";
		
		FileInputStream in = null;  // FIS라고 쳐도 팁으로 나온다.
		FileOutputStream out = null;  // FOS라고 쳐도 팁으로 나온다.
		
		try {
			// 파일을 읽기 위한 스트림 객체 생성.
			in = new FileInputStream(fileName);
			
			// 파일에 데이터를 쓰기 위한 스트림 객체 생성.
			out = new FileOutputStream(copyFile);
			// -> 둘 다 try 안에서 생성하는 이유는 예외때문이다.
			
			while (true) {
				int read = in.read(); // 파일에서 1byte를 읽음.
				// read() 설명 : 파일의 끝을 도착하면 -1을 리턴한다.
				if (read == -1) { // 파일 끝(EOF, end of file)에 도달한 경우
					break; // 반복문 종료.
				}
				
//				System.out.println((char) read);
				// 한글은 적어도 2byte를 필요로하는데 지금 불러온건 1byte만 읽어서 표기가 안된다.
				
				out.write(read); // 파일에 1byte를 씀.
				
			}
			System.out.println("파일 복사 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				in.close(); // FIS를 닫음.
				out.close(); // FOS를 닫음.
				
			} catch (IOException e) {
				e.printStackTrace();
				
			}
		}
		
		
		
	}

}

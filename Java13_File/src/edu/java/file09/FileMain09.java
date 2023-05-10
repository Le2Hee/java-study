package edu.java.file09;

import java.io.File;

public class FileMain09 {

	public static void main(String[] args) {
		// 파일, 폴더(디렉토리) 생성, 삭제, 관리
		
		// System.getProperty(key) :
		//  - Java Runtime이 실행 중인 컴퓨터의 여러가지 시스템 정보들을 리턴해주는 메서드.
		String cwd = System.getProperty("user.dir");
		System.out.println(cwd);
		// CWD(Current Working Directory, 현재 작업 디렉토리) : 현재 프로그램이 실행되는 위치.
		
		/*
		 * 경로를 사용할때 2가지 방법을 사용한다.
		 * 
		 * 절대 경로 (absolute path) :
		 *  -시스템의 루트 (C:\, D:\, ...)부터 파일 또는 폴덕 있는 위치를 찾아가는 방식.
		 *     -> Windows 기준으로
		 *     -> (예) C:\workspaces\lab-java\Java13_File\data\encoding-ansi.txt
		 * 
		 * 상대경로 (relative path)
		 *  -현재 작업 디렉토리(CWD)를 기준으로 파일 또는 폴더가 있는 위치를 상대적으로 찾아가는 방식. 
		 *   -> (예) data\encoding-ansi.txt
		 *  -특별하게 사용하는 기호가 있다.
		 *   -> "." : 현재 디렉토리(폴더) -> 현재 디렉토리는 굳이 안써도되서 잘 안쓴다.
		 *      ".." : 상위 디렉토리(폴더)
		 *   -> (예) .\data\encoding-ansi.txt -> 현재 디렉토리
		 *      (예) ..\Java11_MVC\src
		 *          (1) .. : 현재는 Java13번 파일에서 lab-java로 올라간 것.
		 *          (2) lab-java에서 Java11_MVC로 들어가서 src로 들어간 것.
		 *    
		 *   \ : 파일 구분자 -> (폰트에따라 원화 표시로 보인다.)
		 *   파일 구분자(file separator) :
		 *    - 상위 폴더와 하위 폴더, 폴더와 파일을 구분하기 위한 문자.
		 *    - MS-Windows에서는 파일 구분자를 \(backslash)로 사용한다.
		 *      MS-Windows를 제외한 다른 모든 OS에서는 /(slash)를 사용한다.
		 *   
		 *   
		 *   문자열 "" 안에서 backslash는 특별한 의미를 갖음(escape문자)
		 *   
		 */
		
		// backslash가 포함된 문자열
		System.out.println("C:\\workspaces\\lab-java\\Java13_File");
		
		// 프로그램이 실행되는 OS에 따라서 자동으로 파일 구분자가 선택되도록 할 수 있다.
		String path = "data" + File.separator + "encoding-ansi.txt";
		System.out.println(path);
		
		// File 클래스 : 
		// 파일(txt, jpg, mp4, ...)과 폴더(디렉토리)에 관련된 기능(메서드)들을 가지고 있는 클래스.
		
		// File 타입 객체 생성
		// 상대경로, 절대경로 둘 다 가능하다.
		File f =new File(path);
		System.out.println("경로 : " + f.getPath());  // 출력된 내용 -> 상대경로
		// -> getPath가 무조건 상대경로를 출력하는게 아니다.
		// -> 파일 객체가 생성될 때 상대 경로로 생성된 경우 getPath() 메서드는 상대 경로를 리턴.
		// -> 파일 객체를 생성할 때 절대 경로로 생성하면, getPat() 메서드는 절대 경로를 리턴.
		
		System.out.println("경로 : " + f.getAbsolutePath()); // 출력된 내용 -> 절대경로
		
		System.out.println("이름 : " + f.getName()); // -> 젤 끝에 있는 파일 이름만 리턴.
		// -> 끝에 끝나는게 파일이면 파일이름, 폴더면 폴더이름
		
		System.out.println("존재? : " + f.exists());
		// -> 파일이 존재하느냐?
		
		System.out.println("파일? : " + f.isFile()); 
		// -> boolean타입 메서드들은 대부분 is로 시작을 한다.
		
		System.out.println("폴더? : " + f.isDirectory());
		
		System.out.println("크기 : " + f.length());
		// -> byte 단위
		
		// data폴더의 내용(하위 폴더, 파일들)을 출력
		File dataDir = new File("data"); // -> 상대경로
		System.out.println(dataDir.getAbsolutePath());
		// -> 절대 경로
		
		File[] files = dataDir.listFiles(); 
		// -> 파일 객체(폴더)의 하위 멤버들의 배열을 리턴해준다.
		
		for(File file : files) {
			String fileName = file.getName(); // 파일 또는 폴더 이름.
			String info = null;  // 화면에 출력할 정보.
			if (file.isFile()) { // 파일인 경우.
				info = fileName + "\t" + file.length() + "Bytes";
			} else { // 파일이 아닌 경으 -> 폴더인 경우
				info = fileName + "\t<DIR>";
			}
			System.out.println(info);
		}
		
		// 새 폴더 생성 :
		// (1) File 객체 생성한다.
		// (2) 폴더가 없으면, mkdir() 메서드를 호출한다.
		File newFolder = new File("data", "temp");
		// -> 현재 폴더 밑에 data 밑에 temp라는 폴더를 만드는 것.  (현재 폴더 : Java13)
		//    .\data\temp
		
		if(newFolder.exists()) { // 폴더가 이미 존재하면
			System.out.println("폴더가 이미 있습니다.");
		} else { // 폴더가 존재하지 않으면
			newFolder.mkdir(); // make directory
			System.out.println("새 폴더 생성 성공");
		}
		
		// 기존 폴더 삭제 :
		// (1) File 객체 생성한다.
		// (2) 폴더가 있으면, delete() 메서드를 호출.
		if(newFolder.exists()) { // 폴더가 존재 하면.
			newFolder.delete();
			System.out.println("폴더를 삭제 했습니다.");
		} else { // 존재 안하면
			System.out.println("삭제할 폴더가 없습니다.");
		}
		
		
	}

}

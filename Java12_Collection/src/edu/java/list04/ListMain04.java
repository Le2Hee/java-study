package edu.java.list04;

import java.util.ArrayList;
import java.util.Scanner;

public class ListMain04 {

	public static void main(String[] args) {
		// User 타입을 저장하는 ArraryList 타입 변수 선언, 객체 생성.
		ArrayList<User> users = new ArrayList<>();
		
		// 3개의 User 객체를 ArrayList에 저장.
		Scanner sc = new Scanner(System.in);
		User user = new User();
		
		for (int i = 0; i < 3; i++) {
			System.out.print("아이디를 입력하세요 >>> ");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력하세요 >>> ");
			String password = sc.nextLine();
			user = new User(id, password);
			users.add(i, user);
			System.out.println();
		}
		
		// 저장된 내용을 출력하기.
		System.out.println(users);
		
		System.out.println("=========================================================");
		
		// 리스트 User에서 인덱스 0번 위치의 원소를 삭제
		users.remove(0);
		System.out.println(users);
		
		// id가 "guest"인 User 객체를 리스트에서 삭제
		String s = user.getId();
		users.remove(s.concat("guest"));
		System.out.println(users);
		
		// 풀이
		for(int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals("guest") ) {
				users.remove(i);
				break; // -> 맨 앞에꺼만 없애고 나온기 위해
			}
		}
		
	}

}

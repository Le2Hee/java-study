package edu.java.contact02;

import java.util.Scanner;

public enum Menu_My {
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKONWN;
	
	public static Menu_My showMainMenu() {
		Menu_My[] x = Menu_My.values();
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("=========================================================");
		System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
		System.out.println("=========================================================");
		System.out.print("선 택 >>> ");
		while (true) {
			try {
				int result = Integer.parseInt(scanner.nextLine());
				int len = x.length;
				if (result >= 0 && result < len) {
					return x[result];
				} else {
					return x[len-1];
				}
			} catch (NumberFormatException e) {
				System.out.print("정수를 다시 입력하세요. >>> ");	
			}
		}
	}

}

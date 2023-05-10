package edu.java.conditional03;

import java.util.Scanner;

public class ConditionalMain03 {

	public static void main(String[] args) {
		// 간단한 성적 처리 프로그램
		// Scanner를 사용해서 세 과목(java, sql, html)의 점수를 입력받고 변수에 저장.
		// 세 과목의 총점을 계산하고 출력.
		// 세 과목의 평균을 계산하고 출력.
		// 학점(A, B, C, D, F)를 출력 90/80/70/60
		
		// Ctrl+Space : 코드 추천
		// Ctrl+F11 : 실행 (Run java program)
		
		// //쳐서 있는데가 선생님 코드
		
		Scanner sc = new Scanner(System.in);  // 입력장치 Scanner를 사용할 준비 끝남.
		
		System.out.println("java 점수 입력 : ");
		int java = sc.nextInt();
		System.out.println("java : "+java+"점");
		
		System.out.println("sql 점수 입력 : ");
		int sql = sc.nextInt();
		System.out.println("sql : "+sql+"점");
		
		System.out.println("html 점수 입력 : ");
		int html = sc.nextInt();
		System.out.println("html : "+html+"점");
		
		System.out.println("============================");
		
		double total = java+sql+html;   // int total = java + sql + html
		System.out.println("총점 : "+total+"점");  // 세과목 총점 계산
		
		
		// double average = total/3.0;
		// 캐스팅 사용 : double average = (double)total/3;
		double average = total/3+total%3-(int)total%3;
		System.out.println("평균 : "+average+"점");  // 세과목 평균 계산
		
		if (average >= 90) {
			System.out.println("학점은 A입니다.");
		} else if (average >= 80){
			System.out.println("학점은 B입니다.");
		} else if (average >= 70){
			System.out.println("학점은 C입니다.");
		} else if (average >= 60){
			System.out.println("학점은 D입니다.");
		} else {
			System.out.println("학점은 F입니다.");
		}
		
		System.out.println("============================");
		
		
	}

}

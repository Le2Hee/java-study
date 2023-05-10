package edu.java.class07;

public class Student {
	// field
	int stuNo; // 학생 번호(학번)
	String name; // 학생 이름
	Score score; // 학생 (java, sql, html) 시험 점수
	
	// constructor
	// (1) 기본 생성자
	public Student() {
		score = new Score();
	}
	
//	public Student() {}  // 해석
	
	// (2) stuNO, name, score를 초기화할 수 있는 생성자
	public Student(int stuNo, String name, Score score) {
		this.stuNo = stuNo;
		this.name = name;
		score = new Score(score.java, score.sql, score.html);
		this.score = score;
	}
	// 해석
//	public Student(int stuNo, String name, Score score) {
//		this.stuNo = stuNo;
//		this.name = name;
//		this.score = score;
//	}
	
	// method
	// (1) printStudent - 학번, 이름, 세 과목 점수, 총점, 평균을 출력하는 메서드.
	public void printStudent() {
		System.out.printf("학 번 : %d\n이 름 : %s\n", stuNo, name);
		score.printScore();
		System.out.println("총 점 : " + score.getTotal());
		System.out.println("평 균 : " + score.getAvergae());
	}
	
	// 해석
//	public void printStudent() {
//		System.out.println("--- 학생 정보 ---");
//		System.out.println("학 번 : " + this.stuNo);
//		System.out.println("이 름 : " + this.name);
//		if (this.score != null) { // != : 아니다.
//			this.score.printScore();
//			System.out.println("총 점 : " + this.score.getTotal()); // getTotal 은 int를 출력
//			System.out.println("평 균 : " + this.score.getAvergae()); 
//		} else {
//			System.out.println("점수 없음");
//		}
//		System.out.println("------------------");
//	}
	
}

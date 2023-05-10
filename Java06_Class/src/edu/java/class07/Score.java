package edu.java.class07;

public class Score {
	// 필드 - 객체 속성(데이터).
	int java;  // java 과목 점수 0 ~ 100
	int sql;  // sql 과목 점수
	int html;  // html 과목 점수
	
	// 생성자 - 객체 생성 & 속성 초기화.
	// (1) 기본 생성자
	public Score () {}
	
	// (2) argument 3개를 가지는 생성자
	public Score(int java, int sql, int html) {
		this.java = java;
		this.sql = sql;
		this.html = html;
	}
	
	// 메서드 - 객체 기능.
	// (1) printScore - 세 과목 점수 출력
	public void printScore() {
		System.out.printf("Java 점수 : %d\nSQL 점수 : %d\nHTML 점수 :%d\n", java, sql, html);
	}
	
	// (2) getTotal - 세 과목 총점 리턴
	public int getTotal() {
		return java + sql + html;
	}
	
	// (3) getAvergae - 세 과목 평균 리턴(double)
	public double getAvergae() {
		return getTotal() / 3.0;
	}
	
	
}

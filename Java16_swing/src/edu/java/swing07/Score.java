package edu.java.swing07;

// MVC 아키텍쳐에서 model 객체
public class Score {
	private int korean;
	private int english;
	private int math;
	
	public Score() {}

	public Score(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal() {
		int total = this.korean + this.english + this.math;
		return total;
	}
	
	public double getMean() {
		double mean = (this.korean + this.english + this.math) / 3.0;
		return mean;
	}
	
	@Override
	public String toString() {
		return String.format("점수(국어 : %d, 영어 : %d, 수학 : %d, 총합 : %d, 평균 : %f)",
				korean, english, math, getTotal(), getMath());
	}
	
}

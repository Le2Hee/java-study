package edu.java.conditional06;

import java.util.Random;

public class ConditionalMain06 {

	public static void main(String[] args) {
		// Random 타입의 변수를 선언하고 초기화.
		// java 과목 점수를 난수(0~100)로 만들어서 저장.
		// sql 과목 점수를 난수(0~100)로 만들어서 저장.
		// html 과목 점수를 난수(0~100)로 만들어서 저장.
		// 합격/불합격 여부를 출력
		// 합격 조건 : 3과목의 점수가 모두 40점 이상이고, 세 과목의 평균이 60점 이상.
		
		Random random = new Random();
		/*
		 * 내 답안지
		int java = random.nextInt(101);
		System.out.println("java 점수 : "+java);
		int sql = random.nextInt(101);
		System.out.println("sql 점수 : "+sql);
		int html = random.nextInt(101);
		System.out.println("html 점수 : "+html);
		
		int total = java+sql+html;
		System.out.println("총점 : "+total);
		
		double average = total/3.0;
		System.out.println("평균은 : "+average);
		
		String result = ((java>=40)&&(sql>=40)&&(html>=40)&&(average)>=60)?"합격":"불합격";
		System.out.println("최종결과 : "+result);
		*/
		
		// 답
		int java = random.nextInt(101);  // 0이상 101 미만(100이하)의 난수
		System.out.println("java 점수 :"+java); 
		
		int sql = random.nextInt(101); 
		System.out.println("sql 점수 :"+sql); 
		
		int html = random.nextInt(101); 
		System.out.println("html 점수 :"+html); 
		
		double average = (double)(java+sql+html)/3; //double total = (java+sql+html)/3.0;
		System.out.println("평균은 : "+average);
		
		//if문
		if (java>=40&&sql>=40&&html>=40&&average>=60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		//삼항 연산자
		String result = (java>=40&&sql>=40&&html>=40&&average>=60)?"합격":"불합격";
		System.out.println(result);
		
	}

}

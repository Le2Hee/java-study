package edu.java.class07;

public class ClassMain07 {

	public static void main(String[] args) {
		Score sc1 = new Score(83, 58, 94);
		sc1.printScore();
		System.out.println("총점은 : " + sc1.getTotal());
		System.out.println("평균은 : " + sc1.getAvergae()); 
		
		System.out.println("========================================================");
		
		Student st1 = new Student(170206, "이찬희", sc1);
		st1.printStudent();
		
		System.out.println("========================================================");
		
		Student st2 = new Student();
		st2.printStudent();
		
		System.out.println("========================================================");
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("========================================================");
		
		// null 의미
		// 생선된 객체가 없습니다. (객체에 주소값이 없습니다.)/찾아갈수가없다.
		
		// String s = "";
		  // stack에 s가 있고 힙공간에 ""객체가 만들어져 있다.
		  // s는 ""를 찾아가는 주소값이 저장되어 있다.
		// String s = null;
		  // null은 주소값이 없으니까 stack에 s가 0으로 채워져있는데 그게 찾아갈수 없다
//		     라는 의미한다. (0이상의 수로 주소값으로 인식하고 찾아간다.)
		  // 프린트에서 null이 나오는 이유는 찾아갈수없는데  s를 찾아가보니 null이 있다.
		
		String emptyString = ""; // 문자열 객체가 있는 것, 그 대신 문자를 하나도 안가진거 일뿐.
		System.out.println("길이 : " + emptyString.length());
//		String nullString = null;
//		System.out.println("길이 : " + nullString.length());
		 // -> NullPointException 발생
		 // 실행하면 오류가 난다.
		 // nullString이 문제가 있는 것
		 // 문자열이 생성되지 않는 상태인데 문자열 수를 알수가 없다.
		 // null인데 null이 가르키는곳을 찾을려한다.(null은 만들어지지 않은 상태)
		
		// 데이터 타입의 기본값 :
		// (1) boolean - false, (2) 정수 - 0, (3) 실수 - 0.0, (4) 참조(클래스) 타입 - null
		
		
	}

}

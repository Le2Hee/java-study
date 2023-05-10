package equ.java.string;

public class StringMain {

	public static void main(String[] args) {
		// Ex 1. 아래의 주민번호 문자열에서 성별을 표시하는 위치에 문자만 출력.
		String ssn = "991231-1234567";
		char c = ssn.charAt(7);
		System.out.println("성별 번호 : " + c);
		System.out.println("남 자 : 1, 3  /  여 자 : 2, 4");
		
		System.out.println("===================================================================");
		
		// Ex 2. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력
		// 만약에 "홍길동" 문자열이 배열에 없으면 -1을 출력.
		String[] names = {"오쌤", "John", "Jane", "홍길동", "허균", "홍길동"};
//		for (int i = 0; i < names.length; i++) {
//			if (names[i].contains("홍길동") == true) {
//				System.out.printf("홍길동 Index 번호 : %d\n", i);
//				break;
//			}
//		}
		// 풀이
		int index = -1;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals("홍길동")) {
				index = i;
				break;
			}
		}
		System.out.println("홍길동 인덱스 : " + index);
		
		
		System.out.println("===================================================================");
		
		// Ex 3. 아래의 문자열 배열에서 5글자 이상인 문자열들을 찾아서 출력. 
		String[] languages = {"Java", "SQL", "HTML", "CSS", "JavaScript", "Python"};
		for (int i = 0; i <languages.length; i++) {
			if (languages[i].length() >= 5) {
				System.out.print(languages[i] + "  ");
			}
		}
		System.out.println();
		System.out.println("===================================================================");
		
		// Ex 4. 아래의 문자열 배열에서 대소문자 구별없이 "est"가 포함된 문자열들을 찾아서 출력.
		String[] tests = {"TEST", "test", "TeSt", "tEST", "테스트"};
		for (int i = 0; i < tests.length; i++) {
			if (tests[i].toLowerCase().contains("est") == true) {
				System.out.print(tests[i] + "  ");
			}
		}
		
		System.out.println();
		// 해석
		for(String x : tests) {
			if (x.toLowerCase().contains("est") == true) {
				System.out.print(x + "  ");
			}
		}
		
//		System.out.println("TEST".);
		// "TEST"에다가 . 을 해도 String 클래스의 메서드를 이용할 수 있다.
		
		System.out.println();
		System.out.println("===================================================================");
		
		
		// Ex 5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 연/월/일 정보를 int 타입 변수에 저장하고 출력.
		String date = "2023-03-22";
		int year;
		int month;
		int day;
		
		String[] dateArr= date.split("-");
		
		year = Integer.parseInt(dateArr[0]);
		System.out.println("년도 : " + year);
		
		month = Integer.parseInt(dateArr[1]);
		System.out.println("월 : " + month);
		
		day = Integer.parseInt(dateArr[2]);
		System.out.println("일 : " + day);
		
	}

}

package eud.java.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		// 문자열 3개를 저장할수 있는 배열(names)을 선언, 초기화.
		String[] names = new String[3];
		
		// 배열 names에 문자열을 저장.
		names[0] = "이찬희";
		names[1] = "지대한";
		names[2] = "김다훈";
		
		// 배열의 names의 내용 한 줄로 출력
		// (1) for 구문 사용
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " ");
		}
		
		System.out.println();
		System.out.println("====================");
		
		// (2) for-each 구문 사용
		for (String i : names) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("====================");
		
		String[] subject = {"Java", "SQL", "HTML", "JavaScript"};
		
		for (String s : subject) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		System.out.println("====================");
		
		
		
	}

}

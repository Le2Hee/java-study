package eud.java.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
		// int 10개를 저장할 수 있는 배열을 선언.
		int[] genderCodes = new int[10];
		
		// 배열에 난수(0, 1) 10개를 저장.
		Random rand = new Random();
		for (int i = 0; i < genderCodes.length; i++) {
			genderCodes[i] = rand.nextInt(2);
		}
		
		// 배열에 내용을 출력.
		for (int i : genderCodes) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// 문자열 10개를 저장할 수 있는 배열(genders)을 선언.
		String[] genders = new String[10];
		
		// genderCodes의 값이 0이면 "Male", 1이면 "Female"을 문자열 배열에 저장.
		for (int i = 0; i < genders.length; i++) {
			if (genderCodes[i] == 0) {
				genders[i] = "Male";
			} else {
				genders[i] = "Female";
			}
		}
			
		
		// 문자열 배열 genders의 내용을 출력.
		for (String x : genders) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		//문자열 배열에 저장된 "Male"의 개수, "Female"의 개수를 출력
		int f = 0;
		for (int i = 0; i < genderCodes.length; i++) {
			if (genderCodes[i] == 1) {
				f = f + 1;
			}
		}
		System.out.println("Male 개수 : " + (genderCodes.length - f));
		System.out.println("Female 개수 : " + f);
		
		// (힌트) 두 숫자 x, y가 같은 지 비교 : x == y 이렇게 비교 하면 됨.
		
		
		// (힌트) 두 문자열 x,y가 같은 지 비교 : x.equals(y) 로 비교를 해야 됨.
		
		int numOfMales = 0; // Male 개수를 저장할 변수
		int numOfFemales = 0; // Female 개수를 저장할 변수
		for (String s : genders) { // 배열 genders의 원소들을 순서대로 반복하면서
			if (s.equals("Male")) { // 배열에서 읽은 값이 "Male"과 같으면
				numOfMales++; // 남성의 숫자를 1 증가
			} else if (s.equals("Female")) { // 배열에서 읽은 값이 "Female"과 같으면
				numOfFemales++; // 여성의 숫자를 1 증가
			}
		}
		System.out.println("# of Male = " + numOfMales);
		System.out.println("# of Female = " + numOfFemales);
		
		// 이 클래스의 코드가 2개의 배열이 수가 똑같기 때문에
		// int count = 10; 이라고 변수를 설정해서
		// int[] genderCodes = new int[count];
		
		// int[] genders = new int[count];
		// 라고 설정이 가능하다.
		// 이런 경우 에서는 변수 count에 값만 변경하면 2개의 배열을 동시에 수정할수 있다.
		// 이런 경우 반복문을 사용할때 genderCodes.length 값대신에 count를 사용할수 있다.
		
	}

}

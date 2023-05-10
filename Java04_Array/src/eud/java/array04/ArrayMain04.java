package eud.java.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		// 정수 5개를 저장할 수 있는 배열을 선언.
        // 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
        // 배열의 내용을 출력.
        // 배열의 모든 원소의 합을 계산하고 출력.
        // 배열 원소들의 평균을 double 타입으로 계산하고 출력.
		
		Random random = new Random();
		int[] ran = new int[5];
		for (int a = 0; a < ran.length; a++) {
			int min = 0;
			int max = 9;
			int b = random.nextInt(min, max);  // 10까지 하면 0~9까지 나오기 때문에 변수 설정할필요없다.
			ran[a] = b; // 난수가 b이고 b가 ran에 저장하는거기 떄문에 굳이 b변수를 선언 안해도 된다.
			System.out.print(ran[a] + " ");
		}
		
		System.out.println();
		
		int sum = 0;
		for (int t : ran) {
			sum = sum + t;
		}
		System.out.println("총합 : "+sum);
		double average = (double)sum/ran.length;
		System.out.println("평균 : " + average);
		
	}

}

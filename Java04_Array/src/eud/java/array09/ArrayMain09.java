package eud.java.array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
		int[][] num = new int[3][];
		
        // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
		int num0 = 2;
		int num1 = 3;
		int num2 = 4;
		num[0] = new int[num0];
		num[1] = new int[num1];
		num[2] = new int[num2];
		
//		Random rand = new Random();
//		for(int i = 0; i < num.length; i++) {
//			num[i] = new int[i+2];
//			for (int j; j < num[i].length; j++) {
//				num[i][j]
//			}
//		}
		
		// 저장하는 난수의 범위는 0 이상 100 이하.
		Random rand = new Random();
		for(int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				num[i][j] = rand.nextInt(101);
			}
		}
        
		// 2차원 배열의 원소들을 출력.
		for (int[] x : num) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
        
		// 2차원 배열의 모든 원소들의 합을 계산하고 출력.
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				sum = num[i][j] + sum;
			}
		}
		System.out.println("총합 : " + sum);
        
		// 해석
//		int sum = 0; //배열의 원소들의 합을 저장하기 위한 변수
//		int count = 0; //배열의 원소들의 개수를 저장하기 위한 변수
//		for (int[] arr : num) {
//			for(int x : arr) {
//				sum += x;  // 배열에서 읽은 값은 합계에 더 함.
//				count++; // 배열의 원소의 개수는 1 증가.
//			}
//		}
//		System.out.println("su, : " + sum);
//		System.out.println("count : " + count);
		
		// 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
		double average = (double)sum / (num0+num1+num2);
		System.out.println("평균 : " + average);
		
		// 해석
//		double average = (double)sum / count;
//		System.out.println("평균 : " + average);
        
		// 최댓값을 찾고 출력.
        int max = num[0][0];
        for (int i = 0; i < num.length; i++) {
        	for (int j = 0; j < num[i].length; j++) {
        		if (max < num[i][j]) {
        			max = num[i][j];
        		}
        	}
        }
		System.out.println("최댓값 : " + max);
		
//		int max = num[0][0];
//		for (int[] arr : num) { // 2차원 배열의 원소인 1차원 배열들에 대해서
//			for (int x : arr) { // 그 1차원 배열의 각 원소 (정수)들에 대해서
//				max = (x > max) ? x : max; //삼항 연산자
//			}
//		}
//		System.out.println("최댓값 : " + max);
		
		// 최솟값을 찾고 출력.
		int min = num[0][0];
        for (int i = 0; i < num.length; i++) {
        	for (int j = 0; j < num[i].length; j++) {
        		if (min > num[i][j]) {
        			min = num[i][j];
        		}
        	}
        }
		System.out.println("최솟값 : " + min);
		
		
//		int max = num[0][0];
//		for (int[] arr : num) { // 2차원 배열의 원소인 1차원 배열들에 대해서
//			for (int x : arr) { // 그 1차원 배열의 각 원소 (정수)들에 대해서
//				min = (x < min) ? x : min ; //삼항 연산자
//			}
//		}
//		System.out.println("최댓값 : " + max);
		
		
	}

}

package eud.java.array04;

import java.util.Random;

public class ArrayMain041 {

	public static void main(String[] args) {
		// 풀이 클래스
		
		// 정수 5개를 저장할 수 있는 배열을 선언.
		int [] numbers = new int[5];
		
        // 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
		Random rand = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(10);
		}
		
        // 배열의 내용을 출력.
		for (int x : numbers) {
			System.out.print(x + " ");
		}
		System.out.println();
		
        // 배열의 모든 원소의 합을 계산하고 출력.
		int sum = 0;
		// for문
//		for (int i = 0; i < numbers.length; i++) {
//			sum += numbers[i];  //sum = sum + numbers[i]; 이걸 간단하게 쓴것
////			System.out.println("sum : " + sum); , for 안에다가 하면 sum이 계산되는 순서를 알수있다.
//		}
		// 위쪽 for문과 밑에 있는 for-each 구문이랑 같은 결과 값을 가지고 있다.
		// for-each 문
		for (int x : numbers) { 
			sum += x;
		}
		System.out.println("sum : " + sum);
		
        // 배열 원소들의 평균을 double 타입으로 계산하고 출력.
		double average = (double) sum / numbers.length;
		System.out.println("average : " + average);
		
		// 배열의 원소들 중 최댓값을 찾고 출력.
		int max = numbers[0];  // 배열의 첫번째(인덱스 0번 위치의) 원소를 최댓값이라고 가정.
		for (int x : numbers) { // 배열 numbers의 모든 원소들을 순회하면서
			if (x > max) { // 배열에서 읽은 값이 max보다 크다면
				max = x; // max의 값을 x로 변경.
			}
		}
		System.out.println("최대값 : " + max);
		
		// 배열의 원소들 중 최솟값을 찾고 출력.
		int min = numbers[0]; // 배열의 첫번째 원소를 최솟값이라고 가정.
		for (int y : numbers) { // 배열의 모든 원소를 순서대로 반복하면서,
			if (y < min) { // 배열에서 읽은 값이 min 보다 작다면
				min = y; // min의 값을 y(배열에서 읽은 더 작은 값)로 변경.
			}
		}
		
		System.out.println("최소값 : " + min);
		
		
		
		
	}

}

package eud.java.array07;

//import java.util.Random;

public class ArrayMain07 {

	public static void main(String[] args) {
		// 2차원 배열 : 1차원 배열들을 원소로 갖는 배열.
		// 2차원 배열의 원소를 참조할 때 인덱스가 2개 필요함.
		int[][] array = {
				{1, 2, 3, 4},
				{5, 6, 7, 8, 9},
				{10, 11, 12}
		};
		
		// 2차원 배열의 인덱스
		System.out.println(array);  // 2차원 배열
		System.out.println(array[0]);  // 2차원 배열의 인덱스 i번째 원소는 1차원 배열
		System.out.println(array[0][0]);  // 2차원 배열에서 인덱스[i,j] 번째 원소는 값 1개.
		System.out.println(array[1][3]);
		
		// 2차원 배열의 length
		System.out.println(array.length); // array배열의 원소 개수
		System.out.println(array[0].length); // array[0] 배열의 원소 개수 (1,2,3,4) 4개
		System.out.println(array[1].length); // array[1] 배열의 원소 개수 (5,6,7,8,9) 5개
		System.out.println(array[2].length); // array[2] 배열의 원소 개수 (10,11,12) 3개
		
		// for 구문(인덱스를 사용)을 사용한 2차원 배열 출력.
//		Random rand = new Random();
//		int[] num = new int[5];
//		for (int i = 0; i < num.length; i++) {
//			num[i] = rand.nextInt(10);
//		}
//		int[] num2 = new int[8];
//		for (int i = 0; i < num2.length; i++) {
//			num2[i] = rand.nextInt(10);
//		}
//		int[][] resut = {num, num2};
//		for (int i=0; i < resut.length; i++) {
//			for (int j=0; j < resut[i].length; j++) {
//				System.out.print(resut[i][j] + "\t");
//			}
//			System.out.println();
//		}
		
		System.out.println("=====해석=====");
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		
		
		// for-each구문(인덱스를 사용하지 않는)을 사용한 2차원 배열 출력.
		for (int[] x : array) {
			for (int y : x) {
				System.out.print(y + "\t");
			}
			System.out.println();
		}
		
		
		
	}

}

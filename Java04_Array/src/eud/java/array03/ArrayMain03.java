package eud.java.array03;

public class ArrayMain03 {

	public static void main(String[] args) {
		// Ex 1.
		// 정수(int) 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 0, 2, 4, 6, 8, 10, ...., 18를 저장 하세요.
		// 배열의 원소들을 한 줄로 출력.
		
		// Ex 2.
		// boolean 타입 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 true, false, true, false, ..., false 를 저장.
		// 배열의 원소들을 한 줄로 출력.
		
		int[] even = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
		for (int i : even) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("=======================================================");
		
		boolean[] boo = new boolean[10];
		for (int t = 0; t < boo.length; t++) {
			if (t == 0) {
				boo[t] = true;
			} else if (t%2==1) {
				boo[t] = false;
			} else if (t%2==0) {
				boo[t] = true;
			}
		}
		for (boolean q : boo) {
			System.out.print(q + " ");
		}
		
		System.out.println();
		System.out.println("=========================해석=========================");
		
		int[] evens = new int[10];
		
		for (int i = 0; i < evens.length; i++) {
			evens[i] = i * 2;
		}
		for (int x : evens) {
			System.out.print(x + " ");
		}
		
//		for (int x : evens) {
//			x = n * 2;
//			n++;
//		}
		// 변수 x값이 변하는 거지 evens 안에 배열 값이 바뀌는게 아니다 .
		// for-each 구문은 글을 출력하기 위한 구문이지 evens안에 있는 배열을 바꾸는 것이 아니다.
		// 이렇게 하면 안됨!!
		
		System.out.println();
		
		boolean[] isEven = new boolean[10];
		
		for (int i=0; i < isEven.length; i++) {
			if (i % 2 == 0) {
				isEven[i] = true;
			} else {
				isEven[i] = false;
			}
		}
//		for (int i=0; i < isEven.length; i++) {
//			if (i % 2 == 0) {
//				isEven[i] = true;
//			}
//		}
		// 이렇게 해도 같은 값이 나온다.
		// boolean 배열이라고 선언하면 기본 적으로 false가 기본값으로 채워진다.
		// (int 배열이 0인것 처럼 boolean은 false가 기본값이다.)
		
		for (boolean b : isEven) {
			System.out.print(b + " ");
		}
		
		
		
		
	}

}

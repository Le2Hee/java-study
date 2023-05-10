package edu.java.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		// 복합 할당 연산자 : +=, -=, *=, /=, %=, ...  (2개의 연산자가 합쳐서 하나가 되어 복합이라고 한다.)
		int x = 10;
//			x = x + 1; 을 좀 더 편하게 하면 += 이 된다.
		x += 2; //(x에다가 더하기 1을 하고 그 결과를 x에 다시 저장하겠다.)
		System.out.println("x = "+x);
		
		// System.out.println : print line. 출력하고 줄바꿈
		System.out.println("test");
		
		// System.out.print : 출력하고 줄바꿈이 일어나지 않는다. 출력이 끝난 위치에 커서가 위치.
		System.out.print("test1");
		System.out.print("test2");
		System.out.println("test3");
		
		// 결과 : 0 2 4 6 8 10
		// 0부터 10까지 사이에 짝수들을 한 줄에 출력하는 프로그램을 만들기
		
		// 1 3 5 7 9
		// 10이하의 홀수들을 한 줄에 출력
		
		
		// 내 답안
		int n = 0;
		for (n=-2; n<=8;) {
			n += 2;
			System.out.print(n+ " ");
		}
		
		System.out.println();
		
		for (n=-1; n<=7;) {
			n += 2;
			System.out.print(n+ " ");
		}
		
		System.out.println();
		System.out.println("======답안======");
		
		// 답안
		for(int m = 0;m <= 10; m += 2) { // int m 은 변수 설정하고 m <= 10 조건을 걸고 m +=2 반복문을 설정한다 (순서)
			System.out.print(m+" "); // 복합,프린트물 활용          // 조건을 만족할때 까지 반복한다.
		}
		
		System.out.println(); // 줄바꿈
		
		for (int m = 0; m <=5; m++) {
			System.out.print((2 * m) + " ");
		}
		
		System.out.println();
		
		for (int m =0; m <=10; m++) { // for 과 if 를 동시 사용
			if (m%2==0) {
				
				
				System.out.print(m+" ");
			}
		}
		
		System.out.println();
		
		
		
	}

}

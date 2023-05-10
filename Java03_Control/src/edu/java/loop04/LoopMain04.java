package edu.java.loop04;

public class LoopMain04 {

	public static void main(String[] args) {
		// 반목문에서 break와 continue 차이점
		
		// break 가 어떻게 동작하는지만 설명하는 코드
		for (int n = 1; n <= 5; n++) {
			if (n == 3) {
				break; // break; : for문을 나가라 (4,5로 넘어가지 않는다.) / 3에서도 멈춰서 출력이 안된다.
				// break가 포함된 가장 가까운 반복문을 종료.
			}   
			System.out.println(n);
			
		}
		
		System.out.println("============");
		
		for (int n = 1; n <= 5; n++) {
			if (n == 3) {
				continue;  // 계속해라 (돌아가는 과정을)  // continue - 계속하다.
				// 돌아가는 과정을 진행할때 아래있는 코드를 무시한다.
				// 다시 돌아가기 때문에 프린트는 실행되지 않아 3은 프린팅 되지않는다.
				// 돌아가는 과정을 계속하는데 이 위치에서 다시 돌아가라.
				// continue 아래의 코드들은 실행하지 않고, 그 다음 반복을 계속해서 수행.
			}
			System.out.println(n);
			
		}
		
		
		
	}

}

package edu.java.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		// 구구단 2단은 2x2 까지, 3단은 3x3까지, 4단은 4x4까지, ... , 9단은 9x9까지 출력
		
		// while 문
		
		int x = 2;
		while (x < 10) {
			System.out.println("=== " + x + "단 ===");
			
			int y = 1;
			while (y <= x) {
				System.out.printf("%d x %d = %d\n", x, y, x * y);
				y++;
			}
			x++;
		}
		
		System.out.println("\n=======================\n");
		
		// break 문 사용
		
		for (int z = 2; z < 10; z++) {
			System.out.println("==== " + z + " 단===");
			for (int q = 1; q < 10; q++) {
				System.out.printf("%d x %d = %d\n", z, q, z * q);
				if (z==q) {
					break;
				}
			}
		}
		
		// 해석
		
		// for 문 break 쓰는 버전
		
		for(int z = 2; z < 10; z++) {
			System.out.println("=== " + z + "단 ===");
			for (int y = 1; y < 10; y++) {
				System.out.printf("%d x %d = %d\n", z, y, z * y);
				if (z == y) {
					break;
				} // end for - if
			} // end for - for
		} //  end for
		
		System.out.println("\n=====================================\n");
		
		// for문 break 없이 만드는 코드
		
		for (int z = 2; z < 10; z++) {
			System.out.println("=== " + z + "단 ===");
			for (int y = 1; y <= z; y++) { //조건문을 변경해서 만드는 경우
				System.out.printf("%d x %d = %d\n", z, y, z * y);
			}
		}
		
		// while 문
		
		int a = 2;
		while (a < 10) {
			System.out.println("=== " + a + "단 ===");
			int b = 1;
			while (b < 10) {
				System.out.printf("%d x %d = %d\n", a, b, a * b);
				if ( a == b ) {
					break;
				}
				b++;
			}
			a++;
		}
		
		System.out.println("\n=====================================\n");
		
		a = 2;
		while (a < 10) {
			System.out.println("=== " + a + "단 ===");
			int b = 1;
			while (b <= a) {
				System.out.printf("%d x %d = %d\n", a, b, a * b);
				b++;
			}
			a++;
		}
		
		
		
		
	}

}

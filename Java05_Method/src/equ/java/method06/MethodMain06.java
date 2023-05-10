package equ.java.method06;

public class MethodMain06 {

	public static void main(String[] args) {
		// 재귀 메서드 : 메서드 안에서 자기 자신을 다시 호출하는 메서드.
		// 진짜 드물게 사용한다.
		
		for (long n = 0; n < 6; n++) {
			System.out.printf("%d! = %d,%d\n", n, factorial(n),facrotial2(n));
		}
		
		
		
		
		
	}
	
	/**
	 * n factorial(n!)을 계산해서 리턴하는 메서드.
	 * 0! = 1,
	 * 1! = 1 = 0! * 1,
	 * 2! = 1 * 2 = 1! * 2,
	 * 3! = 1 * 2 * 3 = 2! * 3,
	 * 일반적으로 n! = 1 * 2 * 3 * ... * (n-1) * n = (n-1)! * n 이라고 쓸수있다.
	 * @param n 정수.
	 * @return 계산된 factorial 결과 값. n이 음의 정수이면 무조건 -1을 리턴하겠다.
	 */
	public static long factorial(long n) {
		long result = -1;  // 음수 factorial은 계산 하지 않을꺼니깐 초기 리턴값을 -1로 지정.
		
		if (n == 0) { // 0!을 계산 하겠다. 0!은 1이라고 약속.
			result = 1;
		} else if (n > 0) { // n! = (n-1)! x n
		// else if 를 넣은 이유는 음의 정수도 포함되기 때문에 if를 추가 한것이다.
		// -를 넣으면 끝없이 음의 정수로 내려가서 끝이 나지 않는다.
		// 이런걸 스택오버플로어라고 한다.
			result = factorial(n -1) * n; // factorial인데 factorial을 호출하고 있다.
			                               // 이걸 재귀 메서드라고 한다.
			            					// 재귀 호출
		}
		
		return result;
	}
	
	// 재귀 호출을 사용하지 않은 factorial
	public static long facrotial2(long n) {
		long result = -1;
		
		if (n == 0) {
			result = 1;
		} else if (n > 0) {
			result = 1;
			for (long x = 1; x <= n; x++) {
				result *= x;
			}
		} 
		
		return result;
		
		
	}
	
	

}

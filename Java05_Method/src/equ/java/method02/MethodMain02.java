package equ.java.method02;

import java.util.Random;

public class MethodMain02 {

	public static void main(String[] args) {
		// argument를 가지고, 리턴 값이 있는 메서드를 작성/호출 하는 연습.
		
		// 같은 클래스 안에서 작성한 메서드의 경우에는 메서드 이름으로만 호출하면 됨.
		double result = add(1, 2);  // 메서드 호출. 메서드를 사용한다. argument - 1, 2 
		System.out.println(result);
		
		result = subtract(100, 10);
		System.out.println(result);
		
		result = multiply(100, 10);
		System.out.println(result);
		
		result = divide(100, 10);
		System.out.println(result);
		
		int n = 4;
		boolean x = isEven(n);
		System.out.println(x);
		System.out.println(isEven(7));
		// isEven 6 값을 메서드에서 받은 후 출력해라.
		
		int o = 5;
		makeArray(o);
		for (int q : makeArray(o)) {
			System.out.print(q + " ");
		}
//		int[] arr = makeArray(5);
//		for (int q : arr) {
//			System.out.print(q + " ");
//		}
		
		
	}
	
	                          // 두 변수가 같은 타입이라고 해서 타입을 하나만 쓰면안됨.
               //메서드 타입  //여기서 ; 사용하면 끝난다는 의미이기 때문에 ,로 구별.
	/**
	 * 실수 2개를 전달 받아서 덧셈 결과를 리턴하는 메서드
	 * @param x 실수(double) 타입
	 * @param y 실수(double) 타입
	 * @return x + y를 리턴한다.
	 */
	public static double add(double x, double y) {
		// 메서드 정의(선언)
		// 메서드 수식어 - public static
		// 메서드 리턴 타입 - double
		// 메서드 이름 - add
		// 파라미터(parameter) - double x, double y
		
		return x + y; // 리턴 문장. x + y -> 리턴 값
		// return : 되돌려 주다. (x + y)를 되돌려주겠다 -> 메서드를 호출한 곳에
		
	}
	
	/**
     * subtract
     * 숫자 2개를 전달받아서, 뺄셈의 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x - y.
     */
    public static double subtract(double x, double y) {
    	return x - y;
    }
    
    /**
     * multiply
     * 숫자 2개 전달받아서 곱셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x * y.
     */
    public static double multiply(double x, double y) {
    	return x * y;
    }
    
    /**
     * divide
     * 숫자 2개를 전달받아서, 나눗셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x / y.
     */
    public static double divide(double x, double y) {
    	return x / y;
    }
    
    /**
     * isEven
     * 정수가 짝수인 지 아닌 지를 리턴하는 메서드.
     * @param n 짝수인 지 홀수인 지 검사할 정수.
     * @return n이 짝수이면 true, 그렇지 않으면 false.
     */
    public static boolean isEven(int n) {
//    	if (n % 2 == 0) {
//    		return true;
//    	} else {
//    		return false;
//    	}
    	
    	// return을 한번만 쓸려면 아래 처럼 코드를 작성 할수있다.
    	// 개발자의 스타일에 따라서 위 아래 코드가 달라진다.
//    	boolean result = false; // 짝수인 지, 홀수인 지를 저장할 변수.
//    	if (n % 2 == 0) {
//    		result = true;
//    	} else {
//    		result = false;
//    	}
//    	return result;
    	
    	// 또 다른 코드
    	return n % 2 == 0;
    	// n이라는 짝수가 들어가면 0과 같아서 true가 되고
    	// n이라는 홀수가 들어가면 0과 달라서 false가 될수있다.
    	// boolean 타입은 대부분 이런 느낌으로 한다. (코드를 줄이는 방법)
    	
    	
    }
    // return : 메서드가 할일이 끝났다. 만든 값을 돌려주겠다. (2가지 의미가 있다.)
    // if-else 는 2개 처럼 보이지만은 하나로 볼수있다.
    
    /**
     * makeArray
     * argument로 전달된 배열의 길이 크기의 정수 배열을 생성하고,
     * 임의의 난수들로 배열을 초기화해서 리턴하는 함수.
     * @param length 배열의 길이. 양의 정수.
     * @return length개의 난수들로 초기화된 정수 배열.
     */
    public static int[] makeArray(int length) {
//    	Random random = new Random();
//    	int[] i = new int[length];
//    	for (int j = 0; j < length; j++ ) {
//    		i[j] = random.nextInt(100);
//    	}
//    	return i;
    	
    	// 해석
    	int[] array = new int[length];
    	
    	Random rendom = new Random();
    	for (int i = 0; i < array.length; i++) { // array.length 와 length 는 똑같은 값이여서 둘다 가능하다.
    		array[i] = rendom.nextInt();
    	}
    	
    	return array;
    	
    }
    
    // return을 하고 나서는 그 밑에는 문장이 있을수 없다.
    
	
}

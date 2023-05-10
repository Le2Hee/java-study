package equ.java.exception05;

public class Calculator {
	
	// y가 0이 되면 Exception이 나오게 만들 수 있다.
	public int divide(int x, int y) throws Exception {
		if (y != 0) {
			return x / y;
			// return 문 : (1) 메서드 종료.
			//             (2) 값을 메서드 호출한 곳에 반환. 
		}
		
		throw new Exception("y는 0이 될 수 없습니다.");
		// throw : 메서드를 호출한 곳으로 예외 객체를 던진다.
		//     -> 선언문에 throws Exception이 없으면 에러난다.
		// Exception 생성자를 생성해준다.
		
		// 키워드 주의 : 
		  // 선언문에는 throws라고 하고 생성자를 만들때 throw를 사용한다.
	}

}

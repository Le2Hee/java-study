package edu.java.modifier06;

// final 수식어 : - 마지막에 있는, 최종적인 / 변경할 수 없는
   // final 지역 변수 가능.
     // 변경할 수 없는 지역 변수 = 상수(constant)
     // 초기화 이후에는 값을 변경할 수 없는 변수.
  
   // final 클래스 멤버(필드, 생성자, 메서드) 가능하다.
     // 변경할수 없는 클래스 멤버
     // 대부분 생성자를 final로 만드는 경우는 없다. (안되는건 아님)
     // final 메서드는 상속을 배워야 할 수 있다.
     // final 필드(멤버 변수)는 반드시 초기화를 하는 문장을 명시해야 한다.
       // (1) 필드 선언과 동시에 값을 초기화 하는 방법.
       // (2) argument를 갖는 생성자를 사용해서 값을 초기화하는 방법. ( 관습적으로 한다.)
         // (2)-1 argument를 가지고 있지 않아도 사용할 수 있다.

   // final 클래스
     // 상속할 수 없는 클래스.
     // final 클래스는 상속을 배워야 할 수 있다.
     // 변경할 수 없는 클래스.

   // 멤버 변수, 지역 변수 둘다 사용할수 있는 수식어중 유일하다.

public class ModifierMain06 {
	
	private static final int VERSION = 1; // 선언과 동시에 초기화.
	// 파이널은 변수를 대문자로 쓴다. 바꿀수 없다는걸 강조하기 위해
	
	private final int test;  // final 필드를 선언할 때 초기화하지 않는 경우에는 
//							    반드시 argument를 갖는 생성자를 이용해서 
//							    final 필드를 초기화해야 함.
	// 	"private final int test;" -> 이러면 에러가 난다. 
	//								-> 파이널이 생성된 변수인데 초기화가 안되어 있다.
	//	  							  -> 생성자를 생성해서 초기화할 수 있다.
	
	// argument를 갖는 생성자를 사용해서 값을 초기화하는 방법. -> 초기화된 이후에는 변경 불가.
	public ModifierMain06(int test) {
		this.test = test;
	}
	
	// argument를 가지고 있지 않아도 사용할 수 있다.
	public ModifierMain06() {
		this.test = 0;
	}
	

	public static void main(String[] args) {
		final int x = 1;
//		x = 2;  final로 선언된 지역 변수는 재할당(값 변경)할 수 없다.
		
//		VERSION = 2;  final로 선언된 멤버(필드) 변수는 재할당(값 변경)할 수 없다.
		
		
		
	}

	
}

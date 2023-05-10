package equ.java.exception03;

public class ExceptionMain03 {

	public static void main(String[] args) {
		// finally 블록 :
		  // 예외 발생 여부와 상관 없이 "반드시" 마지막에 실행.
		  // try 블록이 정상적으로 모두 실행이 끝난 후
		  // 또는 예외가 발생해서 catch블록의 실행이 끝난 후에 finally 블록이 실행 된다.
		  // (주의) try 블록 또는 catch블록 안에 return 문장이 있는 경우에도
		  //        finally 블록을 실행한 후에 return 문장이 실행됨!!!
		try { // (1)
			int x = 100;
			int y = 5;
			System.out.println("몫 = " + (x / y));
			System.out.println("--- try 블록 끝 ---");
			
		} catch (ArithmeticException e) { // (2)
			System.out.println("0으로 나눌수 없음.");
			System.out.println("--- catch 블록 끝 ---");
			
		} finally { // (3)
			System.out.println("언제 실행될까요?");
			
		}
		
		System.out.println("--- main mathod 종료 ---"); // (4)
		// (1) -> (3) -> (4)   Exception 없으니까 (2)가 넘어간다.
		
		System.out.println("===================================================================");
		
		try { // (1)
			int x = 100;
			int y = 0;
			System.out.println("몫 : " + (x / y));
			System.out.println("---try 블록 끝---");
			
		} catch (ArithmeticException e) { // (2)
			System.out.println("0으로 나눌수 없음.");
			System.out.println("---catch 블록 끝---");
			
		} finally { // (3)
			System.out.println("언제 실행될까요?");
			
		}
		
		System.out.println("---main mathod 종료---"); // (4)
		// (1).33번까지 -> (2) -> (3) -> (4)
		
		System.out.println("===================================================================");
		
		try { // (1)
			int x = 100;
			int y = 0;
			System.out.println("몫 : " + (x / y));
			System.out.println("---try 블록 끝---");
			
		} catch (ArithmeticException e) { // (2)
			System.out.println("0으로 나눌수 없음.");
			System.out.println("---catch 블록 끝---");
			return;  // void 메서드를 종료합니다.
			
		} finally { // (3)
			System.out.println("언제 실행될까요?");
			
		}
		
		System.out.println("---main mathod 종료---"); // (4)
		// (1).33번까지 -> (2) -> (3)  finally는 "무조건" 실행된다.
		// 							   return은 main을 끝내는데 main을 끝내기전에
		//							   finally를 실행하고 return이 되고 main이 끝났기 때문에
		//   						   (4)은 실행이 되지않는다.
		// -> try-catch 문에도 return을 사용할 수 있다.
	}

}

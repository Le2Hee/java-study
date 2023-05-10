package edu.java.lambda01;

import edu.java.lambda01.Calculator.Calculable;

public class LambdaMain01 {

	public static void main(String[] args) {
		// Calculator 타입의 객체 생성
		Calculator calc = new Calculator(1, 2);
		// Calculable 인터페이스 구현 클래스 타입의 객체 생성.
		Calculable adder = new CalcAdder();
		// -> 객체를 생성할 수가 없다. -> 지역 클래스를 모를때는 외부 클래스를 사용했다.
		// 생성된 객체를 calculate 메서드의 argument로 전달.
		double result = calc.calculate(adder);
		System.out.println("result : " + result); // 돌고 돌아서 1+2=3이라는 계산을 하는 코드를 만든것.
		
		// 지역 (내부) 클래스
		class Subtractor implements Calculable {
			@Override
			public double calculate(double x, double y) {
				return x - y;
			}
			
		}
		
		Calculable subtractor = new Subtractor(); // 지역 클래스 객체 생성.
		result = calc.calculate(subtractor);
		System.out.println("result : " + result);
		
		// 익명 클래스 객체 생성.
		Calculable multiplier = new Calculable() {
			@Override
			public double calculate(double x, double y) {
				return x * y;
			}
		};
		result = calc.calculate(multiplier);
		System.out.println("result : " + result);
		
		// 익명 클래스의 또 다른 방법.
		
		result = calc.calculate(new Calculable() {
			
			@Override
			public double calculate(double x, double y) {
				return x / y;
			}
		});
		System.out.println("result : " + result);
		
		// 람다 표현식(lambda expression) : 함수 표현식.
		result = calc.calculate((x, y) -> x / y);
		System.out.println("result : " + result);
		
		/*
		 * 람다 표현식 - 함수 표기법
		 * class 정의와 객체 생성을 동시에 하는 익명 클래스를 간단히 작성하기 위한 문법.
		 * 람다 표현식은 아무때나 사용하는게 아닌 함수형 인터페이스(FunctionalInterface)만 람다
		 *   표현식으로 작성할 수 있다.
		 * -> 함수형 인터페이스 : 추상 메서드를 오직 1개만 갖는 인터페이스.
		 * 
		 * 람다 표현식 문법 :
		 *       (1) (파마리터 선언, ...) -> { 메서드 코드; }
		 * 
		 * - 람다 표현식의 파라미터 선언에서는 타입을 생략해도 된다.
		 * 
		 * - 람다 표현식의 body가 문장이 하나만 있는 경우에는 {}까지 생략할 수 있다.
		 * 
		 * - 람다 표현식의 body가 리턴문 밖에 없는 경우에는 {}와 return키워드를 모두 생략하고
		 *    리턴값만 표기하면 된다.
		 *      표기 방법 : 
		 *      (1) (파라미터,..) -> 리턴 값 
		 * 
		 * - 람다 표현식에서 파라미터가 1개인 경우에는 파라미터 선언에 ()를 생략할 수 있다.
		 *      표기 방법 : 
		 *      (1) 파라미터 -> {}
		 *      (2) 파라미터 -> 리턴 값
		 * 
		 * -> { } 를 생략하면 ;이 없어야 된다.
		 * -> return도 생략해야 된다.
		 * 
		 */
		
		
		
	}

}

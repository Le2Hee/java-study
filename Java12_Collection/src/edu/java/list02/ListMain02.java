package edu.java.list02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ListMain02 {

	public static void main(String[] args) {
		// LinkedList
		// 정수를 저장하는 LinkedList 타입 객체 생성.
		// 주의
		  // List의 원소 타입은 Java의 기본 타입을 사용할 수 없다!! LinkedList<int> -> (x)
		  // 기본 타입 대신에 wrapper 클래스를 사용해야 한다!! LinkedList<Integer> -> (o)
		LinkedList<Integer> numbers = new LinkedList<>();
		
		// LinkedList와 ArrayList는 원소 추가/삭제/검색 메서드 이름과 사용법이 동일하다.
		//								(add/remove/get)
		
		Random random = new Random();
		// 과제 1
		// 리스트 numbers에 [0, 100) 범위의 정수 난수 20개를 저장.
		//                 -> 0이상 100미만이라는 뜻.
		// 리스트 numbers의 내용을 출력.
		for(int i = 0; i < 20; i++) {
			int num = random.nextInt(100);
			numbers.add(num);
		}
		System.out.println(numbers);
		
		System.out.println("=============================================================================");
		
		// 과제 2
		// 홀수들만 저장할 LinkedList 변수를 선언하고 객체를 생성.
		//   					      -> odds
		// numbers의 정수들 중에서 홀수들만 odds에 저장.
		// 리스트 odds의 내용을 출력
		LinkedList<Integer> odds = new LinkedList<>();
		for(int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 != 0) {
				odds.add(numbers.get(i));
			}
		}
		System.out.print(odds);
		System.out.println();
		
		//풀이
//		for(Integer n : numbers) { // 리스트 numbers의 원소들을 처음부터 끝까지 순환하면서.
//			if (n % 2 == 1) { // 원소가 홀수이면
//				odds.add(n); // 리스트 odds에 추가.
//			}
//		}
//		System.out.println(odds);
		
		System.out.println("=============================================================================");
		
		// 과제 3
		// LinkedList 변수 선언, 객체 생성
		//            -> evenSquares
		// evenSquares에는 numbers의 숫자들 중 짝수들의 제곱을 저장.
		// 리스트 evenSquares의 내용을 출력.
		LinkedList<Integer> evenSquares = new LinkedList<>();
		for(int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 == 0) {
				evenSquares.add(numbers.get(i)*numbers.get(i));
			}
		}
		System.out.print(evenSquares + " ");
		System.out.println();
		
		System.out.println("=============================================================================");
		
		// Iterator 사용.
		Iterator<Integer> itr = evenSquares.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

}

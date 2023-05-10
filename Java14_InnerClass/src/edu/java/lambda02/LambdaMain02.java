package edu.java.lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaMain02 {

	public static void main(String[] args) {
		Random random = new Random();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			numbers.add(random.nextInt(100));
		}
		System.out.println(numbers);
		
		for (Integer x : numbers) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		numbers.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		// List numbers에서 짝수들만 선택해서 새로운 리스트에 저장하고 출력.
		ArrayList<Integer> num = new ArrayList<>();
		for(int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 == 0) {
				num.add(numbers.get(i));
			}
		}
		num.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		// 람다를 사용해 한줄로 만들기.
		List<Integer> num2 = numbers.stream().filter(x -> x % 2 == 0).toList();
		//				numbers 스트림()안에 필터(x -> x % 2 == 0)를 써서 거르고 그걸 리스트로 쓴다.
		//                       ->(통로)
		System.out.println(num2);
		
		// filter()의 argument : 
		// -> 파라미터가 1개이고 리턴 타입이 boolean인 FunctionalInteface 객체를 전달.
		
		// List numbers에서 홀수들의 제곱을 저장하는 리스트를 만들고 출력.
		ArrayList<Integer> num3 = new ArrayList<>();
		for(Integer x : numbers) {
			if (x % 2 == 1) {
				num3.add(x * x);
			}
		}
		System.out.println(num3);
		
		List<Integer> num4 = numbers.stream().filter(x -> x%2==1).map(x -> x * x).toList();
		//												-> map한다 라는 의미로 x를 x*x로 바꾼다.
		System.out.println(num4);
		// map()의 argument : 
		// -> 파라미터가 1개이고 리턴 값이 있는(void가 아닌) FunctionalInterface 객체를 전달.
		
		List<String> languages = Arrays.asList("Java", "SQL", "JavaScript", "Python");
		// 리스트 languages에서 5글자 이상인 문자열을 소문자로 변환한 문자열을 원소로 갖는
		//  리스트를 만들고 출력하기.
		List<String> lan = new ArrayList<>();
		for(String x : languages) {
			if (x.length() >= 5) {
				lan.add(x.toLowerCase());
			}
		}
		System.out.println(lan);
		
		List<String> lan2 = languages.stream()
				.filter(x -> x.length()>=5 )
				.map(x -> x.toLowerCase())
				.toList();
		System.out.println(lan2);
		
		
		
		
		
		
	}

}

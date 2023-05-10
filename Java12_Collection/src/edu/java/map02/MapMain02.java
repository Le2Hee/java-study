package edu.java.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고 정수를 value로 하는 TreeMap을 선언, 초기화(객체 생성).
		TreeMap<String, Integer> menu = new TreeMap<>();
		
		menu.put("짜장면", 8000);
		menu.put("볶음밥", 9000); // -> 가, 나, 다, 라, ... 순서대로 간다. 
		menu.put("짬뽕", 9000);
		
		System.out.println(menu);
		
		System.out.println(menu.get("짜장면"));
		System.out.println(menu.get("냉면")); 
		// -> key에 매핑된 value가 있으면 출력해주지만, key에 매핑된 value가 없으면 null이 출력.
		// 대신에 사용되는 매서드가 getOrDefault()이다.
		System.out.println(menu.getOrDefault("냉면", 0)); // -> 0이 리턴된다.
		
		// TreeMap은 정렬 알고리즘이 적용된 Map이기 때문에, 오름차순/내림차순 키 집합을 제공한다.
		Set<String> keySet = menu.keySet();
		for(String k : keySet) {
			System.out.println(k + " : " + menu.get(k)); 
		}
		// -> 오름차순 키셋
		
		Set<String> descKeySet = menu.descendingKeySet();
		for (String k : descKeySet) {
			System.out.println(k + " - " + menu.get(k));
		}
		// -> 내림차순 키셋
		
	}

}

package edu.java.map01;

import java.util.HashMap;
import java.util.Set;

/*
 * Collection<E>
 * |__ List<E>, Set<E>, ...	E -> Element(원소)   // 같은 인터페이스를 받는다는건 공통점이 있다.
 * 
 * List, Set의 공통점 : 
 *  - 한가지 타입의 객체들을 여러개 저장할 수 있는 데이터 타입.
 * 
 * List : 인덱스 있음. 저장하는 순서가 중요.
 *   					-> add 호출할 때 마다, 인덱스 자동으로 증가한다.
 *   	  중복된 값을 저장할 수 있다.
 *   
 * Set : 인덱스 없음.
 *       중복된 값을 저장할 수 없다.
 *       
 * Map<K, V>
 * |__ HashMap<K, V>, TreeMap<K, V>, ...
 * 
 * Map : 키(key)와 값(value)의 쌍으로 구성된 데이터를 저장하는 데이터 타입.
 *   (예) 1번 - 학생이름, 2번 - 학생이름, 3번 - 학생이름, ...
 *        K와 Y의 데이터 타입은 다를 수 있다.
 *   (1) Key의 역할 : 중복된 값을 가질 수 없다.
 *     				   -> 연속된 값을 가질 필요는 없다.
 *       	   	      리스트에서 인덱스의 역할을 한다.
 *                     -> (데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도)
 *                     
 *   (2) Value의 역할 : 중복된 값을 가실 수 있다.
 *   
 *   (3) HashMap의 역할 : 검색을 빠르게 할 수 있는 Map.
 *   
 *   (4) TreeMap의 역할 : 정렬을 빠르게 할 수 있는 Map.	
 */

public class MapMain01 {

	public static void main(String[] args) {
		// 정수를 Key로 하고 문자열을 Value로 하는 HashMap 변수 선언, 초기화
		HashMap<Integer, String> students = new HashMap<>();
		
		// put(key, value) : Map에 key-value 쌍의 데이터를 저장.
		students.put(1, "강효남");
		students.put(2, "김다훈");
		students.put(3, "김도현");
		students.put(20, "김다훈");
		
		System.out.println("Map size : " + students.size());
		System.out.println(students);
		
		// get(key) : key에 해당하는 value를 리턴한다.
		//            key에 매핑된 value가 없으면 null을 리턴한다.
		System.out.println(students.get(3)); // 3 -> 김도현.
		System.out.println(students.get(10)); // -> null
		
		// -> key에 매핑된 value를 리턴. key에 매핑된 value가 없으면 defaultValue를 리턴.
		  // 절대로 null이 나올 수 없게 만든다.
		System.out.println(students.getOrDefault(3, "무명씨"));
		System.out.println(students.getOrDefault(10, "무명씨"));
		 // -> 키에 값이 없으면 "" 아규먼트를 넘겨준다.
		
		// remove(key) : key에 매핑된 key-value 원소를 삭제.
		students.remove(20);
		
		System.out.println("Map size : " + students.size());
		System.out.println(students);
		
		// 변경하는 메서드가 따로 있지 않다.
		// put(key, value) : 
		// (1) Map에 key가 존재하지 않으면 key-Value 데이터를 저장.
		// (2) Map에 key가 존재하면, key에 매핑된 value를 변경.
		students.put(3, "KIM Dohyun");
		System.out.println(students);
		
		// Map에서 향상된 for 문장을 사용하는 방법 : 
		Set<Integer> keySet = students.keySet(); // (1) Map의 Key들로만 이루어진 Set을 만든다.
		// 모든 Map이 공통적으로 가지고 있는 메서드()
		for(Integer k : keySet) { // (2) key들을 처음부터 끝까지 순회하면서
			System.out.println(k + " : " + students.get(k)); // (3) key에 매핑된 value을 찾는다.
		}
		
		
		
	}

}

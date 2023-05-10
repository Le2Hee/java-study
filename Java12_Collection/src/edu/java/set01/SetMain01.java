package edu.java.set01;

import java.util.Iterator;
import java.util.TreeSet;

/*
 * Collection<E>
 * |__ List<E>
 *    |__ ArrayList<E>, LinkedList<E>, ...
 * 
 * Collection<E>
 * |__Set<E>
 *    |__ HashSet<E>, TreeSet<E>, ...
 *    
 * Set의 특징 : 
 * 1. 중복된 값을 저장하지 않는다.(예) {1, 2} = {1, 2, 1, 2} -> 같은 수가 2개3개있어도 1개로 본다.
 *    ->> 중복된 값이 저장이 되면 List, 안되면 Set
 * 2. 저장하는 순서가 중요하지 않음. -> 인덱스가 없다. (예) {1, 2} = {2, 1}
 * 
 * HashSet : Hash 알고리즘(검색을 빠르게 할 수 있는 알고리즘)을 사용한 Set.
 * TreeSet : Tree 알고리즘(정열을 빠르게 할 수 있는 알고리즘)을 사용한 Set.
 *  -> 오름차순, 내림차순
 * 
 */

public class SetMain01 {

	public static void main(String[] args) {
		// String을 원소로 갖는 TreeSet 변수 선언, 객체 생성
		TreeSet<String> set = new TreeSet<>();
		System.out.println("set size : " + set.size());
		System.out.println(set);
		
		set.add("hello");
		set.add("apple"); // -> TreeSet은 정렬된 형태. -> 출력 순서가 apple, hello 이다.
		set.add("hello"); // -> 중복된 데이터들은 저장되지 않는다.
		set.add("zip");
		set.add("banana");
		
		System.out.println(set); // Set은 toString(); override.
		
		// set은 인덱스를 갖지 않기 때문에 get(int index) 메서드는 제공되지 않음.
		// index를 갖고 있지 않기 때문에 for 문장을 사용할 수 없다.
		//  -> for-each 구문과 Iterator는 사용 가능하다.
		for (String s : set) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		Iterator<String> itr = set.iterator(); // -> 오름차순 반복 도구
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		
		// TreeSet은 정렬 알고리즘이 적용된 객체이기 때문에 내림차순 반복 도구도 제공.
		Iterator<String> itr2 = set.descendingIterator(); // -> 내림차순 반복 도구
		while (itr2.hasNext()) {
			System.out.print(itr2.next() + " ");
		}
		System.out.println();
		
		
		
	}

}

package edu.java.list01;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 리스트(list)의 특징 :
 * 1. 한가지 타입의 값들을 여러개 저장할 수 있는 데이터 구조체.
 * 2. 값들을 저장하는 순서가 중요 - index를 가지고 있음.
 * 3. 값들을 저장할 때마다 인덱스는 자동으로 증가.
 *   - 배열에서는 인덱스가 무한히 늘어나지 못하지만, 배열과는 다르게 저장용량이 자동으로 증가.
 *   - 예) int a = new int[10]; 라고 제한을 두지만 리스트는 그렇지않다.
 * 4. 중간에 있는 값을 삭제하면 인덱스는 자동으로 재배열됨.	
 * 5. 같은 값을 여러번 저장할 수 있음. -> Set과 다른 점.
 * 
 * 크게 2가지 종류의 리스트가 있다.
 * ArrayList의 특징 : 
 * 1. 배열(array)을 사용하는 리스트.
 * 2. 데이터를 저장(add)하거나 삭제(remove)할 때 속도가 느리다.
 * 3. 데이터를 검색(get)할 때 속도가 빠르다.
 * 
 * LinkedList의 특징 : 
 * 1. linked list 알고리즘을 사용한 리스트.
 * 2. 데이터를 저장하거나 삭제할 때 속도가 빠르다.
 * 3. 데이터를 검색할 때 속도가 느리다.
 * 
 * Collection<E>
 * |__ List<E>
 *    |__ ArrayList<E>, LinkedList<E>, ...
 * 
 * class이름 뒤에 어떤타입의 원소를 < >안에 적어줘야 된다.
 * 
 * 
 * 
 */

public class ListMain01 {

	public static void main(String[] args) {
		// 문자열을 저장하는 ArrayList 객체를 생성.
		// ArrayList<저장할 원소 타입> 변수이름 = new ArrayList<>();
		// 생성자 호출에서는 리스트의 원소 타입을 생략해도 됨.
		ArrayList<String> languages = new ArrayList<>(); // new ArrayList<String>();
		
		System.out.println("리스트 크기 : " + languages.size());
		System.out.println("리스트 내용 : " + languages); // toString()메서드가 override되어 있음.
		
		// 리스트에 원소 추가
		languages.add("Java");
		languages.add("SQL");
		languages.add("HTML");
		languages.add("Java");
		
		System.out.println("리스트 크기 : " + languages.size());
		System.out.println("리스트 내용 : " + languages);
		
		
		// 리스트에서 인덱스 위치의 원소를 리턴 : get(int index)
		System.out.println(languages.get(0)); // 인덱스는 0부터 시작
		System.out.println(languages.get(1)); 
		
		for (int i = 0; i < languages.size(); i++) {
			System.out.print(languages.get(i) + " ");
		}
		System.out.println();
		
		// 원소를 삭제하는 방법 : 
		  // remove(Object o) : 리스트에서 처음 등장하는 원소를 찾아서 삭제.
		  // remove(int index) : 리스트에서 인덱스 위치에 있는 원소를 삭제.
		languages.remove("Java");
		System.out.println("리스트 내용 : " + languages);
		
		languages.remove(0);
		System.out.println("리스트 내용 : " + languages);
		
		// 향상된 for 구문(for-each) : for (변수 선언 : 리스트) {...}
		for (String s : languages) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		// Iterator<E> 객체를 사용한 리스트 원소들 반복.
		  // -반복을 해줄 수 있는 기계.
		Iterator<String> itr = languages.iterator(); // Iterator 객체 생성.
		// 생성을 직접하는게 아니다. 
		// while문을 이용해야된다.
		// 살짝 공식처럼 되어 있다.
		// for-each구문을 수동으로 사용한다고 생각하면 된다.
		while (itr.hasNext()) { // hasNext()는 boolean 타입.
			System.out.println(itr.next());
		}
		
		
	}

}

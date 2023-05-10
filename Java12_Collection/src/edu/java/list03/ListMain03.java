package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

	public static void main(String[] args) {
		// 문자열들을 원소로 갖는 리스트 생성과 동시에 초기화.
		// Arrays.asList(...);
		  // -> 아규먼트로 전달된 값들을 원소로 갖는 리스트 객체를 생성.
		String[] s = {"a", "b", "c"};
		List<String> subjects = Arrays.asList("Java", "SQL", "HTML",
				"CSS", "JavaScript", "Servlet", "JSP", "Spring", "Python");
		System.out.println(subjects);
		
		System.out.println("====================================================================");
		
		// 문제 1
		// 리스트 subjects에서 5글자 이상인 문자열들만 저장하는 리스트를 만들고 출력.
		List<String> subLength1 = new ArrayList<>();
		for(String x : subjects) {
			if(x.length() >= 5) {
				subLength1.add(x);
			}
		}
		System.out.print(subLength1);
		
		// Iterator 사용풀이
//		Iterator<String> itr = subjects.iterator();
//		while (itr.hasNext()) {
//			String w = itr.next();
//			if(w.length() >= 5) {
//				subLength1.add(w);
//			}
//		}
//		System.out.println(subLength1);
		
		System.out.println();
		System.out.println("====================================================================");
		
		// 문제2
		// 리스트 subjects의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
		List<Integer> subLength2 = new ArrayList<>();
		for(String x : subjects) {
			subLength2.add(x.length());
		}
		System.out.print(subLength2 + " ");
		
		System.out.println();
		System.out.println("====================================================================");
		
		
		// 문제3
		// 정수(0, 1)를 저장하는 리스트를 생성.
		// 리스트 codes의 원소가 0이면 "Male", 1이면 "Female"을 원소로 갖는 리스트를 만들고 출력.
		List<Integer> codes = Arrays.asList(0, 1, 0, 0, 1, 1);
		List<String> MaleFemale = new ArrayList<>();
		
		for (Integer x : codes) {
			if (x == 0) {
				MaleFemale.add("Male");
			} else {
				MaleFemale.add("Female");
			}
		}
		System.out.println(MaleFemale);
		
		System.out.println();
		System.out.println("====================================================================");
		
		
		
	}

}

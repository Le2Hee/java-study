package edu.java.map03;

import java.util.HashMap;
import java.util.Set;

public class MapMain03 {

	public static void main(String[] args) {
		// 단어 개수 세기(word counting):
        // 문자열에 등장하는 단어를 key로 하고, 그 단어의 등자 횟수를 value로 하는 Map을 만들고 출력하세요.
        // 결과> {하늘=3, 땅=2, sky=2}
        String sentence = "하늘 땅 하늘 땅 하늘 sky sky";
//		String[] sentenceValue = sentence.split(" ");
//		HashMap<String, Integer> wordCount = new HashMap<>();
//		int scount = 1;
//		int ecount = 1;
//		int escount = 1;
//		for (int i = 0; i < sentenceValue.length; i++) {
//			 if(sentenceValue[i].equals("하늘")) {
//				 wordCount.put(sentenceValue[i], scount++);
//			 } else if(sentenceValue[i].equals("땅")) {
//				 wordCount.put(sentenceValue[i], ecount++);
//			 } else {
//				 wordCount.put(sentenceValue[i], escount++);
//			 }
//		}
//		System.out.println(wordCount);
//		
//		
		// 풀이
		String[] words = sentence.split(" ");
		
		// 단어(key)-빗돗수(value) 저장하는 Map변수를 선언, 초기화(객체 생성).
		HashMap<String, Integer> wordCounts = new HashMap<>();
		
		for (String w : words) { // 배열의 첫번째 원소부터 마지막 원소까지 순서대로 반복하면서
			Integer count = wordCounts.get(w); // 배열의 단어 w에 매핑된 값(빈도수)를 찾는 것.
			if (count == null) { // 단어에 매핑된 빈돗수가 없을 때.
				wordCounts.put(w, 1); // -> count가 null이기 때문에 +1이 안된다.
			} else { // 단어에 매핑된 빈돗수가 있을 때.
				wordCounts.put(w, count+1);
			}
			System.out.println(wordCounts); // -> 입력이 어떻게 되는지 보기 위해 안에 넣음.
		}
		
		HashMap<String, Integer> wordCount2 = new HashMap<>();
		for (String w : words) {
			Integer count = wordCount2.getOrDefault(w, 0); // -> getOrDefault는 int로 리턴해도 상관없다.
			wordCount2.put(w, count+1);
		}
		System.out.println(wordCount2);
		
	}

}

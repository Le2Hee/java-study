package eud.java.array01;

public class ArrayMain01 {

	public static void main(String[] args) {
		// 배열(array) : 같은 타입의 데이터 여러개를 하나의 변수 이름으로 저장하기 위한 메모리 공간.
		// 인덱스(index) : 배열에서 데이터가 저장된 위치를 나타내는 정수.
		// 배열의 인덱스는 0부터 시작한다!!
		// 배열의 마지막 index는 (배열 원소 개수 - 1).
		// 모든 배열은 length 속성을 가지고 있다.
		// length 속성 : 배열의 길이, 배열의 원소 개수
		// 변수타입에 따라 배열은 달라지고 타입에따라 그 타입만 저장이 가능하다.
		
		// 정수(int) 4개를 저장할 수 있는 배열 선언, 초기화./
		
		int[] scores = new int[4]; // 배열은 몇개짜리인지 꼭 초기화 시켜줘야된다!!
		// int배열 이라는 의미 //  new : 새로운걸 만드는 것
		
		// 배열의 특정 인덱스에 원소를 저장(재할당)
		scores[0] = 100;    // 변수 scores의 0번에 100을 저장하겠다.
		scores[1] = 90;
		
		// 배열의 특정 인덱스에 저장된 원소의 값 읽기
		System.out.println(scores);  //라고 하면 창조값이 나온다. (신경안써도됨)
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);  // 값을 안넣으면 0번이 들어가있다.
		System.out.println(scores[3]);
		
		// 보통 index는 i라고 한다.
		System.out.println("length = " + scores.length);
		for (int i = 0; i < scores.length; i++) { // scores. 하고 ctrl + 스페이스 를 하면 length가 나오고 그 값은 4가 된다.
			System.out.println(scores[i]);
		}
		
		System.out.println("=========");
		// 배열 선언 초기화 방법 2 :
		int[] numbers = {100, 90, 0, 50, 80};  // 몇개 짜리인지 알려주지 않아도 ,로 원소들이 구별이 된다.
		              // 이게 배열의 의미 (정수 n개)
		// 여기선 값이 있으니까 new가 필요가 없다.
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]); // 배열의 내용이 바뀌더라도 length를 쓰면 코드는 바뀌지않아도 나온다.
		}
		
		numbers[2] = 99; // 이렇게 언제든지 변수 내용을 바꿀수있다.
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		System.out.println("=========");
		
		// 배열에서 사용하는 for문
		// 향상된 for 문 (enhanced for statement). for-each 구문
		// 왼쪽에는 변수 선언, 오른쪽에는 배열의 이름
		for (int x : numbers) { // 무조건 ()안에 : 가 있어야된다. 
			System.out.println(x);
		} 
		// for-each 구문 실행 방법
		// numbers에 있는 원소를 첫번째 위치에서 부터 하나 씩 꺼낸다. 예) (100, 90, 99, 50, 80)
		// 배열에서 꺼낸 원소를 저장하기 위한 변수를 선언하는 것 (배열에 int면 int, double이면 double 로)
		// 변수 x 를 가지고서 실행문을 실행하고 다시 numbers로 올라가 그 다음 원소를 찾아간다.
		// 그 다음 원소를 꺼내서 변수 x 값을 바꿔준다. 이걸 계속 반복한다.
		// 마지막에 도달해서 그 다음 원소가 없을때 멈춘다.
		
		// 아무래도 기존에 for문 보다는 for-each문을 사용하면 보기가 좋다.
		// 단순하게 출력만 할때에는 for-each문
		
		
		
		
		
	}

}

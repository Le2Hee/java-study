package edu.java.class01;

// 객체 지향 프로그래밍(Object-Oriented Programming) 언어 : Java, C++, C#, ...
  // 오브젝트를 사용해서 만드는 프로그래밍 (Class)
    // java라고 절차 지향 프로그래밍을 못하는게 아니다.
      // 클라스를 제공하는 언어를 객체 지향 언어라고 한다.

// 대조가 되는 것이 절차 지향 프로그래밍(Procedural Programming) 언어 : C, ...
                  // 절차적으로 순서대로 만들어 내는 방식
   // C는 클라스가 없어 객체 지향으로 할수가 없다.

// 객체(object) : 대상. 프로그램에서 사용하려는 대상.
  // 문자열이라고 하는 것이 객체이다. (스캐너, ...)

// 인스턴스(instance) : 실제로 만들어진(생선된) 객체.
  // 인스턴스를 객체로 많이 헷갈려 한다.
    // 다르지만 대부분 같은 개념으로 생각한다.
      //(머리속(object)에 있냐 실제(instance)로 있냐의 차이)

// 클래스(class) : object를 설계한 코드.
  // 객체가 가질 수 있는 데이터(값)를 변수로 선언하고,
  // 객체가 가질 수 있는 기능들을 메서드로 정의한 코드.
  // 데이터 타입(변수를 선언할 때 사용).

public class ClassMain01 {

	public static void main(String[] args) {
		String s1 = "hello, java";
		String s2 = new String("안녕하세요");
		
		System.out.println("s1 길이 = " + s1.length()); 
		System.out.println("s2 길이 = " + s2.length()); 
		System.out.println(s1.concat("!!!"));
		System.out.println(s2.concat("..."));
		// .concat() 왼쪽과 오른쪽을 합쳐주겠다. 붙여주겠다.
		
		// 데이터는 변수에다가 저장, 기능들은 메서드에다가 저장, 변수와 메서드는 클래스에 저장
		// 클래스는 변수와 메서드를 묶어서 사용할수있는 데이터 타입
		// 틀을 클래스라고하고 틀에서 나오는것을 객체라고 많이 한다.
		
		// class를 작성하고 사용하는 목적
		// 문자열이라고 하는대상이 문자열이라고 하는 데이터로 가지고 있으면 좋겠고 기회를 제공
		// class를 가지고 있지 않는 언어들도 있다. (대표적으로 c언어,c언어 에서는 함수)
		
		
	}

}

package edu.java.inheritance07;

// 추상 메서드(abstract method) :
// 메서드 signature(수식어, 리턴 타입, 이름, 파라미터 선언)
//        -> 메서드를 어떻게 쓰는지 알려주는 것을 signature 라고 한다.

// 메서드의 body(본체, {...}안쪽 부분)가 구현되지 않은 메서드
//  -> "추상 메서드"라고 한다.

// 추상 메서드는 반드시 abstract 키워드로 수식해야 한다.
// 추상 메서드 선언은 반드시 세미콜론(;)으로 끝내야 한다.
//  -> 문장이 끝났는지 안끝난지 모른다. -> {}가 없기때문에

// 이름은 있지만 사용할 수 없는 메서드

// 추상 클레스(abstract class) :
// abstract로 선언된 클래스.

// 추상 메서드는 없어도 추상 클래스가 될 수 있다.
//  -> 대부분 추상 메서드를 가지고 있다. -> 반드시 가지고 있는 건 아니다.

// 추상 메서드를 갖는 클래스는 반드시 추상 클래스로 선언해야 한다.
//  -> 추상 메서드를 만들면 객체가 생성되면 안되니까 추상 클래스로 선언을 해야한다.

// 추상 클레스는 객체를 생성할 수 없다.

// 추상 메서드와 추상 클래스는 상속하는 하위 클래스ㅔ서 메서드 구현을 목적으로 한다.
//  -> 직접 객체를 생성해서 메서드를 활용하는게 아니라 다른 클래스 객체를 이용해 move라는 행동을
//     하는 메서드가 있으면 좋겠다.

abstract class Animal {
	public abstract void move();
	// -> 정의를 내리수 없다.
	// -> 상속 받는 클래스가 정의를 한다.
	// 예) 물고기, 새, 육지동물 등등 움직이는 방법이 다 다르다.
}

class Dog extends Animal {
	// -> 추상 클래스를 상속하면 에러가난다.
	// -> 에러 메세지 -> Animal클래스 안에 있는 move메서드가 추상 메서드이다.
	//                   이 move메서드를 Dog클래스에서 구현해야된다. 
	//                -> 구현(implementation) : 추상 메서드를 override해서 메서드를 바디를 작성.
	@Override 
	public void move() { // abstract 수식어를 없애야된다.
		System.out.println("강아지 총총총...");
	}
	
}

class Fish extends Animal {
	@Override
	public void move() {
		System.out.println("물고기 스윔스윔...");
	}
}

class Bird extends Animal {
	@Override
	public void move() {
		System.out.println("새 훨훨~~");
	}
}

public class InheritanceMain07 {

	public static void main(String[] args) {
//		Animal animal = new Animal();
		// 에러 메세지 -> 인스턴스를 만들다 (객체를 생성하다.)
		//			      Animal클래스에 객체를 생성할수 없다.
		//-> 추상 클래스 타입의 객체는 생성할 수 없다.(cannot instantiate)
		
		Dog dog = new Dog();
		// -> 추상 클래스를 구현하는 하위 타입의 객체는 생성할 수 있음.
		dog.move();
		
		Fish fish = new Fish();
		fish.move();
		
		Bird bird = new Bird();
		bird.move();
		
		// 다형성 : SuperType var = SubType();
		Animal[] animals = {bird, fish, dog};
		for (Animal arr : animals) {
			arr.move();
		}
		
	}

}


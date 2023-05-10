package equ.java.interface03;

// Java는 다중 상속을 제공하지 않는다.
//  -> 2개 이상 class를 상속할 수 없다.
class A {}
class B {}
class c extends A {}
//class D extends A, B {} -> 안됨. 문법 오류.

// Java에서는 클래스에서 구현하는 인터페이스의 개수는 제한이 없다.
interface E {}
interface F {}
class G implements E, F {} // -> 가능.     // 2개 인터페이스를 구현하는 클래스. 
// G -> 서브타입       -> E, F 둘다 상위 타입.
class H extends A implements E, F {} // 1개 클래스를 상속하고 2개 인터페이스를 구현하는 클래스.

// 인터페이스는 다른 인터페이스를 확장(상속)할 수 있다.
// -> 인터페이스의 상속이라고 말한다.
// 주의 : 
// Java에서 클래스는 단일 상속만 가능하지만, 인터페이스는 다중 상속이 가능!
//  -> class와 다른점이다. (다중 상속!)
interface I extends E, F {}

// 인터페이는 클래스를 확장(상속)할 수 없다.
//interface J extend A {}  ->  문법오류. 상위 인터페이스는 인터페이스만 가능.
// 에러 메세지 -> SuperInterface는 반드시 interface여야 한다. 


interface Buyer {
	static void test() {} 
	// -> static 메서드는 class이름을 사용해서 호출을 하기 때문에 
	//    Seller와 메서드 이름이 중복되도 상관이 없다.
	void buy(); // public abstract 메서드
	
	// default 매서드 -> 객체를 생성한 다음에 호출할 수 있는 인스턴스 메서드.
	default void register() {
		System.out.println("구매자 등록");
	}
}
interface Seller {
	static void test() {}
	void sell(); // public abstract 메서드
	
	// default 메서드
	default void register() {
		System.out.println("판매자 등록");
	}
}

class User implements Buyer, Seller {
	@Override // Buyer 인터페이스의 추상 메서드를 구현.
	public void buy() {
		System.out.println("구매");
	}
	
	@Override // Seller 인터페이스의 추상 메서드를 구현.
	public void sell() {
		System.out.println("판매");
	}
	// 2개의 인스턴스 추상 메서드를 구현을 해도 오류가 난다.
	// -> Java가 다중 상속을 지원을 하지 않은 이유와 같다.
	//    -> 같은 이름의 메서드(register())를 가지고 있을 수 있기 때문이다.
	// 인터베이스는 어짜피 2개의 같은 메서드가 있어도 body는 class에서 만들어주기 때문에 다중 상속이
	//  된다.
	// 그런데 업그레이드 되면서 body를 가지는 인터베이스 메서드가 생기면서 오류가 생기기 시작했다.
	
	// 오류 해결 방법 : 
	// 중복되는 default 메서드가 2개의 인터페이스에 있는 경우에 반드시 override!
	@Override
	public void register() {
		// 상위인터페이스.super.메서드() 호출
		Buyer.super.register(); // Buyer  인터페이스의 default 메서드가 호출된다.
		Seller.super.register(); // -> 이러면 2개 사용 가능.
	}
}



public class InterfaceMain03 {
	
	

	public static void main(String[] args) {
		User user1 = new User();
		
		user1.register();
		user1.buy();
		user1.sell();
		
		
	}

}

package edu.java.singleton;

// singleton(싱글톤) : 
  // 오직 한번만 생성할 수 있는 객체.

// singleton 규칙
  // (1) private static 클래스 필드 + (2) pivate 생성자 + (3) public static 클래스타입 리턴하는 메서드

public class Captain {
	private String name = "캡틴 아메리카"; // 생성된 객체가 갖는 필드 -> 인스턴스 필드
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	// get,set은 객체가 생성된 다음에 사용할 수 있는 것. (static이 없기 때문에)
	
	// (1) private static Captain 타입의 필드가 필요하다.
	  // 생성된 Captain 타입 객체의 주소 값을 저장하기 위한 필드.
	  // static으로 선언한 목적 :
	    // 프로그램 로딩 시점에 메서드 영역의 메모리에 미리 변수를 만들어 두기 위해서.
	  // private로 선언한 목적 :
	    // 필드의 값을 변경하는 것은 이 클래스 내부에서만 가능하도록 하기 위해서.
	private static Captain instance = null;
	
	// (2) private 생성자 
	  // 생성자를 private으로 만드는 이유 :
	    // 다른 클래스에서 생성자를 호출할 수 없도록 하기 위해서.
	    // -> 다른 클래스에서 객체를 생성하지 못하도록 하기 위해서. ( = new Captain(): 이 안된다.)
	private Captain () {}
	
	// (3) public static Captain타입을 리턴하는 메서드.
	  // public으로 선언하는 이유 : 
	    // 다른 클래스에서 사용할 수 있도록.
	  // static인 이유 : 
	    // Captain 타입 객체가 생성되기 전에도 호출할 수 있도록 하기 위해서.
	public static Captain getInstance() {
		if (instance == null) { // Captain타입으로 생성된 객체가 없으면
			                    // -> 인스턴스가 생성되지 않은 경우에
			instance = new Captain(); // Captain타입 객체를 생성하고,
			                          //  생성된 객체의 주소값을 instance에 저장
		}
		
		return instance; // Captain 타입 객체의 주소값을 리턴.
	}
	
	// 첫 번째에서 값이 캡틴아메리카가 되었고,
	//  2번째부터는(null이 아니면) if문에 해당이 안되어서 값이 캡틴아메리카 밖에 안나온다.
	
}

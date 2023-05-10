package edu.java.class03;

// 클래스 : 객체가 가질수 있는 속성들을 필드로 정리를 하고 객체가 가져야되는 기능들을 
//          메서드로 정리하는 변수를 선언할때 사용할수 있는 데이터 타입이다.
     // 속성(field) + 생성자(constructor) + 기능(method) => 데이터 타입.

// 생성자(constructor)
  // - 객체를 메모리에 생성하고 초기화(initialize)해 주는 기능을 담당하는 특별한 함수.
  // - 모든 클래스에는 반드시 적어도 1개 이상의 생성자가 있어야 함!!!
  // - 클래스를 작성할 때 생성자를 하나도 정의(선언)하지 않으면, 
  //   자바 컴파일러가 "기본 생성자(default constructor)"를 자동으로 만들어 줌.
  // - 클래스를 작성할 때 생성자를 1개 이상을 정의하면,
  //   자바 컴파일러는 "기본 생성자(default constructor)"를 자동으로 만들지 않음.
  // - 생성자의 이름은 반드시 클래스 이름과 동일해야 함! (대, 소문자도 동일하게)
  // - 생성자는 리턴 타입을 사용하지 않음!!! 
  //   (method는 없을 때에 void를 사용하는데 생성자는 void도 사용하지 않는다!!)

// 기본 생성자(default constructor) : 
  // - argument를 갖지 않는 생성자. (파라미터가 없는 생성자)\
  // - 일반적으로 필드의 값들을 필드 타입의 기본값으로 초기화함. (일반적으로!!)
  // - 기본값 : boolean - false, 정수 - 0, 실수 - 0.0, 참조 타입(클래스 타입) - null.
                                                      //null과 비어있는 문자열은 다르다.

public class User {
	// field
	String userId;
	String userPassword;
	int userAge;
	
	// constructor
	public User() { // 기본 생성자(기본값을 매겨주는 생성자)
		// 코드를 작성하지 않아도, 각 필드들을 그 타입의 기본값으로 초기화를 해줌.
		// 코드를 작성하지 않는건 괜찮은데 public User(){}을 생략하면 안된다.
		  // 다른 생성자를 선언했기때문에 기본 생성자도 선언을 해줘야된다.
		// 기본 생성자도 값을 선언할 수 는 있다.(아규먼트 없는 생성자)
	}
	
	public User(String userId, String userPassword, int userAge) {
		// field를 초기화
		// 메인에서 호출한 값으로 field 변수에다가 저장하는 것.
		this.userId = userId;
		this.userPassword = userPassword;
		this.userAge = userAge;
		
		// field에 있는 변수를 부를때 this. 을 사용한다.
		// 이 클래스에서 this는 field userId와 parameter userID를 구별하기 위해서 사용.
		  // 이름이 같을때에만 구별을 하기 위해서 쓰는 것
		  // 같지 않을 경우는 써도 되지만 이미 생략이 되어 있는 것이다.
	}
	
	// 생성자 오버로딩(overloading) : 파라미터가 다른 생성자를 여러개 정의하는 것.
	
	// this의 의미(기능) :
//	     (1) 생선된 객체(인스턴스) 
//	          - 인스턴스의 필드와 지역 변수를 구별하기 위한 용도 
//	     (2) overloading된 다른 생성자 호출.
	
	public User(String userId, String userPassword) {
//		this.userId = userId;
//		this.userPassword = userPassword;
//		this.userAge = 0;
		this(userId, userPassword, 0);
		// 생성자에서 다른 생성자를 부를려면 꼭 this를 써야된다.
		// 다른 생성자가 없으면 자기 자신을 부른다(계속 반복 생성을 한다.)
		  // 이렇게 하면 안된다!
	}
	
	// method
	public void printUserInfo() {
		System.out.printf("ID : %s, PWD : %s, age : %d\n", userId, userPassword, userAge);
	}
	
}

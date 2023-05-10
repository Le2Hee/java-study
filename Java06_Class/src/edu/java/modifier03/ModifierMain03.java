package edu.java.modifier03;

// 데이터 캡슐화(encapsulation)
  // 데이터를 캡슐로 감싼다. 
  // 객체의 필드(멤버 변수)들은 private으로 선언해서 클래스 외부(다른 클래스)에서
  //   보이지 않도록 감추고,
  // 대신에, 필요한 경우에 한해서 public으로 공개된 메서드를 제공함으로써
  //   간접적으로 필드의 값을 읽거나 혹은 수정할 수 있도록 허용하는 프로그래밍 방법.

// getter 메서드 : 필드의 값을 리턴하는 메서드. (읽거나)
  // getter메서드는 파라미터를 선언하지 않는다.
  // getter 메서드는 get+변수 를 관습으로 사용한다, 첫글자는 대문자로!
  // boolean 타입 필드의 getter 메서드는 get 또는 is를 붙여서 만듦.

// setter 메서드 : 필드의 값을 변경하는 메서드. (수정할)
  // 항상 2개의 메서드만 사용하는 것은 아님.
  // set+변수 를 관습으로 사용한다, 첫글자는 대문자로!

// 전부다 public으로 공개를 해버리면 굳이 method도 만들 필요가 없는데 하는 이유는?
// 데이터 캡술화를 사용하는 이유 : 
  // 데이터의 보안과 무결성을 유지하기 위해서.
    // 보안 : 보이지 않으면 쓸수 없는 것.
    // 무결성
    //  예) 변수가 나이라는 의미로 사용된다면,
    //      나이가 0>= 되는데 음수가 되버리면 무결성이 깨졌다 라고 한다.

public class ModifierMain03 {

	public static void main(String[] args) {
		// Person 타입의 객체 생성
		Person p1 = new Person("오쌤", 16);
		
//		p1.age = -16;  // 필드 값 변경, 무결성이 깨졌다.
//		System.out.println(p1.age);  // 필드 값 읽기
		
		// private으로 감춰진 필드의 값 읽기 -> public으로 공개된 getter 메소드를 사용.
		System.out.println("이름 : " + p1.getName());
		System.out.println("나이 : " + p1.getAge());
		// 나이를 숨길려면 필드를 private로 만들고 get메서드를 안만들면 된다.
		
		p1.setAge(-17);  // 허용하지 않는 값으로는 변경하지 않도록 하겠다.
		System.out.println("나이 : " + p1.getAge());
		
		System.out.println("=======================================================");
		
		User user1 = new User(16, "LCH", "LCH123");
		System.out.println("유저 번호 : " + user1.getUserNo());
		System.out.println("유저 ID : " + user1.getUserId());
		System.out.println("유저 비밀번호 : " + user1.getPassword());
		
		System.out.println("=======================================================");
		
		user1.setUserNo(20);
		user1.setUserId("LeCH");
		user1.setPassword("LeCH123");
		System.out.println("유저 번호 : " + user1.getUserNo());
		System.out.println("유저 ID : " + user1.getUserId());
		System.out.println("유저 비밀번호 : " + user1.getPassword());
		
		
		
	}

}

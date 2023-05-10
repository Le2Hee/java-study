package edu.java.modifier05;

import edu.java.modifier04.PublicClass;
// import edu.java.modifier04.PackageClass; -> 에러 보이지가 않아서(not visible)

// 클래스 접근 수식어(access modifier)
  // 1. public : 어디서나 사용할수 있는 클래스.
  // 2. (package) : 수식어가 없는 경우 같은 패키지의 클래스들에서만 사용 가능한 클래스.

// (주의) public 클래스의 이름은 .java 파일의 이름과 같아야 함!
// (package) 클래스는 .java파일과는 달라도 상관없다.

// 1개의 java 파일에 2개의 public 클래스를 정의할 수 없다.
// public class A {}
  // 파일 이름과 다르다.
  // 문법 오류 

class B {}
// 팩키지 않에서만 사용할 수 있는 클래스이고 다른 패키지에 공개하지 않기 때문에 
// 같아야된다는 제약조건이 없다.
// 가능은 하지만 웬만하면 클래스 별로 따로따로 만들 것!
// 하나의 파일에 여러개를 만들지 않는다.  -> 관습!

public class ModifierMain05 {

	public static void main(String[] args) {
		// edu.java.modifier04.PublicClass 타입의 객체 생성.
		PublicClass cls = new PublicClass();
		
//		edu.java.modifier04. 이렇게 해도 PackageClass는 안된다. -> not visible
		
		
		
		
	}

}

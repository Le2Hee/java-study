package equ.java.interface01;

// -> 특별한 종류의 추상 클래스.
public interface DatabaseModule {
	// public static final 필드
	int DB_VERSION =1; // -> public static final 생략!!
	
	// public abstract 메서드
	/** (가상 회의 내용)
	 * 데이터베이스 테이블에서 자료를 읽어서 검색하는 기능.
	 * 
	 * @return 검색된 자료의 개수(int)
	 */
	int select(); // -> public abstract 생략!!
	
	/**
	 * 데이터베이스 테이블에 자료들을 저장하는 기능.
	 * 
	 * @param strVal 저장할 문자열.
	 * @param intVal 저장할 정수.
	 * @return 테이블에 저장된 행(row)의 개수(int).
	 */
	int insert(String strVal, int intVal);
	
	
	
	
}

// interface 와 class의 차이점
//abstract class A { 
//	abstract int select();
//}
// class는 abstract를 생략할수 없지만, interface는 대부분 생략한다.

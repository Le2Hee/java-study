package equ.java.interface01;

// interface를 구현하는 클래스 작성 방법 : 
// 클래스이름 앞에 implements (interface 이름)을 작성한다.
// 일종의 상속이라고 생각. -> interface는 여러개를 받을수 있다.
// 구현(implements) : 추상 메서드의 바디를 작성(override).
public class OracleDatabaseModule implements DatabaseModule{
	
	@Override
	public int select() {
		System.out.println("오라클 데이터 검색");
		return 1;
	}

	@Override
	public int insert(String strVal, int intVal) {
		System.out.println("오라클 데이터 저장");
		return 1;
	}
	
	
	
}

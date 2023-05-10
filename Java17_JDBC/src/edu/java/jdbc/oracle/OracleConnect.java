package edu.java.jdbc.oracle;

public interface OracleConnect {
	// 인터페이스의 필드는 public static final만 가능. public static final은 생략.
	
	// 오라클 데이터베이스 서버 접속 주소
	// 		IP, port, SID가 필요하다.
	// localhos : 현재 개인 pc에 ip주소.
	String URL = "jdbc:oracle:thin:@192.168.20.1:1521:xe"; // localhost 에 192.168.20.1를 붙여도된다.
	
	// 오라클 데이터베이스 서버 계정
	String USER = "scott";
	
	// 오라클 데이터베이스 서버 계정 비밀번호
	String PASSWORD = "tiger";
}

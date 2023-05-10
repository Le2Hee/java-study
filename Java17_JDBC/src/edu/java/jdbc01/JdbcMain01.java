package edu.java.jdbc01;

import java.sql.Connection;
// Java가 들고있는 것은 전부다 JDK클래스, 인터페이스
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import edu.java.jdbc.model.Blog;
// Oracle JDBC 라이브러리 클래스.
import oracle.jdbc.OracleDriver;

// OracleConnect 인터페이스에서 static로 선언된 모든 상수 이름들을 임포트.
import static edu.java.jdbc.oracle.OracleConnect.*;
import static edu.java.jdbc.model.Blog.Entity.*;

/*
 * JDBC (Java Database Connectivity) :
 * 		자바 프로그램에서 데이터베이스를 연결하고, SQL 문장들을 실행하는 방법.
 * 순서 : (Oracle를 사용하면 Oracle라이브러리 다운, MySQL사용하면 MㅛSQL라이브러리 다운)
 * 1. Oracle JDBC 라이브러리를 다운로드하고 자바 프로젝트에 라이브러리를 포함.
 * 		(1) 라이브러리 다운로드
 * 		(2) 이클립스 프로젝트 폴더에 lib이라는 폴더를 생성
 * 		(3) 다운로드한 라이브러리 jar(확정자) 파일을 lib 폴더에 복사
 *   	(4) jar파일을 프로젝트의 빌드 패스(build path)에 추가.
 *   (프로젝트마다 한번씩)
 * 
 * 2. 오라클 데이터베이스 서버에 접속하기 위한 정보들(필수)(URL, USER, RASSWORD)을 상수로 정의.
 * 이유 : 팩키지2,3,4,... 접속할려면 필요하다
 * 		oracle팩키지 생성 -> 인터페이스 생성 -> 오라클 넘어가서 접속 -> SCOTT 세부정보보기
 *  	-> localhost = 서버ip , 1521 = port , xe = SID(서비스 아이디)
 *  	명령 프로포톰에 ipconfig를 누르면 컴퓨터 정보에서 ip주소가 있다.
 *  
 * 3. 프로그램에서 오라클 JDBC 라이브러리를 사용할 수 있도록 드라이버 등록.
 * 		※드라이버 등록 : 라이브러리를 메모리 로딩.
 * 4. 데이터베이스 서버에 접속 -> (Connection).
 * 5. Statement 타입 객체 생성.
 *      ※ 생성하는 목적 : DB 서버에서 실행할 SQL 문장을 작성, 실행하는 객체.
 * 6. Statement 객체의 메서드를 사용해서 SQL 문장을 DB 서버로 전송하고, 그 결과를 처리.
 *      ※ 사용하는 메서드 :
 *        		executeQuery() : DQL. select 문장. 
 *        			- 테이블 값들이 변경이 아니라 단순하게 읽어오는 것.
 *          	executeUpdate() : DML. insert, update, delete 문장. 
 *          		- 테이블에 값들이 변화가 생기면
 * 7. 결과 처리 - 화면 출력.
 * 8. 사용했던 모든 리소스(Connection, Statement)들을 해제(close).
 * 
 * ---------------------------------- 메모 (select)----------------------------------
 * DriverManager.registerDriver(null); : null에 사용하는 프로그램 라이브러리를 넣어라.
 * 										(Oracle, ...)
 * new OracleDriver() : oracle.jdbc.OracleDriver -> 최신으로 나온 클래스여서 이걸 사용하자.
 * 데이터베이스 서버에 접속하면 Connection객체 생성후 finally에서 close를 해줘야된다.
 * 일단은 Connection con = null; 만들어 생성해주고 4번을 진행.
 * conn = DriverManager.getConnection(null, null, null) -> 접속할 URL, USER, PASSWORD
 * -> 인터페이스에서 들고오기 -> (import static edu.java.jdbc.oracle.OracleConnect.*;)
 * -> 이것도 thorows 여서 try-catch문을 사용해야됨.
 * conn.close(); 로 닫아야 한다. -> try-catch문을 사용
 * 실행 -> 4번까지 끝.
 * Statement 타입 객체 생성.(try 밖에 선언) -> PreparedStatement로 객체 생성 -> 일단은 select 부터
 * conn 이 Statement를 만들어줄 객체를 가지고 있다.
 * stmt = conn.prepareStatement("") 안에 SQL 문장을 넣어야된다
 * String sql = "select * from blogs"; 생성하고
 * () 안에 sql을 넣어준다.
 * "select * from blogs" : JDBC에서 SQL문장은 ;을 사용하지 않는다. 절대로!
 * prepareStatement = 리턴 타입 PreparedStatement인데 
 * Statement 가 부모 prepareStatement 자식 그래서 stmt에 넣을 수 있다.
 * stmt.close(); -> 닫아 줘야된다.
 * (주의) 리소스 해제 - 리소스가 생성된 순서의 반대로 close를 해줘야 된다.
 * 6. Statement 실행을 한다.
 * stmt.executeQuery() -> 아규먼트있는거 사용할 필요가 없다. 이미 만들어 놨기 때문에.
 * stmt.executeQuery(); 를 변수에 저장할꺼면 ResultSet 에 넣고 이것도 close해야된다.
 * ResultSet은 select에만 있고 다른데는 없다.
 * 7. 결과 처리는 6번에서 select결과가 ResultSet(테이블 모양)에 들어가 있다.
 * ResultSet 처리 방법 : 첫행 검사하고 읽어들이고 다음 행가서 읽고 하는 패턴이다. 
 * while문에 rs.next()넣는다. / rs.next() : ResultSet에 행(row) 데이터가 있는 경우
 * while문안에서 컬럼들을 다 읽는다.
 * rs.getInt()로 컬럼을 읽는다. / 아규먼트 : int = 컬럼 인덱스, String = 컬럼 이름.
 * Integer id = rs.getInt("id") / id 컬럼의 값을 읽고 int 타입으로 리턴하겠다.
 * (다른점) java는 인덱스 0부터 sql은 인덱스는 1번 부터 시작한다.
 * 문자열은 상수로 정의해 두면 언제든 불러서 쓸 수 있다.
 * LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
 * --> 시간 타입은 getTimestamp가 있고 이걸 toLocalDateTime()로 LocalDateTime으로 변환해야 된다.
 * LocalDateTime타입으로 설정하는 이유는 더 편리한 메서드들이 있기 때문에 변환해서 사용한다.
 * --> 여기까지 하면 행 하나를 읽은 것이다. -> while문이기 때문에 반복.
 * 
 * Blog blog = new Blog(id, title, content, author, createdTime, modifiedTime);
 * System.out.println(blog);
 * --> SQL 에서 commit; 을 해줘야 된다.!!!!!
 * 
 * ※ 컬럼 이름을 사용할때 오타가 많을 경우 : (컬럼 이름이 헷갈리면)
 * 		interface Entity 를 Blog클래스에서 내부 인터페이스(public)로 정의하면 편하다.
 * 		정의하고 나면
 * 		import static edu.java.jdbc.model.Blog.Entity.*; 를 해줘야 된다.
 * 
 * 		상수로 선언하면 편안 이유 : 코드 추천, 오타 수정은 인터페이스에서만 하면 된다.
 * 
 */

public class JdbcMain01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 3. Oracle JDBC driver(라이브러리) 등록.
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("오라클 드라이버 등록 성공");
			
			// 4.DB 서버에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("conn = " + conn);
			
			// 5. Statement 객체 생성.
			String sql = "select * from blogs order by id"; // JDBC에서 SQL문장은 ;을 사용하지 않는다. 절대로!
			stmt = conn.prepareStatement(sql);
			System.out.println("stmt =" + stmt);
			
			// 6. Statement 실행
			rs = stmt.executeQuery(); // select 문장 실행.
			System.out.println("rs = " + rs);
			
			// 7. 결과 처리
			while (rs.next()) { // ResultSet에 행(row) 데이터가 있는 경우
				Integer id = rs.getInt("id"); // id 컬럼의 값을 읽고 int 타입으로 리턴하겠다.
				String title = rs.getString("title"); // title 컬럼의 값을 String 타입으로 리턴.
				String content = rs.getString("content");
				String author = rs.getString("author");
				LocalDateTime createdTime = rs.getTimestamp("created_time").toLocalDateTime();
				// created_time 컬럼의 값을 Timestamp 타입으로 읽고,
				// 										LocalDateTime 타입으로 변환해서 리턴.
				LocalDateTime modifiedTime = rs.getTimestamp("modified_time").toLocalDateTime();
				
				// Blog는 우리가 만든 인터페이스.
				Blog blog = new Blog(id, title, content, author, createdTime, modifiedTime);
				System.out.println(blog);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제 - 리소스가 생성된 순서의 반대로 close를 해줘야 된다.
			try {
				rs.close();
				stmt.close();
				conn.close();
				System.out.println("Oracle DB 접속 해제 성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

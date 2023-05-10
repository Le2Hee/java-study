package edu.java.jdbc02;

import static edu.java.jdbc.oracle.OracleConnect.*;
import static edu.java.jdbc.model.Blog.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain02 {


	public static void main(String[] args) {
		/* 오라클 드라이버를 등록하는 과정은 똑같이 (select 랑같음)
		 * Connection를 생성하고 DB 접속 과정하기.
		 * import static edu.java.jdbc.oracle.OracleConnect.*; -> import 해줘야 됨.
		 * conn = DriverManager.getConnection(URL, USER, PASSWORD); 
		 * --> import 한거 집어 넣기.
		 * import static edu.java.jdbc.model.Blog.Entity.*; -> import하고
		 * String sql = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)",
					TBL_NAME, COL__TITLE, COL_CONTENT, COL_AUTHOR);
			하는데 ?는 어떤게 들어갈지 모르기 때문에 ?를 넣는다.
		 * Scanner scanner = new Scanner(System.in); -> 입력을 위해.
		 * Statement 타입 객체를 생성해준다. -> 윗쪽문장 SQL 을 실행할 수 있는 
		 * stmt.setString(1, title); --> 인덱스는 1, 왼쪽은 넣을 값
		 * "insert into %s (%s, %s, %s) values (?, ?, ?)" -> 미리만들어준문장
		 * --> 프리페어드스페테이드먼트 라고 한다. 
		 * 		(? : 비어있는 부분만 채울수 있게 java에서 ?를 만듬)
		 * 
		 */
		
		// DB 테이블에 insert 하기 :
		
		Scanner scanner = new Scanner(System.in); // 입력받기 위해서.
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			//오라클 드라이버를 등록하는 과정
			DriverManager.registerDriver(new OracleDriver());
			
			// 오라클 DB에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// SQL 문장(Statement)을 준비
			String sql = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)",
					TBL_NAME, COL__TITLE, COL_CONTENT, COL_AUTHOR);
			System.out.println(sql);
			
			// Statement 타입 객체를 생성.
			stmt = conn.prepareStatement(sql);
			
			// 제목, 내용 입력받기
			System.out.print("제 목 >>> "); 
			String title = scanner.nextLine();  // 필요한 타입에 맞처서.
			
			System.out.print("내 용 >>> ");
			String content = scanner.nextLine();
			
			// SQL 문장에서 ? 부분을 채워주는 것.
			stmt.setString(1, title); // 필요한 타입에 맞처서.
			stmt.setString(2, content);
			stmt.setString(3, "이찬희");
			
			// SQL 문자 실행
			int result = stmt.executeUpdate();
			System.out.println(result + "개 행이 삽입됐습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 모든 리소스 해제
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

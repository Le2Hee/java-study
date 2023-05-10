package edu.java.jdbc04;

import static edu.java.jdbc.oracle.OracleConnect.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static edu.java.jdbc.model.Blog.Entity.*;

public class JdbcMain04 {

	public static void main(String[] args) {
		// 과제 JDBC delete : 
		// delete from BLOGS where ID = ?
		
		Scanner scanner = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			
			conn =  DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = String.format("delete from %s where %s = ?",
					TBL_NAME, COL_ID);
			String sql1 = String.format("select %s from %s", COL_ID, TBL_NAME);
			
			stmt = conn.prepareStatement(sql);
			stmt1 = conn.prepareStatement(sql1);
			
			System.out.print("삭제할 번호를 입력하세요. >>> ");
			int id = Integer.parseInt(scanner.nextLine());
			
			
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			if (rs.next() == true) {
				int result = stmt.executeUpdate();
				System.out.println(id + "번이 삭제되었습니다.");
			} else {
				System.out.println(id + "번 글은 없습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}

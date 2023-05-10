package edu.java.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SizeRequirements;
import javax.swing.table.DefaultTableModel;

import edu.java.model.Score;
import edu.java.model.User;
import edu.java.view.LoginFrame;
import oracle.jdbc.OracleDriver;

import static edu.java.ojdbc.OracleMouseGame.*;
import static edu.java.model.Score.Entity.*;
import static edu.java.model.User.Entity.*;

public class MouseDaoImpl implements MouseGameDao {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static MouseDaoImpl instance = null;
	
	private MouseDaoImpl( ) {}
	
	public static MouseDaoImpl getInstance() {
		if (instance == null) {
			instance = new MouseDaoImpl();
		}
		
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}
	
	private void closeResources(Connection conn, PreparedStatement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	
	private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) 
			throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}
	
	

	@Override
	public int CreatedUser(User user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			String sql = String.format("insert into %s (%s, %s, %s) values (?, ? ,?)",
					TBL_NAME, COL_USERID, COL_USERPW, COL_NICKNAME);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getUserPW());
			stmt.setString(3, user.getNickname());
			
			result = stmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	@Override
	public User SelectUserRead(String nickname) {
		User user = new User();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s where %s = ?",
					TBL_NAME, COL_NICKNAME);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nickname);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString(COL_USERID);
				String userpw = rs.getString(COL_USERPW);
				String nic = rs.getString(COL_NICKNAME);
				
				user = new User(userid, userpw, nic);
				
				return user;
			} else {
				return null;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	

	@Override
	public User MyInformation(String userPW, String nowPw) {
		User user = new User();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		if (userPW.equals(nowPw)) {
			try {
				conn = getConnection();
				String sql = String.format("select * from %s where %s = ?",
						TBL_NAME, COL_USERPW);
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, userPW);
				rs = stmt.executeQuery();
				if (rs.next()) {
					String userId = rs.getString(COL_USERID);
					String userPw = rs.getString(COL_USERPW);
					String nickname = rs.getString(COL_NICKNAME);
					
					user = new User(userId, userPw, nickname);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					closeResources(conn, stmt, rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return user;
		} else {
			return null;
		}
		
		
		
	}

	@Override
	public User UserLogin(String userID, String userPW) {
		User user = new User();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s where %s = ? and %s = ?",
					TBL_NAME, COL_USERID, COL_USERPW);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userID);
			stmt.setString(2, userPW);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String userid = rs.getString(COL_USERID);
				String userpw = rs.getString(COL_USERPW);
				String nickname = rs.getString(COL_NICKNAME);
				user = new User(userid, userpw, nickname);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		return null;
	}

	@Override
	public int UpdatePW(String userPW, User user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			String sql = String.format("Update %s set %s = ? where %s = ? and %s = ? and %s = ?",
					TBL_NAME, COL_USERPW, COL_USERID, COL_USERPW, COL_NICKNAME);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userPW);
			stmt.setString(2, user.getUserId());
			stmt.setString(3, user.getUserPW());
			stmt.setString(4, user.getNickname());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int UpdateNIC(String userNIC, User user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			String sql = String.format("Update %s set %s = ? where %s = ? and %s = ? and %s = ?",
					TBL_NAME, COL_NICKNAME, COL_USERID, COL_USERPW, COL_NICKNAME);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, userNIC);
			stmt.setString(2, user.getUserId());
			stmt.setString(3, user.getUserPW());
			stmt.setString(4, user.getNickname());
			
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int Delete(String userID, String userPW, User user) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		if (user.getUserId().equals(userID) && user.getUserPW().equals(userPW)) {
			try {
				conn = getConnection();
				String sql = String.format("delete from %s where %s = ? and %s = ?",
						TBL_NAME, COL_USERID, COL_USERPW);
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, userID);
				stmt.setString(2, userPW);
				
				result = stmt.executeUpdate();
				
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					closeResources(conn, stmt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
		} else {
			return result;
		}
	}
	
	@Override
	public int CreatedScore(String userNIC, long time) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			String sql = String.format("insert into %s (%s, %s) values (?, ?)",
					TBL_SCNAME, COL_SCNICKNAME, COL_TIME);
			stmt = conn.prepareStatement(sql);
			
			String stime = String.valueOf(time);
			int inttime = Integer.parseInt(stime);
			
			stmt.setString(1, userNIC);
			stmt.setInt(2, inttime);
			
			result = stmt.executeUpdate();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public List<Score> ScoreRead() {
		List<Score> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s order by %s",
					TBL_SCNAME, COL_TIME);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String nic = rs.getString(COL_NICKNAME);
				Long time = rs.getLong(COL_TIME);
				
				list.add(new Score(nic, time));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<Score> MyScoreRead(User user) {
		List<Score> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s where %s = ? order by %s",
					TBL_SCNAME, COL_SCNICKNAME, COL_TIME);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getNickname());
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				String nic = rs.getString(COL_SCNICKNAME);
				Long time = rs.getLong(COL_TIME);
				
				list.add(new Score(nic, time));
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	@Override
	public List<Score> SelectScoreRead(String nickname) {
		List<Score> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s where %s = ? order by %s",
					TBL_SCNAME, COL_SCNICKNAME, COL_TIME);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nickname);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				String nic = rs.getString(COL_SCNICKNAME);
				Long time = rs.getLong(COL_TIME);
				
				list.add(new Score(nic, time));
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	

}

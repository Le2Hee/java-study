package edu.java.controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.model.Score;
import edu.java.model.User;

// 아이디 - (만들기, 읽기, 수정하기, 삭제)
// 점수 - (랭킹 점수 보기, 랭킹 점수 추가, 랭킹 점수 없애기)
public interface MouseGameDao {
	
	/**
	 * 유저를 생성하는 시스템
	 * @param user 새로 생성되는 유저의 정보
	 * @return
	 */
	int CreatedUser(User user);
	
	/**
	 * 닉네임으로 검색한 유저의 정보를 불러오는 시스템.
	 * @param nickname
	 * @return
	 */
	User SelectUserRead(String nickname);
	
	
	/**
	 * 비밀번호를 입력하고 나의 정보를 보는 시스템.
	 * @param userPW 비밀번호 입력.
	 * @return 나의 정보
	 */
	User MyInformation(String userPW, String nowPW);
	
	/**
	 * 로그인 하는 시스템.
	 * @param userPW 유저 개인 비밀번호
	 * @return 1을 리턴하면 로그인 성공, -1을 리턴하면 로그인 실패.
	 */
	User UserLogin(String userID, String userPW);
	
	/**
	 * 유저 비밀번호 수정 시스템
	 * @param user
	 * @return 실패하면 0을 리턴.
	 */
	int UpdatePW(String userPW, User user);
	
	/**
	 * 유저 닉네임 변경 시스템.
	 * @param userNIC 바꿀 닉네임.
	 * @return 실패하면 0을 리턴.
	 */
	int UpdateNIC(String userNIC, User user);
	
	/**
	 * 유저 탈퇴 시스템.
	 * @param userPW 자신의 비밀번호.
	 * @return
	 */
	int Delete(String userID, String userPW, User user);
	
	/**
	 * 점수판에 계정을 등록하는 시스템.
	 * @param userNIC 유저의 닉네임.
	 * @return
	 */
	int CreatedScore(String userNIC, long time);
	
	/**
	 * 전체 랭킹 보기 시스템.
	 * @return
	 */
	List<Score> ScoreRead();
	
	/**
	 * 나의 점수들 보기.
	 * @return
	 */
	List<Score> MyScoreRead(User user);
	
	/**
	 * 다른 유저의 정보 보기
	 * @param nickname
	 * @return
	 */
	List<Score> SelectScoreRead(String nickname);
	
}

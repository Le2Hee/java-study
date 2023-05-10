package edu.java.contact.controller;

import java.util.List;

import edu.java.contact.model.Contact;

// MVC 아키텍처에서 controller 역할의 인터페이스.
// CRUD(Create-insert, Read-select, Update, Delete)
public interface ContactDao {
	
	/**
	 * 연락처 전체 검색하는 기능.
	 * DB contacts 테이블에 저장된 연락처 정보를 검색.
	 * 
	 * @return Contact타입을 원소로 갖는 List를 리턴한다.
	 */
	List<Contact> read();
	
	/**
	 * DB contacts 테이블에서 PK로 연락처 정보를 검색하는 기능.
	 * 
	 * @param cid 검색할 primary key
	 * @return cid가 존재하면 Contact 타입 객체를 리턴, cid가 없으면 null을 리턴.
	 */
	Contact read(int cid);
	
	/**
	 * DB contacts 테이블에서 키워드(이름 or 전화번호 or 이메일)로 연락처 정보를 검색하는 기능.
	 * 검색어는 대/소문자 구분이 없다.
	 * 
	 * @param keyword 검색어
	 * @return 검색 결과 리스트.
	 */
	List<Contact> read(String keyword);
	
	
	/**
	 * 연락처 정보를 DB contact 테이블에 insert하는 기능.
	 * 
	 * @param contact 저장할 이름, 전화번호, 이메일 정보를 가지고 있는 객체
	 * @return DB 테이블에 삽입된 행의 개수.
	 */
	int Create(Contact contact);
	
	/**
	 * primary key에 해당하는 연락처 정보를 수정(업데이트).
	 * 
	 * @param contact 수정할 연락처에 PK, 업데이트할 이름, 전화번호, 이메일를 가지고 있는 객체.
	 * @return DB 테이블에 업데이트된 행의 개수.
	 */
	int Update(Contact contact);
	
	/**
	 * primary key에 해당하는 연락처 정보를 삭제
	 * 
	 * @param cid 삭제할 연락처에 해당하는 PK(cid).
	 * @return DB 테이블에 삭제된 행의 개수.
	 */
	int Delete(Integer cid);
	
	
	
}

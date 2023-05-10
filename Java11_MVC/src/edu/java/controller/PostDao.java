package edu.java.controller;

import edu.java.model.Post;

public interface PostDao {
	
	 /**
     * 새 연락처 저장 기능. 연락처 객체를 배열에 저장
     * @param c 배열에 저장할 연락처 객체.
     * @return 배열에 저장 성공하면 1, 실패하면 0.
     */
    int create(Post c);
    
    /**
     * 연락처 전체 목록 보기 기능. 저장된 연락처 개수 크기의 연락처 배열을 리턴.
     * @return 연락처 배열(Contact[]).
     */
    Post[] read();
    
    /**
     * 인덱스 검색. 전달받은 인덱스 위치에 있는 연락처 객체를 리턴.
     * @param index 검색할 인덱스. 0 이상의 정수.
     * @return 해당 인덱스의 연락처(Post) 객체 또는 null.
     */
    Post read(int index);
    
    /**
     * 인덱스 수정 기능.
     * @param index 수정할 연락처의 인덱스. 0 이상이고, 저장된 연락처 개수보다 작은 정수.
     * @param post 수정할 연락처 정보를 가진 객체.
     * @return 수정 성공하면 1, 실패하면 0.
     */
    int update(int index, Post post);
    
    /**
     * 연락처 삭제 기능.
     * @param index 삭제할 연락처의 인덱스. 0 이상이고, 저장된 연락처 개수보다 작은 정수.
     * @return 삭제 성공하면 1, 실패하면 0.
     */
    int delete(int index);
}

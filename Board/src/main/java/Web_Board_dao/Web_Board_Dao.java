package Web_Board_dao;


import java.util.List;

import Web_Board_domain.Web_Board;

public interface Web_Board_Dao {

	Web_Board allView(Web_Board webboard); // 웹 게시판의 모든 정보를 조회하여 반환하는 메서드입니다.
	
	List<Web_Board> selectAll(int page, int countPerPage);
	// 페이지와 페이지당 항목 수를 기반으로 웹 게시판의 목록을 조회하여 반환하는 메서드입니다.
	Web_Board insert(Web_Board webboard); 
	// 웹 게시판에 새로운 게시글을 추가하는 메서드입니다.
	Web_Board write(Web_Board webboard); 
	// 웹 게시판에 게시글을 작성하는 메서드입니다.
	Web_Board update(int id, Web_Board webboard); 
	// 특정 게시글을 수정하는 메서드입니다.
	Web_Board delete(int id, Web_Board webboard); 
	// 특정 게시글을 삭제하는 메서드입니다.
	List<Web_Board> OneView(int id, Web_Board webBoard); 
	// 특정 게시글을 조회하여 반환하는 메서드입니다.
	public int count();
	// 게시글의 총 수를 반환하는 메서드입니다.
	public String date();
	// 현재 날짜를 반환하는 메서드입니다.
	public int maxCount();// 게시글의 최대 수를 반환하는 메서드입니다.
}

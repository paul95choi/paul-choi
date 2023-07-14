package kr.ac.kopo.ctc.kopo33.service;

import kr.ac.kopo.ctc.dto.*;

public interface StudentScoreService {// StudentScoreService 인터페이스를 정의
	// 페이지 네이션을 구현하기 위한 인터페이스 정의
	// 페이지네이션 정보를 반환하는 메서드. 매개변수 c는 전체 항목 수를, countPerPage는 페이지당 항목 수를 나타낸다. 
	// 이 메서드는 Pagination 객체를 반환하여 페이지네이션 정보를 담을 수 있도록 한다.
	Pagination getPagination(int page, int countperpage);
	   
	
}

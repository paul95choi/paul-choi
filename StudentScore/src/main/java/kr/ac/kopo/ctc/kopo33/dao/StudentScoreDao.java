package kr.ac.kopo.ctc.kopo33.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo33.domain.StudentScore;

public interface StudentScoreDao {
	
	int count(); //총 데이터수를 세는 함수 선언

	StudentScore create(StudentScore studentScore); //총 데이터수를 세는 메서드 선언

	StudentScore selectOne(int studentId, StudentScore studentScoreOneView); //하나의 데이터만 보는 메서드 선언

	List<StudentScore> selectAll(int page, int countPerPage); //전체 데이터를 보는 메서드 선언

	StudentScore update(int id, StudentScore studentScore); //데이터를 업데이트 하는 메서드 선언

	StudentScore deleteById(int id); //아이디로 데이터를 지우는 메서드 선언

	StudentScore deleteByStudentId(int studentId, StudentScore studentScoreDelete); //학번으로 데이터를 지우는 메서드 선언
	
	public String createTable(); //테이블을 만드는 메서드 선언
	
	public String insertData(); //테이블에 값을 입력하는 선언
	
	public String DropTable(); //테이블을 삭제하는 메서드 선언
	
	List<StudentScore> getAll(); //전체 데이터를 담아주는 리스트 메서드 선언
	
	List<StudentScore> getOne(int studentId); //선택한 하나의 데이터를 담아주는 리스트 메서드 선언
	
	public int getPageByStudentId(int studentId, int itemsPerPage); //해당 학번을 입력받아 해당 학번의 페이지를 구하는 메서드 선언

	StudentScore selectOne(int id);

	StudentScore deleteByStudentId(int studentId);

}

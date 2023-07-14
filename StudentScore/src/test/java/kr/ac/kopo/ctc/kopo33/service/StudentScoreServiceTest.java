package kr.ac.kopo.ctc.kopo33.service;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.ac.kopo.ctc.dto.Pagination;
import kr.ac.kopo.ctc.kopo33.dao.StudentScoreDao;
import kr.ac.kopo.ctc.kopo33.dao.StudentScoreDaoImp;
import kr.ac.kopo.ctc.kopo33.domain.StudentScore;

class StudentScoreServiceTest {

	
	@Test
	   void test_create() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
	      StudentScore studentScore = new StudentScore();

	      studentScore.setName("홍길동");
	      studentScore.setStudentid(808010);
	      studentScore.setKor(100);
	      studentScore.setEng(100);
	      studentScore.setMat(100);

	      studentScoreDao.create(studentScore);
	   }

	   @Test
	   void test_selectOne() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
	      StudentScore studentScore = new StudentScore();
	      studentScore = studentScoreDao.selectOne(1);
	      System.out.println(studentScore.getId());
	      System.out.println(studentScore.getName());
	      System.out.println(studentScore.getStudentid());
	      System.out.println(studentScore.getKor());
	      System.out.println(studentScore.getEng());
	      System.out.println(studentScore.getMat());

	   }

	   @Test
	   void test_selectAll() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
	      StudentScoreService studentScoreService = new StudentScoreServiceImp();
	      Pagination pagination = studentScoreService.getPagination(11, 50);
	      List<StudentScore> studentScore = studentScoreDao.selectAll(pagination.getC(), 50);
	      System.out.println(studentScore.toString());
	   }
	   



	   @Test
	   void test_update() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
	      StudentScore studentScore = new StudentScore();
	      studentScore.setName("홍길동");
	      studentScore.setStudentid(808010);
	      studentScore.setKor(100);
	      studentScore.setEng(10);
	      studentScore.setMat(100);
	      int id = 101;
	      StudentScore updateStudentScore = studentScoreDao.update(id, studentScore);
	      System.out.println(updateStudentScore.getId());
	      System.out.println(updateStudentScore.getName());
	      System.out.println(updateStudentScore.getStudentid());
	      System.out.println(updateStudentScore.getKor());
	      System.out.println(updateStudentScore.getEng());
	      System.out.println(updateStudentScore.getMat());
	   }

	   @Test
	   void test_delete() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
	      StudentScore studentScore = new StudentScore();
	      studentScore = studentScoreDao.deleteById(209901);
	   }
	   
	   @Test
	   void test_deletebyid() {
	      StudentScoreDao studentScoreDao = new StudentScoreDaoImp();
	      StudentScore studentScore = new StudentScore();
	      studentScore = studentScoreDao.deleteByStudentId(209902);
	   }
//	@Test
//	void test_50_1() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(1, 50);
//		assertEquals(pagination.getC(),1);
//		assertEquals(pagination.getS(),1);
//		assertEquals(pagination.getE(),10);
//		assertEquals(pagination.getP(),-1);
//		assertEquals(pagination.getPp(),-1);
//		assertEquals(pagination.getN(),11);
//		assertEquals(pagination.getNn(),23);
//	}
//	@Test
//	void test_50_0() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(0, 50);
//		assertEquals(pagination.getC(),1);
//		assertEquals(pagination.getS(),1);
//		assertEquals(pagination.getE(),10);
//		assertEquals(pagination.getP(),-1);
//		assertEquals(pagination.getPp(),-1);
//		assertEquals(pagination.getN(),11);
//		assertEquals(pagination.getNn(),23);
//		}
//	@Test
//	void test_50_minus100() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(-100, 50);
//		assertEquals(pagination.getC(),1);
//		assertEquals(pagination.getS(),1);
//		assertEquals(pagination.getE(),10);
//		assertEquals(pagination.getP(),-1);
//		assertEquals(pagination.getPp(),-1);
//		assertEquals(pagination.getN(),11);
//		assertEquals(pagination.getNn(),23);
//		}
//		
//	@Test
//	void test_50_5() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(5, 50);
//		assertEquals(pagination.getC(),5);
//		assertEquals(pagination.getS(),1);
//		assertEquals(pagination.getE(),10);
//		assertEquals(pagination.getP(),-1);
//		assertEquals(pagination.getPp(),-1);
//		assertEquals(pagination.getN(),15);
//		assertEquals(pagination.getNn(),23);
//		}
//
//	@Test
//	void test_50_10() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(10, 50);
//		assertEquals(pagination.getC(),10);
//		assertEquals(pagination.getS(),1);
//		assertEquals(pagination.getE(),10);
//		assertEquals(pagination.getP(),-1);
//		assertEquals(pagination.getPp(),-1);
//		assertEquals(pagination.getN(),20);
//		assertEquals(pagination.getNn(),23);
//		}
//	@Test
//	void test_50_11() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(11, 50);
//		assertEquals(pagination.getC(),11);
//		assertEquals(pagination.getS(),11);
//		assertEquals(pagination.getE(),20);
//		assertEquals(pagination.getP(),1);
//		assertEquals(pagination.getPp(),1);
//		assertEquals(pagination.getN(),21);
//		assertEquals(pagination.getNn(),23);
//		}
//	@Test
//	void test_50_15() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(15, 50);
//		assertEquals(pagination.getC(),15);
//		assertEquals(pagination.getS(),11);
//		assertEquals(pagination.getE(),20);
//		assertEquals(pagination.getP(),5);
//		assertEquals(pagination.getPp(),1);
//		assertEquals(pagination.getN(),23);
//		assertEquals(pagination.getNn(),23);
//		}
//	@Test
//	void test_50_20() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(20, 50);
//		assertEquals(pagination.getC(),20);
//		assertEquals(pagination.getS(),11);
//		assertEquals(pagination.getE(),20);
//		assertEquals(pagination.getP(),10);
//		assertEquals(pagination.getPp(),1);
//		assertEquals(pagination.getN(),23);
//		assertEquals(pagination.getNn(),23);
//		}
//	@Test
//	void test_50_21() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(21, 50);
//		assertEquals(pagination.getC(),21);
//		assertEquals(pagination.getS(),21);
//		assertEquals(pagination.getE(),23);
//		assertEquals(pagination.getP(),11);
//		assertEquals(pagination.getPp(),1);
//		assertEquals(pagination.getN(),-1);
//		assertEquals(pagination.getNn(),-1);
//		}
//	
//	@Test
//	void test_50_25() {
//		StudentScoreService studentScoreService = new StudentScoreServiceImp();
//		Pagination pagination = studentScoreService.getPagination(25, 50);
//		assertEquals(pagination.getC(),23);
//		assertEquals(pagination.getS(),21);
//		assertEquals(pagination.getE(),23);
//		assertEquals(pagination.getP(),13);
//		assertEquals(pagination.getPp(),1);
//		assertEquals(pagination.getN(),-1);
//		assertEquals(pagination.getNn(),-1);
//		//fail("Not yet implemented");
//		assertEquals("1","1");
//	}

}

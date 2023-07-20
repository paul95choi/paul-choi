package com.kopo.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kopo.domain.Book;

public interface BookRepository {
	
	//��ü ���� ��� ��ȯ
	List<Book> getAllBookList();
	
	//�Ű������� ������ ������ ������ ��ȯ
	List<Book> getBookListByCategory(String category);
	
	//category & publisher �� ������ ������ ��ȯ
	//EX url) localhost:8081/controller/books/filter/bookFilter;publisher=네이버;category=IT전문서
	//�� URL�� �Է��ϸ� �����ϴ� ��ϸ� ��ȯ�ǵ��� �����Ͻÿ�. ���̹�, IT������ ���� value�� ����Ǿ �������
	Set<Book> getBookListByFilter(Map<String, List<String>>filter);
	
	Book getBookById(String bookId);
}

package com.kopo.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.kopo.domain.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	//퍼시스턴스 계층
	private List<Book> listOfBooks = new ArrayList<Book>();
	
	public BookRepositoryImpl() {
		Book book1 = new Book("ISBN1234","커뮤니티 자본론", 17100);
		book1.setAuthor("최바울");
		book1.setDescription("규석아 너 왜 그렇게 사니 나이는 개 똥으로 쳐먹고 너 군대에서 고문관이었나?");
		book1.setPublisher("바울출판사");
		book1.setCategory("경영");
		book1.setUnitsInStock(1000);//책재고
		book1.setReleaseDate("2023/07/15");
		
		Book book2 = new Book("ISBN1235","커뮤니티 자본론", 18100);
		book2.setAuthor("저자");
		book2.setDescription("책설명");
		book2.setPublisher("출판사");
		book2.setCategory("economics");
		book2.setUnitsInStock(1000);//책재고
		book2.setReleaseDate("2023/07/15");
		
		Book book3 = new Book("ISBN1236","커뮤니티 자본론", 17500);
		book3.setAuthor("저자");
		book3.setDescription("책설명");
		book3.setPublisher("출판사");
		book3.setCategory("드라마");
		book3.setUnitsInStock(1000);//책재고
		book3.setReleaseDate("2023/07/15");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	@Override
	public List<Book> getAllBookList() {
		// TODO Auto-generated method stub
		return listOfBooks;
	}
	@Override
	public List<Book> getBookListByCategory(String category) {
		List<Book> booksByCategory = new ArrayList<Book>();
		for(int i = 0; i < listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if(category.equalsIgnoreCase(book.getCategory()))
				booksByCategory.add(book);
		}
		
		return booksByCategory;
	}
	@Override
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
		//category & publisher 가 동일한 도서만 반환
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();
		
		Set<String> booksByFilter = filter.keySet();
		
		//publisher 검출 작업
		if(booksByFilter.contains("publisher")) {
			for(int j = 0; j< filter.get("publisher").size(); j++) {
				String publisherName = filter.get("publisher").get(j);
				for(int i = 0; i < listOfBooks.size(); i++) {
					Book book = listOfBooks.get(i);
					
					if(publisherName.equalsIgnoreCase(book.getPublisher()))
						booksByPublisher.add(book);
				}
			}
		}
		if(booksByFilter.contains("category")) {
			for(int i = 0; i < filter.get("category").size(); i++) {
				String category = filter.get("category").get(i);
				List<Book> list = getBookListByCategory(category);//만들어 놓은 메서드 활용
				booksByCategory.addAll(list);
			}
		}
		booksByCategory.retainAll(booksByCategory);
		return booksByCategory;
	}
	@Override
	public Book getBookById(String bookId) {
		Book bookInfo = null;
		for(int i = 0; i< listOfBooks.size(); i++) {
			Book book = listOfBooks.get(i);
			if(book != null && book.getBookId() != null && book.getBookId().equals(bookId)) {
				bookInfo = book;
				break;
			}
		}
		if(bookInfo == null)
			throw new IllegalArgumentException("도서의 ID를 찾을 수가 없습니다 : " + bookId);
	      
	      return bookInfo;
	   }
}

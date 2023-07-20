package com.kopo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kopo.domain.Book;
import com.kopo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	//@RequestMapping(value = "/books", method=RequestMethod.GET)
	//@RequestMapping	
	@GetMapping
	public String requsetMethod(Model model) {
			List<Book> list = bookService.getAllBookList();
			model.addAttribute("bookList", list);	
			
			return "books";
	}
		
	
	//@RequestMapping("/all")	
//	@GetMapping("/all") // ->mav 형식으로 변경
//	public String requsetAllBooks(Model model) {
//			List<Book> list = bookService.getAllBookList();
//			model.addAttribute("bookList", list);	
//			return "books";
//	}
	@GetMapping("/all")
	public ModelAndView requestAllBooks(ModelMap model) {
		ModelAndView mav = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		mav.addObject("bookList", list);
		mav.setViewName("books");
		return mav;
	}
	
	
	/*
	 @GetMapping("/exam08/{category}/publisher/{publisher}")
	public String requestMethod(@PathVariable String category, <-IT전문서
	*/
	
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory
			, Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
	
	
	
	//EX url) localhost:8081/controller/books/filter/bookFilter;publisher=네이버;category=IT전문서
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(
			@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter,
			Model model) {
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByFilter);
		return "books";
	}
	
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
	
	
	
	
	
	
	
	
}

package com.kopo.test;
//@PathVariable
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ExampleController07 {
	
/*
경로변수 = @PathVariable
웹 요청 URL에 포함된 파라미터 값을 전달받을 수 있음.
사용방법: {}중괄호를 활용하여 URL에 포함된 요청 조건 값을 전달 받음.

사용방법 1
@RequestMapping("경로변수")
public String MethodName(@PathVariable 경로변수,..){}

사용방법 2 - 들어온 값의 이름 바꿔서 사용하기
@RequestMapping("경로변수")
public String MethodName(@PathVariable (경로변수) 매개변수, ..){}

 *
 */
	
	@GetMapping("/exam07/{bookId}") //exam06이 들어왔을때만 처리 //exam06/red red라는 변수를 받아옴.
	public String requestMethod(@PathVariable String bookId, Model model) {
		System.out.println("도서 ID : " + bookId);
		model.addAttribute("data","도서 ID : " + bookId);
		return "webpage06";
	}
}
	


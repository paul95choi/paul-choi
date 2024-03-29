package com.kopo.test;
//@PathVariable
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ExampleController09 {
	

	
	/*
	 * Matrix변수
	 * 웹에서 요청이 여러개 들어올 경우에 웹 요청 URL에 다중 파라미터 값을 전달 받는 매트릭스 변수(matrix variable)
	 *context root/books/color;		year=2023;month=07 //map형식으로 지정
	 *context root/books;				color=red,green,blue; //map형식으로 지정
	 *
	 * @RequestMapping("경로 변수")
	 * public String MethodName(@MatrixVariable 매트릭스 변수, ....) {} //전달된 매트릭스 변수 이름 그대로 사용
	 * public String MethodName(@MatrixVariable (매트릭스 변수) 매개변수, ....) {} //매트릭스 변수의 이름만 바꿔서 사용
	 * 
	 * [속성종류]
	 * defaultValue - 기본값으로 대체
	 * name - 매트릭스 변수 이름
	 * pathVar - 매트릭스 변수가 있는 URI 경로 변수의 이름
	 * required - 매트릭스 변수가 요구되는지 여부
	 * value - 매트릭스 변수의 'name = value'에서 name에 해당하는 영역
	 * 
	 * 
	 */
	
	//matrixvariable은 어디에 속해져있다??
	//exam09/abcd1234;category=무협지
	@GetMapping("/exam09/{bookId}") //exam06이 들어왔을때만 처리 //exam06/red red라는 변수를 받아옴.
	public String requestMethod(@PathVariable String bookId, @MatrixVariable String category, Model model) {
		System.out.println("책이름 : " + bookId);
		System.out.println("분류 : " + category);
		model.addAttribute("data", " 책이름 : " + bookId + "<br>" + "분류 : " + category); 
		return "webpage06";
	}
	
	//matrixvariable은 pathvariable에 종속되어있음
}
	


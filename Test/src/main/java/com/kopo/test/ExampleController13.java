package com.kopo.test;
//@PathVariable
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class ExampleController13 {
	

	
	/*
	
	
	

	
	*/
	

	//exam12/abcd1234;publisher=네이버;name=광마회귀/category/무협지;publisher=카카오;author=둘리
	@GetMapping("/exam13") 
	public String requestMethod(@RequestParam String id, Model model) {
		System.out.println("도서의 ID: " + id);
		model.addAttribute("data", "도서의 id: " + id);
		return "webpage06";
		
	}
}

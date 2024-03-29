package com.kopo.test;
//모델맵 실습
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ExampleController05 {
	
/*
 * model = 모델에 응답 데이터를 저장함
 * 
 * 모델 클래스
 * Model = 데이터 정보를 저장 (기능 똑같), (인터페이스)
 * 역할: 제공된 이름으로 제공된 속성을 등록
 * 매개변수:
 * - attributeName: 속성의 이름 - null 불가
 * - attributeValue: 속성의 값 - null 가능
 * 
 * ModelMap = 데이터 정보를 저장 (기능 똑같), 구현체, 
 * 		Model vs ModelMap : 차이가 있으나 시스템에서 처리 되기에 결과적으로 어떤 것을 활용하든 동일함
 *  * 역할: 제공된 이름으로 제공된 속성을 등록
 * 매개변수:
 * - attributeName: 속성의 이름 - null 불가
 * - attributeValue: 속성의 값 - null 가능
 * 
 * 
 * ModelAndView =  모델 정보 및 뷰 정보를 저장
 */
	
	@GetMapping("/exam05")
	public String requestMethod(ModelMap model) { //
		model.addAttribute("data","ModelMap 예제"); //data라는 속성에 "model 예제"라는 String 저장
		model.addAttribute("data2","웹 요청: /home/exam05");
		return "webpage05";
}
}
	


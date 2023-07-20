package com.kopo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ExampleController03 {
/*
 * @RequestMapping의 단순화
 * 스프링 4.3 버전부터 지원
 * GET방식인 경우 @GetMapping 에너테이션 활용 가능(GET requestMapping라고 읽음)
 * GetMapping - 요청이 get인 경우
 * PostMapping - 요청이 post인 경우
 * PutMapping - 요청이 put인 경우
 * DeleteMapping - 요청이 delete인 경우
 * PatchMapping - 요청이 patch 
 */
	@RequestMapping
	//@GetMapping("/exam03")
	public void requestMethod() {
			System.out.println("@RequestMapping예제");
			System.out.println("웹 요청은 /exam03");
	}
}
	


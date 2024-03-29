package com.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    // "/home" URL에 대한 GET 요청을 처리합니다.
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(Model model) {
        // "hello"라는 속성 이름으로 "Welcome to WebtoonPage"라는 데이터를 모델에 추가합니다.
        model.addAttribute("hello", "Welcome to Webtoon page.");

        // "strapline"이라는 속성 이름으로 "Welcome to Webtoon Mail"이라는 데이터를 모델에 추가합니다.
        model.addAttribute("strapline", "welcome to webtoon mall.");

        // "welcome"라는 뷰 이름을 반환합니다.
        return "welcome";
    }
}

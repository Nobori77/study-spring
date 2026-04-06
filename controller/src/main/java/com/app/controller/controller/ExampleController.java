package com.app.controller.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/ex/*")
public class ExampleController {

    @GetMapping("/ex01")
    public String ex01(String name, int age) {
      log.info("ex01 응답완료");
      log.info("name : {}, age : {}, realAge: {}", name, age, age - 1);

      // GET방식으로 데이터를 어떻게 보내야 하는가
      // 이름과 나이를 요청보내고,
      // 이름과 나이 , 만나이를 로그에 출력하기

//    ex.01.html
//    ex01 -> templates/ex01.html
//    ex/ex/ex01 -> templates/ex/ex/ex01.html
//    응답되는 페이지의 파일 경로
      return "ex01";
    }

    @PostMapping("/ex01")
    public void ex01Test(String name, int age) {
        log.info("ex01 응답완료");
        log.info("name : {}, age : {}, realAge: {}", name, age, age - 1);
    }

    @GetMapping("ex02")
    public String ex02(String name, Model model) {
        model.addAttribute("name", name);
        return "ex02";
    }

    @GetMapping("ex03")
    public String ex03(String name, Model model) {
        List<String> nameList = Arrays.asList("홍길동", "장보고", "이순신");
//        ArrayList<String> nameList2 = new ArrayList<>(Arrays.asList("홍길동", "장보고", "이순신"));
//        model.addAttribute("names", names);

        model.addAttribute("name", name);
        model.addAttribute("list", nameList);
        return "ex03";
    }

//    ModelAttribute: 반드시 쿼리스트링 값을 전달해야 한다.
    @GetMapping("ex04")
    public String ex04(@ModelAttribute("name") String name) {
        return "ex04";
    }

    // ex05
    // Model 어노테이션 활용
    // 이름,취미를 받고
    // 화면에 이름 : 000
    // 취미 : 000 으로 출력하기

    @GetMapping("ex05")
    public String ex05(@ModelAttribute("name") String name, @ModelAttribute("hobby") String hobby) {
        log.info("name : {}, hobby : {}", name, hobby);
        return "ex05";
    }
}

package com.app.threetier.controller;

import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/students/*")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/register")
    public void goToRegisterStudent(@ModelAttribute StudentVO studentVO){;}

    @PostMapping("/register")
    public RedirectView registerStudent(StudentVO studentVO){
        studentService.registerStudent(studentVO);
        return new RedirectView("/students/read?id=" + studentVO.getId());
    }

    @GetMapping("/read")
    public void goToRead(Long id, Model model){
        studentService.getStudent(id).ifPresentOrElse(
                (student) -> {
                    model.addAttribute("student", student);
                    },
                () -> {
                    model.addAttribute("student", new StudentVO());
                }
        );
    }
}

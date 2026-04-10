package com.app.threetier.service;

import com.app.threetier.domain.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentServiceTests {
    @Autowired
    private StudentService studentService;

    @Test
    public void registerStudentTest(){
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName("장보고");
        studentVO.setKor(50);
        studentVO.setEng(30);
        studentVO.setMath(77);
        studentService.registerStudent(studentVO);
        log.info("student: {}", studentService.getStudent(studentVO.getId()));
    }

    @Test
    public void getStudentListTest(){
        log.info("student: {}", studentService.getStudentList());
    }

    @Test
    public void updateStudentTest(){
        log.info("student: {}", studentService.getStudent(21L));
        StudentVO studentVO = new StudentVO();
        studentVO.setId(21L);
        studentVO.setStudentName("장보고");
        studentVO.setKor(130);
        studentVO.setEng(140);
        studentVO.setMath(187);
        studentService.updateStudent(studentVO);
        log.info("수정후 student: {}", studentService.getStudent(21L));
    }

    @Test
    public void deleteStudentTest(){
        studentService.deleteStudent(21L);
    }
}

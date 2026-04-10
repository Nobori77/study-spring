package com.app.threetier.service;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    // 학생 등록
    public void registerStudent(StudentVO studentVO);

    // 학생 단일 조회
    public Optional<StudentDTO> getStudent(Long id);

    // 학생 전체 조회
    public List<StudentDTO> getStudentList();

    // 학생 정보 수정
    public void updateStudent(StudentVO studentVO);

    // 학생 정보 삭제
    public void deleteStudent(Long id);

}

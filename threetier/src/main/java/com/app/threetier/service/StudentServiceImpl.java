package com.app.threetier.service;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import com.app.threetier.repository.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    @Override
    public void registerStudent(StudentVO studentVO) {
        studentDAO.save(studentVO);
    }

    public Optional<StudentDTO> getStudent(Long id) {
        return Optional.ofNullable(studentDAO.findById(id));
    }

    @Override
    public List<StudentDTO> getStudentList() {
        return studentDAO.findAll();
    }

    @Override
    public void updateStudent(StudentVO studentVO) {
        studentDAO.update(studentVO);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDAO.delete(id);
    }
}

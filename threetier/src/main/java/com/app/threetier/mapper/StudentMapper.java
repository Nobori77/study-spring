package com.app.threetier.mapper;

import com.app.threetier.domain.dto.StudentDTO;
import com.app.threetier.domain.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    // 학생 추가
    public void insert(StudentVO studentVO);

    // 학생 전체 조회
    public List<StudentDTO> selectAll();

    // 학생 단일 조회
    // Mapper와 DAO는 Optional로 감싸지 않는다.
    public StudentDTO select(Long id);

    // 학생 정보 수정
    public void update(StudentVO studentVO);

    // 학생 정보 삭제
    public void delete(Long id);
}

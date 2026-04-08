package com.app.threetier.repository;

// 레포지토리(Repository)
// 엔티티에 의해 생성된 데이터베이스 테이블에 직접 접근하는 메서드를 가진 객체 또는 인터페이스

import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.vo.PostVO;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public List<PostDTO> findAll(){
        return postMapper.selectAll();
    }

    public Optional<PostDTO> findById(Long id){
        return postMapper.select(id);
    }

    public PostDTO update(PostDTO postDTO){
        return postMapper.update(postDTO);
    }
}

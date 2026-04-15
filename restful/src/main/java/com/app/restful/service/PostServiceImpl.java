package com.app.restful.service;

import com.app.restful.domain.dto.PostDTO;
import com.app.restful.domain.vo.PostVO;
import com.app.restful.mapper.PostMapper;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public List<PostDTO> findAll() {
        return List.of();
    }

    @Override
    public Optional<PostDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void insert(PostDTO postDTO) {

    }

    @Override
    public void update(PostVO postVO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll(Long id) {

    }
}

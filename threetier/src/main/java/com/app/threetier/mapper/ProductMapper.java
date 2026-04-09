package com.app.threetier.mapper;

import com.app.threetier.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public void insert(ProductVO productVO);
    public List<ProductVO> selectAll();
}

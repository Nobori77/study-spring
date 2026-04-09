package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;

import java.util.List;

public interface ProductService {
    public void registerProduct(ProductVO productVO);
    public List<ProductVO> selectAll();

}

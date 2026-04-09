package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.exception.ProductException;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {ProductException.class, Exception.class})
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    private final ProductVO productVO;

//    상품 등록
    @Override
    public void registerProduct(ProductVO productVO) {
        productDAO.save(productVO);
    }

    @Override
    public List<ProductVO> selectAll() {
        return productDAO.selectAll();
    }
}

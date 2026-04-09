package com.app.threetier.service;

import com.app.threetier.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void insertTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("test11");
        productVO.setProductPrice(555551);
        productVO.setProductStock(101);
        productVO.setProductBrand("test11");
        productService.registerProduct(productVO);
    }

    @Test
    void selectAllTest(){
        productService.selectAll();
        log.info("product: {}", productService.selectAll());
    }
}

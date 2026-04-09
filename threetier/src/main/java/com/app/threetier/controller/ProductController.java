package com.app.threetier.controller;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/products/*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductVO productVO;

    @GetMapping("/insert")
    public void goToInsert(Model model){
        model.addAttribute("productVO", productVO);
    }

    @PostMapping("/insert-ok")
    public RedirectView insert(ProductVO productVO){
        productService.registerProduct(productVO);
        return new RedirectView("/products/list");
    }

    @GetMapping("/list")
    public void goToList(Model model){
        model.addAttribute("products", productService.selectAll());
    }

}

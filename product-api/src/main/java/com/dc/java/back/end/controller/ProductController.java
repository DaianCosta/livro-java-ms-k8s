package com.dc.java.back.end.controller;

import com.dc.java.back.end.dto.ProductDTO;
import com.dc.java.back.end.exception.ProductNotFoundException;
import com.dc.java.back.end.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProducts() {
        List<ProductDTO> produtos = productService.getAll();
        return produtos;
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
        List<ProductDTO> produtos = productService.getProductByCategoryId(categoryId);
        return produtos;
    }

    @GetMapping("/product/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO newProduct(@Valid @RequestBody ProductDTO userDTO) {
        return productService.save(userDTO);
    }

    @DeleteMapping("/product/{id}")
    ProductDTO delete(@PathVariable Long id) throws ProductNotFoundException {
        return productService.delete(id);
    }

}

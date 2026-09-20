package org.jpgroups.springtest.controller;

import org.jpgroups.springtest.dto.ProductRequestDto;
import org.jpgroups.springtest.dto.ProductResponseDto;
import org.jpgroups.springtest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id)
    {
        ProductResponseDto responseDto = productService.getProductById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/new-order")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto requestDto)
    {
        ProductResponseDto responseDto = productService.createProduct(requestDto);
        return ResponseEntity.ok(responseDto);
    }


}

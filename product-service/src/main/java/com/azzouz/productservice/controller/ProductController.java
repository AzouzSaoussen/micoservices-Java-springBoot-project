package com.azzouz.productservice.controller;

/*
 * @created 08/01/2023 - 08:44
 * @project product-service
 * @author Azzouz
 */

import com.azzouz.productservice.dto.ProductRequest;
import com.azzouz.productservice.dto.ProductResponse;
import com.azzouz.productservice.model.Product;
import com.azzouz.productservice.repository.ProductRepository;
import com.azzouz.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
       productService.createProduct(productRequest);
    }
}

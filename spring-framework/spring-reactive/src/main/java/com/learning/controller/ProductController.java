package com.learning.controller;

import com.learning.service.ProductService;
import com.learning.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/")
    public Flux<ProductDto> getProducts(){
        return service.findAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProduct(@PathVariable String id) {
        return service.findProductById(id);
    }

    @GetMapping("/price-range-in-between")
    public Flux<ProductDto> getProductInBetweenPriceRange(@RequestParam("min") double min, @RequestParam("max") double max){
        return service.findProductByPriceBetweenRange(min,max);
    }

    @PostMapping("/save")
    public Mono<ProductDto> saveProduct(@RequestBody Mono<ProductDto> productDto){
        return service.saveProduct(productDto);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> productDto,@PathVariable String id){
        return service.updateProduct(productDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return service.deleteProductById(id);
    }
}

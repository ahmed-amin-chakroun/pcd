package com.example.keycloakbackend.produit.controller;

import com.example.keycloakbackend.produit.model.Product;
import com.example.keycloakbackend.produit.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = { RequestMethod.GET }
)
public class ProductController {

    private final ProductService productService;
    @PostMapping("/product")
    public Product postProduct(@RequestBody Product product){
        return  productService.postProduct(product);
    }
    @GetMapping("/allproducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadProducts(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(productService.uploadProducts(file));
    }

}


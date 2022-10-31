package com.saad.controller;

import com.saad.dto.request.RegisterRequestDto;
import com.saad.repository.entity.Product;
import com.saad.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.saad.constants.ApiUrls.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
@PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(@RequestBody RegisterRequestDto dto){
        if(productService.save(dto))
            return ResponseEntity.ok(true);
        return ResponseEntity.badRequest().build();
    }
    @GetMapping(LIST_ALL_PRODUCTS)
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
}

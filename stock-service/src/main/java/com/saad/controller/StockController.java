package com.saad.controller;

import com.saad.dto.request.StockSaveRequestDto;
import com.saad.dto.request.StockUpdateRequestDto;
import com.saad.repository.entity.Stock;
import com.saad.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.saad.constants.ApiUrls.*;

@RestController
@RequestMapping(STOCK)
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody StockSaveRequestDto dto){
        return ResponseEntity.ok(stockService.save(dto));
    }
    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody StockUpdateRequestDto dto){
        return ResponseEntity.ok(stockService.update(dto));
    }

    @GetMapping(FIND_ALL_BY_PRODUCT_NAME)
    public ResponseEntity<List<Stock>> findAllByProductName(@RequestParam String productName){
        return ResponseEntity.ok(stockService.findAllByProductName(productName));
    }
    @GetMapping(FIND_ALL_BY_PRODUCT_BRAND)
    public ResponseEntity<List<Stock>> findAllByProductBrand(@RequestParam String productBrand){
        return ResponseEntity.ok(stockService.findAllByProductBrand(productBrand));
    }
    @GetMapping(LIST_ALL_STOCK)
    public ResponseEntity<List<Stock>> findAll(){
        return ResponseEntity.ok(stockService.findAll());
    }
}


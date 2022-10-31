package com.saad.service;


import com.saad.dto.request.RegisterRequestDto;
import com.saad.dto.request.StockSaveRequestDto;
import com.saad.manager.StockManager;
import com.saad.repository.IProductRepository;
import com.saad.repository.entity.Product;
import com.saad.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository iProductRepository;
    private final StockManager stockManager;


    public ProductService (IProductRepository iProductRepository, StockManager stockManager){
        super(iProductRepository);
        this.iProductRepository = iProductRepository;
        this.stockManager=stockManager;
    }
    public Boolean save(RegisterRequestDto dto){
        Product product = Product.builder()
                .name(dto.getName())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .build();
            save(product);
        if(product.getId() != null){
           stockManager.save(StockSaveRequestDto.builder()
                  .productId(product.getId())
                   .productName(product.getName())
                           .productBrand(product.getBrand())
                   .quantity(0L)
                  .build());
           return true;
       }
        return false;
    }

    public List<Product> findAll(){
        return iProductRepository.findAll();
    }

}

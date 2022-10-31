package com.saad.service;

import com.saad.dto.request.StockSaveRequestDto;
import com.saad.dto.request.StockUpdateRequestDto;
import com.saad.exception.ErrorType;
import com.saad.exception.StockServiceException;
import com.saad.repository.IStockRepository;
import com.saad.repository.entity.Stock;
import com.saad.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService extends ServiceManager<Stock,Long> {
    private final IStockRepository iStockRepository;


    public StockService(IStockRepository iStockRepository){
        super(iStockRepository);
        this.iStockRepository = iStockRepository;
    }
    public Boolean save(StockSaveRequestDto dto){
        Stock stock =   save(Stock.builder()
                .productId(dto.getProductId())
                .productName(dto.getProductName())
                .quantity(dto.getQuantity())
                .productBrand(dto.getProductBrand())
                .build());
        save(stock);
        return true;
    }
    public Boolean update(StockUpdateRequestDto dto){
        Long product_id= dto.getProductId();
        if(product_id == null) throw new StockServiceException(ErrorType.INVALID_ID);
        Optional<Stock> stock =
                iStockRepository.findOptionalByProductId(product_id);
        if(stock.isEmpty()) throw new StockServiceException(ErrorType.PRODUCT_NOT_FOUND);
        Stock stock1 = stock.get();
        stock1.setQuantity(stock1.getQuantity()+dto.getQuantity());
        save(stock1);
        return true;
    }
    public List<Stock> findAllByProductName(String productName){
        return iStockRepository.findAllOptionalByProductNameEqualsIgnoreCase(productName).get();
    }
    public List<Stock> findAllByProductBrand(String productBrand){
        return iStockRepository.findAllOptionalByProductBrandEqualsIgnoreCase(productBrand).get();
    }

    public List<Stock> findAll(){
        return iStockRepository.findAll();
    }

}

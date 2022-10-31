package com.saad.manager;

import com.saad.dto.request.StockSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.saad.constants.ApiUrls.SAVE;

@FeignClient(name = "stock-service", url = "http://localhost:9091/api/v1/stock", decode404 = true)
public interface StockManager {
    @PostMapping(SAVE)
    ResponseEntity<Boolean> save(@RequestBody StockSaveRequestDto dto);
}

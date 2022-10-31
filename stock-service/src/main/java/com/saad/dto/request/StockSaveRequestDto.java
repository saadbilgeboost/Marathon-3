package com.saad.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StockSaveRequestDto {
    Long productId;
    String productName;
    String productBrand;
    Long quantity = 0L;
}

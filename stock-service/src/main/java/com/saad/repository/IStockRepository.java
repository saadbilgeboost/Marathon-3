package com.saad.repository;

import com.saad.repository.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findOptionalByProductId(Long productId);
    Optional<List<Stock>> findAllOptionalByProductNameEqualsIgnoreCase(String productName);
    Optional<List<Stock>> findAllOptionalByProductBrandEqualsIgnoreCase(String productBrand);
}

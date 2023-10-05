package com.nguyenth.btvn_buoi11.repositories;

import com.nguyenth.btvn_buoi11.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

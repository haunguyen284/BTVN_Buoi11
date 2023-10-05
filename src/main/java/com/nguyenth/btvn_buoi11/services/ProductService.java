package com.nguyenth.btvn_buoi11.services;

import com.nguyenth.btvn_buoi11.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(int currentPage, int pageSize);

    void create(Product product);

    void remove(Long id);

    void update(Product product);

    Optional<Product> findById(Long id);
}

package com.nguyenth.btvn_buoi11.services.impl;

import com.nguyenth.btvn_buoi11.entities.Product;
import com.nguyenth.btvn_buoi11.repositories.ProductRepository;
import com.nguyenth.btvn_buoi11.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(int currentPage, int pageSize) {
        return this.productRepository.findAll(PageRequest.of(currentPage, pageSize, Sort.by("id").descending()));
    }

    @Override
    public void create(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }
}

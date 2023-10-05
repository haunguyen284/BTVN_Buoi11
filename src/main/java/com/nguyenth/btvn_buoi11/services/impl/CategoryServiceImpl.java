package com.nguyenth.btvn_buoi11.services.impl;

import com.nguyenth.btvn_buoi11.entities.Category;
import com.nguyenth.btvn_buoi11.repositories.CategoryRepository;
import com.nguyenth.btvn_buoi11.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}

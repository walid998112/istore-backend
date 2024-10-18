package com.istore.istoreproject.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.CategoryService;
import com.istore.istoreproject.models.Category;
import com.istore.istoreproject.repositories.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);

    }

    @Override
    public void deleteCategory(long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        categoryRepo.delete(category);
    }

    @Override
    public List<Category> getParents() {
        return categoryRepo.findAll().stream().filter(cat -> cat.getParentCategory() == null).toList();
    }

    @Override
    public List<Category> getByParentId(long id) {
        return categoryRepo.findByParentId(id);
    }

}

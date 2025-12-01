package com.haui.swe.service;

import com.haui.swe.model.Category;
import com.haui.swe.model.Product;
import com.haui.swe.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public List<Category> findAllActive() {
        return categoryRepository.findByStatus(true);
    }

    public Category findById(Integer id){
        return categoryRepository.findById(id).get();
    }

    // Thêm + Sửa
    public void saveOrUpdate(Category category){
        categoryRepository.save(category);
    }

    public void delete(Integer id){
        categoryRepository.deleteById(id);
    }

}

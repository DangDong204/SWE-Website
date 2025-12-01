package com.haui.swe.repository;

import com.haui.swe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    List<Category> findByStatus(Boolean status);
}

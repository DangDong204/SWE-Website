package com.haui.swe.service;

import com.haui.swe.model.Product;
import com.haui.swe.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public  List<Product> findAll() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // Lấy ra tất cả model status=1
    public List<Product> findAllActive() {
        return productRepository.findByStatus(true);
    }

    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    // Thêm + Sửa
    public void saveOrUpdate(Product product) {
        productRepository.save(product);
    }
    // xóa
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}

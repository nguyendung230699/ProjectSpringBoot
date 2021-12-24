package com.dungnv.springbootexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// tao cac method de appcontroller call

@Service
public class ProductService {
    @Autowired
 
    private ProductReponsitory repo; // mapping interface ProductRepon
     
    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public void save(Product product) {
        repo.save(product);
    }
     
    public Product get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}

package com.dungnv.springbootexample;

import org.springframework.data.jpa.repository.JpaRepository;
// cteate interface extends JpaRepository de mapping (save(),find,delete,..
public interface ProductReponsitory extends JpaRepository<Product, Long> {
	

}

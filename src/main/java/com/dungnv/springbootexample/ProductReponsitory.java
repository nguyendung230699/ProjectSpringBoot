package com.dungnv.springbootexample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory extends JpaRepository<Product, Long> {
	

}

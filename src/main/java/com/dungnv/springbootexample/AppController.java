package com.dungnv.springbootexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
// Hoan thien cac chuc nang code dua tren service
public class AppController {
	@Autowired
	private ProductService service;
	
	// functions show list producr
	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	
	// function create new product
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
		
	}
	//function save
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
	    service.save(product);
	     
	    return "redirect:/";
	}
	// function edit product
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_product");
	    Product product = service.get(id);
	    mav.addObject("product", product);
	     
	    return mav;
	}
	//function delete product
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/";   
	}

	
	
}

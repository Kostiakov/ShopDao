package com.example.ShopDao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ShopDao.dao.Dao;
import com.example.ShopDao.entity.Food;
import com.example.ShopDao.entity.Nonfood;
import com.example.ShopDao.entity.Product;
import com.example.ShopDao.entity.ProductList;

@RestController
@RequestMapping("/shop")
public class ShopRestController {
	
	@Autowired
	private Dao dao;
	
	@GetMapping("/products")
	public ProductList getAllProducts() {
		List<Product> theProducts = dao.getProducts();
		ProductList list = new ProductList();
		list.setList(theProducts);
		return list;
	}
	
	@PostMapping("/products/food")
	public Product addFood(@RequestBody Food food) {
		dao.addProduct(food);
		return food;
	}
	
	@PostMapping("/products/nonfood")
	public Product addNonfood(@RequestBody Nonfood nonfood) {
		dao.addProduct(nonfood);
		return nonfood;
	}
	
	@DeleteMapping("/products/{theId}")
	public void deleteProduct(@PathVariable("theId") int theId) {
		dao.deleteProduct(theId);
	}

}

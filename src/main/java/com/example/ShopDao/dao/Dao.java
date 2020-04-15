package com.example.ShopDao.dao;

import java.util.List;

import com.example.ShopDao.entity.Product;

public interface Dao {
	
	public List<Product> getProducts();
	public List<Product> getProduct(String name);
	public void deleteProduct(int theId);
	public void addProduct(Product theProduct);
	public Product getProductForOrder(String name);

}

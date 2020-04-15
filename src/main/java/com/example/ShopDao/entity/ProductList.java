package com.example.ShopDao.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ProductList {
	
	@Getter
	@Setter
	private List<Product> list;
	
	public ProductList() {
		list = new ArrayList<>();
	}

}

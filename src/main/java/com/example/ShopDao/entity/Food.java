package com.example.ShopDao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="food")
public class Food extends Product {
	
	public Food() {
		
	}
	
	@Getter
	@Setter
	@Column(name="calories")
	private Integer calories;

	@Override
	public String toString() {
		return "\n" + "Food [name=" + getName() + ", amount=" + getAmount() + ", price=" + getPrice() + ", calories=" + getCalories() + "]";
	}

}

package com.example.ShopDao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="nonfood")
public class Nonfood extends Product {
	
	public Nonfood() {
		
	}
	
	@Getter
	@Setter
	@Column(name="life_time")
	private Integer lifeTime;

	@Override
	public String toString() {
		return "\n" + "Nonfood [name=" + getName() + ", amount=" + getAmount() + ", price=" + getPrice() + ", life time=" + getLifeTime() + "]";
	}

}

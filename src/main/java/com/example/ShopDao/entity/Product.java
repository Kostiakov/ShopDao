package com.example.ShopDao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.Setter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
@Type(value = Food.class),
@Type(value = Nonfood.class),
})
@Entity
@Table(name="products")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Product {
	
	public Product() {
		
	}
	
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Getter
	@Setter
	@Column(name="name")
	private String name;
	@Getter
	@Setter
	@Column(name="amount")
	private Integer amount;
	@Getter
	@Setter
	@Column(name="price")
	private Integer price;

}

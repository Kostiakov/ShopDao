package com.example.ShopDao.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ShopDao.entity.Product;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public List<Product> getProducts() {
		Session session = entityManager.unwrap(Session.class);
		List<Product> listNew = session.createQuery("from Product").list();
		return listNew;
	}

	@Transactional
	@Override
	public List<Product> getProduct(String theName) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("from Product where name LIKE CONCAT('%',:theName,'%')");
		theQuery.setParameter("theName", theName);
		List<Product> theProducts = theQuery.getResultList();
		return theProducts;
	}

	@Transactional
	@Override
	public void deleteProduct(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Product theProduct = session.get(Product.class, theId);
		session.delete(theProduct);
	}

	@Transactional
	@Override
	public void addProduct(Product theProduct) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theProduct);
	}

	@Transactional
	@Override
	public Product getProductForOrder(String theName) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("from Product where name=:theName");
		theQuery.setParameter("theName", theName);
		List<Product> theProducts = theQuery.getResultList();
		Optional<Product> theProduct = theProducts.stream().findAny();
		Product pr = theProduct.get();
		return pr;
	}

}

package com.marlabs.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.marlabs.dao.ProductDao;
import com.marlabs.domain.Product;
import com.marlabs.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	private static ProductDaoImpl productDaoImpl = null;
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public Long saveProduct(Product product) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long)session.save(product);
		transaction.commit();
		session.close();
		
		return id;		
	}

	public void updateProduct(Product product) {
		Session session = this.sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
	}

	public void deleteProduct(Long id) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, id);
		session.delete(product);
		transaction.commit();
		session.close();
	}

	public Product findProductById(Long id) {
		Session session = this.sessionFactory.openSession();
		Product product = session.get(Product.class, id);
		session.close();
		
		return product;
	}

	
	public List<Product> findAllProducts() {
		Session session = this.sessionFactory.openSession();
		List<Product> productList = session.createCriteria(Product.class).list();
		session.close();
		
		return productList;
	}
	
	public static ProductDao getInstance() {
		if(productDaoImpl == null)
			productDaoImpl = new ProductDaoImpl();
		
		  return productDaoImpl;
		}
}

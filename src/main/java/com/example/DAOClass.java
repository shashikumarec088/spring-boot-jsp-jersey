package com.example;

import java.math.BigDecimal;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Product;



@Repository
@Transactional
public class DAOClass {
	
	private static Logger logger = Logger.getLogger(DAOClass.class);
	
	@Autowired
	SessionFactory factory ;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void saveProduct(){
		Session session = factory.openSession();
		Transaction transaction = null;
		//Query query = session.createQuery("select p.productName, p.price from Product p ");
		//query.setParameter("productName", "PEN");
		/* by using index and ? as we do with jdbc
		 * Query query = session.createQuery("select p.productName, p.price from Product p where e.productName =?");
		query.setParameter(0, productName);*/
		//Query query = session.createQuery("from Student s ");
		//  allProducts= query.list();
		//allProductsObjs.forEach(obj ->allProducts.add(new Product(0,(String)((Object [])obj)[0],( BigDecimal)((Object [])obj)[1])));
		//System.out.println(""+allProducts);
		
		 transaction = session.beginTransaction();
		 Object obj = session.get(Product.class,1);
		System.out.println();
		Product product = new Product("TestProduct",new BigDecimal(111));
		product.setPrice(new BigDecimal(122));
		session.save(product);
		transaction.commit();
		 
		
	
	}
	
}

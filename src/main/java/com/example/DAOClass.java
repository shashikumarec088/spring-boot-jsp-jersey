package com.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Address;
import com.dto.Customer;
import com.dto.Item;



@Repository
@Transactional
public class DAOClass {
	
	private static Logger logger = Logger.getLogger(DAOClass.class);
	
	@Autowired
	SessionFactory factory ;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void saveProduct(){
		logger.info(System.currentTimeMillis());
		Session session = factory.openSession();
Transaction tx = session.beginTransaction();
		//Product p = new Product(null,"shashi");
List<Item> items = new  ArrayList<>();
Customer c = new Customer("shashi");
items.add(new Item("shampoo",c));
Address ad1 = new Address("vaijakur",c);
c.setAddress(ad1);
c.setItems(items);
		session.save(c);
		tx.commit();
		/*Query query = session.createQuery("from Product p");
		 
		List <Product> allProducts =  query.list();*/

logger.info(session.createQuery("from Item i1").list());
		session.close();
		logger.info(System.currentTimeMillis());
		 
		
	
	}
	
}

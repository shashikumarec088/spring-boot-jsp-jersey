package com.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	private static final long serialVersionUID = -1231235L;
	
	@Id
	@GenericGenerator(name="marksIdGenerator" , strategy="increment")
	@GeneratedValue(generator="marksIdGenerator")
	@Column(name = "PRODUCT_ID")
	private int productId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
   public Product(){}
   
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
}

public Product(int productId, String productName, BigDecimal price) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.price = price;
}

public Product( String productName, BigDecimal price) {
	super();
	this.productName = productName;
	this.price = price;
}
/**
 * @return the productId
 */
public int getProductId() {
	return productId;
}
/**
 * @param productId the productId to set
 */


public void setProductId(int productId) {
	this.productId = productId;
}
/**
 * @return the productName
 */


public String getProductName() {
	return productName;
}
/**
 * @param productName the productName to set
 */
public void setProductName(String productName) {
	this.productName = productName;
}
/**
 * @return the price
 */


public BigDecimal getPrice() {
	return price;
}
/**
 * @param price the price to set
 */
public void setPrice(BigDecimal price) {
	this.price = price;
};
   
}

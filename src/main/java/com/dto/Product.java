package com.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	private static final long serialVersionUID = -1231235L;
	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_id_seq")
	/*@SequenceGenerator(
		name="product_seq",
		sequenceName="product_id_seq",
		allocationSize=1
	)*/
	private Integer productId;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
   
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName +  "]";
}

public Product(Integer productId, String productName) {
	this.productId = productId;
	this.productName = productName;
}

/**
 * @return the productId
 */
public Product() {
	super();
}

public Integer getProductId() {
	return productId;
}
/**
 * @param productId the productId to set
 */


public void setProductId(Integer productId) {
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

   
}

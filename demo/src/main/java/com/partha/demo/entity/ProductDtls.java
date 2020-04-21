package com.partha.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_DTLS")
public class ProductDtls extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prdct_dtl_generator")
	@SequenceGenerator(name="prdct_dtl_generator", sequenceName = "PRODUCT_DTLS_SEQ", allocationSize=1)
	
	@Column(name="PRODUCT_KY",nullable=false)
	private Long productKy;
	
	@Column(name="PRODUCT_NM",nullable=false)
	private String productName;

	@Column(name="PRODUCT_DESC")
	private String productDesc;
	
	@Column(name="PRODUCT_PRICE",nullable=false)
	private Double productPrice;
	
	@Column(name="PRODUCT_STOCK",nullable=false)
	private Long productStock;
	
	@Column(name="PRODUCT_CURRENCY",nullable=false)
	private String productCurrency;

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}


	public Long getProductKy() {
		return productKy;
	}

	public void setProductKy(Long productKy) {
		this.productKy = productKy;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Long getProductStock() {
		return productStock;
	}

	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}

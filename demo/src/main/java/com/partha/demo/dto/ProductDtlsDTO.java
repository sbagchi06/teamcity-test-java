package com.partha.demo.dto;

public class ProductDtlsDTO {
	
	private Long productKy;	
	private String productDesc;
	private Double productPrice;
	private Long productStock;
	private String productName;
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

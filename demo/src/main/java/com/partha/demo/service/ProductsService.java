package com.partha.demo.service;

import java.util.List;

import com.partha.demo.dto.ProductDtlsDTO;


public interface ProductsService {

	public List<ProductDtlsDTO> getAllProducts();
	public Long createProduct(ProductDtlsDTO productDtlsDTO);
	
}

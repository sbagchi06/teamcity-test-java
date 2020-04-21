package com.partha.demo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.partha.demo.dao.ProductDtlsDao;
import com.partha.demo.dto.ProductDtlsDTO;
import com.partha.demo.entity.ProductDtls;
import com.partha.demo.service.ProductsService;


@Transactional
@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	ProductDtlsDao productDtlsDao;	

	@Override
	public List<ProductDtlsDTO> getAllProducts() {
		List<ProductDtlsDTO> productList = new ArrayList<ProductDtlsDTO>();
		try {
			Iterable<ProductDtls> result = productDtlsDao.findAll();
	  
	        // Create a List from the Iterable 
	        List<ProductDtls> listOfProducts = StreamSupport 
	                           .stream(result.spliterator(), false) 
	                           .collect(Collectors.toList());
			
			for (ProductDtls product : listOfProducts) {
				
				ProductDtlsDTO productDTO = new ProductDtlsDTO();
				productDTO.setProductKy(product.getProductKy());
				productDTO.setProductName(product.getProductName());
				productDTO.setProductDesc(product.getProductDesc());
				productDTO.setProductStock(product.getProductStock());
				productDTO.setProductPrice(product.getProductPrice());
				productDTO.setProductCurrency(product.getProductCurrency());				
				productList.add(productDTO);

			}
		}catch(Exception ex) {
			System.out.println("Exception occurred in ProductsServiceImpl: getAllProducts()");
		}
		return productList;
	}

	
	@Override
	public Long createProduct(ProductDtlsDTO productDtlsDTO) {
		
		Timestamp time = new Timestamp(new Date().getTime());
		Long productId = 0L;
		try{
			
			ProductDtls productDtls = new ProductDtls();
			
			productDtls.setProductName(productDtlsDTO.getProductName());		
			productDtls.setProductDesc(productDtlsDTO.getProductDesc());
			productDtls.setProductPrice(productDtlsDTO.getProductPrice());
			productDtls.setProductStock(productDtlsDTO.getProductStock());
			productDtls.setProductCurrency(productDtlsDTO.getProductCurrency());
			productDtls.setCreateTimestamp(time);
			productDtls.setUpdateTimestamp(time);
			
			productDtls = productDtlsDao.save(productDtls);
			System.out.println("Product Saved with ProductKey: "+ productDtls.getProductKy());
			
			productId = productDtls.getProductKy();
			
		}catch(Exception e){
			System.out.println("Exception occurred in ProductsServiceImpl: createProduct()");
		}
		return productId;
		
		
	}

}

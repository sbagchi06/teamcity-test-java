package com.partha.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partha.demo.dto.ProductDtlsDTO;
import com.partha.demo.service.ProductsService;

@RestController
@RequestMapping("products")
public class ProductsServiceController {
	
	@Autowired
	private ProductsService productsService;
	
	/*
	 * @Autowired private EntityLinks entityLinks;
	 */
	
	//@CrossOrigin
	@GetMapping
	public ResponseEntity<?> viewProducts(){
	
		List<ProductDtlsDTO> products=productsService.getAllProducts();
		
		return  ResponseEntity.ok().body(products);
	}

	//@CrossOrigin
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody ProductDtlsDTO productDtlsDTO) {
		long productKey = productsService.createProduct(productDtlsDTO);
		if(productKey > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(String.valueOf(productKey));
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}

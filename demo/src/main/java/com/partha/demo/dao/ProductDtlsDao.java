package com.partha.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.partha.demo.entity.ProductDtls;

public interface ProductDtlsDao extends CrudRepository<ProductDtls, Long>{

}
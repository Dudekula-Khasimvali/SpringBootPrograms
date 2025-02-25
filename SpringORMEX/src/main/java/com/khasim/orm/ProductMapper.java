package com.khasim.orm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.khasim.orm.entity.Product;
import com.khasim.orm.model.ProductDetails;
@Component
public class ProductMapper {
	
	//This method takes model as input Entity as output
	public Product modelToEntity(ProductDetails productDetails) {
		
		//read the data from model class  set to Entity class
		
		Product product = new Product();
		product.setProId(productDetails.getProId());
		product.setProName(productDetails.getProName());
		product.setProPrice(productDetails.getProPrice());
		product.setCreateBy(System.getProperty("user.name"));
		product.setCreateAt(LocalDateTime.now());
		return product;
	}
	
	//this method is taking model as input Entity as output
	public List<Product> modelToEntityConversion(List<ProductDetails> productDetailsList) {
		List<Product> products = new ArrayList<>();
		
		for (ProductDetails proDetails : productDetailsList) {
			Product product = new Product();
			product.setProId(proDetails.getProId());
			product.setProName(proDetails.getProName());
			product.setProPrice(proDetails.getProPrice());
			product.setCreateBy(System.getProperty("user.name"));
			product.setCreateAt(LocalDateTime.now());
			products.add(product); 
		}
		
		return products;
	}
	
	
	
	
}
package com.springboot.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.ProductEntity;
import com.springboot.model.ProductModel;
import com.springboot.repository.ProductRepository;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void saveProductDetails(ProductModel productModel) {
        // Calculate derived values
        double stockValue = productModel.getPrice() * productModel.getQuantity();
        double discountPrice = productModel.getPrice() * productModel.getDiscountRate() / 100;
        double offerPrice = productModel.getPrice() - discountPrice;
        double taxRate = 18.00;
        double finalPrice = offerPrice + (offerPrice * taxRate) / 100;

        // Map ProductModel to ProductEntity
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productModel.getName());
        productEntity.setBrand(productModel.getBrand());
        productEntity.setMadeIn(productModel.getMadeIn());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setQuantity(productModel.getQuantity());
        productEntity.setDiscountRate(productModel.getDiscountRate());
        productEntity.setDiscountPrice(discountPrice);
        productEntity.setOfferPrice(offerPrice);
        productEntity.setFinalPrice(finalPrice);
        productEntity.setStockRate(stockValue);

        // Save to repository
        productRepository.save(productEntity);
       
    }
    public List<ProductEntity>getAllProducts(){
    	List<ProductEntity>products=productRepository.findAll();
    	return products;
    }
	public ProductEntity searchById(Long id) {
		Optional<ProductEntity>optionalData=productRepository.findById(id);
		if(optionalData.isPresent()) {
			ProductEntity products=optionalData.get();
			return products;
		}
		else
		{
		return null;
	}
	
	}
	public  void deleteProductById(long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}
	public ProductModel editProductById(long id) {
		// TODO Auto-generated method stub
		Optional<ProductEntity>product=productRepository.findById(id);
		if(product.isPresent()) {
			ProductModel productModel=new ProductModel();
			ProductEntity pr=new ProductEntity();
			pr=product.get();
			productModel.setName(pr.getName());
			productModel.setBrand(pr.getBrand());
			productModel.setMadeIn(pr.getMadeIn());
			productModel.setPrice(pr.getPrice());
			productModel.setQuantity(pr.getQuantity());
			productModel.setDiscountRate(pr.getDiscountRate());
			return productModel;
			
		}else
		{
			return null;
		}	
	}
	

public void editsubmit(long id,ProductModel model) {
	Optional<ProductEntity> optionaldata=productRepository.findById(id);
	if(optionaldata.isPresent());
	{
		ProductEntity entity=optionaldata.get();
		entity.setName(model.getName());
		entity.setBrand(model.getBrand());
		entity.setMadeIn(model.getMadeIn());
		entity.setPrice(model.getPrice());
		entity.setQuantity(model.getQuantity());
		entity.setDiscountRate(model.getDiscountRate());
		
		 double stockValue = model.getPrice() *model.getQuantity();
	        double discountPrice =model.getPrice() * model.getDiscountRate() / 100;
	        double offerPrice = model.getPrice() - discountPrice;
	        double taxRate = 18.00;
	        double finalPrice = offerPrice + (offerPrice * taxRate) / 100;
	        productRepository.save(entity);
		
	}
}
}


package com.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.springboot.entity.ProductEntity;
import com.springboot.model.ProductModel;
import com.springboot.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/productform")
	public String productform() {
		return "add";
	}
@PostMapping("/saved")
public String saved(ProductModel productModel)
{
	productService.saveProductDetails(productModel);
	return "success";
}

@GetMapping("/getallproduct")
public String getallproduct(Model model) {
	List<ProductEntity>products=productService.getAllProducts();
	model.addAttribute("products",products);
    return "product-list";
}
@GetMapping("/searchbyid")
public String searchByIdForm() {
    // Serve the search form view.
    return "searchform";
}

@PostMapping("/searchbyid")
public String searchById(@RequestParam Long id, Model model) {
    // Call the service to fetch the product by ID.
    ProductEntity products = productService.searchById(id);

    // Add the product to the model if found, or null if not.
    model.addAttribute("products", products);

    // Return the same view with the results.
    return "searchform";
}
@GetMapping("/delete/{id}")
public String deleteProductById(@PathVariable("id")long id) {
	productService.deleteProductById(id);
    return "redirect:/getallproduct";
}
@GetMapping("/edit/{id}")
public String editProductById(@PathVariable("id")long id,Model model) {
	ProductModel product= productService.editProductById(id);
	model.addAttribute("product", product);
	model.addAttribute("id", id);
	return"edit";
}
@PostMapping("/editsubmitform/{id}")
public String editsubmit(@PathVariable("id") long id,ProductModel model) {
    //TODO: process POST request
    productService.editsubmit(id,model);
    return "redirect:/getallproduct";
}

}
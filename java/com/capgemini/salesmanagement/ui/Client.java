package com.capgemini.salesmanagement.ui;

import java.util.Scanner;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.exception.InvalidQuantityException;
import com.capgemini.salesmanagement.service.IProductService;
import com.capgemini.salesmanagement.service.ProductService;

public class Client {
	void selectOption() {
	Scanner sc = new Scanner(System.in);
	ProductBean p = new ProductBean();
	IProductService productService = new ProductService();
	// User Interface
	
	System.out.println("Enter the product code");
	int productCode = sc.nextInt();
	//Calling the method to check if the product is existing
	p = productService.getProductDetails(productCode);
	System.out.println("Enter the quantity");
	int quantity = sc.nextInt();
	//Quantity Validation
	if (quantity <= 0) {
		//since quantity entered is less than 0, throwing custom exception
		try {
			throw new InvalidQuantityException();
		} catch (InvalidQuantityException e) {
		}
	} else {
		//since quantity entered is more than 0, continuing the execution
		//product details are stored in productBean variable to display appropriate values
		//productBean = productService.getProductDetails(productCode);
		p.setQuantity(quantity);
		boolean ret = productService.insertSalesDetails(p);
		if(ret == true) {
			System.out.println("Product Name: "+p.getProduct_name());
			System.out.println("Product Category: "+p.getProduct_category());
			System.out.println("Product Description: "+p.getProduct_description());
			System.out.println("Product Price(Rs): "+p.getProduct_price());
			System.out.println("Quantity: "+quantity);
			System.out.println("Line Total(Rs): "+(quantity * p.getProduct_price()));
		}else {
			System.err.println("Insertion Failed");
		}
	}
	
		
	}
	public static void main(String args[]) {
		Client c = new Client();
		c.selectOption();
	}
}

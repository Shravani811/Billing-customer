package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.dao.IProductDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;

public class ProductService implements IProductService{
IProductDAO productDao = new ProductDAO();
	
	public ProductBean getProductDetails(int productCode) {
		return productDao.getProductDetails(productCode);
	}

	

	public boolean insertSalesDetails(ProductBean product) {
		// TODO Auto-generated method stub
		return productDao.insertSalesDetails(product);
	}

	
	
}

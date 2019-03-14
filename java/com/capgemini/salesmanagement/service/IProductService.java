package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.ProductBean;

public interface IProductService {
	ProductBean getProductDetails(int productCode);
	boolean insertSalesDetails(ProductBean product);
	
}

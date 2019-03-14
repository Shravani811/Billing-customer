package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.bean.ProductBean;

public interface IProductDAO {
	ProductBean getProductDetails(int productCode);
	boolean insertSalesDetails(ProductBean product);
}

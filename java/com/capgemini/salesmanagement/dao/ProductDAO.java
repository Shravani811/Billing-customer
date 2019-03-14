package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.exception.InvalidProductCodeException;
import com.capgemini.salesmanagement.utility.DataConnection;

public class ProductDAO implements IProductDAO {
	Scanner input = new Scanner(System.in);
	DataConnection d = new DataConnection();
	Connection con = d.connect();
	ProductBean productBean = new ProductBean();
	public ProductBean getProductDetails(int productCode) {
		
		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			int flag=0;
			while (rs.next()) {
				if (rs.getInt(1) == productCode) {
					productBean.setProduct_code(productCode);
					productBean.setProduct_name(rs.getString(2));
					productBean.setProduct_category(rs.getString(3));
					productBean.setProduct_description(rs.getString(4));
					productBean.setProduct_price(rs.getInt(5));
					flag++;
				}
			}
			if (flag == 0)
				try {
					throw new InvalidProductCodeException();
				} catch (InvalidProductCodeException e) {
					System.exit(0);
				}
		} catch (SQLException e) {
			
		}
		return productBean;
		
		
	}
	
			
	

	public boolean insertSalesDetails(ProductBean product) {
		boolean ret = false;
		
		try {
		
			PreparedStatement preparedStatement = con.prepareStatement("insert into sales values(?,?,?,?,?)");
			preparedStatement.setInt(1, productBean.getProduct_code());
			preparedStatement.setInt(2, productBean.getProduct_code());
			preparedStatement.setInt(3, productBean.getQuantity());
			preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
			preparedStatement.setInt(5, productBean.getQuantity() * productBean.getProduct_price());
			preparedStatement.executeUpdate();
			ret = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;

	}

}











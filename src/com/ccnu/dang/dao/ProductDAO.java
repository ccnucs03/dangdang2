package com.ccnu.dang.dao;

import java.util.List;

import com.ccnu.dang.pojo.Product;

public interface ProductDAO {

	public boolean add(Product product);//添加一个新产品
	
	public List<Product> findByProductName(String productName);	//根据product_name查找Product集合
	
	public List<Product> findByKeywords(String keywords);	//根据keyword查找Product集合
	
	//public List<Product> findByProductId(String keyword);	//根据keyword查找Product集合
	
	public boolean update(Product product);//修改产品信息
	
	public boolean delete(Product product);//删除产品信息

	
}

package com.ccnu.dang.dao;

import java.util.List;

import com.ccnu.dang.pojo.Product;

public interface ProductDAO {

	public boolean add(Product product);//���һ���²�Ʒ
	
	public List<Product> findByProductName(String productName);	//����product_name����Product����
	
	public List<Product> findByKeywords(String keywords);	//����keyword����Product����
	
	//public List<Product> findByProductId(String keyword);	//����keyword����Product����
	
	public boolean update(Product product);//�޸Ĳ�Ʒ��Ϣ
	
	public boolean delete(Product product);//ɾ����Ʒ��Ϣ

	
}

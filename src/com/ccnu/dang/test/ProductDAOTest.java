package com.ccnu.dang.test;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.ccnu.dang.dao.ProductDAO;
import com.ccnu.dang.dao.ProductDAOImpl;
import com.ccnu.dang.pojo.Product;

public class ProductDAOTest {
	private ProductDAO productDao = new ProductDAOImpl();
	
	@Test
	public void add() {
		Product product = new Product();
		product.setProductName("百年孤独");
		product.setDescription("世界名著");
		product.setProductId(1);
		product.setAddTime(Timestamp.valueOf("2016-01-14 11:51:20"));
		product.setFixedPrice(12.88);
		product.setDangPrice(11.50);
		product.setKeywords("文学");
		productDao.add(product);
		productDao.add(product);
	}
	
	@Test
	public void findByProductName(){
		System.out.println(productDao.findByProductName("百年孤独").toString());
	}
	
	@Test
	public void findByKeywords(){
		System.out.println(productDao.findByKeywords("文学").toString());
	}
	
	@Test
	public void update(){
		Product product	= productDao.findByProductName("百年孤独").get(0);
		product.setProductName("孤独");
		product.setDescription("著");
		//product.setProductId(1);
		product.setAddTime(Timestamp.valueOf("2016-01-14 14:51:20"));
		product.setFixedPrice(9.9);
		product.setDangPrice(5.5);
		product.setKeywords("theme");
		productDao.update(product);
	}
	
	@Test
	public void delete(){
		/*Product product	=new Product();
		product.setProductName("百年孤独");
		product.setDescription("世界名著");
		product.setProductId(1);
		product.setAddTime(Timestamp.valueOf("2016-01-14 11:51:20"));
		product.setFixedPrice(12.88);
		product.setDangPrice(11.55);
		product.setKeywords("theme");*/
		List<Product> products = productDao.findByProductName("百年孤独");
		/*for(int i = 0; i < products.size(); i++ ) {
			productDao.delete(products.get(i));
		}*/
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
			productDao.delete(it.next());
		}
	}
}

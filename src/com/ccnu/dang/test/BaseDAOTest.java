package com.ccnu.dang.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ccnu.dang.dao.BaseDAO;
import com.ccnu.dang.dao.BaseDAOImpl;
import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.Book;
import com.ccnu.dang.pojo.Category;
import com.ccnu.dang.pojo.Product;
import com.ccnu.dang.pojo.User;

public class BaseDAOTest {
	
	
	@Test
	public void baseDaoCategory(){
		BaseDAO<Category, Integer> categoryDao = new BaseDAOImpl<Category, Integer>();
		//Category cg = new Category(1, "Book", "图书", null, null);
		categoryDao.get(1);		
		
	}
	@Test
	public void testUserAdd(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Category cg = new Category(1, "Book2", "图书", null, null);
		Product product = new Product("计算机组成原理", 12.2, "计算机");
		session.save(product);		
		cg.getProducts().add(product);		
		session.save(cg);
		tx.commit(); 
		session.close();
	}
	
	@Test
	public void testBook(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Category cg = new Category(1, "Book2", "图书", null, null);
		//Product product = new Product("计算机组成原理", 12.2, "计算机");
		Book book = new Book();
		book.setIsbn("97814444");
		book.setAuthor("王敬华");
		session.save(book);		
		cg.getProducts().add(book);		
		session.save(cg);
		tx.commit();
		session.close();
	}

	@Test
	public void add(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		Category cg = new Category(1, "Book2", "图书", null, null);
		
		Book book = new Book();	
		book.setProductName("计算机组成原理");
		book.setDangPrice(22.22);
		book.setAuthor("张三");
		book.setIsbn("20160114");
		
		session.save(book);		
		cg.getProducts().add(book);		
		session.save(cg);
		tx.commit();
		
		System.out.println(book.getProductId());
		
		session.close();
	}	
}

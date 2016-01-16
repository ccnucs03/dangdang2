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
		//Category cg = new Category(1, "Book", "ͼ��", null, null);
		categoryDao.get(1);		
		
	}
	@Test
	public void testUserAdd(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Category cg = new Category(1, "Book2", "ͼ��", null, null);
		Product product = new Product("��������ԭ��", 12.2, "�����");
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
		Category cg = new Category(1, "Book2", "ͼ��", null, null);
		//Product product = new Product("��������ԭ��", 12.2, "�����");
		Book book = new Book();
		book.setIsbn("97814444");
		book.setAuthor("������");
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
		Category cg = new Category(1, "Book2", "ͼ��", null, null);
		
		Book book = new Book();	
		book.setProductName("��������ԭ��");
		book.setDangPrice(22.22);
		book.setAuthor("����");
		book.setIsbn("20160114");
		
		session.save(book);		
		cg.getProducts().add(book);		
		session.save(cg);
		tx.commit();
		
		System.out.println(book.getProductId());
		
		session.close();
	}	
}

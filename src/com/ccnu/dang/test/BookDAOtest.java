package com.ccnu.dang.test;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.Book;
import com.ccnu.dang.pojo.Category;
import com.ccnu.dang.pojo.User;

public class BookDAOtest {
	@Test
	public void addBook(){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		Category cg = new Category(1, "Book2", "图书", null, null);
		
		Book book = new Book();	
		
		book.setProductName("计算机组成原理");
		book.setDescription("计算机专业核心课程");
		book.setAddTime(new Timestamp(System.currentTimeMillis()));
		book.setFixedPrice(30.0);
		book.setDangPrice(22.22);
		book.setKeywords("计算机,硬件");
		book.setAuthor("张三");
		book.setProductPic("/");
		book.setIsbn("20160114");
		
		session.save(book);		
		cg.getProducts().add(book);		
		session.save(cg);
		tx.commit();
		
		System.out.println(book.getProductId());
		
		session.close();
	}	
	
	@Test
	public void findByAddTime() {
		List list = null;
		
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;   //声明一个事务对象
		transaction = session.beginTransaction();
		//System.out.println("1111111");
		Query query = session.createQuery("from Book as book where book.keywords='ccnu'");   //HQ
		
		//System.out.println("2222221");			
		list = query.list();					//查询结果保存到list中
		transaction.commit();
		HibernateSessionFactory.closeSession();		//关闭Session对象
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println( ((Book)list.get(i)).toString());
		}
		
	
	}
}

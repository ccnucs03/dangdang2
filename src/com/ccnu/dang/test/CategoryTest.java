package com.ccnu.dang.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.Book;
import com.ccnu.dang.pojo.Category;

public class CategoryTest {
	@Test
	public void addCategories() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		Category cg1 = new Category(1, "Book", "ͼ��", null, null);
		Category cg2 = new Category(1, "Novel", "С˵��", null, 1);
		Category cg3 = new Category(2, "Youth", "�ഺ", null, 1);
		Category cg4 = new Category(3, "Humanity And Social Science", "�������", null, 1);
		Category cg5 = new Category(4, "Management", "����", null, 1);
		Category cg6 = new Category(1, "Chinese Contemporary Novel", "����С˵", null, 2);
		
		Book book = new Book();	
		
		book.setProductName("��������ԭ��");
		book.setDescription("�����רҵ���Ŀγ�");
		book.setAddTime(new Timestamp(System.currentTimeMillis()));
		book.setFixedPrice(30.0);
		book.setDangPrice(22.22);
		book.setKeywords("�����,Ӳ��");
		book.setAuthor("����");
		book.setProductPic("/");
		book.setIsbn("20160114");
		
		session.save(book);		
		cg1.getProducts().add(book);
		cg2.getProducts().add(book);
		cg3.getProducts().add(book);
		cg4.getProducts().add(book);
		cg5.getProducts().add(book);
		cg6.getProducts().add(book);
		
		session.save(cg1);
		session.save(cg2);
		session.save(cg3);
		session.save(cg4);
		session.save(cg5);
		session.save(cg6);
		
		tx.commit();
		
		System.out.println(book.getProductId());
		
		session.close();
	}
	
	@Test
	public void showCategories(){
		Session session= HibernateSessionFactory.getSession();
		//Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Category as cg where cg.categoryId=1");
		Category category = (Category)query.list().get(0);
		List<Category> firstList = category.getChildcategories();
		
		for(Category cg : firstList) {       //cg�� һ���˵�(firstList)�е�һ��
			System.out.println("һ���˵�: " + cg.toString());
			List<Category> secendList = cg.getChildcategories();   
			for(Category e : secendList) {    //e�Ƕ����˵�(secendList)�е�һ��
				System.out.println("----- �����˵�: "+ e.toString());
			}
			
		}
		
		//tx.commit();
		session.close();
		
	}
}

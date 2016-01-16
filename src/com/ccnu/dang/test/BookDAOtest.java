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
		Category cg = new Category(1, "Book2", "ͼ��", null, null);
		
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
		cg.getProducts().add(book);		
		session.save(cg);
		tx.commit();
		
		System.out.println(book.getProductId());
		
		session.close();
	}	
	
	@Test
	public void findByAddTime() {
		List list = null;
		
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction  transaction = null;   //����һ���������
		transaction = session.beginTransaction();
		//System.out.println("1111111");
		Query query = session.createQuery("from Book as book where book.keywords='ccnu'");   //HQ
		
		//System.out.println("2222221");			
		list = query.list();					//��ѯ������浽list��
		transaction.commit();
		HibernateSessionFactory.closeSession();		//�ر�Session����
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println( ((Book)list.get(i)).toString());
		}
		
	
	}
}

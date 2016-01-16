package com.ccnu.dang.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.Product;

public class ProductDAOImpl implements ProductDAO {
private static final Log log = LogFactory.getLog(ProductDAOImpl.class);
	
	@Override
	public boolean add(Product product) {
		log.debug("saving Product instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.save(product);
			System.out.println("22222222");
			transaction.commit();//提交事务			
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			re.printStackTrace();
			transaction.rollback();//事务回滚		
			flag = false;
			throw re;			
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
		if(flag)
			return true;
		else
			return false;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByProductName(String productName) {
		
		@SuppressWarnings("rawtypes")
		List list = null;
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();
			System.out.println("1111111");
			Query query = session.createQuery("from Product as product where product.productName = ?");		
			query.setString(0, productName);			
			System.out.println("2222221");			
			list = query.list();					//查询结果保存到list中
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象				
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		
		if(!list.isEmpty()) {
			return (List<Product>)list;
		}else{
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findByKeywords(String keywords) {
		@SuppressWarnings("rawtypes")
		List list = null;
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();
			System.out.println("1111111");
			Query query = session.createQuery("from Product as product where product.keywords = ?");		
			query.setString(0, keywords);			
			System.out.println("2222221");			
			list = query.list();					//查询结果保存到list中
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象				
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		
		if(!list.isEmpty()) {
			return (List<Product>)list;
		}else{
			return null;
		}
	
	}


	@Override
	public boolean update(Product product) {
		log.debug("updating Product instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.update(product);
			System.out.println("22222222");
			transaction.commit();//提交事务			
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			re.printStackTrace();
			transaction.rollback();//事务回滚		
			flag = false;
			throw re;			
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
		if(flag)
			return true;
		else
			return false;
	}


	@Override
	public boolean delete(Product product) {
		log.debug("deleting Product instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.delete(product);
			System.out.println("22222222");
			transaction.commit();//提交事务			
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			re.printStackTrace();
			transaction.rollback();//事务回滚		
			flag = false;
			throw re;			
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
		if(flag)
			return true;
		else
			return false;
	}
	


}

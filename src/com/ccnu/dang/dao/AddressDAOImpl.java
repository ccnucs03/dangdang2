package com.ccnu.dang.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.Address;

public class AddressDAOImpl implements AddressDAO {
	private static final Log log = LogFactory.getLog(AddressDAOImpl.class);
	
	@Override
	public boolean add(Address address) {
		log.debug("saving Address instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.save(address);
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
	public List<Address> findByUserId(int userId) {
		
		List list = null;
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();
			System.out.println("1111111");
			Query query = session.createQuery("from Address as address where address.user.userId = ?");		
			query.setInteger(0, userId);			
			System.out.println("2222221");			
			list = query.list();					//查询结果保存到list中
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象				
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		
		if(!list.isEmpty()) {
			return (List<Address>)list;
		}else{
			return null;
		}
	}
	
	@Override
	public boolean update(Address address) {
		log.debug("updating Address instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.update(address);
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
	public boolean delete(Address address) {
		log.debug("deleting Address instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.delete(address);
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

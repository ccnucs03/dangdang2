package com.ccnu.dang.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.User;

public class UserDAOImpl implements UserDAO {
private static final Log log = LogFactory.getLog(UserDAOImpl.class);
	

	@Override
	public boolean add(User user) {
		log.debug("saving User instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.save(user);
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

	@Override
	public User findById(int userId) {
		log.debug("getting User instance with id: " + userId);
		List list = null;
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象
			Transaction  transaction = null;   //声明一个事务对象
			transaction = session.beginTransaction();
			//System.out.println("1111111");
			Query query = session.createQuery("from User as user where user.userId=?");   //HQL
			query.setInteger(0, userId);
			//System.out.println("2222221");			
			list = query.list();					//查询结果保存到list中
			transaction.commit();
			HibernateSessionFactory.closeSession();		//关闭Session对象
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		

		if(!list.isEmpty()) {
			return (User)list.get(0);
		}else{
			return null;
		}
	
	}
	
	@Override
	public User findByName(String nickname) {
		log.debug("getting User instance with nickname: " + nickname);
		List list = null;
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象		
			//System.out.println("1111111");
			Query query = session.createQuery("from User as users where users.nickname = ?");		
			query.setString(0, nickname);		//查询获取用户名字
			//System.out.println("2222221");			
			list = query.list();					//查询结果保存到list中			
			HibernateSessionFactory.closeSession();		//关闭Session对象
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}		

		if(!list.isEmpty()) {
			return (User)list.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public boolean allowLogin(String nickname, String password) {
		User user = this.findByName(nickname);
		if(user == null) {		//判断是否存在该name的用户
			return false;
		}else {
			if(password.equals(user.getPassword())) {	//判断密码是否相同
				return true;
			}else{
				return false;
			}
			
		}
	}

	@Override
	public User findByEmail(String email) {
		log.debug("getting User instance with email: " + email);
		List list = null;
		try {
			Session session = HibernateSessionFactory.getSession();//获得Session对象		
			//System.out.println("1111111");
			Query query = session.createQuery("from User as users where users.email = ?");		
			query.setString(0, email);		//查询获取用户名字
			//System.out.println("2222221");			
			list = query.list();					//查询结果保存到list中			
			HibernateSessionFactory.closeSession();		//关闭Session对象
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}		

		if(!list.isEmpty()) {
			return (User)list.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public boolean update(User user) {
		log.debug("updating User instance");
		boolean flag = true;
		System.out.println("before getSession");
		Session session = HibernateSessionFactory.getSession();
		System.out.println("after getSession");
		Transaction  transaction = null;   //声明一个事务对象
		try {
			transaction = session.beginTransaction();//开启事务
			System.out.println("1111111");
			session.update(user);
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
}

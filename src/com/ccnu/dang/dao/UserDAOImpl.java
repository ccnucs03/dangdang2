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
		Transaction  transaction = null;   //����һ���������
		try {
			transaction = session.beginTransaction();//��������
			System.out.println("1111111");
			session.save(user);
			System.out.println("22222222");
			transaction.commit();//�ύ����			
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			re.printStackTrace();
			transaction.rollback();//����ع�		
			flag = false;
			throw re;			
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
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
			Session session = HibernateSessionFactory.getSession();//���Session����
			Transaction  transaction = null;   //����һ���������
			transaction = session.beginTransaction();
			//System.out.println("1111111");
			Query query = session.createQuery("from User as user where user.userId=?");   //HQL
			query.setInteger(0, userId);
			//System.out.println("2222221");			
			list = query.list();					//��ѯ������浽list��
			transaction.commit();
			HibernateSessionFactory.closeSession();		//�ر�Session����
			
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
			Session session = HibernateSessionFactory.getSession();//���Session����		
			//System.out.println("1111111");
			Query query = session.createQuery("from User as users where users.nickname = ?");		
			query.setString(0, nickname);		//��ѯ��ȡ�û�����
			//System.out.println("2222221");			
			list = query.list();					//��ѯ������浽list��			
			HibernateSessionFactory.closeSession();		//�ر�Session����
			
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
		if(user == null) {		//�ж��Ƿ���ڸ�name���û�
			return false;
		}else {
			if(password.equals(user.getPassword())) {	//�ж������Ƿ���ͬ
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
			Session session = HibernateSessionFactory.getSession();//���Session����		
			//System.out.println("1111111");
			Query query = session.createQuery("from User as users where users.email = ?");		
			query.setString(0, email);		//��ѯ��ȡ�û�����
			//System.out.println("2222221");			
			list = query.list();					//��ѯ������浽list��			
			HibernateSessionFactory.closeSession();		//�ر�Session����
			
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
		Transaction  transaction = null;   //����һ���������
		try {
			transaction = session.beginTransaction();//��������
			System.out.println("1111111");
			session.update(user);
			System.out.println("22222222");
			transaction.commit();//�ύ����			
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			re.printStackTrace();
			transaction.rollback();//����ع�		
			flag = false;
			throw re;			
		}
		HibernateSessionFactory.closeSession();//�ر�Session����
		if(flag)
			return true;
		else
			return false;
	}
}

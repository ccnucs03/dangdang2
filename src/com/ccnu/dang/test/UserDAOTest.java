package com.ccnu.dang.test;



import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.ccnu.dang.dao.UserDAO;
import com.ccnu.dang.dao.UserDAOImpl;
import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.Address;
import com.ccnu.dang.pojo.User;

public class UserDAOTest {
	
	private UserDAO userDao = new UserDAOImpl();	
	
	@Test
	public void add(){
		User user = new User();	
		user.setEmail("4444");
		user.setNickname("4444");
		user.setPassword("123");		
		userDao.add(user);		
	}
	
	@Test
	public void findByNickname() {
		User user = userDao.findByName("yhyang");
		Set<Address> address = new HashSet<Address>();
		address = user.getAddresses();
		Iterator<Address> it = address.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}		
		
	}
	
	
}

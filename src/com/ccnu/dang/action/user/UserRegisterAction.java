package com.ccnu.dang.action.user;

import java.io.UnsupportedEncodingException;

import com.ccnu.dang.dao.UserDAO;
import com.ccnu.dang.dao.UserDAOImpl;
import com.ccnu.dang.pojo.User;

public class UserRegisterAction {
	
	private User user=new User();
	private UserDAO dao=new UserDAOImpl();
	
	public String execute() throws UnsupportedEncodingException{
		System.out.println(user.toString());
		boolean b=dao.add(user);
		if(!b) return "error";
		return "success";
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
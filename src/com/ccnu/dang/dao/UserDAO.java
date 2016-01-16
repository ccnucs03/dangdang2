package com.ccnu.dang.dao;

import com.ccnu.dang.pojo.User;


public interface UserDAO {
	public boolean add(User user);   //添加一个新的用户
	public User findById(int userId);		//根据userId查找一个User对象
	public User findByName(String nickname);	//根据nickname查找一个User对象。 在登陆时，用到这个方法
	public User findByEmail(String email);   //根据email查找一个User对象, 注册时查找
	public boolean update(User user); //修改用户信息
	public boolean allowLogin(String nickname, String password);  //登陆判断，会调用上面的findByName(String userName)方法
}

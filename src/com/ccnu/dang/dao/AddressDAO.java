package com.ccnu.dang.dao;

import com.ccnu.dang.pojo.Address;

import java.util.List;

public interface AddressDAO {
	
	public boolean add(Address address); //添加一个新地址
	
	public List<Address> findByUserId(int userId);	//根据userId查找Address集合
	
	public boolean update(Address address); //修改地址信息
	
	public boolean delete(Address address); //删除地址信息	
}

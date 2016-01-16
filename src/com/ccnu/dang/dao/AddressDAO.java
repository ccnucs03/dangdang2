package com.ccnu.dang.dao;

import com.ccnu.dang.pojo.Address;

import java.util.List;

public interface AddressDAO {
	
	public boolean add(Address address); //���һ���µ�ַ
	
	public List<Address> findByUserId(int userId);	//����userId����Address����
	
	public boolean update(Address address); //�޸ĵ�ַ��Ϣ
	
	public boolean delete(Address address); //ɾ����ַ��Ϣ	
}

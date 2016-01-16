package com.ccnu.dang.dao;

import com.ccnu.dang.pojo.User;


public interface UserDAO {
	public boolean add(User user);   //���һ���µ��û�
	public User findById(int userId);		//����userId����һ��User����
	public User findByName(String nickname);	//����nickname����һ��User���� �ڵ�½ʱ���õ��������
	public User findByEmail(String email);   //����email����һ��User����, ע��ʱ����
	public boolean update(User user); //�޸��û���Ϣ
	public boolean allowLogin(String nickname, String password);  //��½�жϣ�����������findByName(String userName)����
}

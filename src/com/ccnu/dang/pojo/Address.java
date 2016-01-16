package com.ccnu.dang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="d_receive_address")
public class Address {
	@Id @Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	
	// �����Addressʵ�������Userʵ��
	@ManyToOne(targetEntity=User.class)
	// ������Ϊuser_id����У������������d_user���user_id�С�
	@JoinColumn(name="user_id", referencedColumnName="user_id"
	, nullable=false)
	private User user;
	
	@Column(name="receive_name")
	private String receiveName;    //�ջ���
	@Column(name="full_address")
	private String fullAddress;  //�ջ���ַ
	@Column(name="postal_code", length=8)
	private String postalCode;   //�������
	@Column(name="mobile", nullable=false)
	private String mobile;   //�û��ֻ���
	@Column(name="phone")
	private String phone;   //�û��绰
	
	public Address(){
		
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", userId=" + user.getUserId()
				+ ", receiveName=" + receiveName + ", fullAddress="
				+ fullAddress + ", postalCode=" + postalCode + ", mobile="
				+ mobile + ", phone=" + phone + "]";
	}
	
	

}


/*
id int(12) NOT NULL auto_increment,
user_id int(11) NOT NULL,             --�û�        
receive_name varchar(20) NOT NULL,    --�ջ���
full_address varchar(200) NOT NULL,   --�ջ���ַ
postal_code varchar(8) NULL,      --�������
mobile varchar(15) default NULL,      --�û��ֻ���
phone varchar(20) default NULL,       --�û��绰

*/
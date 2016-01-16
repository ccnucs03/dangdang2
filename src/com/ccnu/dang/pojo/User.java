package com.ccnu.dang.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="d_user")
public class User {
	// ��ʶ����
	@Id @Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="email", nullable=false)
	private String email;   //����
	@Column(name="nickname", nullable=false)
	private String nickname;  //ע����
	@Column(name="password", nullable=false)
	private String password;   //����	
	@Column(name="user_integral")
	private Integer userIntegral;   //�û��ȼ�
	@Column(name="is_email_verify")
	private Boolean isEmailVerify;   //�Ƿ�email��֤
	@Column(name="email_verify_code")
	private String emailVerifyCode;   //email��֤��
	@Column(name="last_login_time")
	private Timestamp lastLoginTime;   //���һ�ε�¼��ʱ��
	@Column(name="last_login_ip")
	private String lastLoginIp;  //��¼IP
	
	// �����Userʵ�����й�����Addressʵ��
	// ָ��mappedBy���Ա�����Userʵ�岻���ƹ�����ϵ
	@OneToMany(targetEntity=Address.class 
			, mappedBy="user", fetch = FetchType.EAGER)
	private Set<Address> addresses = new HashSet<>();
	
	
	public User() {
		
	}
	
	
	
	/**
	 * @param email
	 * @param nickname
	 * @param password
	 */
	public User(String email, String nickname, String password) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
	}



	//setter��getter����
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}
	public Boolean getIsEmailVerify() {
		return isEmailVerify;
	}
	public void setIsEmailVerify(Boolean isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	//String
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = Timestamp.valueOf(lastLoginTime);
	}
	//Timestape
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", nickname="
				+ nickname + ", password=" + password + ", userIntegral="
				+ userIntegral + ", isEmailVerify=" + isEmailVerify
				+ ", emailVerifyCode=" + emailVerifyCode + ", lastLoginTime="
				+ lastLoginTime + ", lastLoginIp=" + lastLoginIp
				+ ", addresses=" + addresses + "]";
	}
	
	
	
	

}


/*

CREATE TABLE d_user (
  id int(12) NOT NULL auto_increment,
  email varchar(50) NOT NULL,            --����
  nickname varchar(50) default NULL,     --ע����
  password varchar(50) NOT NULL,         --����
  user_integral int(12) NOT NULL default '0',  -- �û��ȼ�
  is_email_verify char(3),                     --�Ƿ�email��֤
  email_verify_code varchar(50) default NULL,  -email��֤��
  last_login_time bigint(20) default NULL,        --���һ�ε�¼��ʱ��
  last_login_ip varchar(15) default NULL,     --��¼IP
  PRIMARY KEY  (id),
  UNIQUE KEY email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
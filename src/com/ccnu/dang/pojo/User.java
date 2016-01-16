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
	// 标识属性
	@Id @Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="email", nullable=false)
	private String email;   //邮箱
	@Column(name="nickname", nullable=false)
	private String nickname;  //注册名
	@Column(name="password", nullable=false)
	private String password;   //密码	
	@Column(name="user_integral")
	private Integer userIntegral;   //用户等级
	@Column(name="is_email_verify")
	private Boolean isEmailVerify;   //是否email验证
	@Column(name="email_verify_code")
	private String emailVerifyCode;   //email验证码
	@Column(name="last_login_time")
	private Timestamp lastLoginTime;   //最后一次登录的时间
	@Column(name="last_login_ip")
	private String lastLoginIp;  //登录IP
	
	// 定义该User实体所有关联的Address实体
	// 指定mappedBy属性表明该User实体不控制关联关系
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



	//setter和getter方法
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
  email varchar(50) NOT NULL,            --邮箱
  nickname varchar(50) default NULL,     --注册名
  password varchar(50) NOT NULL,         --密码
  user_integral int(12) NOT NULL default '0',  -- 用户等级
  is_email_verify char(3),                     --是否email验证
  email_verify_code varchar(50) default NULL,  -email验证码
  last_login_time bigint(20) default NULL,        --最后一次登录的时间
  last_login_ip varchar(15) default NULL,     --登录IP
  PRIMARY KEY  (id),
  UNIQUE KEY email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/
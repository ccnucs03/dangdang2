package com.ccnu.dang.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
//指定使用连接子类的映射策略
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="d_product")
public class Product {
	@Id @Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	@Column(name="product_name", nullable=false)
	private String productName;   //产品名字	
	@Column(name="description")
	@Type(type="text")
	private String description;   //产品描述
	@Column(name="add_time")   
	private Timestamp addTime;     //添加产品的时间
	@Column(name="fixed_price")   
	private Double fixedPrice;   //固定价格 
	@Column(name="dang_price")
	private Double dangPrice;  //当当价格
	private String keywords;   //关键搜索
	@Column(name="has_deleted")
	private Boolean hasDeleted;   //是否删除
	@Column(name="product_pic")
	private String productPic;   //产品图片
	
	// 定义该Product实体所有关联的Category实体
	@ManyToMany(targetEntity=Category.class)
	// 映射连接表，指定连接表的表名为person_address
	@JoinTable(name="d_category_product",
		// 映射连接表中名为product_id的外键列，
		// 该列参照当前实体对应表的product_id主键列
		joinColumns=@JoinColumn(name="product_id"
			, referencedColumnName="product_id"),
		// 映射连接表中名为category_id的外键列，
		// 该列参照当前实体对应表的category_id主键列
		inverseJoinColumns=@JoinColumn(name="category_id"
			, referencedColumnName="category_id")
		
	)
	private Set<Category> categorys = new HashSet<>();
	
	public Product() {
		
	}
	
	
	/**
	 * @param productName
	 * @param dangPrice
	 * @param keywords
	 */
	public Product(String productName, Double dangPrice, String keywords) {
		super();
		this.productName = productName;
		this.dangPrice = dangPrice;
		this.keywords = keywords;
	}


	//getter和setter方法
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getAddTime() {
		return addTime;
	}
	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}
	public Double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(Double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public Double getDangPrice() {
		return dangPrice;
	}
	public void setDangPrice(Double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Boolean getHasDeleted() {
		return hasDeleted;
	}
	public void setHasDeleted(Boolean hasDeleted) {
		this.hasDeleted = hasDeleted;
	}
	public String getProductPic() {
		return productPic;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}


	public Set<Category> getCategorys() {
		return categorys;
	}


	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}
	
	
}




/*--产品表
CREATE TABLE d_product (
  id int(12) NOT NULL auto_increment,  
  product_name varchar(100) NOT NULL,   --产品名字
  description varchar(100) default NULL, --产品描述
  add_time bigint(20) default NULL,      --添加产品的时间
  fixed_price double NOT NULL,           --固定价格 	
  dang_price double NOT NULL,            --当当价格
  keywords varchar(200) default NULL,    --关键搜索
  has_deleted int(1) NOT NULL default '0', --是否删除
  product_pic varchar(200) default NULL,  --产品图片
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8*/
package com.ccnu.dang.pojo;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//指定使用连接子类的映射策略
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="d_category")
public class Category {
	@Id @Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryId;	
	private Integer turn;
	@Column(name="en_name")
	private String enName;   //英文名字
	@Column(name="cn_name")
	private String cnName;    //中文名字
	private String description;   //种类描述(*) 
	
	// 定义该Person实体所有关联的Address实体，没有指定cascade属性
	@OneToMany(targetEntity=Category.class)
	// 映射外键列，此处映射的外键列将会添加到关联实体对应的数据表中
	@JoinColumn(name="parentId" , referencedColumnName="category_id")	
	private Set<Category> childcategories = new HashSet<>();	
	
	private Integer parentId;	

	// 定义该Category实体所有关联的Product实体
	@ManyToMany(targetEntity=Product.class)
	// 映射连接表，指定连接表的表名为person_address
	@JoinTable(name="d_category_product",
		// 映射连接表中名为category_id的外键列，
		// 该列参照当前实体对应表的category_id主键列
		joinColumns=@JoinColumn(name="category_id"
			, referencedColumnName="category_id"),
		// 映射连接表中名为product_id的外键列，
		// 该列参照当前实体对应表的product_id主键列
		inverseJoinColumns=@JoinColumn(name="product_id"
			, referencedColumnName="product_id")
	)
	private Set<Product> products = new HashSet<>();
	
	/**
	 * 无参构造器
	 */
	public Category() {
		
	}
	
	/**
	 * @param turn
	 * @param enName
	 * @param cnName
	 * @param description
	 * @param parentId
	 * @param products
	 */
	public Category(Integer turn, String enName, String cnName,
			String description, Integer parentId) {
		super();
		this.turn = turn;
		this.enName = enName;
		this.cnName = cnName;
		this.description = description;
		this.parentId = parentId;	
	}



	//getter和setter方法
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getTurn() {
		return turn;
	}
	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}



	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public Set<Category> getChildcategories() {
		return childcategories;
	}


	public void setChildcategories(Set<Category> childcategories) {
		this.childcategories = childcategories;
	}

	@Override
	public String toString() {
		return "Category [" + "parentId=" + parentId + ", categoryId=" + categoryId + ", turn=" + turn
				+ ", enName=" + enName + ", cnName=" + cnName
				+ ", description=" + description +  "]";
	}
	
	
	
	
	
}


/*
id int(12) NOT NULL auto_increment,
  turn int(10) NOT NULL,         --显示顺序(*)
  en_name varchar(200) NOT NULL,  --英文名字
  name varchar(200) NOT NULL,     --中文名字
  description varchar(200),      --种类描述(*) 
  parent_id int(10),             --父类项
*/
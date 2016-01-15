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
//ָ��ʹ�����������ӳ�����
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="d_category")
public class Category {
	@Id @Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryId;	
	private Integer turn;
	@Column(name="en_name")
	private String enName;   //Ӣ������
	@Column(name="cn_name")
	private String cnName;    //��������
	private String description;   //��������(*) 
	
	// �����Personʵ�����й�����Addressʵ�壬û��ָ��cascade����
	@OneToMany(targetEntity=Category.class)
	// ӳ������У��˴�ӳ�������н�����ӵ�����ʵ���Ӧ�����ݱ���
	@JoinColumn(name="parentId" , referencedColumnName="category_id")	
	private Set<Category> childcategories = new HashSet<>();	
	
	private Integer parentId;	

	// �����Categoryʵ�����й�����Productʵ��
	@ManyToMany(targetEntity=Product.class)
	// ӳ�����ӱ�ָ�����ӱ�ı���Ϊperson_address
	@JoinTable(name="d_category_product",
		// ӳ�����ӱ�����Ϊcategory_id������У�
		// ���в��յ�ǰʵ���Ӧ���category_id������
		joinColumns=@JoinColumn(name="category_id"
			, referencedColumnName="category_id"),
		// ӳ�����ӱ�����Ϊproduct_id������У�
		// ���в��յ�ǰʵ���Ӧ���product_id������
		inverseJoinColumns=@JoinColumn(name="product_id"
			, referencedColumnName="product_id")
	)
	private Set<Product> products = new HashSet<>();
	
	/**
	 * �޲ι�����
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



	//getter��setter����
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
  turn int(10) NOT NULL,         --��ʾ˳��(*)
  en_name varchar(200) NOT NULL,  --Ӣ������
  name varchar(200) NOT NULL,     --��������
  description varchar(200),      --��������(*) 
  parent_id int(10),             --������
*/
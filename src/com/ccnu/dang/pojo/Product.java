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
//ָ��ʹ�����������ӳ�����
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="d_product")
public class Product {
	@Id @Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	@Column(name="product_name", nullable=false)
	private String productName;   //��Ʒ����	
	@Column(name="description")
	@Type(type="text")
	private String description;   //��Ʒ����
	@Column(name="add_time")   
	private Timestamp addTime;     //��Ӳ�Ʒ��ʱ��
	@Column(name="fixed_price")   
	private Double fixedPrice;   //�̶��۸� 
	@Column(name="dang_price")
	private Double dangPrice;  //�����۸�
	private String keywords;   //�ؼ�����
	@Column(name="has_deleted")
	private Boolean hasDeleted;   //�Ƿ�ɾ��
	@Column(name="product_pic")
	private String productPic;   //��ƷͼƬ
	
	// �����Productʵ�����й�����Categoryʵ��
	@ManyToMany(targetEntity=Category.class)
	// ӳ�����ӱ�ָ�����ӱ�ı���Ϊperson_address
	@JoinTable(name="d_category_product",
		// ӳ�����ӱ�����Ϊproduct_id������У�
		// ���в��յ�ǰʵ���Ӧ���product_id������
		joinColumns=@JoinColumn(name="product_id"
			, referencedColumnName="product_id"),
		// ӳ�����ӱ�����Ϊcategory_id������У�
		// ���в��յ�ǰʵ���Ӧ���category_id������
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


	//getter��setter����
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




/*--��Ʒ��
CREATE TABLE d_product (
  id int(12) NOT NULL auto_increment,  
  product_name varchar(100) NOT NULL,   --��Ʒ����
  description varchar(100) default NULL, --��Ʒ����
  add_time bigint(20) default NULL,      --��Ӳ�Ʒ��ʱ��
  fixed_price double NOT NULL,           --�̶��۸� 	
  dang_price double NOT NULL,            --�����۸�
  keywords varchar(200) default NULL,    --�ؼ�����
  has_deleted int(1) NOT NULL default '0', --�Ƿ�ɾ��
  product_pic varchar(200) default NULL,  --��ƷͼƬ
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8*/
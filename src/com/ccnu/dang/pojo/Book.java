package com.ccnu.dang.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="d_book")
public class Book extends Product {
	
	private String author; //�鼮����
	
	private String publishing;	//���������
	
	@Column(name="publish_time")
	private Date publishTime; //����ʱ��
	
	@Column(name="word_number")
	private String wordNumber; //����
	
	@Column(name="which_edtion")
	private String whichEdtion;  //���
	
	@Column(name="total_page")
	private String totalPage;   //��ҳ��
	
	@Column(name="print_time")
	private Date printTime;   //ӡˢʱ��
	
	@Column(name="print_number")
	private String printNumber;   //ӡ��
	
	private String isbn;   //�鼮���
	
	@Column(name="author_summary")
	@Type(type="text")
	private String authorSummary; //���߼��
	
	@Column(name="catalogue")
	@Type(type="text")
	private String catalogue;  //Ŀ¼

	public Book(){
		super();
	}
	
	public Book(String author, String isbn) {
		super();
		this.author = author;
		this.isbn = isbn;
	}
	
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing() {
		return publishing;
	}

	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getWordNumber() {
		return wordNumber;
	}

	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

	public String getWhichEdtion() {
		return whichEdtion;
	}

	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	public String getPrintNumber() {
		return printNumber;
	}

	public void setPrintNumber(String printNumber) {
		this.printNumber = printNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorSummary() {
		return authorSummary;
	}

	public void setAuthorSummary(String authorSummary) {
		this.authorSummary = authorSummary;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", productName=" + super.getProductName()+ ", publishing=" + publishing
				+ ", publishTime=" + publishTime + ", wordNumber=" + wordNumber
				+ ", whichEdtion=" + whichEdtion + ", totalPage=" + totalPage
				+ ", printTime=" + printTime + ", printNumber=" + printNumber
				+ ", isbn=" + isbn + ", authorSummary=" + authorSummary
				+ ", catalogue=" + catalogue + "]";
	}	
	
	
	
}

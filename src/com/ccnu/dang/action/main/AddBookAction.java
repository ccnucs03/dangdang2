package com.ccnu.dang.action.main;

import java.io.File;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ccnu.dang.hibernate.HibernateSessionFactory;
import com.ccnu.dang.pojo.Book;
import com.opensymphony.xwork2.ActionSupport;


public class AddBookAction extends ActionSupport {
	

	private Book book = new Book();
	private File image = null;        //图片
	private String imageContentType;//文件类型,这两个属性，Struts2自动会解析  
    private String imageFileName;   //文件名     
    
	public String execute() {
		//HttpSession session = ServletActionContext.getRequest().getSession();		
		//ServletActionContext.getRequest().setAttribute("books", books);
		//session.setAttribute("books", books);
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		book.setAddTime(new Timestamp(System.currentTimeMillis()));
		book.setHasDeleted(false);
		book.setProductPic(imageFileName);
		System.out.println(book.toString());
		System.out.println("imageFileName=" + imageFileName + "imageContentType=" + imageContentType);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	
		session.save(book);		
		tx.commit();		
		System.out.println(book.getProductId());
		
		session.close();
		return SUCCESS;
		
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
	
	public String getImageContentType() {
		return imageContentType;
	}


	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}


	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	

}

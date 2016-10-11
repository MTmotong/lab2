package com.attribute;

import java.util.Date;

public class Book{

	private String ISBN;
	private String QISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private Date PublishDate;
	private double Price;

	
	public String getQISBN() {
		return QISBN;
	}

	public void setQISBN(String qISBN) {
		QISBN = qISBN;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int AuthorID) {
		this.AuthorID = AuthorID;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}

	public Date getPublishDate() {
 
		return PublishDate;
	}

	public void setPublishDate(Date PublishDate) {
		 
		this.PublishDate = PublishDate;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;
	}
}




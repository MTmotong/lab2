package com.action;


import com.attribute.Author;
import com.attribute.Book;
import com.manage.Manage;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class AuthorAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Author author;
	String AuthorID;
	private List<Book> books;
	
	public String getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(String AuthorID) {
		this.AuthorID = AuthorID;
	}

	List<Author> authors;
	Manage DAO = new Manage();
 
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Manage getDAO() {
		return DAO;
	}

	public void setDAO(Manage DAO) {
		this.DAO = DAO;
	}
	
	public String infor()			
	{
		if(author.getName()==null){
			books = DAO.getBook("");
		}else{
			books = DAO.getBook(author.getName());
		}
		
		return SUCCESS;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String execute()
	{
		return SUCCESS;
	}

	//return; 
	
	
}

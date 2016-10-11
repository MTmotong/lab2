package com.action;


import com.attribute.Book;
import com.attribute.Author;
import com.manage.Manage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Book book;
	Author author;
	private String ISBN;
	String QISBN;
	List<Book> books;
	List<Author> authors;
	Manage DAO = new Manage();
	
	public String get()
	{
		book = DAO.get(ISBN);
		return SUCCESS;
	}
	public String show() throws SQLException
	{
		books = new ArrayList<Book>();
		books = DAO.getAll(book.getISBN());
		authors = new ArrayList<Author>();
		authors = DAO.getAuthor(author.getAuthorID());
		return SUCCESS;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String list() throws SQLException
	{
		if(book==null){
			books = DAO.getAll("");
		}else{
			books = DAO.getAll(book.getQISBN());
		}
		
		return SUCCESS;
	}
 
	public String save()
	{
		 
		DAO.save(book.getISBN(),book.getTitle(),book.getAuthorID(),book.getPublisher(),book.getPublishDate(),book.getPrice());
		return SUCCESS;
	}
	
	public String delete()
	{
		DAO.delete(ISBN);
		return SUCCESS;
	}
	
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
	public List<Book> getBooks()
	{
		return books;
	}
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
	public Manage getDAO() {
		return DAO;
	}

	public void setDAO(Manage DAO) {
		this.DAO = DAO;
	}
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String execute()
	{
		return SUCCESS;
	}
	//xx
 
	
}

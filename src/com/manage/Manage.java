package com.manage;

import com.attribute.Book;
import com.connect.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.attribute.Author;
public class Manage 
{
	public Manage(){
	}
	
	boolean issuc= false;
	DBConnect DBC = new DBConnect();
	ResultSet rs = null;
	//Statement stmt = null;
	public boolean save(String ISBN,String Title,int AuthorID,String Publisher,Date PublishDate,double Price)
	{
		Connection conn = DBC.getConn();
		Statement stmt = null;
		String sql = "";
		String sqlt = "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String sDate=sdf.format(PublishDate);
 
       // SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmss");
       // String sDate2=sdf2.format(new java.util.Date());
		if(ISBN==null || "".equals(ISBN))
		{
			sql = "update Book set Title='" + Title + "',AuthorID=" + AuthorID + ",Publisher='" + Publisher + "',PublishDate=" + sDate + ",Price=" + Price + " where ISBN='"+ISBN+"'";
		}
		else
		{
			sqlt = "delete from Book where ISBN='" + ISBN + "'";
			sql = "insert into Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)values('" + ISBN + "','" + Title + "'," + AuthorID + ",'" + Publisher + "','" + sDate + "'," + Price + ")";
		
		}
		try
		{
			stmt = conn.createStatement();
			stmt.execute(sqlt);
			int count = stmt.executeUpdate(sql);
			if(count > 0)
			{
				issuc = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(stmt,conn);
		}
		return issuc;
	}
	
	public List<Book> getAll(String ISBN) throws SQLException
	{
		List<Book> Blist = new ArrayList<Book>();
		Connection conn = DBC.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "";
		if(ISBN==null || "".equals(ISBN))
		{
			sql = "select * from Book ";
		}else{
			sql = "select * from Book where ISBN='"+ISBN+"'";
		}
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			Book myattribute = new Book();
			myattribute.setISBN(rs.getString("ISBN"));
			myattribute.setTitle(rs.getString("Title"));
			myattribute.setAuthorID(rs.getInt("AuthorID"));
			myattribute.setPublisher(rs.getString("Publisher"));
			myattribute.setPublishDate(rs.getDate("PublishDate"));
			myattribute.setPrice(rs.getDouble("Price"));
			Blist.add(myattribute);
			//create database bookdb;
			//create table Book(ISBN char(50)  NOT NULL PRIMARY KEY,Title char(20),AuthorID int,Publisher char(20),PublishDate date,Price double)
			//insert into Book values (11,'22',1,'33','2015-02-02',8.9);
			//<s:date name="book.PublishDate" format="yyyy-MM-dd" />
			//<ss:hidden?name="book.ISBN" label="ISBN" >?</ss:hidden>
		}
		close(rs,stmt,conn);
		
		return Blist;
	}
	//输出作者的详细信息
	public List<Author> getAuthor(int AuthorID)
	{
		List<Author> Alist = new ArrayList<Author>();
		Connection conn = DBC.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			String sql = "";
			sql = "select * from Author where AuthorID ="+AuthorID+";";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Author myattribute = new Author();
				myattribute.setAuthorID(rs.getInt("AuthorID"));
				myattribute.setName(rs.getString("Name"));
				myattribute.setAge(rs.getInt("Age"));
				myattribute.setCountry(rs.getString("Country"));
				Alist.add(myattribute);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs,stmt,conn);
		}
		
		return Alist;
	}
	
	//查询作者名字，输出其所有书
	//xxxxx
	@SuppressWarnings("resource")
	public List<Book> getBook(String Name)
	{			
		List<Book> Blist = new ArrayList<Book>();
		List<Author> Alist = new ArrayList<Author>();
		Connection conn = DBC.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			String sql = "";
			if(Name==null || "".equals(Name))
			{
				sql = "select * from Author ";
			}else{
				sql = "select * from Author where Name='"+Name+"'";		
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Author myattribute = new Author();
				myattribute.setAuthorID(rs.getInt("AuthorID"));
				sql = "select * from Book where AuthorID='"+myattribute.getAuthorID()+"'";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{	
					Book yattribute = new Book();
					yattribute.setTitle(rs.getString("Title"));
					yattribute.setISBN(rs.getString("ISBN"));
					yattribute.setAuthorID(rs.getInt("AuthorID"));
					Blist.add(yattribute);
				}
				Alist.add(myattribute);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs,stmt,conn);
		}
		
		return Blist;
	}
	
	public boolean delete(String ISBN)
	{
		Connection conn = DBC.getConn();
		Statement stmt = null;
		try
		{
			stmt = conn.createStatement();
			int count = stmt.executeUpdate("delete from Book where ISBN='" + ISBN + "'");
			if(count > 0)
			{
				issuc = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(stmt,conn);
		}
		return issuc; 
	}
	
	public Book get(String ISBN)
	{
		Connection conn = DBC.getConn();
		Book myattribute = new Book();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			String sql = "select *from Book where ISBN='" + ISBN + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				myattribute.setISBN(rs.getString("ISBN"));
				myattribute.setTitle(rs.getString("Title"));
				myattribute.setAuthorID(rs.getInt("AuthorID"));
				myattribute.setPublisher(rs.getString("Publisher"));
				myattribute.setPublishDate(rs.getDate("PublishDate"));
		 
				myattribute.setPrice(rs.getDouble("Price"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs,stmt,conn);
		}
		
		return myattribute;
	}
	
	public void close(ResultSet rs,Statement stmt,Connection conn)
	{
		try
		{
			if(rs != null)
			{
				rs.close();
				stmt.close();
				conn.close();
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void close(Statement stmt,Connection conn)
	{
		try
		{
			stmt.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	
}

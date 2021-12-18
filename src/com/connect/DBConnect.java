package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
	public DBConnect(){		
	}
	
	public Connection getConn()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		try
		{
			String username="root";
			// + "?useUnicode=true&characterEncoding=UTF-8"
			//String url = "jdbc:mysql://localhost:3306/bookdb";
			String url = "jdbc:mysql://anfvigiwajmj.rds.sae.sina.com.cn:10598/bookdb";
			conn = DriverManager.getConnection(url,username,password);
			//mysqld --install MySQL --defaults-file="my.ini"
			//net start mysql
			//mysqld --console
			//mysqld --skip-grant-tables
			//mysql -hlocalhost -uroot -p
			//use mysql
			//update user set password=password("199587") where user="root";FLUSH PRIVILEGES;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}

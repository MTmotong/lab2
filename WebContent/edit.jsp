<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	#grad1
	{
		height: 1100px;
		background: -webkit-liner-gradient(springgreen,mediumblue);
		background: -o-linear-gradient(springgreen,mediumblue);
		background: -moz-linear-gradient(springgreen,mediumblue);
		background: linear-gradient(springgreen,mediumblue);
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Operation</title>
 
</head>
<body>
	<div id="grad1">
	<h2>
		<s:if test="null == book">
			<p><br> <br></p>
			Add Book
		</s:if> 
		<s:else>
			<p><br> <br></p>
			Edit Book
		</s:else>
	</h2>
	<s:form action="Save" theme="simple"  >
	<table style="border:1px,solid,black">
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>AuthorID</th>
			<th>Publisher</th>
			<th>PublishDate</th>
			<th>Price</th>
		</tr>
		<tr>
			<td><s:textfield name="book.ISBN" label="ISBN" /></td>
			<td><s:textfield name="book.Title" label="Title" /></td>
			<td><s:textfield name="book.AuthorID" label="AuthorID" /></td>
			<td><s:textfield name="book.Publisher" label="Publisher" /></td>
			<td><s:textfield name="book.PublishDate"><s:param name="value" ><s:date name="book.PublishDate" format="yyyy-MM-dd" /></s:param></s:textfield></td>
			<td><s:textfield name="book.Price" label="Price" /></td>
		</tr>
	</table>
	 <s:submit />
	</s:form>	
	</div>		
</body>
</html>
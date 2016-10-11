<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Library Database</title>
	<style type="text/css">
		
		h2 {text-align: center}
		h3 {text-align: left}
		#grad1
		{
			height: 1100px;
			background: -webkit-liner-gradient(springgreen,mediumblue);
			background: -o-linear-gradient(springgreen,mediumblue);
			background: -moz-linear-gradient(springgreen,mediumblue);
			background: linear-gradient(springgreen,mediumblue);
		}
		#customers
		{
			font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
			width:100%;
			border-collapse:collapse;
		}
		#customers td, #customers th
		{
			font-size:1em;
			border:1px solid #E6E6FA;
			padding:3px 7px 2px 7px;
		}
		#customers th
		{
			font-size:1.1em;
			text-align:left;
			padding-top:5px;
			padding-bottom:4px;
			background-color:#3CB371;
			color:#ffffff;
		}
		
	</style>
</head>
<body>
	<div id="grad1">
	<p><br> <br></p>
	<h2>Library Database</h2>

	<s:form  theme="simple" action="infor" method="post" namespace="">
		<h3>please input Author's name:(ex:dongziyu)</h3>
		<s:textfield name="author.Name">
		</s:textfield>
		<s:submit value="submit" />
	</s:form>
	<p><br> <br></p>
	<s:form  theme="simple">
		<table id="customers">
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Title</th>
					<th>AuthorID</th>
					<th>Publisher</th>
					<th>PublishDate</th>
					<th>Price</th>
					<th>Operation</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="books">
				<tr>
					<td>
						<s:property value="ISBN"/>
					</td>
					<td>
						<s:property value="Title"/>
					</td>
					<td>
						<s:property value="AuthorID"/>
					</td>
					<td>
						<s:property value="Publisher"/>
					</td>
					<td>
			
				<s:date name="PublishDate" format="yyyy-MM-dd" />
					</td>
					<td>
						<s:property value="Price"/>
					</td>
					<td>
						<a href='<s:url  action="Edit"><s:param  name="ISBN" value="ISBN" /></s:url>'>Edit</a>
						&nbsp;
						<a href='<s:url  action="Delete"><s:param  name="ISBN" value="ISBN" /></s:url>'>Delete</a>
					</td>
				</tr>
			</s:iterator>
			</tbody>	
		</table>
		<h3><a href="edit.jsp">  Add</a></h3>
	</s:form>
	</div>
</body>
</html>



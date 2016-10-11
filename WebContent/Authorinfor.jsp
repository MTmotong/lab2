<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Library Database</title>
	<style type="text/css">
		h2 {text-align: left}
		#grad1
		{
			height: 1100px;
			background: -webkit-liner-gradient(springgreen,mediumblue);
			background: -o-linear-gradient(springgreen,mediumblue);
			background: -moz-linear-gradient(springgreen,mediumblue);
			background: linear-gradient(springgreen,mediumblue);
		}
		table
		{
			border: 1px solid black;
			border-collapse:collapse;
		}
		table thead tr th
		{
			border:1px solid black;
			padding:3px;
			background-color:#ccccc;
		}
		table tbody tr td
		{
			border:1px solid black;
			padding:3px;
		}
	</style>
</head>
<body>
	<div id="grad1">
	<p><br> <br></p>
	<h2>All books from the author</h2>
	<s:form  theme="simple">
		<table cellspacing="0">
			<thead>
				<tr>
					<th>Title</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="books">
				<tr>
					<td>
						<a href="Show.action?book.ISBN=${ISBN }&author.AuthorID=${AuthorID}" target="_"><s:property value="Title"/></a>
					</td>
				</tr>
			</s:iterator>
			</tbody>	
		</table>
	</s:form>
	</div>
</body>
</html>



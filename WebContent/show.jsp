<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Detailed information</title>
	<style type="text/css">
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
	<h2>Detailed information</h2>
	<s:form  theme="simple">
		<table cellspacing="0">
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Title</th>
					<th>AuthorID</th>
					<th>Publisher</th>
					<th>PublishDate</th>
					<th>Price</th>
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
				</tr>
			</s:iterator>
			</tbody>	
		</table>
	</s:form>
	<p><br><br></p>
	<s:form  theme="simple">
		<table cellspacing="0">
			<thead>
				<tr>
					<th>AuthorID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Country</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="authors">
				<tr>
					<td>
						<s:property value="AuthorID"/>
					</td>
					<td>
						<s:property value="Name"/>
					</td>
					<td>
						<s:property value="Age"/>
					</td>
					<td>
						<s:property value="Country"/>
					</td>
				</tr>
			</s:iterator>
			</tbody>	
		</table>
	</s:form>
	</div>
</body>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><td>图书管理画面............</td></del></tr>
<c:forEach items="${bookList}" var="books">
	<tr>
		<td>图书ID:<span>${books.bookId}</span></td>
		<td>图书名称:<span>${books.name}</span></td>
		<td>馆藏数量:<span>${books.number}</span></td>
	</tr>   
</c:forEach>
</table>

</body>
</html>
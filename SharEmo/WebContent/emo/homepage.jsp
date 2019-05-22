<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="">
<title>emotion store</title>
</head>
<body>
<center>
<img style=''src='./homepageicon.png' width=30px height=30px>
<input type=text style='width:500px; height:30px;'> 
</center>

<sql:query var="rs" dataSource="jdbc/mysql">
select username, email from jdbct
</sql:query>

<hr>

<c:forEach var="row" items="${rs.rows}">
</c:forEach>

</body>
</html>
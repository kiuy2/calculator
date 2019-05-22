<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="">
  <title>emotion store</title>
</head>
<body>

  <center>
	<img style=''src='./homepageicon.png' width=30px height=30px>
	<input type=text style='width:500px; height:30px;'> 
  </center>

  <h1>게시판 목록 보기</h1>
  <hr>
  <table border='1'>
	<tr>
		<td colspan='5'>
			<form action='search.do'>
				<select name='searchName' size='1'>
					<option value='author'>작성자</option>
					<option value='title'>글제목</option>
				</select>
				<input type='text' name='searchValue'>
				<input type='submit' value='찾기'>
			</form>
		</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>날짜</td>
		<td>조회수</td>
	</tr>
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.num}</td>
			<td>
				<c:forEach begin="1" end="${dto.repIndent}">
				<%="&nbsp;&nbsp;" %>
				</c:forEach>
				<a href="retrieve.do?num=${dto.num}">${dto.title}</a>
			</td>
			<td>${dto.author}</td>
			<td>${dto.writeday}</td>
			<td>${dto.readcnt}</td>
		</tr>
	</c:forEach>
  </table>
  <a href='writeui.do'>글쓰기</a>

</body>
</html>
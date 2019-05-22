<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   		<title>게시판 등록</title>
	</head>
   <body>
         <h2>게시판 등록</h2>
      
	<form name=form1 action='write.do' method=post>
     	제목 : <input type=text name='title'><br/>
		작성자 : <input type=text name='author'><br/>
		내용 : <textarea name='content' rows='5'></textarea><br/>
        <input type=submit value="저장">
	</form>
	<a href='list.do'>목록보기</a>
   </body>
</html>



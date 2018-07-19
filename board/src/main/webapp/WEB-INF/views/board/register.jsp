<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<style>
	td, th {
		border: 1px solid #000;
	}
</style>
<body>
<form method="post">
	<p>
		<label for="title">제목: </label>
		<input type="text" name="title" placeholder="제목입력" required="required"/>
	</p>
	<p>
		<label for="content">내용: </label>
		<input type="text" name="content" placeholder="내용입력" required="required"/>
	</p>
	<p>
		<label for="writer">작성자: </label>
		<input type="text" name="writer" placeholder="작성자입력" required="required"/>
	</p>
	<p>
		<input type="submit" value="글쓰기" />
	</p>
		
</form>
</body>
</html>

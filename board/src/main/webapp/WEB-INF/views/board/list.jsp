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
<table>
    <colgroup>
        <col>
        <col width=70%>
        <col>
    </colgroup>
    <thead>
        <tr>
            <th>bno</th>
            <th>title</th>
            <th>writer</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="boardVO" items="${boardVOs}">
        <tr>
            <td>${boardVO.bno}</td>
            <td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
            <td>${boardVO.writer}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<button type="submit" class="register">글쓰기</button>
<script>
    document.querySelector('.register').addEventListener('click', function (e) {
        self.location = "/board/register";
    });
</script>
</body>
</html>

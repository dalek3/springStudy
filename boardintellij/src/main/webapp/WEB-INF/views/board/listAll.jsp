<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko-KR">

<head>
  <meta charset="UTF-8">
  <title>Hello Spring</title>
</head>

<body>
    <table class="table table-bordered">
        <tr>
            <th style="width: 10px">BNO</th>
            <th>TITLE</th>
            <th>WRITER</th>
            <th>REGDATE</th>
            <th style="width: 40px">VIEWCNT</th>
        </tr>
        <c:forEach items="${list}" var="boardVO">
        <tr>
            <td>${boardVO.bno}</td>
            <td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
            <td>${boardVO.writer}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
                 value="${boardVO.regdate}" /></td>
        </tr>
        </c:forEach>
    </table>
</body>

</html>
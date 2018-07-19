<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <form method="post">
        <input type="hidden" name="bno" value="${boardVO.bno}">
    </form>
<section>
    <h3>${boardVO.title}</h3>
    <p>${boardVO.writer}</p>
    <p>${boardVO.content}</p>
</section>
<p>
    <button type="submit" class="remove">삭제</button>
    <button type="submit" class="modify">수정</button>
    <button type="submit" class="list">목록</button>
</p>
<script>
    
(function(global){   
    // 버튼으로 이벤트 발생시 form으로 필요한 데이터를 받아 놓은 후 js를 사용하여 처리한다.
    var formObj = document.querySelector('form');
    console.log(formObj);

    document.querySelector('.modify').addEventListener('click', function(e) {
        formObj.setAttribute("action", "/board/modify");
        formObj.setAttribute("method", "get");
        formObj.submit(); 
    });

    document.querySelector('.remove').addEventListener('click', function(e) {
        formObj.setAttribute("action", "/board/remove");
        formObj.submit(); 
    });
    
    document.querySelector('.list').addEventListener('click', function(e) {
        self.location = "/board/list";
    });
}(window));

</script>
</body>
</html>

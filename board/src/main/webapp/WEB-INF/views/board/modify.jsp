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
        <p>
            <label for="title">제목: </label>
            <input type="text" name="title" value="${boardVO.title}">
        </p>
        <p>
            <label for="writer">작성자: </label>
            <input type="text" name="writer" value="${boardVO.writer}">
        </p>
        <p>
            <label for="content">내용: </label>
            <textarea name="content" cols="30" rows="10">${boardVO.content}</textarea>
        </p>
    </form>
        <p>
            <button type="submit" class="save">저장</button>
            <button type="submit" class="cancel">취소</button>
        </p>
<script>
    
(function(global){   
    // 버튼으로 이벤트 발생시 form으로 필요한 데이터를 받아 놓은 후 js를 사용하여 처리한다.
    var formObj = document.querySelector('form');
    console.log(formObj);

    document.querySelector('.save').addEventListener('click', function(e) {
        formObj.submit(); 
    });

    document.querySelector('.cancel').addEventListener('click', function(e) {
        self.location = "/board/list";
    });
}(window));

</script>
</body>
</html>

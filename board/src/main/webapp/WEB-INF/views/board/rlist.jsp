<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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

	    </tbody>
	</table>
	<button type="submit" class="register">글쓰기</button>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
		    $.getJSON("api/list",function (result) {
		    	var html = []
		    	$.each(result, function(i, item) {
			        html.push('<tr>')
			        html.push('		<td>' + item.bno +'</td>')
			        html.push('		<td><a href="/board/read?bno=' + item.bno +'">' + item.title +'</a></td>')
			        html.push('    	<td>'+item.writer+'</td>')
			        html.push('</tr>');
		    		
		    		$('tbody').html(html.join(''));
		   		});
		
		        
		    })
		});
		document.querySelector('.register').addEventListener('click', function (e) {
		    self.location = "/board/register";
		});
</script>
</body>
</html>

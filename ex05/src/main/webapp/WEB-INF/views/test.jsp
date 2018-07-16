<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko-KR">
<head>
	<meta charset="UTF-8" />
	<title>ajax test</title>
	<style>
	   
	   #modDiv {
	       width: 300px;
	       height: 100px;
	       background-color: gray;
	       position: absolute;
	       top: 50%;
	       left: 50%;
	       margin-top: -50px;
	       margin-left: -150px;
	       padding: 10px;
	       z-index: 1000;
	   }
	   .pagination {
	       width: 100%;
	   }
	   .pagination li {
           list-style: none;
			float: left; 
			padding: 3px; 
			border: 1px solid blue;
			margin:3px;  
		}
			
		.pagination li a {
			margin: 3px;
			text-decoration: none;  
		}
	</style>
</head>
<body>
	
	<h2>Ajax Test Page</h2>
	
	<div>
	   <div>
	       REPLYER <input type="text" name="replyer" id="newReplyWriter" />
	   </div>
	   <div>
	       REPLY TEXT <input type="text" name="replytext" id="newReplyText"/>
	   </div>
	   <button id="replyAddBtn">ADD REPLY</button>
	</div>
	
	<ul id="replies">
	</ul>

	<ul class="pagination"></ul>
	
	<div id="modDiv" style="display: none;">
	   <div class="modal-title"></div>
	   <div>
	       <input type="text" id="replytext" />
	   </div>
	   <div>
	       <button type="button" id="replyModBtn">Modify</button>
	       <button type="button" id="replyDelBtn">DELETE</button>
	       <button type="button" id="closeBtn">Close</button>
	   </div>
	</div>
	
	
	<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script>
	   var bno = 393198;
	   var replyPage = 1;
	   
	   // 리스트 출력
	   function getAllList() {
		   $.getJSON("/replies/all/" + bno, function(data) {
			  
			   var str= "";
			   console.log(data.length);
			   
			   $(data).each(function() {
				   str += "<li data-rno='" + this.rno + "' class='replyLi'>"
				       + this.rno + ":" + this.replytext
				       + "<button>MOD</button></li>"
			   });
			   
			   $("#replies").html(str);
		   });
	   }
	   
	   function printPaging(pageMaker) {
           
           var str = "";
           
           if(pageMaker.prev) {
               str += "<li><a href='" + (pageMaker.startPage-1) + "'> << </a></li>";
           }
           
           for(var i = pageMaker.startPage; i <= pageMaker.endPage; i++){
               var strClass = pageMaker.cri.page == i ? 'class=active' : '';
               str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
           }
           
           if(pageMaker.next) {
               str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>";
           }
           $('.pagination').html(str);
       }
       
       function getPageList(page) {
           
           $.getJSON("/replies/" + bno + "/" + page, function(data) {
              
               console.log(data.list.length);
               
               var str = "";
               
               $(data.list).each(function() {
                   str += "<li data-rno='" + this.rno + "' class='replyLi'>"
                       + this.rno + ":" + this.replytext
                       + "<button>MOD</button></li>"
               });
               
               $("#replies").html(str);
               
               printPaging(data.pageMaker);
           });
       }
	   
       $(".pagination").on("click", "li a", function(event){
    	  
    	   event.preventDefault();
    	   
    	   replyPage = $(this).attr("href");
    	   
    	   getPageList(replyPage);
    	   
       });
	   // 추가
	   $("#replyAddBtn").on("click", function(){
		  
		   var replyer = $("#newReplyWriter").val();
		   var replytext = $("#newReplyText").val();
		   
		   $.ajax({
			   type : 'post',
			   url : '/replies',
			   headers : {
				   "Content-Type" : "application/json",
				   "X-HTTP-Method-Override" : "POST"
			   },
			   dataType : 'text',
			   data : JSON.stringify({
				   bno : bno,
				   replyer : replyer,
				   replytext : replytext
			   }),
			   success : function(result) {
				   if(result == 'SUCCESS') {
					   alert("등록 되었습니다.");
					   getPageList(replyPage);
				   }
			   }  
		   });   
	   });
	   
	   // 수정 창
	   $("#replies").on("click", ".replyLi button", function() {
		  
		   var reply = $(this).parent();
		   
		   var rno = reply.attr("data-rno");
		   var replytext = reply.text();
		   
		   // alert(rno + " : " + replytext);
		   
		   $(".modal-title").html(rno);
		   $("#replytext").val(replytext);
		   $("#modDiv").show("slow");
		   
	   });
	   
	   // 삭제
	   $("#replyDelBtn").on("click", function() {
		  
		   var rno = $(".modal-title").html();
		   var replytext = $("#replytext").val();
		   
		   $.ajax({
               type : 'delete',
               url : '/replies/' + rno,
               headers : {
                   "Content-Type" : "application/json",
                   "X-HTTP-Method-Override" : "DELETE"
               },
               dataType : 'text',
               success : function(result) {
            	   console.log("result: " + result);
                   if(result == 'SUCCESS') {
                       alert("삭제 되었습니다.");
                       $("#modDiv").hide("slow");
                       getPageList(replyPage);
                   }
               }  
           });
	   });

	   // 수정
	   $("#replyModBtn").on("click", function() {
		  
		   var rno = $(".modal-title").html();
		   var replytext = $("#replytext").val();
		   
		   $.ajax({
               type : 'put',
               url : '/replies/' + rno,
               headers : {
                   "Content-Type" : "application/json",
                   "X-HTTP-Method-Override" : "PUT"
               },
               data:JSON.stringify({replytext:replytext}),
               dataType : 'text',
               success : function(result) {
            	   console.log("result: " + result);
                   if(result == 'SUCCESS') {
                       alert("수정 되었습니다.");
                       $("#modDiv").hide("slow");
                       // getAllList();
                       getPageList(replyPage);
                   }
               }  
           });
	   });
	         
	   
	   
	   // getAllList();
	   getPageList(1);
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<style>
.wrapper{
width:900px;
margin:0 auto;                /*block level 요소를 가운데로 하는 것*/
}
h2{
text-align:center;
}
table{
 width:880px;
}
table,tr,td,th{
   border :1px solid gray;
}
th{
width:400px;
padding:5px;
}
input {
display : inline-block;
width : 700px;
}

</style>
</head>
<body>

<div class="wrapper">


<h2>상세 글 보기</h2>
<form action = "boardwrite" method = "post">
<input type = "hidden" name = "boardseq" value ="${board.boardseq}">
<table>
<tr>
   <th>아이디</th>
   <td>${board.userid}</td>
</tr>
<tr>
   <th>날짜</th>
   <td>
   ${board.regdate}
   </td>
</tr>
<tr>
   <th>제목</th>
   <td>	
   ${board.title}
   </td>
</tr>
<tr>
   <th>첨부파일 </th>
   <td>
   <c:if test="${board.originalfile!=null}">
   <a href ="download?boardseq=${board.boardseq}">
   ${board.originalfile}
   </a>
   </c:if>
   <c:if test="${board.originalfile==null}">
    	첨부된 파일이 없습니다.
   </c:if>
   </td>
</tr>
<tr>
   <th>글내용</th>
   <td><pre>
   ${board.content}
   </pre></td>
</tr>
<tr>
</form>
   <th colspan="2">
   <a href = "${pageContext.request.contextPath}/boardList">목록으로</a>
   
   <c:if test="${sessionScope.loginId!=null}">
	   <c:if test ="${sessionScope.loginId == board.userid}">
	 		<form action = "boardDelete" method = "post">  
	 		<input type = "hidden" name = "boardseq" value ="${board.boardseq}">
	   		<input type = "submit" value ="삭제" style = "width: 70px;">
	   		</form>
	   		<form action = "boardUpdate" method = "get">  
	   		<input type = "hidden" name = "boardseq" value ="${board.boardseq}">
	   		<input type = "submit" value ="수정" style = "width: 70px;">
	   		</form>
	   </c:if>
	 </c:if>
   </th>
</tr>


</table>

</div>



</body>
</html>
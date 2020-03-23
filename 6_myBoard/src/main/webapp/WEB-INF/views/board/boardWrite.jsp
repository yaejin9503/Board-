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

<input type = "hidden" name = "boardseq" value ="${board.boardseq}"/>
<h2>게시판 글쓰기</h2>
<c:if test="${board.boardseq==null}">
	<form action = "boardwrite" method = "post" enctype ="multipart/form-data">
</c:if>

<c:if test="${board.boardseq!=null}">
	<form action = "boardUpdate" method="post" enctype ="multipart/form-data">
	<input type = "hidden" name = "boardseq" value ="${board.boardseq}"/>
</c:if>
<table>
<tr>
   <th>아이디</th>
   <td><input type = "text" value = "${sessionScope.loginId}" disabled ="disabled"/></td>
</tr>
<tr>
   <th>날짜</th>
   <td>
   <input type = "text" value = "<fmt:formatDate value ="${today}" pattern ="yyyy년 MM월 dd일(E)"/>" disabled ="disabled"/>
   </td>
</tr>
<tr>
   <th>제목</th>
   <td>	
   <input type="text" name="title" placeholder="제목입력">
   </td>
</tr>
<tr>
   <th>첨부 파일</th>
   <td>	
   <input type="file" name="upload">
   </td>
</tr>
<tr>
   <th>글내용</th>
   <td><textarea name="content" rows="15" cols="100"></textarea></td>
</tr>
<tr>
   <th colspan="2">
   <button type="submit">글저장</button>
   <button type="button">취소</button>
   </th>
</tr>


</table>
</form>
</div>



</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<!-- 글 등록 화면 -->
<center>
<form action="insertBoard.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="yellow" width="80">제목</td><td align="left">
		<input type="text" name="title"/></td>
	</tr>
	<tr>
		<td bgcolor="yellow">작성자 ID</td><td align="left">
		<input type="hidden" name="writer" value="${user.id}">${user.id}</td>
	</tr>
	<tr>
		<td bgcolor="yellow">내용</td><td align="left">
		<textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="글등록"/></td>
	</tr>
</table>
</form>
</center>

<%@ include file="../layout/footer.jsp" %>

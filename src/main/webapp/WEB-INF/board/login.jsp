<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<!-- 로그인 화면 -->
<center>
<form action="login.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td bgcolor="orange">아이디</td>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td bgcolor="orange">비밀번호</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인"/>
			</td>
		</tr>
	</table>
</form>
</center>

<%@ include file="../layout/footer.jsp" %>

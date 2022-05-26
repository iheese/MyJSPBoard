<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!-- 회원 가입 화면 -->
<center>
	<h1>회원가입</h1>
	
	<form action="insertUser.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="orange">아이디</td>
				<td><input type="text" name="id" size="10" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">비밀번호</td>
				<td><input type="password" name="password" size="12" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">이름</td>
				<td><input type="text" name="name" size="30" /></td>
			</tr>
			<tr>
				<td bgcolor="orange">권한</td>
				<td><input type="radio" name="role" value="USER"
					checked="checked" />일반회원 <input type="radio" name="role"
					value="ADMIN" />관리자</td>
			</tr>
			</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원가입"> <input type="reset" value="입력취소"></td>
			</tr>
		</table>
	</form>
</center>
<%@ include file="../layout/footer.jsp"%>
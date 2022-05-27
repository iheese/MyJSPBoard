<%@page contentType="text/html; charset=UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<!-- 글 상세 조회 페이지 -->
<center>
	<form action="updateBoard.do" method="post">
		<input name="seq" type="hidden" value="${board.seq}" />
		<table border="1" cellpadding="0" cellspacing="5">
			<tr>
				<td bgcolor="yellow" width="70">제목</td>
				<c:if test="${board.writer ==user.id }">
				<td align="left"><input name="title" type="text"
					value="${board.title}" /></td></c:if>
				<c:if test="${board.writer !=user.id }">
				<td align="left">${board.title}</td></c:if>
			</tr>
			<tr>
				<td bgcolor="yellow">작성자 ID</td>
				<td align="left">${board.writer}</td>
			</tr>
			<tr>
				<td bgcolor="yellow">내용</td>
				<c:if test="${board.writer ==user.id }">
				<td align="left"><textarea name="content" cols="40" rows="10">${board.content}</textarea></td></c:if>
				<c:if test="${board.writer !=user.id }">
				<td align="left" height="200" width="300">${board.content}</td></c:if>
			</tr>
			<tr>
				<td bgcolor="yellow">등록일</td>
				<td align="left">${board.regDate}</td>
			</tr>
			<tr>
				<td bgcolor="yellow">조회수</td>
				<td align="left">${board.cnt+1}</td>
			</tr>
				<c:if test="${board.writer ==user.id }">
				<tr>
				<td colspan="2" align="center"><input type="submit"
					value="글 수정" /></td>
				</tr>
				</c:if>
		</table>
	</form>
	<br>
	<!-- 검색 결과 페이지에서 글 목록을 누르면 다시 검색 결과로 돌아가게 했다. -->
	<a href="getBoardList.do?select=${select}&searchContent=${searchContent}">글 목록</a>
	<!-- 관리자만 글 삭제 권한을 가지고 있다. -->
	<c:if test="${user.role=='ADMIN'}">&nbsp
	<a href="deleteBoard.do?seq=${board.seq}">글삭제</a>
	</c:if>

</center>

<%@ include file="../layout/footer.jsp"%>

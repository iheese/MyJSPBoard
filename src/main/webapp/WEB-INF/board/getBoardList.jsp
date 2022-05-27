<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../layout/header.jsp"%>

<center>
	<h1>게시판</h1>
	<form action="getBoardList.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td colspan="5" align="right">
				<select name="select">
				<!-- 기본값은 title이며 검색 후 검색내용을 똑같이 유지시켰다. -->
						<option value="title"
							<c:if test = "${select =='title'}"> selected </c:if>>제목
						
						<option value="content"
							<c:if test = "${select =='content'}"> selected </c:if>>내용
						
				</select> <input type="text" name="searchContent" size='20'
					value="${searchContent}"> <input type='submit' value='검색'>

				</td>
			</tr>
			</table>
			</form>
			
			<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="yellow" width="100">번호</th>
				<th bgcolor="yellow" width="200">제목</th>
				<th bgcolor="yellow" width="150">작성자 ID</th>
				<th bgcolor="yellow" width="150">등록일</th>
				<th bgcolor="yellow" width="100">조회수</th>
			</tr>

			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.seq}</td>
					<td align="left"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
</center>

<%@ include file="../layout/footer.jsp"%>
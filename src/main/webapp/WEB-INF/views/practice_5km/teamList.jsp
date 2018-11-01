<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>プロ野球<br>セントラル・リーグ一覧
			</th>
		</tr>
	</table>

	<ul>
		<c:forEach var="league" items="${leagues}">
			<li><a
				href="${pageContext.request.contextPath}/baseballLeague/load?id=<c:out value="${league.id}" />">
					<c:out value="${league.teamName}" />
			</a></li>
		</c:forEach>
	</ul>

</body>
</html>
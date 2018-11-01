<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>球団名</h1>
	<c:out value="${league.teamName}"></c:out>
	<h1>本拠地</h1>
	<c:out value="${league.headQuarters}"></c:out>
	<h1>発足</h1>
	<c:out value="${league.inauguration}"></c:out>
	<h1>歴史</h1>
	<pre>
		<c:out value="${league.history}"></c:out>
	</pre>
	<form
		action="${pageContext.request.contextPath}/baseballLeague/practice_5km/teamList"
		method="post">
		<input type="submit" value="戻る">
		<%-- 	<a href="${pageContext.request.contextPath}/baseballLeague/teamList">戻る</a> --%>
	</form>
</body>
</html>
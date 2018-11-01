<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>洋服shop</th>
		</tr>
	</table>

	<h3>好きな色を選択してください</h3>
	
	<form:form modelAttribute="shopForm" action="${pageContext.request.contextPath}/shop/search">
	
		<form:radiobutton path="gender" value="0" />Man <br>
		<form:radiobutton path="gender" value="1" />Woman 
	
		<%-- <form:checkboxes path="color" items="${colorMap}" delimiter="<br>"/> --%> 
		
		 <form:select path="color">
		  <form:options items="${colorMap}" />
		 </form:select>
		 
		 
		 <input type="submit" value="検索">
		<%-- <form:select path="color">
			
			<form:option value="1"></form:option>
		</form:select>
	 --%> 
	
	
	</form:form>
	<c:forEach var="shop" items="${shops}">
	<table border="1">
	
		<tr>
			<th>ジャンル</th>
			<td><c:out value="${shop.genre}"/></td>
		</tr>
		<tr>
			<th>サイズ</th>
			<td><c:out value="${shop.size}"/></td>
		</tr>
		<tr>
			<th>価格</th>
			<td><fmt:formatNumber value="${shop.price}" pattern="###,###"/>yen</td>
		</tr>
	
	</table>
	</c:forEach>
	<%-- <form action="${pageContext.request.contextPath}/shop/search" method="post">
		<input type="radio" name="gender">Man<br>
		<input type="radio" name="gender">Woman 
		
		<select name="color">
			<c:forEach var="shop" items="${shops}">
				<option value="1"><c:out value="${shop.color}" /></option>
			</c:forEach>
		</select> 
		
		<input type="submit" value="検索">
		
	</form>
 --%>


</body>
</html>
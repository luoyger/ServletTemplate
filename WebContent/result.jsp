<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
	User:  ${username}
	<br> Result:  ${result}
	<br>
	<br> TotalCount:  ${adminList.size()}
	<br>
	<br> AdminList:
	<br>
	<c:forEach var="admin" items="${adminList}" varStatus="status">
		${status.index}.  ${admin.username}<br>
	</c:forEach>
</body>
</html>
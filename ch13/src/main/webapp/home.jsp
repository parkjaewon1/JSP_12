<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty img }">
	<c:set var="img" value="images/ioi.jpg"></c:set>
</c:if>
<img alt="" src="${img }">
</body>
</html>
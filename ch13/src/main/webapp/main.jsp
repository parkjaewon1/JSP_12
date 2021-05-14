<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">@import url("common.css");</style>
</head><body>
<c:if test="${empty param.pgm }">
	<c:set var="pgm" value="home.jsp"></c:set>
</c:if>
<c:if test="${not empty param.pgm }">
	<c:set var="pgm" value="${param.pgm }"></c:set>
</c:if>
<table>
	<tr><th><jsp:include page="menu.jsp"></jsp:include></th></tr>
	<tr><td><jsp:include page="${pgm }"></jsp:include></td></tr>
</table>
</body>
</html>
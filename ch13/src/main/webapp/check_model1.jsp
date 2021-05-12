<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ch13.service.*"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">@import url("common.css");</style>
</head><body>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	IdCheck ic = new IdCheck();
	int result = ic.idChk(id, password);
	if (result > 0) {
%>
	<h2>메뉴</h2>
	1. 환경보호<p> 2. 세계평화<p> 3.국가 발전
<%  } else { %>
	<h2>로그인 실패</h2>
	아이디나 암호가 다릅니다
	<a href="login_model1.jsp">다시 시도</a>
<%  } %>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="myung.utility.helper.CookieBox"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	if (id.equals(password)) {
		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS",
				"/", -1));
		response.addCookie(CookieBox.createCookie("ID", id, "/", -1));
	}
%>

<html>
<head>
<title>로그인성공</title>
</head>
<body>
로그인에 성공했습니다.
</body>
</html>
<%
	} else {<%= 
	%>
	}
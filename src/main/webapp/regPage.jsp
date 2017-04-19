<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="RegAction_doReg" namespace="/" method="post">
		E-mail:<s:textfield name="email"></s:textfield><s:fielderror><s:param>email</s:param></s:fielderror>
		<br>
		密码：<s:password name="password"></s:password><s:fielderror><s:param>password</s:param></s:fielderror>
		<br>
		确认密码：<s:password name="confirmPassword"></s:password>
		<br>
		昵称：<s:textfield name="nickName"></s:textfield><s:fielderror><s:param>nickName</s:param></s:fielderror>
	<s:submit value="注册"></s:submit>
	</s:form>
</body>
</html>
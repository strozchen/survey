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

<s:form action="LoginAction_doLogin" namespace="/" method="post">
	用户名：<input type="text" name="email" value="zhangsan@stroz.com">
	密码：<input type="password" name="password" class="text" value="111111">
	<s:actionerror/>
	<s:submit value="login"></s:submit>
</s:form>
</body>
</html>
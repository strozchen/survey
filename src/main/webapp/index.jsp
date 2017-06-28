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
	<s:include value="header.jsp" />
	<s:if test="#session.user">
	欢迎：<s:property value="#session.user.email" />
		<hr>
	</s:if>
	<a href="RegAction_toRegPage">注册</a>
	<a href="LoginAction_toLoginPage">登陆</a>
	<s:a href="SurveyAction_mySurveys">我的调查</s:a>
	<s:a href="SurveyAction_newSurvey">新建调查</s:a>
</body>
</html>
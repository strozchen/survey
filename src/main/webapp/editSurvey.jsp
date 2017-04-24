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
<s:form action="SurveyAction_updataSurvey">
	<s:hidden name="id"></s:hidden>
	调查标题：<s:textfield name="title"></s:textfield>
	<br>
	“上一步”提示：<s:textfield name="preText"></s:textfield>
	<br>
	“下一步”提示：<s:textfield name="nextText"></s:textfield>
	<br>
	“退出”提示：<s:textfield name="endText"></s:textfield>
	<br>
	<s:submit label="确定" value="确定 "></s:submit>
</s:form>
</body>
</html>
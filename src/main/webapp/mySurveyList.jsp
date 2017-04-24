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
	<s:if test="mySurveys.isEmpty()==true">no surveys</s:if>
	<s:else>
		<table>
			<tr>
				<td colspan="10" style="height: 5px"></td>
			</tr>
			<tr>
				<td colspan="10" class="tdHeader">我的调查</td>
			</tr>	
			<tr>
				<td colspan="10" style="height: 5px"></td>
			</tr>	
			<tr>
				<td class="tdHeader">ID</td>
				<td class="tdHeader">调查标题</td>
				<td class="tdHeader">创建时间</td>
				<td class="tdHeader">状态</td>
				<td class="tdHeader">设计</td>
				<td class="tdHeader">收集信息</td>
				<td class="tdHeader">分析</td>
				<td class="tdHeader">打开/关闭</td>
				<td class="tdHeader">清除调查</td>
				<td class="tdHeader">删除</td>
			</tr>	
			<s:iterator value="mySurveys">
			<s:set var="sId" value="id"/>
				<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="title"/></td>
				<td><s:date name="createTime" format="yyyy-MM-dd HH-mm"/></td>
				<td><s:a action="SurveyAction_designSurvey?sid=%{#sId}" namespace="/" cssClass="aList">设计</s:a></td>
				<td><s:a action="" namespace="/" cssClass="aList">收集信息</s:a></td>
				<td><s:a action="" namespace="/" cssClass="aList">分析</s:a></td>
				<td><s:a action="" namespace="/" cssClass="aList">打开/关闭</s:a></td>
				<td><s:a action="" namespace="/" cssClass="aList">清除调查</s:a></td>
				<td><s:a action="" namespace="/" cssClass="aList">删除</s:a></td>
				</tr>
			</s:iterator>		
		</table>
	</s:else>
</body>
</html>
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
	this is designSurveyPage.jsp
	<br>
	<s:set var="sId" value="id"></s:set>
	<s:a href="SurveyAction_editSurveyPage?sid=%{#sId}">edit survey</s:a>
	<hr>
	<!-- 调查标题 -->
	<s:property value="title" />
	<!-- 迭代页面 -->
	<s:iterator value="pages" var="p">
		<!-- 页面标题 -->
		<s:property value="#p.title" />
		<!-- 迭代问题 -->
		<s:iterator value="#p.questions" var="q">
			<!-- 问题页标题 -->
			<s:property value="#q.title" />
			<!-- 根据 questionType配置选项-->
			<s:set var="qt" value="#q.questionType"></s:set>

			<s:if test="#qt<4">
				<s:iterator value="#q.optionArr">
					<input type="<s:property value="#qt"/><2?'radio:'checkbox'">
					<s:property />
					<!-- 是否携带BR -->
					<s:if test="#qt==1||#qt==3">
						<br>
					</s:if>
				</s:iterator>
				<!-- 是否存在其他 -->
				<s:if test="#q.other">
					<input type="<s:property value="#qt"/><2?'radio:'checkbox'">其它
					<!-- 其他为输入框 -->
					<s:if test="q.otherStyle==1">
						<input type="text">
					</s:if>
					<!-- 其他为下拉框 -->
					<s:if test="q.otherStyle==2">
						<select>
							<!-- 迭代下拉框内容 -->
							<s:iterator value="#q.otherSelectOptionArr">
								<option><s:property /></option>
							</s:iterator>
						</select>
					</s:if>
				</s:if>
			</s:if>
			<s:elseif test="#qt==4||#qt==5">
				<s:if test="#qt==4">
					<select>
						<!-- 迭代下拉框内容 -->
						<s:iterator value="#q.optionArr">
							<option><s:property /></option>
						</s:iterator>
					</select>
				</s:if>
				<s:elseif test="#qt==5">
					<input type="text">
				</s:elseif>
			</s:elseif>
			<s:elseif test="#qt>5">
				<table>
					<!-- 表头 -->
					<tr>
						<td></td>
						<s:iterator value="q.matrixColTitleArr">
							<td><s:property /></td>
						</s:iterator>
					</tr>
					<!-- 输出N行 -->
					<s:iterator value="q.matrixRowTitle">
						<td><s:property /></td>
						<s:iterator value="q.matrixColTitleArr">
							<td><s:if test="#qt==6">
									<input type="radio">
								</s:if> <s:elseif test="#qt==7">
									<input type="checkbox">
								</s:elseif> 
								<s:elseif test="#qt==8">
									<select>
										<s:iterator value="#q.matrixSelectTitleArr">
											<option><s:property /></option>
										</s:iterator>
									</select>
								</s:elseif></td>
						</s:iterator>
					</s:iterator>
				</table>
			</s:elseif>

		</s:iterator>


	</s:iterator>
</body>
</html>
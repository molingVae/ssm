<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
用户：${sessionScope.username } 
<c:if test="${sessionScope.username!=null }">
<a href="logout.action">退出</a>
</c:if>
	<form action="findUsers.action" method="post">
		<input type="text" name="username"> <input type="submit"
			value="查询">
	</form>

	<table width="100%" border=1>
		<tr>
			<td>User名称</td>
			<td>User性别</td>
			<td>User生日</td>
			<td>User地址</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.username }</td>
				<td>${user.sex}</td>
				<td><fmt:formatDate value="${user.birthday }" pattern="yyyy年MM月dd日"/></td>
				<td>${user.address}</td>
				<td><a href="queryUser.action?id=${user.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

</head>
<body>
用户：${sessionScope.username }
<c:if test="${sessionScope.username!=null }">
    <a href="logout.action">退出</a>
</c:if>
<div id="find">
    <input type="text" v-model="username">
    <button @click="find(username)">查询</button>
    <table class="table table-hover">
        <tr v-if="flag">
            <th>User名称</th>
            <th>User性别</th>
            <th>User生日</th>
            <th>User地址</th>
            <th>操作</th>
        </tr>

        <tr v-for="user in users">
            <td>{{user.username}}</td>
            <td>{{user.sex}}</td>
            <td>{{user.birthday}}</td>
            <td>{{user.address}}</td>
            <td><a href="queryUser.action?id=${user.id}">修改</a>
            </td>
        </tr>

    </table>
</div>
<script type="text/javascript" src="js/vue.min.js"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
    new Vue({
        el: '#find',
        data: {
            users: '',
            username: '',
            flag:false
        },
        methods: {
            find: function (username) {
                const self = this;
                const url = "${pageContext.request.contextPath}/reqUsers.action";
                $.ajax({
                    url: url,
                    data: username,
                    type: "post",
                    dataType: "json",
                    contentType: "application/json;charset=utf-8",
                    success: function (results) {
                        self.flag=true;
                        self.users=results;
                    },
                    error: function () {
                        alert("请求失败");
                    }
                });
            }
        }
    })
</script>
</body>
</html>



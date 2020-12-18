<%--
  Created by IntelliJ IDEA.
  User: shuzheng
  Date: 12/16/20
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<script src="scripts/jquery-3.5.1.min.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<!-- 全路径保险 -->
    <form action="${ctp}/test" method="post">
        <input name="id" value="1" /> <br />
        <input name="name" value="zhangsan" /><br />
        <input name="gender" value="male" /><br />
        <input name="age" value="1" /><br />
        <input name="file" type="file" /><br>
        <input type="submit" value="提交">
    </form>
    <hr>
    <a href="${ctp}/testRequestBody">发送JSON数据</a>
</body>
<script>
    $("a:first").click(function(){
        var user = {
            id: "1",
            name: "zhangsan",
            gender: "male",
            age: 3
        };
        var jsonuser = JSON.stringify(user);$.ajax({
            url: "${ctp}/testRequestJson",
            type: "post",
            data: jsonuser,
            contentType: "application/json",
            success: function(data){
                alert(data)
            }
        })
        return false;
    });
</script>
</html>

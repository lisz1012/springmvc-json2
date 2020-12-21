<%--
  Created by IntelliJ IDEA.
  User: shuzheng
  Date: 12/16/20
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  pageContext.setAttribute("ctp", request.getContextPath());
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="${ctp}/i18n">国际化页面</a><br />
    <a href="${ctp}/exception1">触发异常</a><br />
    <a href="${ctp}/exception2">触发异常2</a><br />
  </body>
</html>

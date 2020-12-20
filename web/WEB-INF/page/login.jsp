<%--
  Created by IntelliJ IDEA.
  User: shuzheng
  Date: 12/19/20
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<head>
    <title>Title</title>
</head>
<body>
<h1><fmt:message key="welcomeinfo"></fmt:message></h1>
    <form action="${ctp}/login" method="post">
        <fmt:message key="username"></fmt:message><input type="text" name="username" /><br />
        <fmt:message key="password"></fmt:message><input type="password" name="password" /><br />
        <input type="submit" valeu="<fmt:message key="btn"/>" />
    </form>
    <a href="${ctp}/i18n?locale=zh_CN">中文</a>
    <a href="${ctp}/i18n?locale=en_US">English</a>
</body>
</html>
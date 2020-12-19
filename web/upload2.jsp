<%--
  Created by IntelliJ IDEA.
  User: shuzheng
  Date: 12/18/20
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<body>
    <form method="POST" enctype="multipart/form-data" action="${ctp}/uploadMultipleFiles">
        File to upload: <input type="file" name="file"><br/>
        File to upload: <input type="file" name="file"><br/>
        File to upload: <input type="file" name="file"><br/>
        Notes about the file: <input type="text" name="note"><br/>
        <br/>
        <input type="submit" value="Upload"> to upload the file!
    </form>
</body>
</html>

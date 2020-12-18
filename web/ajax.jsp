<%--
  Created by IntelliJ IDEA.
  User: shuzheng
  Date: 12/16/20
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="scripts/jquery-3.5.1.min.js"></script>
  <head>
    <title>$Title$</title>
  </head>
  <%
    pageContext.setAttribute("ctp", request.getContextPath());
  %>
  <body>
    <a href="${ctp}/json">
      获取用户信息
    </a>
    <div>

    </div>
  </body>
  <script type="text/javascript">
    $("a:first").click(function(){
      $.ajax({
        url:"${ctp}/json",
        type:"GET",
        success:function (data) {
          $.each(data, function(){
            var user = this.id + "--" + this.name + "--" + this.gender + "--" + this.age;
            $("div").append(user+"<br/>");
          })
        }
      });
      return false;
    });
  </script>
</html>

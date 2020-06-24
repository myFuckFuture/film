<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/20
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title>$Title$</title>
    <!--引入bootstrap样式-->
    <link rel="stylesheet" href="${ctx}/js/bootstrap/css/bootstrap.min.css">
    <!--引入JQuery  -->
    <script type="text/javascript" src="${ctx}/js/jq/jquery-3.1.1.min.js"></script>
    <!--引入bootstrap-->
    <script type="text/javascript" src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>

    <style>
      * {
        /*margin:0 auto;*/
      }
      form{
        margin: 100px auto;
        width:500px;
      }

    </style>
  </head>
  <body>
  <!--修改了文件-->
  <!--又修改了文件-->
     <form action="${ctx}/login">
           <div class="form-group">
              <label for="username" >用户名</label>
              <input type="text"  class="form-control" id="username" name="username">
           </div>
           <div class="form-group">
             <label for="password" >密码</label>
             <input type="password" class="form-control" id="password" name="password">
           </div>
           <button type ="submit" class="btn btn-default">登陆</button>
     </form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/20
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>查询电影</title>
    <!--引入bootstrap css样式表-->
    <link rel="stylesheet"  href="${ctx}/js/bootstrap/css/bootstrap.min.css"/>
    <!--引入Jquery -->
    <script type="text/javascript" src="${ctx}/js/jq/jquery-3.1.1.min.js"></script>
    <!--引入bootstrap-->
    <script type="text/javascript" src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>

    <style>
        form {
            margin: 100px auto;
            width: 500px;
        }
        .numberInput{
            width:196px;
            display:inline;
        }
    </style>
</head>
<body>
<form class="form-horizontal" action="${ctx}/findFilmInfoList" method="post">
    <div class="form-group">
        <label for="filmName" class="col-sm-2">电影名</label>
        <div class="col-sm-10">
        <input type="text" id="filmName" name="filmName" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label for="typeId" class="col-sm-2">电影类型</label>
        <div class="col-sm-10">
        <select id="typeId" name="typeId" class="form-control">
            <option value="0" selected="selected">全部</option>
            <c:forEach var="filmType" items="${filmTypeList}">
                <option value="${filmType.typeid}">
                        ${filmType.typename}
                </option>
            </c:forEach>
        </select>
        </div>
    </div>

    <div class="form-group" >
        <label for="actor" class="col-sm-2">主演</label>
        <div class="col-sm-10">
        <input type="text" id="actor" name="actor" class="form-control"/>
        </div>
    </div>

    <div class="form-group" >
        <label for="director" class="col-sm-2" >导演</label>
        <div class="col-sm-10">
        <input type="text" id="director" name="director" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label  class="col-sm-2">价格</label>
        <div class="col-sm-10">
        <input type="text" name="smallPrice" class="form-control numberInput" />至
        <input type="text" name="bigPrice" class="form-control numberInput"/>
        </div>
    </div>

    <div>
        <button class="btn btn-danger" class="form-group" type="submit">提交查询</button>
        <button type="button" class="btn btn-success" onclick="javascript:location='${ctx}/addFilmInfo'">发布电影</button>
    </div>

</form>


</body>
</html>

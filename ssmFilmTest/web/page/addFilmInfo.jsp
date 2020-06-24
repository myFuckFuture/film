<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/21
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>添加电影</title>
    <!--引入css样式表-->
    <link rel="stylesheet" href="${ctx}/js/bootstrap/css/bootstrap.min.css"/>
    <!--引入JQuery-->
    <script type="text/javascript" src="${ctx}/js/jq/jquery-3.1.1.min.js"> </script>

    <style>

     form{
         width: 500px;
         margin: 100px auto;
     }
    </style>
</head>
<body>
    <form class="form-horizontal" action="${ctx}/saveFilmInfo" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="filmName" class="col-sm-2">电影名</label>
            <div class="col-sm-10">
                <input type="text" id="filmName" name="filmname" onblur="checkName(this)" class="form-control"/>
                <span id="msg" style="color:red"></span>
            </div>
        </div>
        <div class="form-group">
            <label for="typeId" class="col-sm-2">电影类型</label>
            <div class="col-sm-10">
                <select id="typeId" name="typeid" class="form-control">
                    <c:forEach var="filmType" items="${filmTypeList}">
                        <option value="${filmType.typeid}">${filmType.typename}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="actor" class="col-sm-2">主演</label>
            <div class="col-sm-10">
                <input type="text" id ="actor" name="actor" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="director" class="col-sm-2">导演</label>
            <div class="col-sm-10">
                <input type="text" id ="director" name="director" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="ticketprice" class="col-sm-2">价格</label>
            <div class="col-sm-10">
                <input type="text" id ="ticketprice" name="ticketprice" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label for="picName" class="col-sm-2">图片</label>
            <div class="col-sm-10">
                <input type="file" id="picName" name-="picName" class="form-control"/>
            </div>
        </div>

        <button class="btn btn-success" type="submit" >发布电影</button>
        <button class="btn btn-danger"  type="button" onclick="javascript:location='${ctx}/findFilmTypeList'">返回首页</button>
    </form>
</body>
<script>
    function checkName(obj){
        //  1.查电影名
        $.ajax({
            url:"${ctx}/checkFilmName?filmName="+obj.value,
            method:"post",
            success:function(msg){
                if(msg=="true"){
                    $("#msg").html("电影名已被占用");
                }else{
                    $("#msg").html("");
                }
            }
        });
    }
</script>
</html>

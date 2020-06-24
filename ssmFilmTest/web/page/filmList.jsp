<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/21
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>电影列表页面</title>

    <!--引入BootStrap样式表-->
    <link rel="stylesheet" href="${ctx}/js/bootstrap/css/bootstrap.min.css"/>
    <!--引入JQuery-->
    <script type="text/javascript" src="${ctx}/js/jq/jquery-3.1.1.min.js"></script>
    <!--引入BootStrap-->
    <script type="text/javascript" src="${ctx}/js/bootstrap/js/bootstrap.min.js"></script>
    <style>
        #table_div{
            width: 800px;
            margin:100px auto;
        }
    </style>
    <script>
        function findFilmList(pageNum){
            if(pageNum<1){
                pageNum=1;
            }
            if(pageNum>${pageInfo.pages}){
                pageNum=${pageInfo.pages};
            }
            document.getElementById("pageNum").value=pageNum;
            document.getElementById("findFilmInfoList").submit();
        }
    </script>
</head>
<body>
   <div id="table_div">
   <table class="table table-bordered">
       <tr class="success">
           <th>电影名称</th>
           <th>类型</th>
           <th>主演</th>
           <th>导演</th>
           <th>票价</th>
           <th>详情</th>
       </tr>
       <c:choose>
           <c:when test="${empty requestScope.filmInfoList}">对不起找不到电影</c:when>
           <c:when test="${!empty requestScope.filmInfoList}">
               <c:forEach var="filmInfo" items="${filmInfoList}">
                    <tr>
                        <td>${filmInfo.filmname}</td>
                        <td>${filmInfo.filmType.typename}</td>
                        <td>${filmInfo.actor}</td>
                        <td>${filmInfo.director}</td>
                        <td>${filmInfo.ticketprice}</td>
                        <td>详情</td>
                    </tr>
               </c:forEach>
           </c:when>
       </c:choose>

   </table>

       <form action="${ctx}/findFilmInfoList" id="findFilmInfoList" method="post">
           <!--添加隐藏域-->
           总记录数：${pageInfo.total}&nbsp;&nbsp;&nbsp;&nbsp;当前&nbsp;&nbsp;${pageInfo.pageNum}/总页码&nbsp;&nbsp;${pageInfo.pages}
           <input type="hidden" name="typeId" value="${query.typeId}"/>
           <input type="hidden" name="pageNum" id="pageNum" value="${query.pageNum}"/>
           <input type="hidden"  name="filmName" value="${query.filmName}"/>
           <input type="hidden"  name="actor" value="${query.actor}"/>
           <input type="hidden"  name="director" value="${query.director}"/>
           <input type="hidden"  name="smallPrice" value="${query.smallPrice}"/>
           <input type="hidden"  name="bigPrice" value="${query.bigPrice}"/>

           <c:choose>
               <c:when test="${pageInfo.pageNum==1}">
                   <button class="btn" disabled="disabled" >首页</button>
                   <button class="btn" disabled="disabled" >上一页</button>
                   <button class="btn btn-success" onclick="findFilmList(${pageInfo.nextPage})">下一页</button>
                   <button class="btn btn-danger" onclick="findFilmList(${pageInfo.pages}">尾页</button>
               </c:when>
               <c:when test="${pageInfo.pageNum==pageInfo.pages}">
                   <button class="btn btn-danger" onclick="findFilmList(1)">首页</button>
                   <button class="btn btn-success" onclick="findFilmList(${pageInfo.prePage})">上一页</button>
                   <button class="btn " disabled="disabled">下一页</button>
                   <button class="btn" disabled="disabled">尾页</button>
               </c:when>
               <c:otherwise>
                   <button class="btn btn-danger" onclick="findFilmList(1)">首页</button>
                   <button class="btn btn-success" onclick="findFilmList(${pageInfo.prePage})">上一页</button>
                   <button class="btn btn-success" onclick="findFilmList(${pageInfo.nextPage})">下一页</button>
                   <button class="btn btn-danger" onclick="findFilmList(${pageInfo.pages}">尾页</button>
               </c:otherwise>
           </c:choose>
       </form>
       <a href="${ctx}/findFilmTypeList" >返回首页</a>
   </div>
</body>
</html>

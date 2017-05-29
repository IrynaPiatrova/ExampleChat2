<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Irina Petrova
  Date: 23.05.2017
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <%@include file="head.jsp" %>
</head>
<body>
<div>
    <table id="buttons" class="table table-hover">
        <tr>
            <th>
                <button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#myModal">Создать
                    чат
                </button>
            </th>
            <th><p>${fullname}</p></th>
            <th><input type="submit" class="btn btn-danger" onclick="location.pathname = '/index.jsp'"
                       name="goToFirstPage"
                       value="Выйти"></th>
        </tr>
    </table>
    <div class="tableFilms" align="center">
        <c:if test="${!chaters.isEmpty()}">
            <table id="films" class="table table-bordered">
                <tr>
                    <th>НАЗВАНИЕ</th>
                </tr>
                <c:forEach var="chater" items="${chaters} ">
                    <c:if test="${chaters.size()== 1}">
                        <c:set var="chater" value="${fn:substring(chater, 1, chaters.toString().length() - 1)}"/>
                    </c:if>
                    <tr>
                        <th>
                            <button type="button" class="btn btn-primary btn-block"'">
                                <c:out value="${chater}"/>
                                <a href="chat?nameChat=${chater}">-----></a>
                            </button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <div id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" type="button" data-dismiss="modal">×</button>
                    <h4 class="modal-title">Добавление новой беседы </h4>
                </div>

                <div class="modal-body">
                    <form action="addChat" method="post">
                        <input type="text" name="nameChat" value="Название"
                               onBlur="if(this.value=='')this.value='Название'"
                               onFocus="if(this.value=='Название')this.value='' ">
                        <th><input type="submit" class="btn btn-primary" name="addChat" value="Создать"></th>
                        <input type="hidden" name="name" value="${fullname}">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Irina Petrova
  Date: 28.05.2017
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <script src="addChat.js"></script>
</head>
<body>
<div class="container" align="center">
    <div class="row">
        <div class="col-md-5">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-comment"></span> ${namechat}
                </div>
                <div id="panelBody" class="panel-body">
                    <div id="panelMessage">

                    </div>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <form id="msgForm" name="msgForm">
                            <input id="btn-input" name="message" type="text" class="form-control input-sm"
                                   placeholder="Type your message here..."/>
                        <span class="input-group-btn">
                                <button class="btn btn-warning btn-sm" id="btn-chat">Send</button>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

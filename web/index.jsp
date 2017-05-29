<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="icon" href="images/korovka.png" type="image/x-icon">
    <link rel="shortcut icon" href="images/korovka.png" type="image/x-icon">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <title>Главная</title>
</head>
<body>
<div id="login-form">
    <h1>АВТОРИЗАЦИЯ</h1>
    <fieldset>
        <form action="Authentication" method="post">
            <input type="text"  name="username" value="Name" onBlur="if(this.value=='')this.value='Name'" onFocus="if(this.value=='Name')this.value='' ">
            <input type="text"  name="lastname" value="Last Name" onBlur="if(this.value=='')this.value='Last Name'" onFocus="if(this.value=='Last Name')this.value='' ">
            <input type="submit" value="ВОЙТИ">
        </form>
    </fieldset>
</div>
</body>
</html>

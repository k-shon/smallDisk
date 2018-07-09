<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html >
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>校园网盘登录</title>

    <link rel="stylesheet" type="text/css" href="style/bootstrap/css/bootstrap.min.css">
    <link type="text/css" href="style/css/login.css" rel="stylesheet">

</head>
<body>
  
<div style="height:1px;"></div>
<div class="login">
 <header>
	<h1>登陆</h1>
 </header>
 <div class="sr">
	<form action="user_login" method="post">
	    <div style="color:red;">
		     <s:actionerror/>
		</div>
		<div class="name">
			<label>
			<i class="sublist-icon glyphicon glyphicon-user"></i>
			</label>
			<input type="text" name="username" placeholder="这里输入登录名" class="name_inp">
		</div>
		 <div class="name">
			<label>
			<i class="sublist-icon glyphicon glyphicon-pencil"></i>
			</label>
			<input type="text" name="password" placeholder="这里输入登录密码" class="name_inp">
		</div>
		<button class="dl">登陆</button>
	</form>
 </div>
</div>

</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>校园网盘个人信息</title>

    <link rel="stylesheet" type="text/css" href="style/bootstrap/css/bootstrap.min.css">
    <link type="text/css" href="style/css/login.css" rel="stylesheet">

</head>
<body>
  
<div style="height:1px;"></div>
<div class="login">
 <header>
	<h1>个人信息</h1>
 </header>
 <div class="sr">
	<form action="person_modify" method="post">
		真实姓名:<input type="text" name="name">
		邮件:<input type="text" name="email">
		手机号码:<input type="text" name="phone">
		简介:<input type="text" name="introduction">
		<input type="submit" value="修改"/>
	</form>
 </div>
</div>

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园网盘</title>
    <link rel="stylesheet" type="text/css" href="style/bootstrap/css/bootstrap.min.css">
    <link type="text/css" href="style/css/index.css" rel="stylesheet">
	<script type="text/javascript" src="style/bootstrap/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="style/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="style/js/index.js"></script>
</head>
<body>
    <div class="col nav mynav">
        <div class="col-md-2 logo"><img src="style/images/logo.png" class="img-rounded"/>校园网盘</div>
        <div class="col-md-7 menu1">
           <ul class="navbar-left">
              <li>网盘</li>
              <li>分享</li>
              <li>更多</li>
           </ul>
        </div>
        <div class="col-md-3 menu2">
           <ul>
              <li><a href="${pageContext.request.contextPath}/person_edit.action"><s:property value="#session.person.name"/></a></li>
              <li><a href="${pageContext.request.contextPath}/user_exit.action">退出</a></li>
           </ul>
        </div>
    </div>
	<div class="col">
	    <div class="col-md-2 leftLayout">
	        <ul class="">
	           <li><span class="glyphicon glyphicon-duplicate"></span><a>全部文件</a></li>
               <li><a>图片</a></li>
               <li><a>文档</a></li>
               <li><a>视频</a></li>
               <li><a>音乐</a></li>
               <li><a>其他</a></li>
	           <li><span class="glyphicon glyphicon-share"></span><a>我的分享</a></li>
	           <li><span class="glyphicon glyphicon-trash"></span><a>回收站</a></li>
	        </ul>
	    </div>
	    <div class="col-md-10 rightLayout">
               <div class="right-top">
                  <ul>
                     <li style="margin-left:15px;"><button class="btn btn-primary navbar-btn" onclick="selectFile()">
                         <span class="glyphicon glyphicon-open"></span>上传</button></li>
                     <li><button class="btn btn-default navbar-btn" onClick="newFile()">
                          <span class="glyphicon glyphicon-folder-open"></span>新建文件夹</button></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                     <li>
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                               <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">查找</button>
                        </form>
                     </li>
                     <li><button class="btn btn-default navbar-btn glyphicon glyphicon-sort"></button></li>
                     <li style="margin-right:15px;"><button class="btn btn-default navbar-btn glyphicon glyphicon-th-large"></button></li>
                  </ul>
               </div>
               <div style="clear:both;"></div>
               <div class="right-midding">
                   <span class="return" style="display:none"><a>返回上一级 | </a></span>
                   <span class="all"><a href="${pageContext.request.contextPath}/all_directory">全部文件</a></span>
               </div>
               <div class="right-content">
                   <div class="content-header">
                       <ul class="col">
                           <li class="col-md-6">文件名</li>
                           <li class="col-md-3">大小</li>
                           <li class="col-md-3">修改日期</li>
                        </ul>
                   </div>
                   <div style="clear:both;"></div>
                   <div class="content-body">
                      <ul class="directory_list">
                          <s:include value="directory.jsp"></s:include>
                       </ul>
                   </div>
               </div>
        </div>
	</div>
	<form id="uploadForm" action="upload_upload" method="post" enctype="multipart/form-data" style="display:none">
	    <input type="file" id="file" name="uploadFile" onchange="uploadFile()">
	</form>
</body>
</html>
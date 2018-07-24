<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校园网盘</title>
    <link rel="stylesheet" type="text/css" href="style/bootstrap/css/bootstrap.min.css">
    <link type="text/css" href="style/css/directory.css" rel="stylesheet">
	<script type="text/javascript" src="style/bootstrap/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="style/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
        
            <s:iterator value="#session.directoryList" var="directory">
                  <li class="col" onmouseover="showIcon(this)" onMouseOut="hideIcon(this)">
                       <div class="col-md-6">
                            <img src="style/images/folder.png"/>
                            <input type="text" hidden="true" onBlur="getFilename(this)" style="width:130px;height:18px;"/>
                            <a id="<s:property value="#directory.directory_id"/>" onClick="joinDrectory(this)"><s:property value="#directory.name"/></a>
                            <span class="icon">
                                <img src="style/images/share.png" class="pull-right"/>
                                <img src="style/images/upload.png" class="pull-right"/>
                                <img src="style/images/rename.png" class="pull-right" onClick="rename(this)"/>
                             </span>
                        </div>
                        <div class="col-md-3">-</div>
                        <div class="col-md-3"><s:property value="#directory.createname"/></div>
                     </li>
              </s:iterator>                   
</body>
 <script>
   
 </script>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>        
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin</title>
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />    
    <link rel="stylesheet" href="./styles/casvid.css" />
    <script language="javascript" src="./scripts/jquery.js"></script>
    <script language="javascript" src="./scripts/jquery-validate.js"></script>

</head>
<body>
    <div id="main">
        <div id="header">
            <table border="0"><tr><td><img src="./images/cloud2.png"  width="80" height="60"/></td><td><label style="color:#F06000;font-weight:bolder;font-size:36px;margin:5px">SLA Manager</label></td></tr></table>
      <ul id="top-navigation">
                <li><a href="CustomerController?action=listcustomer"  <c:if test="${strLink=='customer'}">class="active"</c:if>>Customers</a></li>
                <li><a href="UserController?action=listuser" <c:if test="${strLink=='user'}">class="active"</c:if>>Users</a></li>
                <li><a href="ConfigController?action=listconfig" <c:if test="${strLink=='config'}">class="active"</c:if>>Configurations</a></li>
                <li><a href="ApplicationController?action=listapplication" <c:if test="${strLink=='app'}">class="active"</c:if>>Applications</a></li>
                <li><a href="SlaParamController?action=listslaparam" <c:if test="${strLink=='slaparam'}">class="active"</c:if>>SLA Parameters</a></li>               
            </ul>
        </div>
  <div id="middle">
            <div id="left-column">
            <h3><c:out value="${userData.userName}"/></h3>
                <ul class="nav">
                    <li><a href="UserController?action=edit&userId=<c:out value="${userData.userId}"/>">My Profile</a></li>
                    <li><a href="UserController?action=logout">Logout</a></li>                    
                </ul>
            </div>
            <div id="center-column">





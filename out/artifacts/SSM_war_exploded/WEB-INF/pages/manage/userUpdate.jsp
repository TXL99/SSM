<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 
	<link type="text/css" rel="stylesheet" href="css/style.css" />
        
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
   
		 <div class="m_right">
            <p>${ts}</p>
            <div class="mem_tit">修改用户</div>
           	<form action="<%=path%>/UserUpdate2" method="post">
           	<c:forEach items="${list}" var="user">
            <table border="0" style="width:880px; margin-top:20px;"  cellspacing="0" cellpadding="0">

              <tr height="45">
                <td align="right">用户id:&nbsp; &nbsp;</td>
                <td><input type="text" value="${user.id}" class="add_ipt" style="width:290px;" readonly="readonly" name="id"/></td>
              </tr>
              
              <tr valign="top" height="110">
                <td align="right">帐户名称: &nbsp; &nbsp;</td>
                <td><input type="text" value="${user.loginName}" class="add_ipt" style="width:290px;" name="loginName" /></td>
              </tr>
              
              <tr height="45">
                <td align="right">用户名:&nbsp; &nbsp;</td>
                <td><input type="text" value="${user.userName}" class="add_ipt" style="width:290px;" name="userName"/></td>
              </tr>
             
                 <tr height="45">
                <td align="right">密码:&nbsp; &nbsp;</td>
                <td><input type="text" value="${user.password}" class="add_ipt" style="width:290px;" name="password"/></td>
              </tr>
              
                  <tr height="45">
                <td align="right">姓别:&nbsp; &nbsp;</td>
                <td><input type="radio" value="1" name="sex"  ${user.sex==1?"checked":""}/>男&nbsp;
                	<input type="radio" value="2" name="sex"  ${user.sex==2?"checked":""} />女
                	</td>
              </tr>
              
                  <tr height="45">
                <td align="right">身份证号:&nbsp; &nbsp;</td>
                <td><input type="text" value="${user.identityCode}" class="add_ipt" style="width:290px;" name="identityCode"/></td>
              </tr>
              
                  <tr height="45">
                <td align="right">邮箱:&nbsp; &nbsp;</td>
                <td><input type="text" value="${user.email}" class="add_ipt" style="width:290px;" name="email"/></td>
              </tr>
              
                  <tr height="45">
                <td align="right">手机号:&nbsp; &nbsp;</td>
                <td><input type="text" value="${user.mobile}" class="add_ipt" style="width:290px;" name="mobile"/></td>
              </tr>
              
                  <tr height="45">
                <td align="right">类型:&nbsp; &nbsp;</td>
                <td>
                    <input type="radio" value="0" ${user.type==0?"checked":""} name="type"> 前台&nbsp;
                    <input type="radio" value="1" ${user.type==1?"checked":""} name="type">后台
                </td>
              </tr>
              </c:forEach>
             
             
              <tr height="50" valign="bottom">
                <td>&nbsp;</td>
                <td><input type="submit" value="提交" class="btn_tj" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
	 
   
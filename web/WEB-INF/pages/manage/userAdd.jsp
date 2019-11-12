<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 
	<link type="text/css" rel="stylesheet" href="css/style.css" />
        
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
		<style>
          .mem_tit{
              text-align: center;
              color:red;
              font-weight: bolder;
              font-size: 30px;
              padding: 10px;
          }
         </style>
   
		 <div class="m_right">
            <p style="color: red">${ts}</p>
            <div class="mem_tit">新增用户</div>
           <div style="width: 700px;text-align: center;">
           	<fm:form action="${pageContext.request.contextPath}/UserAdds" modelAttribute="easybuy_user" method="post">
            <table border="0" style="width:880px; margin-top:20px;"  cellspacing="0" cellpadding="0">
              <tr valign="top" height="45">
                <td align="right">帐户名: &nbsp; &nbsp;</td>
                <td><input type="text" class="add_ipt" style="width:290px;" name="loginName" value="${easybuy_user.loginName}"/>
                    <fm:errors path="loginName"></fm:errors>
                </td>
              </tr>
              
              <tr height="45">
                <td align="right">用户名:&nbsp; &nbsp;</td>
                <td><input type="text" class="add_ipt" style="width:290px;" name="userName" value="${easybuy_user.userName}"/>
                <fm:errors path="userName"></fm:errors>
                </td>
              </tr>
             
                 <tr height="45">
                <td align="right">密码:&nbsp; &nbsp;</td>
                <td><input type="text" class="add_ipt" style="width:290px;" name="password" value="${easybuy_user.password}"/>
                <fm:errors path="password"></fm:errors>
                </td>
              </tr>
              
                  <tr height="45">
                <td align="right">姓别:&nbsp; &nbsp;</td>
                <td>
                <input type="radio" value="1" name="sex" ${easybuy_user.sex==1?"checked":"" }/>男&nbsp; &nbsp;&nbsp;&nbsp;
                 <input type="radio" value="2" name="sex" ${easybuy_user.sex==2?"checked":"" }/>女
                </td>
              </tr>
              
                  <tr height="45">
                <td align="right">身份证号:&nbsp; &nbsp;</td>
                <td><input type="text"  class="add_ipt" style="width:290px;" name="identityCode" value="${easybuy_user.identityCode}"/>
                <fm:errors path="identityCode"></fm:errors>
                </td>
              </tr>
              
                  <tr height="45">
                <td align="right">邮箱:&nbsp; &nbsp;</td>
                <td><input type="text" class="add_ipt" style="width:290px;" name="email" value="${easybuy_user.email}"/>
                <fm:errors path="email"></fm:errors>
                </td>
              </tr>
              
                  <tr height="45">
                <td align="right">手机号:&nbsp; &nbsp;</td>
                <td><input type="text" class="add_ipt" style="width:290px;" name="mobile" value="${easybuy_user.mobile}"/>
                <fm:errors path="mobile"></fm:errors>
                </td>
              </tr>
              
                  <tr height="45">
                <td align="right">类型:&nbsp; &nbsp;</td>
                <td>
                <input type="radio" value="0" name="type" ${easybuy_user.type==0?"checked":"" }/>前台&nbsp; &nbsp;
                <input type="radio" value="1" name="type" ${easybuy_user.type==1?"checked":"" }/>后台
                </td>
              </tr>
              
             
             
              <tr height="50" valign="bottom">
                <td>&nbsp;</td>
                <td><input type="submit" value="提交" /></td>
              </tr>
            </table>
            </fm:form>
            </div>
        </div>
    
	 
   
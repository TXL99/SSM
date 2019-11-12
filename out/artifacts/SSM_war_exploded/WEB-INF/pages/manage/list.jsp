<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
	<style>
          .mem_tit{
              text-align: center;
              color:red;
              font-weight: bolder;
              font-size: 30px;
              padding: 10px;
          }
    </style>
    <script>
        $(function(){
        
        });
        function zf(ii){
           $("[name='page']").val(ii);
           $("#form_action").submit();
        }
    </script>
   
		<div class="m_right">
            <p>${ts }</p>
            <div class="mem_tit">查看用户</div>
            <form action="<%=request.getContextPath()%>/list" method="post" modelAttribute="easybuy_user" id="form_action">
            <input type="hidden" name="page" value="1">;
               帐号： <input type="text" id="loginName" name="loginName" value="${easybuy_user.loginName}">
               用户名： <input type="text" id="userName" name="userName" value="${easybuy_user.userName}"><br>
               姓别： 女<input type="radio" name="sex" value="2" ${easybuy_user.sex==2?"checked":"" }>
                          男<input type="radio" name="sex" value="1" ${easybuy_user.sex==1?"checked":"" }>
               电话号码：<input type="text" id="mobile" name="mobile" value="${easybuy_user.mobile}"><br>
               <input type="submit" value="搜索">
            </form>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="20%" style="color:#ff4e00;">账户</td>
                <td width="25%" style="color:green;">姓名</td>
                <td width="15%" style="color:goldenrod;">性别</td>
                <td width="25%" style="color:blue;">电话</td>
                <td width="15%" style="color:purple;">操作</td>
              </tr>
              
              <c:forEach items="${pagebean.lists}" var="user">
              <tr>
                <td><font color="#ff4e00">${user.loginName}</font></td>
                <td style="color:green;">${user.userName}</td>
                <td style="color:goldenrod;">${user.sex==1?"男":"女"}</td>
                <td style="color:blue;">${user.mobile}</td>
                <td ><a href="<%=request.getContextPath() %>/UserUpdate?id=${user.id}" style="color:purple;">修改</a>-<a href="<%=request.getContextPath() %>/UserDelete?id=${user.id }" id="delec" style="color:purple;">删除</a> </td>
              </tr>
              </c:forEach>
            </table>
              <p style="text-align: center;font-size: 16px;">
                               一共<font color=red>${pagebean.countPage}</font>页,当前第<font color=red>${pagebean.index}</font>页<br>
                 <a href="javascript:;" onclick="zf(1);">首页</a>
                 <a href="javascript:;" onclick="zf(${pagebean.index-1});">上一页</a>
                 <a href="javascript:;" onclick="zf(${pagebean.index+1});">下一页</a>
                 <a href="javascript:;" onclick="zf(${pagebean.countPage});">尾页</a>
              </p>
            
            </div>
        
    

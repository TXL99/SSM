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
            <p></p>
            <div class="mem_tit">新闻管理</div>
            <form action="<%=request.getContextPath()%>/Easybuy_newsList" method="post" modelAttribute="easybuy_news" id="form_action">
                <input type="hidden" name="page" value="1">;
                标题： <input type="text" id="loginName" name="title" value="${easybuy_news.title}">
                内容： <input type="text" id="content" name="userName" value="${easybuy_news.content}"><br>
                创建时间：<input type="text" id="mobile" name="createTime" value="${easybuy_news.createTime}"><br>
                <input type="submit" value="搜索">
            </form>

            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="25%" style="color:green;">标题</td>
                <td width="15%" style="color:goldenrod;">内容</td>
                <td width="25%" style="color:blue;">时间</td>
                <td width="15%" style="color:purple;">操作</td>
              </tr>
              
           <c:forEach items="${pagebean.lists}" var="u">
              <tr>
                <td style="color:green;">${u.title }</td>
                <td style="color:goldenrod;">${u.content} </td>
                <td style="color:blue;">${u.createTime}</td>
                <td ><a href="<%=request.getContextPath() %>/Easybuy_newsUpdateServlet?id=${u.id}" style="color:purple;">修改</a>-<a href="<%=request.getContextPath() %>/Easybuy_newsDelServlet?id=${u.id}" id="delec" style="color:purple;">删除</a> </td>
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
        
    

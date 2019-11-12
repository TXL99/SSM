<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>阿里巴巴时间</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript">
	      $(function(){
	           $("#show").click(function(){
	                $.getJSON("<%=path%>/showAddressList.action","",function(rs){
	                var ul=$("#ull");
	                    for ( var i = 0; i < rs.length; i++) {
							var li=$("<li></li>");
							li.html("<a href='${pageContext.request.contextPath}/delectAddress/"
							+rs[i].id+"/"+rs[i].userId+"'>"+rs[i].address+":"+rs[i].createTime+"</a>");
							ul.append(li);
						}
	                });
	           });
	      });
	</script>

  </head>
  
  <body>
       <button id="show">查看地址时间</button>
       <ul id="ull">
           
       </ul>
  </body>
</html>

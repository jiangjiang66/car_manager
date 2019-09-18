<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车列表页面</title>
<link rel="stylesheet"  href="css/bootstrap.css"></link>
</style>
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  显示所有汽车
</nav>
 <div class="container">
	<form action="CarUserServlet?action=search" method="post">
		<table border="1" width="700" bordercolor="#c0c0c0" class="table table-hover table-bordered">
		
			<tr bordercolor="#c0c0c0">
				<td colspan="8">
					
					按名称查询:<input type="text" name="name"/>
					&nbsp;
					按类型查询:<select name="type"><!-- 最好从数据库查出来 -->
								<option value="">--请选择--
								<option value="大众">大众
								<option value="吉普">吉普
							  </select>
					&nbsp;&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>
				</td>
				<td><input type="submit" value="删除" ></td>
				<td><input type="button" value="修改" onclick="editmore()"></td>
			</tr>
		
		  <tr align="center" bordercolor="#c0c0c0">
		    <td><input type="checkbox"></td>
			<td>编号</td>
			<td>颜色</td>
			<td>类型</td>
			<td>大小</td>
			<td>名称</td>
			<td>生产日期</td>
			<td>保修期</td>
			<td>价格</td>
			<td>操作</td>
		  </tr>
		  
			  <c:forEach items="${cars}" var="car">
				  <tr align="center" id="${car.carid}" bordercolor="#c0c0c0">
				    <td><input type="checkbox" name="carids" value="${car.carid}"></td>
					<td>${car.carid }</td>
					<td>${car.color }</td>
					<td>${car.type }</td>
					<td>${car.size }</td>
					<td>${car.name }</td>
					<td>${car.borthday }</td>
					<td>${car.maintain }</td>
					<td>${car.price }</td>
					<td><a href="#" onclick="toedit(${car.carid})">更新</a>   <a href="#" onclick="doDelete(${car.carid})">删除</a></td>
				  </tr>
			  </c:forEach>
		  </table>
	  </form>
	
	
	 <form id="editoneForm" action="CarManagerServlet?action=editone" method="post" style="display:none;">
	 	<p>汽车编号：<input type="text"></p>
	 	<p>汽车颜色：<input type="text"></p>
	 	<p>汽车类型：<input type="text"></p>
	 	<p>汽车名称：<input type="text"></p>
	 	<p>汽车生产日期：<input type="text"></p>
	 	<p>汽车维护期：<input type="text"></p>
	 	<p>汽车价格：<input type="text"></p>
	 	<p><input type="submit" value="提交"><input type="button" value="取消"></p>
	 </form>
	
	</div>
	
	
	
<script type="text/javascript" src="js/jquery.js"></script>  
<script type="text/javascript">

	function doDelete(cid) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="CarManagerServlet?action=delone&cid="+cid;
		}
	}
	
	function doDeleteMore(){
		var flag = confirm("是否确定删除?");
		if(flag){
			//string ids[] = $("[name]=carids").value();
			location.href="CarManagerServlet?action=delmore";
		}
		
	}
	
	function toedit(cid){
		location.href="CarManagerServlet?action=toedit&cid="+cid;
		
	}
</script>
	  
</body>
</html>
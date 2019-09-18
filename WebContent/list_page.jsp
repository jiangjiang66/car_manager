<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>
<link rel="stylesheet"  href="css/bootstrap.css"></link>
<script type="text/javascript">

	function doDelete(sid) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteServlet?sid="+sid;
		}
	}
</script>

</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  显示所有汽车
</nav>
  <div class="container">
	<form action="CarUserServlet?action=search" method="post">
		<table  width="700"  class="table table-hover table-bordered">
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
		  
			 <c:forEach items="${pageBean.list}" var="car">
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
			  
			  <tr>
			  	<td colspan="10">
			  		第 ${pageBean.currentPage } / ${pageBean.totalPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="CarUserServlet?action=listpage&currentPage=1">首页</a>
						| <a href="CarUserServlet?action=listpage&currentPage=${pageBean.currentPage-1 }">上一页</a>
			  		</c:if>
			  		
			  		<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="CarUserServlet?action=listpage&currentPage=${i }">${i }</a>
			  			</c:if>
			  		
			  		</c:forEach>
			  		
			  		
			  		<c:if test="${pageBean.currentPage !=pageBean.totalPage }">
			  			<a href="CarUserServlet?action=listpage&currentPage=${pageBean.currentPage+1 }">下一页</a> | 
			  			<a href="CarUserServlet?action=listpage&currentPage=${pageBean.totalPage }">尾页</a>
			  		</c:if>
			  	</td>
			  </tr>
		  </table>
	  </form>
	  </div>
</body>
</html>
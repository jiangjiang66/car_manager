<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新汽车页面</title>

</head>


<body>

<h3>更新汽车页面</h3>

<form method="post" action="CarManagerServlet?action=editone">
	<input type="hidden" name="cid" value="${car.carid }">
  <table border="1" width="600">
  <tr>
	<td>颜色</td>
	<td><input type="text" name="color" value="${car.color }"></td>
  </tr>
  <tr>
	<td>类型</td>
	<td>
		<!-- 如果性别是男的，  可以在男的性别 input标签里面， 出现checked ,
		如果性别是男的，  可以在女的性别 input标签里面，出现checked -->
		<input type="radio" name="type" value="大众" <c:if test="${car.type == '大众'}">checked</c:if>>大众
		<input type="radio" name="type" value="吉普" <c:if test="${car.type == '吉普'}">checked</c:if>>吉普
	</td>
  </tr>
  <tr>
	<td>大小</td>
	<td><input type="text" name="size" value="${car.size }"></td>
  </tr>
   <tr>
	<td>名称</td>
	<td><input type="text" name="name" value="${car.name }"></td>
  </tr>
  <tr>
	<td>生产日期</td>
	<td><input type="text" name=borthday value="${car.borthday }"></td>
  </tr>
  <tr>
	<td>维修期</td>
	<td>
		<input type="text" name=maintain value="${car.maintain }">
	</td>
  </tr>
  <tr>
	<td>价格</td>
	<td><input type="text" name=price value="${car.price }"></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新"> </td>
  </tr>
  </table>
   </form>
</body>
</html>
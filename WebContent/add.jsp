<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加汽车页面</title>
<style type="text/css">
table{
	border-color:#c0c0c0;
}
 table > tr >td{
 	border-color:#c0c0c0;
 }
</style>
</head>


<body>

<h3>添加汽车页面</h3>

<form method="post" action="CarManagerServlet?action=add">
  <table border="1" width="600" >
  <tr>
	<td>颜色</td>
	<td><input type="text" name="color"></td>
  </tr>
  <tr>
	<td>类型</td>
	<td>
		<input type="radio" name="type" value="大众">大众
		<input type="radio" name="type" value="吉普">吉普
	</td>
  </tr>
  <tr>
	<td>大小</td>
	<td><input type="text" name="size"></td>
  </tr>
  <tr>
	<td>名称</td>
	<td><input type="text" name="name"></td>
  </tr>
  <tr >
	<td>生产日期</td>
	
	<td><input type="text" name="borthday"></td>
  </tr>
  <tr>
	<td>维护期</td>
	<td><input type="text" name="maintain"></td>
  </tr>
  <tr>
	<td>价格</td>
	<td><input type="text" name="price"></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="添加"> </td>
  </tr>
  </table>
   </form>
</body>
</html>
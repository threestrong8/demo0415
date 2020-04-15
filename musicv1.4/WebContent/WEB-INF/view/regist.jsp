<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>regist</title>
		<%@ include file="base.jsp"%>
		<style>
		#tid{
			margin-left:150px;
			margin-top:100px;
		}
		tr{
			display: block;
			margin-bottom: 30px;
		}
		
		#btn {
			width:80px;
		}
		</style>
	</head>
	<body>
	<form action="regist" method="post">
		<div id="tid">
		 <div id="top">${msg}</div>
			<table>
				<tr>
					<td>昵称：&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="password" name="rename"/></td>
				</tr>
				<tr>
					<td>邮箱：&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="text" name="post"/></td>
				</tr>
				<tr>
					<td>密码：&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="password" name="pwd"/></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="repwd"/></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="submit" value="确认" id="btn"/></td>
				</tr>
			</table>
		</div>
	</form>
	</body>
</html>

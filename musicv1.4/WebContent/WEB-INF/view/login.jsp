<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>login</title>
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
		#btn{
			margin-left:250px;
		}
		#btn input{
			width:80px;
		}
		#top{
		color:red;
		}
		</style>
	</head>
	<body>
	<form action="login" method="post">
		<div id="tid">
		  <div id="top">${msg}</div>
			<table>
				<tr>
					<td>邮箱：&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="text" name="post"/></td>
				</tr>
				<tr>
					<td>密码：&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="password" name="pwd"/></td>
				</tr>
			</table>
		</div>
		<div id="btn">
			<input type="submit" value="登录"/>
		</div>
	</form>
	</body>
</html>

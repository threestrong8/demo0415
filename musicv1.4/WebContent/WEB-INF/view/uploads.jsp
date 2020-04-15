<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>upload</title>
		<%@ include file="base.jsp"%>
		<style>
			tr{
				display: block;
				margin-bottom: 30px;
			}
			#saveid{
				width:100px;
			}
			#tid{
				margin-top:150px;
				margin-left:90px;
			}
			input{
				height:40px;
				width:200px;
			}
		</style>
	</head>
	<body>
	  <form action="uploads" method="post" enctype="multipart/form-data">
		<div id="tid">
			<table>
				<tr>
					<td>歌曲名称：</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>歌&nbsp;&nbsp;&nbsp;&nbsp;手：</td>
					<td><input type="text" name="singer"/></td>
				</tr>
				<tr>
					<td>专&nbsp;&nbsp;&nbsp;&nbsp;辑：</td>
					<td><input type="text" name="special"/></td>
				</tr>
				<tr>
					<td>上&nbsp;&nbsp;&nbsp;&nbsp;传：</td>
					<td><input type="file" name="myfile"/></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="submit" value="保存" id="saveid"/></td>
				</tr>
			</table>
		</div>
	</form>
	</body>
</html>

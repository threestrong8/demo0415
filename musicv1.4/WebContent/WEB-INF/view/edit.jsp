<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>edit</title>
		<%@ include file="base.jsp"%>
		<style>
			tr{
				display: block;
				margin-bottom: 30px;
			}
			#upid{
				width:100px;
			}
			#tid{
				margin-top:150px;
				margin-left:60px;
			}
		</style>
	</head>
	<body>
	  <form action="#">
		<div id="tid">
			<table>
				<tr>
					<td>歌曲名称：</td>
					<td><input type="text" name="sname"/></td>
				</tr>
				<tr>
					<td>歌&nbsp;&nbsp;&nbsp;&nbsp;手：</td>
					<td><input type="text" name="singer"/></td>
				</tr>
				<tr>
					<td>专&nbsp;&nbsp;&nbsp;&nbsp;辑：</td>
					<td><input type="text" name="editor"/></td>
				</tr>
				<tr>
					<td>文件上传：</td>
					<td><input type="file" name="sfile"/></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input type="submit" value="上传" id="upid"/></td>
				</tr>
			</table>
		</div>
	</form>
	</body>
</html>

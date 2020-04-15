<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>play</title>
		<%@ include file="base.jsp"%>
		<style>
		   #sum{
		   	width:700px;
		   	margin-left:150px;
		   }
			table{
				width:300px;
			}
			#tid{
				width:300px;
				margin:0px auto;
			}
			#playid{
				height:100px;
				border:1px solid gray;
				text-align: center;
				padding-top:60px;
				margin-top: 50px;
				margin-bottom:50px;
			}
			#bottom{
				width:100px;
				margin:0px auto;
			}
			#bottom input{
				width:80px;
			}
		</style>
		<script>
		function closeit(){
			history.back();
		}
			
		</script>
	</head>
	<body>
		<div id="sum">
			<div id="tid">
				<table>
					<tr>
						<td>歌曲名称：</td>
						<td>${song.songName}</td>
					</tr>
					<tr>
						<td>歌&nbsp;&nbsp;&nbsp;&nbsp;手：</td>
						<td>${song.singer}</td>
					</tr>
					<tr>
						<td>专&nbsp;&nbsp;&nbsp;&nbsp;辑：</td>
						<td>${song.special}</td>
					</tr>
				</table>
				
			</div>
			<div id="playid">
				<embed src="resources/play/CuMp3PlayerV1.swf?musicfile=${song.path}&musictitle=${song.songName}" width="446" height="68" quality="high" swLiveConnect=true name="CuPlayer" align="middle" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" allowfullscreen="true"
				></embed>
			</div>
			<div id="bottom">
				<input type="button" value="关闭" onclick="closeit()"/>
			</div>
		</div>
	</body>
</html>

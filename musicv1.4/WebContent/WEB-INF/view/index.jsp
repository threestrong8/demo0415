<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>index</title>
		<%@ include file="base.jsp"%>
		<script src="resources/script/jquery-1.8.3.min.js"></script>
		<script>
		    var ifr;
		    $(function(){
		    	ifr=document.getElementById("ifr");
		    });
			function allsong(){
				ifr.src="allsong";
			}
			function mysong(){
				ifr.src="mysong";
			}
			function collections(){
				ifr.src="collections";
			}
		</script>
		<style>
			#wel{
				height:50px;
				border:1px solid gray;
				padding-top:19px;
				margin-bottom:20px;
				width:1200px;
			}
			a{
				text-decoration: none;
			}
			#fir{
				float:left;
				margin-left:20px;
			}
			#hr{
				float:right;
				margin-right:30px;
			}
			#btn{
				margin-left:40px;
				margin-bottom:20px;
			}
			input{
				height:30px;
			}
			#fdiv{
				height:600px;
				width:1160px;
				border:1px solid gray;
				margin-left:40px;
			}
		</style>
	</head>
	<body>
	   <audio src="G:\music\薛之谦 - 暧昧.mp3" id="mymusic"></audio>
		<div id="wel">
			<div id="fir">
				欢迎来到我的音乐网站！
			</div>
			<div id="hr">
				<a href="login">登录</a>&nbsp;&nbsp;
				<a href="regist">注册</a>&nbsp;&nbsp;
				<a href="clearlogin">注销</a>
			</div>
		</div>
		<div id="btn">
			<input type="button" value="所有歌曲" onclick="allsong()"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="我的歌曲" onclick="mysong()"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="我的收藏" onclick="collections()"/>
		</div>
		<div id="fdiv">
			<iframe src="allsong" height="600" width="1160" id="ifr"></iframe>
		</div>
	</body>
</html>

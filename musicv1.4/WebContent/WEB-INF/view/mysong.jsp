<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>mysong</title>
		<%@ include file="base.jsp"%>
		<script type="text/javascript" src="resources/script/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		  $(function(){
			  var pc=parseInt($.trim($("#pc").val()));
			  var tp=$("#tp").val();
			  $("a.classpage").click(function(){
				  var a=$(this).attr("id");
				  switch(a){
				  case "first":$("#pc").val(1);
				  break;
				  case "previous":$("#pc").val(pc-1);
				  break;
				  case "next":$("#pc").val(pc+1);
				  break;
				  case "last":$("#pc").val(tp);
				  break;
				  }
				  $("#form").submit();
				  return false;
			  });
		  });
		</script>
		<script>
			function myupload(){
				location.href="uploads";
			}
		</script>
		<style>
		a{
			text-decoration: none;
		}
		#sum{
			width:800px;
			margin-top:150px;
			margin-left:50px;
		}
			table{
				border-collapse: collapse;
				border:1px solid gray;
				height:100px;
				width:800px;
				text-align: center;
			}
			td{
				border:1px solid gray;
			}
			#page{
				width:40px;
				margin:0px auto;
				margin-top:30px;
				margin-bottom:40px;
			}
			#bottom{
				width:300px;
				margin-left:260px;
			}
			input{
				height:40px;
				width:100px;
			}
			#tid{
				margin-top: 20px;
			}
		</style>
	</head>
	<body>
	<h1>${msg}</h1>
	   <div id="sum">
	       <form action="mysong" method="post" id="form">
	         <input type="hidden" name="pc" value="${pc}" id="pc"/>
	      </form>
	       <input type="hidden" name="tp" value="${tp}" id="tp"/>
	   	  <div>
	   	  <input type="button" value="上传歌曲" onclick="myupload()"/>
	   	  </div>
		  <div id="tid">
		  	<table>
		  		<tr>
		  			<td>序号</td>
		  			<td>歌名</td>
		  			<td>专辑</td>
		  			<td>歌手</td>
		  			<td>上传时间</td>
		  			<td>操作</td>
		  		</tr>
		  		<c:forEach items="${list}" var="song" varStatus="sta">
		  		     <tr>
		  			<td>${sta.index+1}</td>
		  			<td>${song.songName }</td>
		  			<td>${song.special }</td>
		  			<td>${song.singer }</td>
		  			<td>${song.time }</td>
		  			<td>
		  				<a href="play?songId=${song.id}">播放</a>
		  				<a href="download?songId=${song.id}" target="_blank">下载</a>
		  				<a href="addcollection?songId=${song.id}">收藏</a>
		  				<a href="deletesong?songId=${song.id}">删除</a>
		  			</td>
		  		</tr>
		  		</c:forEach>
		  	</table>
		  </div>
		  <div id="page">
		  	${pc}/${tp}
		  </div>
		   <div id="bottom">
		  		<a href="#" id="first" class="classpage">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		  	<c:if test="${pc>1}"><a href="#" id="previous" class="classpage">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
		    <c:if test="${pc<tp}"><a href="#" id="next" class="classpage">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
		  	<a href="#" id="last" class="classpage">尾页</a>
		  </div>
	   </div>	
	</body>
</html>

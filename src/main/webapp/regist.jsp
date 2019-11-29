<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="prc"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${prc}/css/style.css" />
		<script src="${prc}/js/jquery-3.3.1.min.js" charset="utf-8"></script>
		<script src="${prc}/js/jquery.validate.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#name").blur(function () {
					$("#hh").empty();
					 var name = $("#name").val();
					$.ajax({
						url:"${prc}/admin/verifyAdmin",
						data:{"username" : name},
						type:"get",
						success:function (data){
							$("#hh").html(data);
						}
					})
				});
			});



			var t = null;
			t = setTimeout(time,1000);
			function time()
			{
				clearTimeout(t);
				dt = new Date();
				var h=dt.getHours();
				var m=dt.getMinutes();
				var s=dt.getSeconds();
				document.getElementById("p").innerHTML =h+"时"+m+"分"+s+"秒";
				t = setTimeout(time,1000);
			}

			$(function () {
				$("form").validate({
					rules :{
						username:{required:true,maxlength: 10,minlength: 3},
						password:{required:true,maxlength:20,minlength:6}
					},
					messages:{
						username:{required:"*名字不能为空",maxlength:"*长度不能超过20字符",minlength:"*长度不能低于1"},
						password:{required:"*密码不能为空！",maxlength:"*密码长度不能超过20",minlength:"*密码长度不能小于6"}
					}
				});
			});
		</script>
		<style type="text/css">
			label{
				color: red;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader"><%--时间--%><p id ="p"></p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="${prc}/dep/showAllDep">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${prc}/admin/addAdmin" method="get">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" id="name" class="inputgri" name="username"value=""/><h style="color: #ff0f1d" id="hh"></h>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="男" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="女"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
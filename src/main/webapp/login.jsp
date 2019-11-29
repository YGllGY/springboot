<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath}" var="prc"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${prc}/css/style.css" />
	<script type="text/javascript">
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
		</script>
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
						登陆
					</h1>
					<form action="${prc}/admin/selectAllAdmin" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
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
						</table>
						<p>
							<input type="submit" class="button" value="登陆" />
							<input type="button" class="button" onclick="location.href='${prc}/regist.jsp'" value="注册" />
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

<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="prc" ></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${prc}/css/style.css" />
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
						<a href="${prc}/admin/invalidate"><h5 style="color: orange">注销&nbsp;&nbsp;&nbsp;</h5></a>
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
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								部门ID
							</td>
							<td>
								部门编号
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach var="dep" items="${requestScope.list}">
							<tr class="row1">
								<td>
									${dep.id}
								</td>
								<td>
									${dep.depnumber}
								</td>
								<td>
									${dep.depname}
								</td>
								<td>
									<a href="${prc}/dep/selectOneById?id=${dep.id}">更新</a>&nbsp;&nbsp;&nbsp;<a href="${prc}/emp/showEmpByDepId?depnumber=${dep.depnumber}">员工列表</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='${prc}/emp/showAllDep'"/> <input type="button" class="button" value="添加部门" onclick="location='${prc}/addDepartment.jsp'"/>
					</p>
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

<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="prc"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
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

			function upload_review() {
				var img = document.getElementById("uploadimg");
				var input = document.getElementById("file_upload1");

				var file = input.files.item(0);
				var freader = new FileReader();
				freader.readAsDataURL(file);
				freader.onload = function(e) {
					img.src = e.target.result;
				};
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
								<a href="${prc}/dep/showAllDep">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="${prc}/upload/uploadImg" method="post" enctype="multipart/form-data">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">				
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									${emp.id}
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									头像:
								</td>
								<td valign="middle" align="left">
								<img id="uploadimg" width="40px" height="40px" src="${prc}/img/${emp.image}" />
									<input type="file" id="file_upload1" onchange="upload_review()" name="upload" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${emp.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${emp.salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${emp.age}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									部门:
								</td>
								<td valign="middle" align="left">
									<select name="depnumber">
										<c:forEach var="dep" items="${requestScope.departments}">
											<c:if test="${dep.depnumber == emp.depnumber}">
											<option selected="selected" value="${dep.depnumber}">${dep.depname}</option>
											</c:if>
											<c:if test="${dep.depnumber != emp.depnumber}">
												<option value="${dep.depnumber}">${dep.depname}</option>
											</c:if>
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="hidden" name="image" value="${emp.image}">
							<input type="hidden" name="id" value="${emp.id}">
							<input type="submit" class="button" value="修改" />
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

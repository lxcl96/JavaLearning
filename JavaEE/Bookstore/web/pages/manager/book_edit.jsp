<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@ include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="post">
				<!-- El表达式中字符串拼接需要使用指定函数-->
<%--			requestScope.bookInfoObj == null或者empty param.bookInfoId,或者在请求时额外加一个参数进行判断	--%>
				<!-- 至于id传递，可以额外加一个隐藏域,隐藏其实也就是提交的参数-->
				<input type="hidden" name="action" value=${requestScope.bookInfoObj == null? "addBook":"updateBook"} >
<%--				<input type="hidden" name="bookId" value=${requestScope.bookInfoObj.id} >--%>
				<input type="hidden" name="bookId" value=${param.bookInfoId} >
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="bookName" type="text" placeholder="请输入书名" value="${requestScope.bookInfoObj.bookName}"/></td>
						<td><input name="price" type="text" placeholder="请输入价格" value="${requestScope.bookInfoObj.price}"/></td>
						<td><input name="author" type="text" placeholder="请输入作者" value="${requestScope.bookInfoObj.author}"/></td>
						<td><input name="sales" type="text" placeholder="请输入销量" value="${requestScope.bookInfoObj.sales}"/></td>
						<td><input name="stock" type="text" placeholder="请输入库存" value="${requestScope.bookInfoObj.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
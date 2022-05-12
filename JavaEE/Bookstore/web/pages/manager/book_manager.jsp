<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ly.bean.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/pages/common/head.jsp"%>
<script type="text/javascript">
	$(function () {
		//给删除按钮绑定事件
		$(".delClass").click(function () {
			//this 是dom对象 需要转成JQ对象
			if (!confirm("确定要删除图书《" + $(this).parent().parent().find("td").first().text() +"》吗？")) {
				return false;
			}
		});

	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<!-- jsp循环 -->
<%--			<%--%>
<%--				List<Book> bookList = (List<Book>) request.getAttribute("bookList");--%>
<%--				for (Book book : bookList) { %>--%>
<%--			<tr>--%>
<%--				<td><%= book.getBookName()%></td>--%>
<%--				<td><%= book.getPrice()%></td>--%>
<%--				<td><%= book.getAuthor()%></td>--%>
<%--				<td><%= book.getSales()%></td>--%>
<%--				<td><%= book.getStock()%></td>--%>
<%--				<td><a href="book_edit.jsp">修改</a></td>--%>
<%--				<td><a href="#">删除</a></td>--%>
<%--			</tr>--%>
<%--			<% } %>--%>
			<!-- jstl的写法 -->
			<c:forEach items="${requestScope.bookList}" var="book">
				<tr>
					<td>${book.bookName}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=bookInfo&bookInfoId=${book.id}">修改</a></td>
					<td><a class="delClass" href="manager/bookServlet?action=delBook&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
	</div>
	<div id="page_nav">
		<!-- 是第一页的意思-->
		<form action="manager/bookServlet" method="post">
			<input type="hidden" name="action" value="queryPages"/>
			<a href="manager/bookServlet?action=queryPages">首页</a>

			<% if ((Integer)(request.getAttribute("currentPage")) - 1 > 0) { %>
				<a href="manager/bookServlet?action=queryPages&currentPage=${requestScope.currentPage - 1}">上一页</a>
				<a href="manager/bookServlet?action=queryPages&currentPage=${requestScope.currentPage - 1}">${requestScope.currentPage - 1}</a>
			<% }%>

			【${requestScope.currentPage}】

			<% if ((Integer)(request.getAttribute("currentPage")) + 1 <= (Integer) (request.getAttribute("pageNum"))) { %>
				<a href="manager/bookServlet?action=queryPages&currentPage=${requestScope.currentPage + 1}">${requestScope.currentPage + 1}</a>
				<a href="manager/bookServlet?action=queryPages&currentPage=${requestScope.currentPage + 1}">下一页</a>
			<% }%>

			<a href="manager/bookServlet?action=queryPages&currentPage=${requestScope.pageNum}">末页</a>
			共${requestScope.pageNum}页，${requestScope.total}条记录 到第<input name="currentPage" id="pn_input" />页
			<input type="submit" value="确定" />
		</form>
	</div>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<!-- 静态包含 引入相同信息-->
		<%@ include file="/pages/common/login_success_menu.jsp"%>
		<script type="text/javascript">
			$(function () {
				let $orderStatus = $(".orderStatus");
				if ($orderStatus.text() == 0) {
					$orderStatus.text("未发货");
				} else if ($orderStatus.text() == 1) {
					$orderStatus.text("已发货");
				} else if ($orderStatus.text() == 2) {
					$orderStatus.text("已签收");
				} else {
					$orderStatus.text("状态异常，请联系管理员！");
				}
			});
		</script>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>

			<c:forEach items="${sessionScope.orderList}" var="order">
				<tr>
					<td>${order.createTime}</td>
					<td>${order.price}</td>
					<td class="orderStatus">${order.status}</td>
					<td><a href="#">查看详情</a></td>
				</tr>
			</c:forEach>

		</table>
		
	
	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
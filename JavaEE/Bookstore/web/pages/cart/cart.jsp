<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			//按照id找只能找到1个 实际上是每个都会有的
			$(".goodsDel").click(function () {
				let text=$(this).parent().parent().find("td:first").text();
				return confirm("确定删除商品 《" + text + "》 吗？");
			});

			//清空购物车确认
			$(".cartClean").click(function () {
				return confirm("确定删除所有商品吗？");
			});

			//修改数量时提示用户是否修改[可以将blur改成change事件，就不用额外判断了]
			$(".goodsCountCls").blur(function () {
				//修改前的值
				let num = $(this).attr("goodsNum");
				//修改后的值
				let val = $(this).val();

				if (num == val){
					return false;
				}
				let ret = confirm("是否确认修改？");
				let patten = /^\d+$/;
				if (ret) {
					if (patten.test(val) && val != 0) {
						$(this).attr("goodsNum",val);
						location.href = "<%=basePath%>" + "cartServlet?action=goodsNumAlter&&goodsId=" + $(this).attr("goodsId") + "&&goodsCount=" + val;
						return true;
					} else {
						alert("请输入正确个数！");
					}
				}
				$(this).val(num);
				return false;
			});
		});
	</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<!-- 静态包含 引入相同信息-->
		<%@ include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.cart.goodsList}" var="goods">
				<tr>
					<td>${goods.value.goodsName}</td>
					<td>
						<input type="text" value="${goods.value.goodsCount}" style="width: 60px;text-align: center" class="goodsCountCls" goodsNum="${goods.value.goodsCount}" goodsId="${goods.value.goodsId}"/>
					</td>
					<td>${goods.value.goodsPrice}</td>
					<td>${goods.value.goodsTotalPrice}</td>
					<td><a href="cartServlet?action=goodsDel&&goodsId=${goods.value.goodsId}" class="goodsDel">删除</a></td>
				</tr>
			</c:forEach>

			<c:if test="${empty sessionScope.cart.goodsList}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空！快跟小伙伴去浏览商品把！！！</a></td>
				</tr>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.goodsList}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.GTotalPrices}</span>元</span>
				<span class="cart_span"><a href="cartServlet?action=cartClean" class="cartClean">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=saveOrder">去结账</a></span>
			</div>
		</c:if>
	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
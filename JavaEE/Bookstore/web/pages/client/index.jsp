<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--目的是为了主页能访问分页数据，所有就把要显示的数据放在这里，由首页跳转过来 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            //给添加购物车绑定单击事件
            $(".addToCart").click(function () {
                //直接请求，即改变地址栏地址
                location.href="<%= basePath%>" + "cartServlet?action=goodsAdd&&goodsId=" + $(this).attr("goodsId");
            });
            //给价格筛选绑定单击事件
            $("#queryBooksByPrice").click(function () {
                let $minObj = $("#min");
                let $maxObj = $("#max");
                let priceRule = /^\d+$/;

                if (!priceRule.test($minObj.val()) || !priceRule.test($maxObj.val()) ||$maxObj.val() < $minObj.val()) {
                    alert("请输入正确价格区间（整数）！");
                    return false;
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">网上书城</span>
    <div>
<%--        如果用户还没有登陆显示登录信息--%>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
<%--    如果已经登陆显示登陆成功后信息--%>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
            <a href="orderServlet?action=queryOrderByUserid">我的订单</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="clientBookServlet" method="post">
                <input type="hidden" name="action" value="queryPagesByPrice">
                价格：<input id="min" type="text" name="min" /> 元 -
                <input id="max" type="text" name="max" /> 元
                <input type="submit" id="queryBooksByPrice" value="查询" />
            </form>
        </div>
        <c:if test="${not empty sessionScope.cart.goodsList}">
            <div style="text-align: center">
                <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.latestGoods}</span>加入到了购物车中
                </div>
            </div>
        </c:if>
        <!-- 商品列表  jstl写法-->
        <c:forEach items="${requestScope.bookList}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.img_path}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.bookName}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button class="addToCart" goodsId="${book.id}">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<div id="page_nav">
    <!-- 是第一页的意思-->
    <form action="clientBookServlet" method="post">
        <input type="hidden" name="action" value="queryPages"/>
        <a href="clientBookServlet?action=queryPages">首页</a>

        <% if ((Integer)(request.getAttribute("currentPage")) - 1 > 0) { %>
        <a href="clientBookServlet?action=queryPages&currentPage=${requestScope.currentPage - 1}">上一页</a>
        <a href="clientBookServlet?action=queryPages&currentPage=${requestScope.currentPage - 1}">${requestScope.currentPage - 1}</a>
        <% }%>

        【${requestScope.currentPage}】

        <% if ((Integer)(request.getAttribute("currentPage")) + 1 <= (Integer) (request.getAttribute("pageNum"))) { %>
        <a href="clientBookServlet?action=queryPages&currentPage=${requestScope.currentPage + 1}">${requestScope.currentPage + 1}</a>
        <a href="clientBookServlet?action=queryPages&currentPage=${requestScope.currentPage + 1}">下一页</a>
        <% }%>

        <a href="clientBookServlet?action=queryPages&currentPage=${requestScope.pageNum}">末页</a>
        共${requestScope.pageNum}页，${requestScope.total}条记录 到第<input name="currentPage" id="pn_input" />页
        <input type="submit" value="确定" />
    </form>
</div>
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
	<script type="text/javascript">

		//用户校验函数
		let checkName = function (nameText,msg) {
			//alert(typeof nameText);
			let nameReg = /^\w{5,12}$/;
			if (!nameReg.test(nameText)) {
				//alert("注册失败!\n用户名长度为5-12位，且只能包含数字、字母和下划线。");
				$("span[class='errorMsg']").text(msg);
				return false;
			}
			//把错误信息 删除掉
			$("span[class='errorMsg']").text("");
			return true;
		}

		//电子邮箱校验
		let checkEmail = function (emailText) {
			//alert("email");
			let emailReg = /^\w{3,10}\@\w{1,10}\.com$/;
			if (!emailReg.test(emailText)) {
				$("span[class='errorMsg']").text("邮箱不合法!");
				return false;
			}
			//把错误信息 删除掉
			$("span[class='errorMsg']").text("");
			return true;
		}

		$(document).ready(function () {
			//使用ajax校验该用户是否可用
			$("#username").change(function () {
				$.getJSON("userServlet",{action:"verifyUsername",username:this.value},function (data) {
					//alert(data);
					console.log(data);
					//0代表可用 其他代表不可用
					if (data.isAvailable == true) {
						//提交按钮可用
						$("#sub_btn").removeAttr("disabled");
						$(".errorMsg").text("");
					} else {
						//提交按钮不可用，置灰 并给出提示
						$("#sub_btn").attr("disabled","disabled");
						$(".errorMsg").text("该用户已存在！");

					}
				})
			});

			//看不清验证码点击刷新
			$("#verityCode").click(function () {
				//个别浏览器（IE、FireFox）点了之后不刷新，是因为每次请求地址相同所以 直接从缓存中取了
				//所以每次添加一个时间戳，充当随即数即可  new Date().getTime()=unix纯数字
				$(this).attr("src","verifyCode.jpg?random=" + new Date().getTime());
			});

			$("#sub_btn").click(function () {
				//校验用户名
				let nameText = $("#username").val();
				if (!checkName(nameText,"用户名不合法！")) {
					return false;
				}
				//校验密码
				let pwdText = $("#password").val();
				if (!checkName(pwdText,"密码不合法!")) {
					return false;
				}
				//校验确认密码
				let repwdText = $("#repwd").val();
				if (repwdText != pwdText) {
					$("span[class='errorMsg']").text("两次密码是不相同！");
					return false;
				} else {
					$("span[class='errorMsg']").text("");
				}

				//校验电子邮箱
				let emailText = $("#email").val();
				if (!checkEmail(emailText)) {
					return false;
				}
				//校验验证码
				let codeText = $("#code").val();
				//alert(codeText);
				//去掉首位内容的字符串
				codeText = $.trim(codeText);
				//alert(codeText);
				if (codeText == null || codeText == "") {
					$("span[class='errorMsg']").text("验证码不能为空！");
					return false;
				} else {
					$("span[class='errorMsg']").text("");
				}
			});
		});
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
<%--									<%= request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									<!-- El表达式优化-->
									${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="register">
<!--								<form action="regist_success.jsp">-->
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" value="${requestScope.password}"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" value="${requestScope.password}"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 120px;" id="code" name="code" value="${requestScope.code}"/>
									<img alt="" src="verifyCode.jpg" style="float: right; margin-right: 40px;width: 120px;height: 40px" alt="验证码" id="verityCode">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
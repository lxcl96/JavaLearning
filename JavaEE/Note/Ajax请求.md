***Ajax***

AJAX即Asynchronous Javascript And Xml（异步Javascript和XML），是一种创建交互式的网页应用的网页开发技术。

`ajax是一种浏览器通过js异步发起请求。服务器接受到请求返回信息给浏览器,局部更新页面的技术`

`同步请求：点了一下，网页就会卡住别的按钮等都不能点击，只有等到服务器响应后才能继续。`

`异步请求：点了一下，不影响其他的网页功能使用。`

***原生Ajax发起请求步骤*：**

1、我们首先要创建XMLHttpRequest 对象
2、调用open方法设置请求参数
3、调用send方法发送请求
4、在send方法前绑定 onreadystatechange事件，处理请求完成后的操作。

```html
<script type="text/javascript">
    function ajaxRequest() {
        //在这里使用javaScript语言发起ajax请求，访问服务器的AjaxServlet中javascriptAjax方法
        // 1、我们首先要创建XMLHttpRequest 
        let xmlhttprequest = new XMLHttpRequest();
        // 2、调用open方法设置请求参数 参数：[请求的类型，请求的地址，是否为异步请求]
        xmlhttprequest.open("get","http://localhost:8080/16_json/ajaxServlet?action=javascriptAjax",true);

        //4、在send方法前绑定 onreadystatechange  事件判读其值是不是等于4即服务器已经回传数据切已经成功接收，处理请求完成后的操作。 最好放在发送前，因为每次发生变化都会调用此函数
        xmlhttprequest.onreadystatechange = function () {
            if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200) {
                alert("哈哈哈");
                //alert(xmlhttprequest.responseText);
                let divObj = document.getElementById("div01");
                let personObj = JSON.parse(xmlhttprequest.responseText);
                divObj.innerHTML = "编号为：" + personObj.id + "，名称为：" + personObj.name;
            }
        }
        // 3、调用send方法发送请求
        xmlhttprequest.send();
   		
        //***如果使用同步的方法，就需要等ajax的代码执行完才会执行这一步，即先提示“哈哈哈”，再提示 “我是最后一行代码”
        alert("我是最后一行的代码")；
    }
</script>
</head>
<body>	
    <button onclick="ajaxRequest()">ajax request</button>
    <div id="div01">
    </div>
</body>
<!--
	总结：
	同步就是代码顺序执行，即需要等到服务器响应后才会再执行下面的非ajax代码。 
	异步就是代码也是顺序执行，但不需要等到服务器响应后才会再执行下面的非ajax代码，而是直接执行下面的非ajax代码。
即：异步就是执行了ajax请求后，直接执行下面的feiajax代码，知道服务器有响应才会执行ajax的onreadystatechange对应代码。
-->
```

------

***JQuery中的Ajax请求：***

###### 1、$.ajax(url,settings)方法

```js
/*
	参数解析：
	url：表示请求的地址
	type：表示请求的类型 get或post
	data：表示发送给服务器的数据  格式：{key:value}
	success：请求成功，响应的回调函数   //**必须传参表示服务器返回数据
	dataType：数据类型，是服务器响应给浏览器的响应数据类型，常用的由text,xml和json
*/
$.ajax({
    url:"http://localhost:8080/16_json/ajaxServlet",
    type:"get",
    data:"action=JQAjax",
    success:function (data) { //成功的回调函数必须加参数，表示服务器传递过来的数据
        alert("服务器响应成功！,返回数据为：" + data);
    },
    dataType:"json"
});
```

###### 2、$.get(url,data,callback,type)方法

```js
/*
	参数解析：
	url：表示请求的地址
	data：表示发送给服务器的数据	格式：{key:value}
	success：请求成功，响应的回调函数 //**必须传参表示服务器返回数据
	dataType：数据类型，是服务器响应给浏览器的响应数据类型，常用的由text,xml和json
*/
//上面$.ajax()的get方法简化
$.get("http://localhost:8080/16_json/ajaxServlet",{ action:"JQAjax", test:"test"},function (data) {
    $("#msg").text("编号为：" + data.id + "，名称为：" + data.name);
},"json");
```

###### 2、$.post(url,data,callback,type)方法

```js
//和 $.get(url,data,callback,type)方法方法完全一样
注意：$.get()和$.post()方法没办法在执行出错时执行出错函数，这个需要使用$.ajax()
```

###### 4、$.getJSON(url,data,callback)方法

```js
//通过get请求到json数据
/*
	参数解析：
	url：表示请求的地址
	data：表示发送给服务器的数据	格式：{key:value}
	success：请求成功，响应的回调函数 //**必须传参表示服务器返回数据
*/


```

###### 5、$.serialize()方法

`$.serialize()可以把表单中所有表单项的内容都获取到，并以name=value&name=value的形式拼接。`

```js
//获取表单项内容
$("#form01").serialize();

//将表单项通过ajax发送给服务器
$.getJSON("http://localhost:8080/16_json/ajaxServlet","action=JQSerialize&" + $("#form01").serialize(),function (data) {
    alert("服务器已成功接受并返回！");
});
```


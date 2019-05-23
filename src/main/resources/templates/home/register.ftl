<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>注册榴莲</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="/css/user.css">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script type="text/javascript">
  	$("#userName").blur(function(){
  		var uname= $("#userName").val();
  		$.ajax({
  		   type : "POST", //数据传输的方式
  		   url : "/user/loginMethod", //进行判断的地址值
  		   data : {
  			  userName : uname
  		   }, //使用(key,value)方式传递数据
  		   success : function(data) {
	  		   if (data.get("username")) {
	  			  $(function () {
	  			      window.location.href = "/index.html";
	  			  })
	  		   } else {
	  		      alert("登录失败!");
	  		   }
  		   }
  		});
	});
  	$("#passWord").blur(function(){
  	  	$("input").css("background-color","#D6D6FF");
  	});
  	$("#rePassWord").blur(function(){
  	  	$("input").css("background-color","#D6D6FF");
  	});
  	$("#age").blur(function(){
  	  	$("input").css("background-color","#D6D6FF");
  	});
  	$("#tel").blur(function(){
    	$("input").css("background-color","#D6D6FF");
    });
  </script>
</head>
<body>
  <header>
    <a href="/index.html"><img src="/img/logo.png" class="logo" alt="榴莲"></a>
    <nav class="navbar">
      <a href="/login.html">登录榴莲</a>
      <a href="/register.html" id="curr">注册榴莲</a>
      <a href="">我的榴莲</a>
      <a href="">榴莲故事</a>
      <a href="">榴莲</a>
    </nav>
  </header>
  <div class="user-box">
    <h2>注册</h2>
    <form action="" id="registerForm">
    <input type="text" class="form-control" id="userName" placeholder="用户名"><br>
    <input type="password" class="form-control" id="passWord" placeholder="密码"><br>
    <input type="password" class="form-control" id="rePassWord" placeholder="确认密码"><br>
    <input type="number" class="form-control" id="age" placeholder="年龄"><br>
    <input type="text" class="form-control" id="tel" placeholder="电话号码"><br>
    <select name="sex" class="form-control" id="sex">
      <option value="男">男</option>
      <option value="女">女</option>
    </select><br>
    </form>
    <a href="/login.html"><button type="button" class="btn btn-primary user-submit">注册</button></a>
  </div>
</body>
</html>
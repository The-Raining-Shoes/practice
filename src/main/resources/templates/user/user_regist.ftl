<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/user_regist.css" >
</head>
<body>
<div class="main">
	<div class="col-md-8 zhuce">
		<form class="my_form" name="my_form"
			  action="/user/registMethod"
			  method="post" onsubmit="return check(this)">
			<h3>欢迎注册</h3>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="text" class="form-control" id="username"
						   placeholder="用户名" name="username">
					<span  id="name-error" ></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="password" name="pwd1" class="form-control" id="inputPassword3"
						   placeholder="密码" >
					<span class="pwd-error"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="password" name="pwd2" class="form-control" id="confirmpwd"
						   placeholder="确认密码 " onblur="checkpwd()" />
					<span class="pwd-error"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="text" class="form-control" id="phone"
						   placeholder="联系方式" name="phone">
					<span id="em-error"></span>
				</div>
			</div>
			<div class="form-group opt">
				<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
				<div class="col-sm-6">
					<label class="radio-inline"> <input type="radio"
														id="inlineRadio1" name="sex" value="男">
						男
					</label> <label class="radio-inline"> <input type="radio"
																 id="inlineRadio2" name="sex" value="女">
					女
				</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn-zhuce" value="注册" name="submit">
				</div>
			</div>
		</form>
	</div>
	
	<div class="bj_right">
		<p>使用以下账号直接登录</p>
		<a href="#" class="zhuce_qq">QQ注册</a>
		<a href="#" class="zhuce_wb">微博注册</a>
		<a href="#" class="zhuce_wx">微信注册</a>
		<p>已有账号？<a href="login.html">立即登录</a></p>
	</div>
	
</div>
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

$(function(){
	
	$('#username').bind('input propertychange', function() {
		 $("#name-error").html("");
	        var uname = $(this).val();
	        if(uname==""){
	            $("#name-error").html("用户名不能为空");
	        }else{
	            // $.ajax方法实现
	            $.ajax({
	                url:"/user/ajaxNameCheck",
	                type:"post",
	                dataType: "json",
	                data:{
	                	"username":$("#username").val()
	                	},
	                async:false,
	                success:function(result){
	                    $("#name-error").html(result.result);
	                }
	            });
	        }
	});
	
	$('#phone').bind('input propertychange', function() {
		 $("#em-error").html("");
	       var uname = $(this).val();
	       if(uname==""){
	           $("#em-error").html("联系方式不能为空");
	       }else{
	           // $.ajax方法实现
	           $.ajax({
	               url:"/user/ajaxPhoneCheck",
	               type:"post",
	               dataType: "json",
	               data:{
	               	"phone":$("#phone").val()
	               	},
	               async:false,
	               success:function(result){
	                   $("#em-error").html(result.result);
	               }
	           });
	       }
	});
	
/*     $("#username").onchange(function(){
    	 $("#name-error").html("");
        var uname = $(this).val();
        if(uname==""){
            $("#name-error").html("用户名不能为空");
        }else{
            // $.ajax方法实现
            $.ajax({
                url:"/user/ajaxNameCheck",
                type:"post",
                dataType: "json",
                data:{
                	"username":$("#username").val()
                	},
                async:false,
                success:function(result){
                    $("#name-error").html(result.result);
                }
            });
        }
    }); */

/*     $("#phone").onchange(function(){
   	 $("#em-error").html("");
       var uname = $(this).val();
       if(uname==""){
           $("#em-error").html("联系方式不能为空");
       }else{
           // $.ajax方法实现
           $.ajax({
               url:"/user/ajaxPhoneCheck",
               type:"post",
               dataType: "json",
               data:{
               	"phone":$("#phone").val()
               	},
               async:false,
               success:function(result){
                   $("#em-error").html(result.result);
               }
           });
       }
   }); */
    
});

function check(form){
	var input=document.querySelectorAll(".form-control");
	for(var i=0;i<input.length;i++){
		input[i].parentNode.children[1].innerHTML="";
		if(input[i].value==""){
			input[i].parentNode.children[1].innerHTML="不能为空！";
			console.log(input[i].parentNode.children[1]);
		}
		else if(input[0].value!==""&&input[1].value!==""&&input[2].value!==""&&input[3].value!==""&&input[4].value!==""&&input[5].value!==""){
			return true;
		}
		
	}
	return false;
} 

/*  function checkpwd() {
        var passwd1=document.my_form.pwd1.value;  
        var passwd2=document.my_form.pwd2.value;
        
        if (passwd1 =="") {
            document.my_form.pwd1.innerText="密码空，请输入";
            document.my_form.pwd2.innerText="";
            return;
        }
        if (passwd1 != passwd2) {
            document.my_form.pwd1.innerText="";
            document.my_form.pwd2.innerText="密码不一致，请重输入";
            document.my_form.pwd1.innerText="";
            document.my_form.pwd2.innerText="";
        } else {
            document.my_form.pwd1.innerText="";
            document.my_form.pwd2.innerText="";
        }
   }
*/ 

</script>
</body>
</html>
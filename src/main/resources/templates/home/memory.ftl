<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>我的榴莲</title>
<link rel="stylesheet" href="/css/memory.css">
</head>
<body>
	<header>
		<a href="/memory.html"><img src="/img/logo.png" class="logo"
			alt="榴莲"></a>
		<nav class="navbar">
			<a href="/page/they">榴莲中心</a> <a href="/page/mypage" id="curr">我的榴莲</a>
			<a href="/page/index">榴莲主页</a>
		</nav>
	</header>
	<main>
	<p class="memory-bar">种下你的榴莲</p>
	<form action="/user/completeMethod" method="post" enctype="multipart/form-data">
		<div>物品名称：<input type="text" id="name" name="goodsName"></div> 
        <div style="margin-top: 10px">上传图片
                        <input type="file" name="file" onchange="imgPreview(this)" id="blogLogo" />  
                    </div>
		
		是否公开：
		<select name="private" name="goodsIsShow" id="isShow">
			<option value="1">公开</option>
			<option value="2">隐藏</option>
		</select><br>
		<div id="priceTagert">
		公开价格：<input type="number" name="price">
		</div>
		类别： <select name="goodsType" name="goodsType">br
			<option value="1">生活品</option>
			<option value="2">衣物</option>
			<option value="3">电子产品</option>
			<option value="4">书籍</option>
		</select><br> 
		存放时间： <input type="number" name="goodsTime">&nbsp;天<br>
		榴莲故事：
		<textarea name="goodsStory" cols="50" rows="5"></textarea>
		<br>
		<div class="btn">
			<input type="submit" id="shangchuan" value="上传" id="login">		
		</div>
	</form>
	</main>
</body>

<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script>

$("#shangchuan").click(function(){
	alert("上传成功！")
})

$("#isShow").change(function(){
	if($("#isShow").val() == "1"){
		$("#priceTagert").show();
	}else if($("#isShow").val() == "2"){
		$("#priceTagert").hide();
	}
	});
</script>
</html>
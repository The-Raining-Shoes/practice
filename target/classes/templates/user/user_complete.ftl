<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>创建博客</title>
<link rel="stylesheet" type="text/css" href="/css/user_complete.css" >
</head>
<body>
    <form action="/user/completeMethod" method="post" enctype="multipart/form-data">
    	<div class="block1">
        	<div class="block2">
        		<img id="preview"  width="130px" height="130px" border="0" src="/img/shangchuan.jpg"/>
            <!-- <br /> -->
                <div class="block3">
                    <div>
                        	博客名<br>
                        <input type="text" id="name" name="blogname">
                    </div> 
                    <div  style="margin-top: 10px">
                  	 	     上传博客头像<br>
                        <input type="file" name="file" onchange="imgPreview(this)" id="blogLogo" />  
                    </div>                 
                    <div>
                        <input type="submit" value="创建博客" id="login">
                    </div>   
                </div> 
        	</div>	
    	</div>
	</form>
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    function imgPreview(fileDom){
        //判断是否支持FileReader
        if (window.FileReader) {
            var reader = new FileReader();
        } else {
            alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
        }

        //获取文件
        var file = fileDom.files[0];
        var imageType = /^image\//;
        //是否是图片
        if (!imageType.test(file.type)) {
            alert("你这个是不是图片心里没点B数？");
            return;
        }
        //读取完成
        reader.onload = function(e) {
            //获取图片dom
            var img = document.getElementById("preview");
            //图片路径设置为读取的图片
            img.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
    
    function upload() {
        var xhr = new XMLHttpRequest();
        var progress = document.getElementById("progress")
        progress.style.display = "block";

        xhr.upload.addEventListener("progress", function(e) {
            if (e.lengthComputable) {
                var percentage = Math.round((e.loaded * 100) / e.total);
                progress.value = percentage;
            }
        }, false);

        xhr.upload.addEventListener("load", function(e){
              console.log("上传完毕...")
          }, false);

        xhr.open("POST", "upload");
        xhr.overrideMimeType('text/plain; charset=x-user-defined-binary');
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                alert(xhr.responseText); // handle response.
                progress.style.display = "none";
                progress.value = 0;
            }
        };
        var file = document.getElementById("imgFile");
        var fd = new FormData();
        fd.append(file.files[0].name, file.files[0]);
        xhr.send(fd);
    }
</script>
</body>
</html>

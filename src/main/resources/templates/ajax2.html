<!DOCTYPE html>
<html>
  <head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>评论框</title>
        <style>
        *{
            margin: 0;
            padding: 0;
        }
        ul,li{
            list-style: none;
        }
        a{
            display: block;
            text-decoration: none;
        }
        .clearfix:after{
            content:".";
            display:block;
            height:0;
            clear:both;
            visibility:hidden;
        }
        .content{
            width: 50%;
            padding: 20px;
            margin: 0 auto;
        }
        .content .article{
            padding: 20px;
            border: 1px solid gray;
        }
        .content .article .username{
            font-size: 18px;
            color: #295c9d;
            font-weight: bolder;
        }
        .content ul{
            clear: both;
            height: 40px;
            line-height: 20px;
            border-bottom: 1px solid #295c9d;
            margin-bottom: 20px;
        }
        .content ul li{
            float: right;
            margin:10px;
            color:#295c9d;
        }
        .content ul li a{
            color:#295c9d;
        }

        #comment{
            display: none;
        }
        #comment textarea{
            width: 100%;
            height: 100px;
            resize: none;
        }
        #comment .publish{
            float: right;
            width: 55px;
            height: 28px;
            line-height: 28px;
            font-size: 14px;
            color: aliceblue;
            background-color: #295c9d;
            border-radius: 2px;
            text-align: center;
        }
    </style>

  </head>
  <body>
  <div class="content">
  
  </div>
  <div id="comment" class="clearfix">
            <textarea name="" id="tests" cols="30" rows="10"></textarea>
            <a class="publish" id="publish">确定</a>
            <button onclick="setDisplay()">取消</button>
        </div>
  <div width="200px" height="200px" background="black" id="text" style="display: none"> test</div>
   <script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
    <script type="text/javaScript">
function tests(){
	document.getElementById("text").style.display="block";
}
	window.onload=function(){
		integralData = {
				tie_list:${tie_list},
				tie_info:${tie_info}
		}
		
		var temphtml ='';
		for(var i=0;i<integralData.tie_list.length;i++){
			temphtml+='<div class="article">';
			temphtml+='<span class="username">'+integralData.tie_list[i].tie_username+'</span>';
			temphtml+=' <p>'+integralData.tie_list[i].tie_neirong+'</p>';
			temphtml+=' </div>';
			temphtml+=' <ul>';
			temphtml+=' <li><a href="#">赞</a></li>';
			temphtml+=' <li><a href="#"  onclick="setComment('+integralData.tie_list[i].main_id+',\''+integralData.tie_list[i].tie_username+'\')">评论</a></li>';
			temphtml+='  <li><a href="#">转发</a></li>';
			temphtml+=' <li><a href="#">收藏</a></li>';
			temphtml+='  </ul>';
			for(var j=0;j<integralData.tie_info.length;j++){
				if(integralData.tie_list[i].main_id==integralData.tie_info[j].tie_id){
					temphtml+=''+integralData.tie_info[j].answer_son+'回复了'+integralData.tie_info[j].answer_father+':'+integralData.tie_info[j].answer_content+'<span onclick="setComment('+integralData.tie_list[i].main_id+',\''+integralData.tie_info[j].answer_son+'\')">回复</span></br>';
				}
			}
		}
			$(".content").html(temphtml);
	}
	
	function setComment(main_id,tie_username){
		
		$("#comment").show();
        // 在点击发表按钮时，提交评论内容到后台
        $("#publish").click(function(){
        	console.log(main_id);
    		console.log(tie_username);
    		console.log($("#tests").val());
         	
    		//ajax传值　
    		　  $.ajax({
  	    	    url:"/comment/commentAnswer",//提交地址
  	    	    type:"POST",
  	    	    dataType: "json",
  	    	    traditional:true,
  	     	    data: {
  	     	    	"main_id":main_id,
  	     	    	"answer_content":$("#tests").val(),
  	     	    	"tie_username":tie_username
  	     	    	},
  	    	    success:function(result){
  	    	    	console.log(1);
  	    	        if (result.code == 1){
  	    	        	alert("yes！");
  	    	        	location.reload();
  	        	    }else{
  	        	    alert("失败！");
  	            }
  	        },
  	     	    	error:function(result){
  	     	    		console.log(2);
  	  	    	        if (result.code == 1){
  	  	    	        	alert("yes！");
  	  	    	        	location.reload();
  	  	        	    }else{
  	  	        	    alert("失败！");
  	  	            }
  	  	        }
  	    }); 
        })
		
    }
	
	</script>
  </body>
</html>



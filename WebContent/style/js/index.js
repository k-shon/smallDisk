//全局变量，第一级文件夹为0，其余赋值为各级文件夹的id
var parent_id = 0;
//显示和隐藏图标 
   function showIcon(obj){
	   $(obj).find("span").show();
   }
   function hideIcon(obj){
	   $(obj).find("span").hide();
   }
   //点击重命名
   function rename(obj){
	   $(obj).parent().siblings('input').show().focus();
	   $(obj).parent().siblings('a').hide();
	}
   //设置文件名
	function getFilename(obj){ 
		//隐藏输入框，显示链接
	    $(obj).hide();
	    $(obj).siblings('a').show();
	    //设置文件名
	    var name = $(obj).siblings('a').text(); //获取a标签中的值
	    var newName = $(obj).val();
	    var directory_id = $(obj).siblings('a').attr('id');
		if(name==""||name==null){
			//a标签为空，则是新建文件夹
			if(newName==""||newName==null){
				//输入框为空则默认命名为"新建文件夹"
				newName="新建文件夹";
			}
			//ajax提交，新建文件夹
			$.post("${pageContext.request.contextPath}/directory_create.action",{'directory_id':directory_id,
				'name':newName,'parent_id':parent_id},function(id){
					$(obj).siblings('a').attr('id',id);
				});
		}
		else{
			//a标签不为空，则是重命名
			$.post("${pageContext.request.contextPath}/directory_update.action",{'directory_id':directory_id,
				'name':newName},function(result){});
		}
		//命名标签a
		$(obj).siblings('a').html(newName);
    }
	//新建文件夹
   function newFile(){
		
	   $(".content-body ul").append('<li class="col" onmouseover="showIcon(this)" onMouseOut="hideIcon(this)">'+
                               '<div class="col-md-6">'+
                                  '<img src="style/images/folder.png"/>'+
								  '<input type="text" class="input" autofocus style="width:130px;height:18px;" onBlur="getFilename(this)"/>'+
                                   '<a id="0" onClick="joinDrectory(this)"></a>'+
                                   '<span class="icon">'+
                                       '<img src="style/images/share.png" class="pull-right"/>'+
                                       '<img src="style/images/upload.png" class="pull-right"/>'+
                                       '<img src="style/images/rename.png" class="pull-right" onClick="rename(this)"/>'+
                                   '</span>'+
                               '</div>'+
                               '<div class="col-md-3">-</div>'+
                               '<div class="col-md-3">2018-06-29</div>'+
                           '</li>');
	   setTimeout($('.input').focus(),100);  //第二条input获取焦点将失效，因为全部语句执行后浏览器才会重绘画面，导致不能正常聚焦，设置延时的作用是让页面重绘
   }

 //进入文件夹
   function joinDrectory(obj){
		//获取当前的文件夹id
		var  directory_id = $(obj).attr('id');
		$.post('${pageContext.request.contextPath}/join_directory.action',{'directory_id':directory_id},function(data){
			//struts.xml中设置返回哪个页面，data就是哪个页面的内容，相当于刷新了一次子页面
			$(".directory_list").html(data);
			//修改父级文件夹的id
			parent_id = directory_id;
		});
	}
   //选择文件
   function selectFile(){
	   $("#file").click();
   }
   //上传文件
   function uploadFile(){
	   $("#uploadForm").submit();
   }
   
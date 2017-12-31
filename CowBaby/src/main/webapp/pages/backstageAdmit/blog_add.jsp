<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 管理者後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="<c:url value="/css/backstageAdmitMainStyle.css"/>">

<!--body-->
<body>
	<section id="container" >
		<!--引入 header-->
		<jsp:include page="/pages/backstageAdmit/header_backstage.jsp"/>
		
		<!--引入 側邊蘭選單-->
		<jsp:include page="/pages/backstageAdmit/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="blog_list">
				<div class="breadcrumb-row">
					<h3>新增文章</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">媽咪推薦</a></li>
					  	<li><a href="#">新增文章</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
	<!--這邊開始寫內容-->
	<div class="container">
		<div class="row">
			<section class="panel"> 
				<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">新增文章</header>
				<div class="panel-body">
					<form class="form-horizontal" id="shopSetForm" enctype="multipart/form-data">
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-label">新增部落客大名</label>
								<div class="col-md-6">
									<input type="text" class="form-control" name="bloggerName">
								</div>
								<span class="col-md-4 text-limit-description">(限制10字內)<span>
							</div>
	
							<div class="form-group col-md-12">
								<label class="col-md-2 control-label">新增文章標題</label>
								<div class="col-md-6">
									<input type="text" class="form-control" name="articleHeader">
								</div>
								<span class="col-md-4 text-limit-description">(限制30字內)<span>
							</div>

							<div class="dash-line col-md-12" /></div>
	
							<div class="form-group col-md-12" style="padding-top: 30px;">
								<label class="col-md-2 control-label">新增文章小圖</label>
								<div class="col-md-2 add-prouduct-list-description">
									<img style="width: 150px; height: 110px" src="<c:url value="/images/emptyImg.jpg"/>" class="previewArticlePhoto">
								</div>
								<div class="col-md-3" style="padding-top: 35px;">
									<input type="file" name="articlePhoto" class="logoUpl" style="margin-bottom: 10px;">
									<span class="pictip">(長寬為1024*768，大小不得超過1M)</span>
								</div>
							</div>						
						</div>
						
							<div class="form-group col-md-12" style="padding-top: 30px;">
									<label class="col-md-2 control-label">新增文章內容</label>
									<div class="col-md-10">
																			<!--註1 對應利用CKeditor的值或是設定預設內容 -->
										<textarea name="articleContent" id="addcontentsaa">${blogData.articleContent}</textarea>
										<script>
											CKEDITOR.replace("addcontentsaa", {
												width : 700
											});
										</script>
									</div>	
								</div>
							</div>
							
					</form>
				<div class="dash-line col-md-12" /></div>
				<button id="add" class="btn btn-primary pull-right" style="margin-top: 15px;">設定儲存</button>
			</div>
			</section>
		</div>
	</div>
	<!--這邊開始寫內容結束-->
	</div>

			<!-- wrapper end -->
      	</section>
      	<!-- main-content end -->
	</section>
	<!-- container end -->
	
 </section>
 	 <!-- overlayPanel--->
	 <div class="qqq">
	</div>
 
	 <!-- 警告視窗--->
	 <div class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	        <h4 class="modal-title">Modal titlasdasd</h4>
	      </div>
	      <div class="modal-body">
	        <p>One fine bodyasdasd…</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div><!-- /.modal-content -->
	   </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->	
</body>
</html>

<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
<script src="<c:url value="/pluging/Bootsrap/bootstrap-datetimepicker.min.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>



<script>
$(function(){
	
	//註1 對應， ckeditor按更新儲存編輯，ID為addcontentsaa 參考網址https://dotblogs.com.tw/bowwowxx/2010/04/01/14349
	$("#add").on('click', function () {
		var sourceInput = CKEDITOR.instances.addcontentsaa.getData();
		$("#addcontentsaa").val(sourceInput);
	})
	
	// side_menu 帳戶總覽填充背景色	
	$(".blog").css({'background':'#3a4152'});
	$(".blog").find('.sub').css({'display':'block'});
	$(".blog").find('.sub a').eq(1).css({'color':'yellow'});
	
	// 設置 loaading圖案
	 $.LoadingOverlaySetup({ 
		/* image : "/CowBaby/src/main/webapp/images/loading_icon.gif", */
		size : "10%"
	 });
	 
	 // 圖片預覽功能
	 $("body").on("change", ".logoUpl", function (){
        preview(this);
    })
    
    $("body").on("change",".bannerUpl", function (){
       preview(this);
    })

    function preview(input) {

       if (input.files && input.files[0]) {
           var reader = new FileReader();
           reader.onload = function (e) {
           	$(input).parent().siblings().eq(1).find('img').attr('src', e.target.result);
           }
           reader.readAsDataURL(input.files[0]);
       }
    }
	
	 // 保存 發AJAX
	 $("#add").on('click', function () {
		 
		 console.log("AAAA");
	
		
		$.ajax({
			url: "http://localhost:8080/CowBaby/Blog/addBlogData", //"http://localhost:8080/CowBaby/service/qoo",
		    type: 'post',
		    cache: false,
		    data: new FormData($('#shopSetForm')[0]),
		    processData: false,
		    contentType: false,
		    
		 	success: function(result){  //處理回傳成功事件，當請求成功後此事件會被呼叫
		       console.log(result);
		     
		       //通知儲存成功  ，call BootstrapDialog      		       
		       BootstrapDialog.show({
	                type: BootstrapDialog.TYPE_INFO,
	                title: "訊息",
	                message: '儲存成功!!',
	                buttons: [{
	                	label: 'Close',
	                    action: function(dialogItself){
	                        dialogItself.close();
	                    }
	                }]
	            });     
		       
		 	},
			error: function(result){  
			     //your code here
			},
			
			statusCode: {               
			     404: function() {
			        alert("page not found");
			     }
			}
		});
	 }) 
})
</script>




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
		
		<!--引入 側邊欄選單-->
		<jsp:include page="/pages/backstageAdmit/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="blog_list">
				<div class="breadcrumb-row">
					<h3>修改文章</h3>
					<ol class="breadcrumb">
						<li><a href="<c:url value='/pages/backstageAdmit/blog_list.jsp'/>">回文章列表</a></li>
					</ol>					  	<li><a href="#">修改文章</a></li>
					</ol>
				</div>
				<div class="row">
					<div class="clear-both"></div>
				</div>
		<!--main-content-->
		<!--主要內容-->
		<!--這邊開始寫內容-->
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">編輯部落格資料</header>
	                        <div class="panel-body">
								<form class="form-horizontal" id="shopSetForm" action="http://localhost:8080/CowBaby/BlogUpdate.controller" method="POST">
									<div class="row">
										<input type="text" style="display:none" name="articleID" value="${blogData.articleID}" />
			                            <!-- 基本資料 -->
			                            <div class="dash-line col-md-12"/></div>
			                            <div class="form-group col-md-12" style="padding-top: 30px">
		                                    <label class="col-md-2 control-label">部落客大名</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="bloggerName" class="form-control" value="${blogData.bloggerName}">
		                                    </div>
		                                </div>
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">文章標題</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" name="articleHeader" class="form-control" value="${blogData.articleHeader}">
		                                    </div>
		                                </div>	
		                                
		                                <div class="dash-line col-md-12" /></div>
										<!-- 編輯部落格小圖用 -->
										<div class="form-group col-md-12" style="padding-top: 30px;">
											<label class="col-md-2 control-label">新增文章小圖</label>
											<div class="col-md-2 add-prouduct-list-description">
												<img style="width: 150px; height: 110px" src="data:image/jpg;base64,${logingPhotoImg}" class="previewArticlePhoto">
											</div>											
											<div class="col-md-3" style="padding-top: 35px;">
												<input type="file" name="articlePhoto" value="" class="logoUpl" style="margin-bottom: 10px;">
												<span class="pictip">(長寬為1024*768，大小不得超過1M)</span>
											</div>
										</div>	
		                             	<!-- 以上編輯部落格小圖用 -->
		                                								
										<div class="form-group col-md-12" style="padding-top: 30px;">
												<label class="col-md-2 control-label">商品詳細說明</label>
												<div class="col-md-10">
																						<!--註1 對應利用CKeditor的值或是設定預設內容 -->
													<textarea name="articleContent" id="contentsaa">${blogData.articleContent}</textarea>
													<script>
														CKEDITOR.replace("contentsaa", {
															width : 700
														});
													</script>
												</div>	
											</div>
										</div>
                                     <input type="button" id="beforePage" class="btn btn-primary pull-left" value="返回查詢頁面" />
		                             <input type="button" id="update" class="btn btn-primary pull-right" value="儲存修改" />
	                              </form>
	                          </div>
	                      	</section>
						</div>
					</div>	
				</div>	
				<!-- 內容結束 -->
			</section>
			<!-- wrapper end -->
      	</section>
      	<!-- main-content end -->
	</section>
	<!-- container end -->
</body>
</html>

<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
<script src="<c:url value="/pluging/Bootsrap/bootstrap-datetimepicker.min.js"/>"></script>


<script>
$(function(){
	// side_menu 帳戶總覽填充背景色	
	$(".blog").css({'background':'#3a4152'});
	$(".blog").find('.sub').css({'display':'block'});
	$(".blog").find('.sub a').eq(2).css({'color':'yellow'});
	// side_menu 帳戶總覽填充背景色
	$(".memberManagment a").addClass('active');
	
	$("#beforePage").on('click', function () {
		window.location.assign('<c:url value="/pages/backstageAdmit/blog_list.jsp" />');
	})
	
	// 圖片預覽功能
		$("body").on("change", ".logoUpl", function (){
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
	
	//註1 對應， ckeditor按更新儲存編輯，ID為contentsaa 參考網址https://dotblogs.com.tw/bowwowxx/2010/04/01/14349
	$("#update").on('click', function () {
		var sourceInput = CKEDITOR.instances.contentsaa.getData();
		$("#contentsaa").val(sourceInput);

		$.ajax({
			type: 'POST',
			url: "http://localhost:8080/CowBaby/Blog/blogDataUpdate", // url: "<c:url value='/service/cutomerDataUpdate' />",

			cache: false,
			processData: false,
			contentType: false,
			data: new FormData($('#shopSetForm')[0]),
			success: function(result){  //處理回傳成功事件，當請求成功後此事件會被呼叫
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
			error: function(result){   //處理回傳錯誤事件，當請求失敗後此事件會被呼叫
				//your code here

			},
			complete: function(result) {

			},
			statusCode: {                     //狀態碼處理
				404: function() {
					alert("page not found");
				}
			}
		});
     
	}) 

})
</script>





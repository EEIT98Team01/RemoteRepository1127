<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 賣家後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet"
	href="<c:url value="/css/backstageSellerMainStyle.css"/>">

<!--body-->
<body>
	<section id="container"> <!--引入 header--> <jsp:include
		page="/pages/backstageSeller/header_backstage.jsp" /> <!--引入 側邊蘭選單-->
	<jsp:include page="/pages/backstageSeller/side_menu.jsp" /> <!--main-content-->
	<!--主要內容--> <section id="main-content"> <section
		class="wrapper">
	<div class="breadcrumb-row">
		<h3>新增商品</h3>
		<ol class="breadcrumb">
			<li><a href="#">商品管理</a></li>
			<li><a href="#">編輯商品</a></li>
		</ol>
	</div>
	<div class="row">
		<div class="clear-both"></div>
	</div>
	<!--這邊開始寫內容-->
	<div class="container">
		<div class="row">
			<section class="panel"> <header
				class="panel-heading product-add-heading"
				style="background:#93bad1;color: #fff; ">編輯商品資訊</header>
			<div class="panel-body">
				<form class="form-horizontal" id="productSetForm" enctype="multipart/form-data"">
					<div class="row">
						<input type="text" name="productID" class="form-control" style="display:none" value="${product.productID}">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">商品名稱</label>
							<div class="col-md-6">
								<input type="text" name="productName" class="form-control" value="${product.title}">
							</div>
							<span class="col-md-4 text-limit-description">(限制30字內)<span>
						</div>	
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">商品摘要</label>
							<div class="col-md-6 add-prouduct-list-description">
								<input type="text" name="productSummary" class="form-control" value="${product.summary}">
							</div>
						</div>
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">商品分類</label>
							<div class="col-md-6">
								<select class="form-control" name="productClassfication">
									<c:forEach var="classfication" items="${classficationList}">
										<c:if test="${classfication.classficationID != product.classficationID}">
											<option value="${classfication.classficationID}">${classfication.classficatoinName}</option>
										</c:if>
										<c:if test="${classfication.classficationID == product.classficationID}">
											<option selected="true" value="${classfication.classficationID}">${classfication.classficatoinName}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="dash-line col-md-12" /></div>

						<div class="form-group col-md-12" style="padding-top: 30px;">
							<label class="col-md-2 control-label">商品價格</label>
							<div class="col-md-6">
								<input type="text" name="productUnitPrice" class="form-control" value="${product.unitPrice}">
							</div>
							<span class="col-md-4 not">元</span>
						</div>
						
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">商品狀態</label>
							<div class="col-md-6">
								<select class="form-control" name="productStatus">
									<option <c:if test="${product.productStatus == false}">selected="true"</c:if> value="0">下架</option>
									<option <c:if test="${product.productStatus == true}">selected="true"</c:if> value="1">上架</option>
								</select>
							</div>
						</div>
						
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">適用年齡</label>
							<div class="col-md-6">
								<select class="form-control" name="suitableAges">
									<option <c:if test="${product.suitableAges == 1}">selected="true"</c:if> value="1">0歲-3歲</option>
									<option <c:if test="${product.suitableAges == 2}">selected="true"</c:if> value="2">3歲-6歲</option>
									<option <c:if test="${product.suitableAges == 3}">selected="true"</c:if> value="3">6歲-9歲</option>
									<option <c:if test="${product.suitableAges == 4}">selected="true"</c:if> value="4">9歲-12歲</option>
								</select>
							</div>
						</div>

						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">適用性別</label>
							<div class="col-md-6">
								<select class="form-control" name="genderPreference">
									<option <c:if test="${product.genderPreference == 'A'}">selected="true"</c:if> value="A">通用</option>
									<option <c:if test="${product.genderPreference == 'M'}">selected="true"</c:if> value="M">男</option>
									<option <c:if test="${product.genderPreference == 'F'}">selected="true"</c:if> value="F">女</option>
								</select>
							</div>
						</div>

						<div class="dash-line col-md-12" /></div>

						<div class="form-group col-md-12" style="padding-top: 30px;">
							<label class="col-md-2 control-label">商品規格1</label>
							<div class="col-md-6">
								<input type="text" name="productSpec" class="form-control" value="${productSize1.productSpec}">
							</div>
						</div>
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">商品庫存1</label>
							<div class="col-md-6">
								<input type="text" name="productStock" class="form-control" value="${productSize1.specStock}">
							</div>
							<span class="col-md-4 not">個</span>
						</div>
						
						<div class="form-group col-md-12" style="padding-top: 30px;">
							<label class="col-md-2 control-label">商品規格2</label>
							<div class="col-md-6">
								<input type="text" name="productSpec" class="form-control" value="${productSize2.productSpec}">
							</div>
						</div>
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">商品庫存2</label>
							<div class="col-md-6">
								<input type="text" name="productStock" class="form-control" value="${productSize2.specStock}">
							</div>
							<span class="col-md-4 not">個</span>
						</div>
						
						<div class="form-group col-md-12" style="padding-top: 30px;">
							<label class="col-md-2 control-label">商品規格3</label>
							<div class="col-md-6">
								<input type="text" name="productSpec" class="form-control" value="${productSize3.productSpec}">
							</div>
						</div>
						<div class="form-group col-md-12">
							<label class="col-md-2 control-label">商品庫存3</label>
							<div class="col-md-6">
								<input type="text" name="productStock" class="form-control" value="${productSize3.specStock}">
							</div>
							<span class="col-md-4 not">個</span>
						</div>

						<div class="dash-line col-md-12" /></div>
						
						<div class="form-group col-md-12" style="padding-top: 30px;">
							<label class="col-md-2 control-label">商品圖示</label>
							<div class="col-md-2 add-prouduct-list-description">
								<img style="width: 150px; height: 110px" src="${product.productImage}" class="previewBanner">
							</div>
	
							<div class="col-md-3" style="padding-top: 35px;">
								<input type="file" name="productImage" class="ImageUpl" style="margin-bottom: 10px;"> 
								<span class="pictip">(長寬為1024*768，大小不得超過1M)</span>
							</div>
						</div>
						
						<div class="form-group col-md-12" style="padding-top: 30px;">
							<label class="col-md-2 control-label">商品說明</label>
							<div class="col-md-10">
								<textarea name="productContents" id="addcontent">${product.productDescription}</textarea>

								<script>
									CKEDITOR.replace("addcontent", {
										width : 700
									});
								</script>
							</div>	
						</div>
					</div>
				</form>

				<button style="margin-right:250px;" class="btn btn-primary" id="beforePage">
					<i class="fa" aria-hidden="true"></i>返回商品列表
				</button>
				<button style="margin-right:250px;" class="btn btn-primary pull-right" id="edit">
					<i class="fa" aria-hidden="true"></i>儲存商品編輯
				</button>
			</div>
			</section>
		</div>
	</div>
	</div>
	<!-- 這邊開始寫內容結束 --> </section> <!-- wrapper end --> </section> <!-- main-content end --> </section>
	<!-- container end -->
</body>
</html>

<!-- javasript pluging link CDN-->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/3.3.4/js/bootstrap-switch.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.7/js/bootstrap-dialog.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
<script src="<c:url value="/pluging/Bootsrap/bootstrap-datetimepicker.min.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/src/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@1.5.4/extras/loadingoverlay_progress/loadingoverlay_progress.min.js"></script>

<script>
	$(function() {

		// side_menu 帳戶總覽填充背景色
		$("#nav-accordion").find('li a').eq(3).addClass('active');
		$("#nav-accordion li a").siblings(".sub").css({
			'display' : 'block'
		});
		$("#nav-accordion li ul").find('a').eq(1).css({
			'color' : 'yellow'
		});
		$("#nav-accordion li").eq(3).css({
			'background' : '#3a4152'
		});

		// 圖片預覽功能
		$("body").on("change", ".ImageUpl", function (){
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
		
		$("#beforePage").on('click', function () {
			window.location.assign('<c:url value="/pages/backstageSeller/ProductList" />');
		})
		
		// 保存 發AJAX
		 $("#edit").on('click', function () {
			// 取得CKEditor值,並回填給textarea
			var sourceInput = CKEDITOR.instances.addcontent.getData();
			$("#addcontent").val(sourceInput);
			
			$.ajax({
				url: "http://localhost:8080/CowBaby/product/editProduct",
			    type: 'post',
			    cache: false,
			    data: new FormData($('#productSetForm')[0]),
			    processData: false,
			    contentType: false,
			    
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
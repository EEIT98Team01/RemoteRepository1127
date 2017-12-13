<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cow baby 賣家後台</title>
<link rel="icon" href="logo.ico">
</head>

<!--css-->
<link rel="stylesheet" href="<c:url value="/css/backstageSellerMainStyle.css"/>">
<!--body-->
<body>
	<section id="container" >
		<!--引入 header-->
		<jsp:include page="/pages/backstageSeller/header_backstage.jsp"/>
		
		<!--引入 側邊蘭選單-->
		<jsp:include page="/pages/backstageSeller/side_menu.jsp"/>
		
		<!--main-content-->
		<!--主要內容-->
     	<section id="main-content">
			<section class="wrapper" id="shop_setting">
				<div class="breadcrumb-row">
					<h3>商店設置</h3>
					<ol class="breadcrumb">
					  	<li><a href="#">商店設置</a></li>
					</ol>
				</div>
				
				<div class="row">
					<div class="clear-both"></div>
				</div>
				<!--這邊開始寫內容-->
				<div class="container">
					<div class="row">
						<section class="panel">
							<header class="panel-heading product-add-heading" style="background:#93bad1;color: #fff; ">商店基本資料</header>
	                        <div class="panel-body">
								<form class="form-horizontal" method="get">
									<div class="row">
										<div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">商店名稱</label>
		                                    <div class="col-md-6">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                    <span class="col-md-4 text-limit-description">(限制30字內)<span>
			                            </div>   
			                            
			                            <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">連絡電話</label>
		                                    <div class="col-md-6">
		                                        <input type="text" class="form-control">
		                                    </div>
		                                    <span class="col-md-4 text-limit-description">(限制10字內)<span>
			                            </div>   
	 
		                                
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">你的區域</label>
		                                    <div class="col-md-6">
		                                        <select class="form-control">
													<option>北部</option>
													<option>中部</option>
													<option>南部</option>
													<option>東部</option>		
												</select>
		                                    </div>  
		                                </div>
		                                
		                                 <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">商店狀態</label>
		                                    <div class="col-md-6">
		                                        <select class="form-control">
													<option>開啟</option>
													<option>關閉</option>		
												</select>
		                                    </div>  
		                                </div>    
		                    
		                                <div class="form-group col-md-12">
		                                    <label class="col-md-2 control-label">店家描述</label>
		                                    <div class="col-md-6 add-prouduct-list-description">
		                                        <input type="text" class="form-control">    
		                                    </div>
		                                    <span class="col-md-4 text-limit-description">(最多只可30字)<span>
		                                </div>
		                                
		                                
		                                <div class="dash-line col-md-12"/></div>
		                                 
		                                <div class="form-group col-md-12" style="padding-top: 30px;">
		                                    <label class="col-md-2 control-label">商店logo</label>
		                                    <div class="col-md-2 add-prouduct-list-description">
		                                           <img style="width:150px;height:110px" src="<c:url value="/images/emptyImg.jpg"/>" class="img-thumbnail">
		                                    </div>
		                                    
		                                    <div class="col-md-3" style="padding-top:35px;">
		                                    	<input type="file" id="aa" style="margin-bottom: 10px;">
		                                     	<span class="pictip">(長寬為1024*768，大小不得超過1M)</span>
                                      		</div>  
 
		                                </div>
		                                
		                                <div class="form-group col-md-12" style="padding-top: 30px;">
		                                    <label class="col-md-2 control-label">商店橫幅</label>
		                                    <div class="col-md-2 add-prouduct-list-description">
		                                           <img style="width:150px;height:110px" src="<c:url value="/images/emptyImg.jpg"/>" class="img-thumbnail">
		                                    </div>
		                                    
		                                    <div class="col-md-3" style="padding-top:35px;">
		                                    	<input type="file" id="aa" style="margin-bottom: 10px;">
		                                     	<span class="pictip">(長寬為1024*768，大小不得超過1M)</span>
                                      		</div>   
		                                </div>
                                     </div>          
	                              </form>
	                              <div class="dash-line col-md-12"/></div>
	                              
	                              <button type="submit" class="btn btn-primary pull-right" style="margin-top: 15px;">設定儲存</button>
	                           </div>
	                      	</section>
						</div>
					</div>	
				<!--這邊開始寫內容結束-->	
				</div>	
			<!--wrapper end-->
			</section>
		<!--main-content end-->
      	</section>
	<!--containe end-->	
	</section>
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
	// side_menu 商店設置填充背景色
	$("#nav-accordion").find('li a').eq(1).addClass('active');
})
</script>




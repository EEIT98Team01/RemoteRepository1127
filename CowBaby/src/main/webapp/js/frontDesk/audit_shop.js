/*店家審核js*/

$(function(){
	// side_menu 帳戶總覽填充背景色
	$(".auditComplaints").css({'background':'#3a4152'});
	$(".auditComplaints").find('.sub').css({'display':'block'});
	$(".auditComplaints").find('.sub a').eq(2).css({'color':'yellow'});
	
	// 設置 loaading icon大小
	$.LoadingOverlaySetup({ size : "10%"});

	// 抓取表單欄位
	var formData ="";
	// 預設當前頁
	var pagenow = 1; 
	// 預設總頁數
	var totalPage = 1; 
	// 預設每頁顯示筆數
	var visiblecount = 10; 
	
	
	// 查詢
	$(".inquire").click(function(){
		event.preventDefault(); 
		console.log("AA")
		 $('.pagination').twbsPagination('destroy');
		// 抓取表單欄位
		formData = $(".audit_shop_form").serializeArray();
	    // 發 ajax 查詢表單資料
		inqueryData(formData , pagenow);
	});
	 
 	 // 查詢表單資料
	 function inqueryData(formData,pageNum){
	 	console.log("********formData***********",formData);
	 	console.log("pageNum",pageNum);
	 	

	 
	   	// 將畫面清空
	   	$('tbody').empty();
	   	
	   	$.ajax({
	        type:"GET",                   
	        url: "http://localhost:8080/CowBaby/SellerAudit/getSellerAuditData",    
	        data: {
	        	 pageSize:visiblecount,
	        	 pageNumber:pageNum, 
	        	 email:formData[0].value,
	        	 processStatus:formData[1].value,	
	        }, 
	         
	        dataType:"json",   
	        
	        // ajax載入前
	       beforeSend: function(){
	        	//顯示laoding 參考網址=>https://gasparesganga.com/labs/jquery-loading-overlay/#quick-demo
	        	$("#audit_shop_List").LoadingOverlay("show");
			}, 
			
			// 成功要做的事
	        success : function(response){ 
	        	
	           // response 回來的字串轉 json物件
	           var obj = JSON.parse(response.list);
	        
	           setTimeout(function(){
	        		$("#audit_shop_List").LoadingOverlay("hide");
	        	},300)	
	           
	           // 組出 列表塞回 table
	           
	           $.each(obj, function (index, item) {
	        	
	        	    // 狀態轉換
	        	    var state="";
	        	    if(item.applicationState==1){
	        	    	state = "<span class='label label-info'>審核中</span>"
					}else if(item.applicationState==2){
						state = "<span class='label label-success'>審核通過</span>"
					}else if(item.applicationState==3){
						state = "<span class='label label-warning'>審核不通過</span>"
					}
	        	    
	        	    // 是可否編輯
	        	    var isEditor="";
	        	    if(item.applicationState==2 || item.applicationState==3){
	        	    	
	        	    	isEditor = "<button type='button' class='btn disabled'><i class='fa fa-pencil'></i></button>"
	        	    }else{
	        	    	isEditor = "<a href='#' class='btn btn-primary audit_popupbox_btn'><i class='fa fa-pencil'></i></a>"	    	
	        	    }
	        	 
	        	    
	        	    // 是否有備註
	        	    var isNote="";
	        	    if(item.applicationDescription=="undefined" || item.applicationDescription==undefined){
	        	    	
	        	    	isNote = ""
	        	    }else{
	        	    	isNote = item.applicationDescription
	        	    }
	        	    
	        	    // 組HTML塞回TABLE
	           	    var html="";
	           	    
	 		    	html="<tr>"+
 							"<td>"+(index+1+ (response.pageSize*(response.pageNumber-1)))+"</td>" +
 							"<td>"+item.email+"</td>" +
 							"<td>"+item.applicationDate+"</td>"+
 							"<td>"+ state +"</td>"+
 							"<td>"+ isEditor +"</td>"+	
 							"<td>"+ isNote +"</td>"+
 							"<td style='display:none;'>"+item.applicationID+"</td>"+
						 "</tr>";
	 
 		    		$('tbody').append(html);
	           })
	            
	          	    
         		// 自動產生分頁
	            var totalPages = response.tatalPage;
	            var pageSize  = response.pageSize;
 
 				if(!totalPages==0){
 				// 如果查詢有資料
				   $('.pagination').twbsPagination({
		                  totalPages: totalPages,
		                  visiblePages: pageSize,
		                  
		                  onPageClick: function (evt, page) { 
		                	  
							 inqueryData(formData,page);
			       	　　　　 }
	                });
 				  
					// 把頁數 ，筆數，開始筆數-結束筆數 塞回去
		            $(".pageNum").html(response.pageNumber);
		            $(".firstNum").html( ((response.pageNumber-1)*response.pageSize) +1);
		            $(".endNum").html(response.pageNumber*response.pageSize);
		            $(".totalNum").html(response.tatal);
				  
 				}else{
 			 	// 如果查詢無資料	
 					$(".pageNum").html(0);
 		            $(".firstNum").html(0);
 		            $(".endNum").html(0);
 		            $(".totalNum").html(0);
 		            $('tbody').html('<tr><td colspan="10">目前無任何資料</td></tr>');	
 				}
  
	        },

			// 發ajax錯誤
	        error:function(xhr, ajaxOptions, thrownError){
	            alert(xhr.status+"\n"+thrownError);
	        }

    	});

	}
 	
 	// 申訴審核彈出框
 	$('body').on('click','.audit_popupbox_btn',function () {
 		
 		var emailId = $(this).parents('tr').find('td').eq(1).text();
 		var id = $(this).parents('tr').find('td').eq(6).text();

 		console.log(emailId)
 		console.log(id)
 		
 		
 		BootstrapDialog.show({
 			 message: $('<div></div>').load('../common/audit_sellers.jsp'),
             title:"申請審核",
             buttons: [{
 		                label: '確定',
 		                // no title as it is optional
 		                cssClass: 'btn-primary',
 		                action: function(dialogItself){
 		                	// 抓取裡面表單資料
 		                	formData = $(".seller_audit_popupForm").serializeArray();
 		                	changeAuditStatus(formData,emailId,id);
 		                	dialogItself.close();
 		                   
 		                }
 		            },{
 		                label: '取消',
 		                action: function(dialogItself){
 		                    dialogItself.close();
 		               }
 		            }]
 	     });
	});
 	
 	//改變審核狀態
 	function changeAuditStatus(formData,emailId,id){
 		
 		$.ajax({
	        type:"GET",                   
	        url: "http://localhost:8080/CowBaby/SellerAudit/updateSellerAuditStatus",    
	        data: {
	        	 applicationID:id, 
	        	 email:emailId,
	        	 processStatus:formData[0].value,	
	        	 applicationDescription:formData[1].value,
	        }, 
	         
	        dataType:"json",          
			// 成功要做的事
	        success : function(response){
	        	var myformData = $(".audit_shop_form").serializeArray();
	        	inqueryData(myformData,1);

	        }
 		})         
 	} 


})

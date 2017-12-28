/*call shopping cart API*/
/*取的頁面上購物車裡面的商品，每頁都要發AJAX*/
var ShoppingCatAPI = function(productID,productSpec,quantity){
	
	var url = "";
	var type = "";
	
	if(productID=="" &&  productSpec=="" && quantity==""){
		//獲取購物車內商品
		url = "http://localhost:8080/CowBaby/shopping/getShoppingCart";
		type="get";
			
	}else{
		//增加購物車內商品
		url = "http://localhost:8080/CowBaby/shopping/addShoppingCart";
		type="post";
	}
	
	$.ajax({
		url: url,
		type: type,
		data:{
		    productID:productID,
			spec:productSpec,
			productNum:quantity

		},
		dataType:"json",   
		success: function(result){ 
			console.log(result); 
		    console.log(result.productInfo);
		    
		    var productInfor = result.productInfo;
		    var totalAmount = result.totalAmount;
		    var totalItems = result.totalItems;
		    var item="";
		    
		    // 把每ㄧ筆店家所購買的物品列出來 (key = 商店名子,productInfor = 在該商店購買的物品 )
		    for(var key in productInfor){
		       for(var i =0 ; i<productInfor[key].length ; i++){
		        	
		       		item  = item +"<li>"+
		        			"<img src='<c:url value='/images/ad1.jpg'/>'>"+
							"<div class='cartList'>"+
								"<p>"+ key +"</p>"+
								"<p>"+ productInfor[key][i].productName + "<span>-"+ productInfor[key][i].productSpec+"</span></p>"+
								"<p>"+ productInfor[key][i].unitPrice +"元 X"+ productInfor[key][i].quantity +"</p>"+
							"</div>"+
							"</li>" 
		         } 

		    }
		    
		  /*   "<p>數量-2</p>"+ */
		    $(".currentShoppingCartList ul").empty();
		    $(".currentShoppingCartList ul").append(item);

		    

		},
		error: function(result){  
		     //your code here
		}

	}) 
}	



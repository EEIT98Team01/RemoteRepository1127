package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.service.Order01Service;

@Controller
public class Order01ManagementController {
	
	@Autowired
	private Order01Service order01Service;
	
	@RequestMapping(
			value=("Order01List.controller"),    //對應到JSP order_list, "識別字串"要跟JSP對應
			method={RequestMethod.GET, RequestMethod.POST}
	)
						//Client端送資料過來，從請求裡面把需要的值拿出來  等於Servlet getParameter key 
						//eg:POST 10個參數，要寫10個 request.getParameter...Spring幫我們做掉了			
	public String list(Model model, String orderID, String orderStatus, String startTime, String endTime) {
		
		System.out.println(orderID);
		System.out.println(orderStatus);

	//讀取使用者輸入資料
	//進行必要的資料型態轉換
	//進行資料檢查
	//進行商業服務
		
		//處理orderStatus的5種狀況
		if("全部".equals(orderStatus)) {
			orderStatus = null;
		} else if("未處理".equals(orderStatus)) {
			orderStatus = "1";
		} else if("撿貨中".equals(orderStatus)) {
			orderStatus = "2";
		} else if("送貨中".equals(orderStatus)) {
			orderStatus = "3";
		} else if("已完成".equals(orderStatus)) {
			orderStatus = "4";
		}
		
		if("".equals(orderID)) {
			orderID = null;
		}
		
		if("".equals(startTime)) {
			startTime = null;
		} else {
			String[] temp = startTime.split("/");
			startTime = temp[2] + "/" + temp[0] + "/" + temp[1];
		}
		
		if("".equals(endTime)) {
			startTime = null;
		} else {
			String[] temp = endTime.split("/");
			endTime = temp[2] + "/" + temp[0] + "/" + temp[1];
		}
		
		
	
		if(orderID == null && orderStatus == null && (endTime == null || startTime == null)) {
			model.addAttribute("order01List", order01Service.find());   //"order01List" 要跟JSP對應
		} else {
			model.addAttribute("order01List", order01Service.findByCondition(orderID, orderStatus, startTime, endTime));  //"order01List" 要跟JSP對應
		}
		
		//依照執行結果挑選適當的View元件
		return "order01_list";  //"order01_list 要跟view對應
	}
		public String edit(Model model, String orderStatus) {
			System.out.println("edit");																//id改為orderStatus
//			model.addAttribute("orderStatusData", order01Service.findById(Integer.parseInt(orderStatus)));
			return "order01_managment_edit";
	}
}

package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.OrderDetailBean;
import model.service.Order01Service;
import model.service.OrderDetailService;

@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private Order01Service order01service;
	
	@RequestMapping(
			value=("OrderDetailList.controller"),
			method={RequestMethod.GET})		
									//客戶端選點後，因為要從order_list送 orderID 過來orderDetail
	public String list(Model model, int orderID) {
		
		List<OrderDetailBean> orderDetailList = orderDetailService.findByCondition(orderID);
		
		System.out.println(orderDetailList);
		//把東西放到request裡面 ()    識別字串                                     因要orderID所以用orderDetailList
		model.addAttribute("orderDetail_list", orderDetailList);
		model.addAttribute("orderID", orderID);
		
		return "orderDetail_list";  //識別字串要放在view裡面喔
	}
}

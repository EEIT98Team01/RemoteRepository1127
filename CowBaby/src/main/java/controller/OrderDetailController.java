package controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.OrderDetailBean;
import model.service.Order01Service;
import model.service.OrderDetailService;
import model.service.ProductManagmentService;
import model.service.SellerBackstageManageService;

@Controller
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private Order01Service order01service;
	@Autowired
	private ProductManagmentService productManagmentService;
	@Autowired
	private SellerBackstageManageService sellerBackstageManageService;
	
	@RequestMapping(
			value=("OrderDetailList.controller"),
			method={RequestMethod.GET})		
									//客戶端選點後，因為要從order_list送 orderID 過來orderDetail
	public String list(Model model, int orderID) {
		
		List<OrderDetailBean> orderDetailListTemp = orderDetailService.findByCondition(orderID);
		System.out.println("orderID:" + orderID);
		System.out.println("orderDetailListTemp:" + orderDetailListTemp);
		//把東西放到request裡面 ()    識別字串                                     因要orderID所以用orderDetailList
		
		List<Object[]> orderDetailList = new LinkedList<Object[]>();
		for(OrderDetailBean orderDetail: orderDetailListTemp) {
			Object[] temp = new Object[5];
			temp[0] = orderDetail.getTitle();
			temp[1] = productManagmentService.findById(orderDetail.getProductID()).getProductImage();
			temp[2] = orderDetail.getQuantity();
			temp[3] = orderDetail.getProductSpec();
			temp[4] = orderDetail.getUnitPrice();
			orderDetailList.add(temp);
		}
		

		model.addAttribute("orderDetail_list", orderDetailList);
		model.addAttribute("orderID", orderID);
		
		return "orderDetail_list";  //識別字串要放在view裡面喔
	}
	
	@RequestMapping(
			value=("/pages/member/orderDetail"),
			method={RequestMethod.GET}
	)		
	public String orderDetail(Model model, int orderID) {
		List<OrderDetailBean> orderDetailListTemp = orderDetailService.findByCondition(orderID);
		System.out.println("orderID:" + orderID);
		System.out.println("orderDetailListTemp:" + orderDetailListTemp);
		//把東西放到request裡面 ()    識別字串                                     因要orderID所以用orderDetailList
		
		List<Object[]> orderDetailList = new LinkedList<Object[]>();
		for(OrderDetailBean orderDetail: orderDetailListTemp) {
			Object[] temp = new Object[6];
			temp[0] = orderDetail.getTitle();
			temp[1] = productManagmentService.findById(orderDetail.getProductID()).getProductImage();
			temp[2] = orderDetail.getQuantity();
			temp[3] = orderDetail.getProductSpec();
			temp[4] = orderDetail.getUnitPrice();
			temp[5] = orderDetail.getProductID();
			orderDetailList.add(temp);
		}

		model.addAttribute("orderDetail_list", orderDetailList);
		model.addAttribute("orderData", order01service.findById(orderID));
		model.addAttribute("store", sellerBackstageManageService.getStoreData(order01service.findById(orderID).getStoreID()));
		
		return "customer_Order_Detail";
	}
}

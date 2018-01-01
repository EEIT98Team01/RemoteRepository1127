package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.CustomerServiceBean;
import model.bean.Order01Bean;
import model.bean.OrderDetailBean;
import model.service.Order01Service;
import model.service.OrderDetailService;
import model.service.ProductManagmentService;
import model.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private Order01Service order01service;
	@Autowired
	private ProductManagmentService productManagmentService;

	// 後台Blog檢視使用
	@RequestMapping(value = ("/pages/backstageSeller/orderView"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, String id) {
		if (id != null && !"".equals(id.trim())) {
			model.addAttribute("orderData", order01service.findById(Integer.parseInt(id)));

			List<OrderDetailBean> orderDetailListTemp = orderDetailService.findByCondition(Integer.parseInt(id));
			System.out.println("orderID:" + id);
			System.out.println("orderDetailListTemp:" + orderDetailListTemp);
			// 把東西放到request裡面 () 識別字串 因要orderID所以用orderDetailList

			List<Object[]> orderDetailList = new LinkedList<Object[]>();
			for (OrderDetailBean orderDetail : orderDetailListTemp) {
				Object[] temp = new Object[5];
				temp[0] = orderDetail.getTitle();
				temp[1] = productManagmentService.findById(orderDetail.getProductID()).getProductImage();
				temp[2] = orderDetail.getQuantity();
				temp[3] = orderDetail.getProductSpec();
				temp[4] = orderDetail.getUnitPrice();
				orderDetailList.add(temp);
			}

			model.addAttribute("orderDetail_list", orderDetailList);
		} // ↑識別字串
		return "order_view"; // ← 要放view用
	}
	
	//order編輯
	@RequestMapping(value = ("OrderUpdate.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String orderupdate(Model model, int orderID, String status) {
		System.out.println(status);

		int statuss = -1;
		if ("未處理".equals(status)) {
			statuss = 1;
		} else if ("檢貨中".equals(status)) {
			statuss = 2;
		} else if ("送貨中".equals(status)) {
			statuss = 3;
		} else if ("已完成".equals(status)) {
			statuss = 4;
		}

		if (status == null || status.trim().length() == 0) {
			return "order_update_success";
		} else {
			Map<String, String> condition = new HashMap<String, String>();
			if (statuss != -1) {
				Order01Bean aa = order01service.findById(orderID);
				aa.setStatus(statuss);

				order01service.updateCustomerData(aa);
			}
		}
		return "order_update_success";
	}
}

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
public class OrderController {

	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private Order01Service order01service;
	
	// 後台Blog檢視使用
	@RequestMapping(value = ("/pages/backstageSeller/orderView"), method = { RequestMethod.GET,
			RequestMethod.POST })
	public String view(Model model, String id) {
		if (id != null && !"".equals(id.trim())) {
			model.addAttribute("orderData", order01service.findById(Integer.parseInt(id)));
		}						//↑識別字串

		return "order_view"; //← 要放view用
	}		
}

package controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.ClassficationBean;
import model.service.ClassficationService;

@Controller
public class LoingOutController {
	@Autowired
	ClassficationService classficationService;

	@RequestMapping(value = ("LoingOutController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model,HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("shoppingCart");
		 
		return "logout_success";
	}
}

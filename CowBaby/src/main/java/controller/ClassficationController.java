package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.ClassficationBean;
import model.service.ClassficationService;

@Controller
public class ClassficationController {
	@Autowired
	ClassficationService classficationService;

	@RequestMapping(
			value=("ClassficationController"),
			method={RequestMethod.GET, RequestMethod.POST}
	)
	public String view(Model model, String toys, String books, String clothes, String shoes, String groceries) {
		System.out.println(model);
		System.out.println("123456");
		
		if ((toys == null || "".equals(toys.trim())) && (books == null || "".equals(books.trim()))
				&& (clothes == null || "".equals(clothes.trim())) && (shoes == null || "".equals(shoes.trim()))
				&& (groceries == null || "".equals(groceries.trim()))) {
			model.addAttribute("classficationData", classficationService.find());
		}

		return "product_managment_view";
	}
}

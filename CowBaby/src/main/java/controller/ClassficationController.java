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

	@RequestMapping(value = ("ClassficationController"), method = { RequestMethod.GET, RequestMethod.POST })
	public String view(Model model, String classficatoinName) {
		System.out.println(classficatoinName);

		if (classficatoinName == null || "".equals(classficatoinName.trim())) {
			model.addAttribute("ClassficationList", classficationService.find());
		} else {
			model.addAttribute("ClassficationList", classficationService.findByCondition(classficatoinName));
		}
		return "product_managment_view";
	}

	@RequestMapping(value = ("ficationControllerinsert"), method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(Model model, String classficatoinName, String ClassificationDescription, boolean StartStopStatus) {
		System.out.println(classficatoinName);
		System.out.println(ClassificationDescription);
		System.out.println(StartStopStatus);

		if ((classficatoinName == null) || ("".equals(classficatoinName.trim())) && 
		   (ClassificationDescription == null) || "".equals(ClassificationDescription.trim()))
		 {
			return "product_managment_insert";
		} else {
			ClassficationBean bean = new ClassficationBean();
			bean.setClassficatoinName(classficatoinName);
			bean.setClassificationDescription(ClassificationDescription);
			bean.setStartStopStatus(StartStopStatus);
			classficationService.insertStoreData(bean);
		}
		return "product_managment_insert";
	}
}

package controller;

import java.util.HashMap;
import java.util.Map;

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
	public String insert(Model model, String classficatoinName, String ClassificationDescription,
			boolean StartStopStatus) {
		System.out.println(classficatoinName);
		System.out.println(ClassificationDescription);
		System.out.println(StartStopStatus);

		if ((classficatoinName == null) || ("".equals(classficatoinName.trim())) && (ClassificationDescription == null)
				|| "".equals(ClassificationDescription.trim())) {
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

	// 商品分類編輯
	@RequestMapping(value = ("ficationupdate.controller"), method = { RequestMethod.GET, RequestMethod.POST })
	public String ficationunameupdate(Model model, int classficationID, String classficatoinName,
			String classificationDescription, String startStopStatus) {
		System.out.println(classficationID);
		System.out.println(classficatoinName);
		System.out.println(classificationDescription);
		System.out.println(startStopStatus);

		int status = -1;
		if ("玩具".equals(classficatoinName)) {
			status = 1;
		} else if ("圖書".equals(classficatoinName)) {
			status = 2;
		} else if ("衣服".equals(classficatoinName)) {
			status = 3;
		} else if ("鞋子".equals(classficatoinName)) {
			status = 4;
		} else if ("日用品".equals(classficatoinName)) {
			status = 5;
		}

		ClassficationBean bean = classficationService.getStoreData(classficationID);

		if ((classficatoinName == null) || (classficatoinName.trim().length() == 0)) {
			;
		} else {
			if (status != -1) {
				bean.setClassficatoinName(classficatoinName);
			}
		}

		if ((classificationDescription == null) || (classificationDescription.trim().length() == 0)) {
			;
		} else {
			bean.setClassificationDescription(classificationDescription);
		}

		if ((startStopStatus == null)) {
			;
		} else {
			if ("true".equals(startStopStatus)) {
				bean.setStartStopStatus(true);
			} else {
				bean.setStartStopStatus(false);
			}
		}

		classficationService.updateStoreData(bean);

		return "product_managment_view";
	}
}

package test.classfication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.ClassficationBean;

public class TestCustomerManagementService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		ClassficationService service = (ClassficationService) context.getBean(ClassficationService.class);
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(service.getClassficationData(1));
		*/
		
	  //find()
		/*
		for(ClassficationBean bean: service.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(CustomerBean bean: service.find(2, 10)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(CustomerBean bean: service.find(2, 10, "CustomerName")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String account, String userType, String clusterID)
		
		for(ClassficationBean bean: service.findByCondition(null, "'玩具'")) {
			System.out.println(bean);
		}
		
		
	  //findByCondition(String account, String userType, String clusterID, int page, int rows)
		/*
		for(CustomerBean bean: service.findByCondition("Allen", "1", null, 2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String account, String userType, String clusterID, int page, int rows, String sortCondition)
		/*
		for(CustomerBean bean: service.findByCondition("Allen", "1", null, 1, 3, "customerName")) {
			System.out.println(bean);
		}
		*/
		
	  //getQuantity()
		/*
		System.out.println(service.getQuantity());
		*/
		
	  //getConditionQuantity(String account, String userType, String clusterID)
		
//		System.out.println(service.getConditionQuantity("Allen", "1", null));
		
		
		
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}
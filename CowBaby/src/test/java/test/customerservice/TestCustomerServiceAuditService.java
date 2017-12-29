package test.customerservice;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.CustomerServiceBean;

public class TestCustomerServiceAuditService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		CustomerServiceAuditService service = (CustomerServiceAuditService) context.getBean(CustomerServiceAuditService.class);
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(service.findById(8));
		*/
		
	  //find()
		/*
		for(CustomerServiceBean bean: service.find()) {
			System.out.println(bean);
		}
		*/
		
	  //insert
		/*
		CustomerServiceBean bean = new CustomerServiceBean();
		bean.setProblemTypes(1);
		bean.setEmail("s730530@gmail.com");
		bean.setProblemDescription("安安");
		bean.setServiceFeedback("你好");
		bean.setProcessStatus(2);
		System.out.println(service.insertStoreData(bean));
		*/
		
	  //Update
		CustomerServiceBean update = service.getReprotData(2);
		update.setProblemDescription("3317868367723873");
		service.updateCustomerData(update);
		
	  //find(int page, int rows)
		/*
		for(CustomerServiceBean bean: service.find(1, 5)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(CustomerServiceBean bean: service.find(1, 3, "processStatus")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String problemTypes, String processStatus, String customerID)
		/*
		for(CustomerServiceBean bean: service.findByCondition("s730530@gmail.com", "2", null)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String problemTypes, String processStatus, String customerID, int page, int rows)
		/*
		for(CustomerServiceBean bean: service.findByCondition(null, "3", null, 2, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String problemTypes, String processStatus, String customerID, int page, int rows, String sortCondition)
		/*
		for(CustomerServiceBean bean: service.findByCondition(null, "3", null, 1, 5, "customerID")) {
			System.out.println(bean);
		}
		*/
		
	  //getQuantity()
		/*
		System.out.println(service.getQuantity());
		*/
		
	  //getConditionQuantity(String problemTypes, String processStatus, String customerID)
		/*
		System.out.println(service.getReview(1, 2, "s730530@gmail.com"));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}

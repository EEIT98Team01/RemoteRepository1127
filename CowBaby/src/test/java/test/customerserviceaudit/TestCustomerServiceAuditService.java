package test.customerserviceaudit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomerServiceAuditService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		CustomerServiceAuditService service = (CustomerServiceAuditService) context.getBean(CustomerServiceAuditService.class);
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(service.findById(6));
		*/
		
	  //find()
		/*
		for(CustomerServiceBean bean: service.find()) {
			System.out.println(bean);
		}
		*/
		
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
		for(CustomerServiceBean bean: service.findByCondition(null, null, "33")) {
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
		
		System.out.println(service.getConditionQuantity("1", null, null));
		
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}

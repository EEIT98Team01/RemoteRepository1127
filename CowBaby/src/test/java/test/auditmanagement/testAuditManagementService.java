package test.auditmanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.customer.CustomerManagementService;

public class testAuditManagementService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
		/*---------------------------------------------------------------------------------------------*/
			
		// 依照要測試的對象進行修改
			AuditManagementService service = (AuditManagementService) context.getBean(AuditManagementService.class);
			
		// 測試內容
		  
			service.findCustomerService("Allen", null, null, 1, 100, "reportID");
			
		/*---------------------------------------------------------------------------------------------*/
			((ConfigurableApplicationContext) context).close();
	}

}

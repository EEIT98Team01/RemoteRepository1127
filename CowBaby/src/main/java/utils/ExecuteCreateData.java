package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecuteCreateData {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
		
		DataManagementService service = (DataManagementService) context.getBean("dataManagementService");
		service.createCustomersData(500);
		
		((ConfigurableApplicationContext) context).close();
	}

}

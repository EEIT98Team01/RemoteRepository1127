package test.auditmanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.BackstageBean;

public class testAuditManagementService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
		/*---------------------------------------------------------------------------------------------*/
			
		// 依照要測試的對象進行修改
			AuditManagementService service = (AuditManagementService) context.getBean(AuditManagementService.class);
			
		// 測試內容
		  // findCustomerServiceById(int id)
			/*
			System.out.println(service.findCustomerServiceById(3));
			*/
			
		  // findCustomerService(String account, String processStatus, String problemTypes, int page, int rows, String sortCondition)
			/*
			for(CustomerServiceBean bean: service.findCustomerService("555", "", "", 1, 99, "processStatus desc")) {
				System.out.println(bean);
			}
			*/

		  // updateCustomerService(CustomerServiceBean bean)
			/*
			CustomerServiceBean bean = new CustomerServiceBean();
			bean.setReportID(1);
			bean.setProblemTypes(1);
			bean.setEmail("999@gmail.com");
			bean.setProblemDescription("賣假貨");
			bean.setServiceFeedback(null);
			bean.setProcessStatus(2);
			bean.setReportTime(new java.util.Date("2017/11/11 05:41:32"));
			bean.setReportiInProcess(new java.util.Date("2017/11/17 05:41:32"));
			bean.setReportFix(null);
			service.updateCustomerService(bean);
			*/
			
			
		  // findAdvertisementById(int id)
			/*
			System.out.println(service.findAdvertisementById(2));
			*/
			
		  // findAdvertisement(String account, String adState, int page, int rows, String sortCondition)
			/*
			for(AdvertisementBean bean: service.findAdvertisement("1", "4", 1, 99, "AdFee desc ,orderAdTime")) {
				System.out.println(bean);
			}
			*/
			
			
		  // findAdvertisementDetail(String adId, String sortCondition)
			/*
			for(AdvertisementDetailBean bean: service.findAdvertisementDetail("2", "DisplayAdTime desc")) {
				System.out.println(bean);
			}
			*/
			
			
		  // findBackstageById(int id)
			/*
			System.out.println(service.findBackstageById(2));
			*/
			
		  // findBackstage(String account, String applicationState, int page, int rows, String sortCondition)
			
			for(BackstageBean bean: service.findBackstage("", "", 2, 2, "email")) {
				System.out.println(bean);
			}
			
			
		/*---------------------------------------------------------------------------------------------*/
			((ConfigurableApplicationContext) context).close();
	}

}

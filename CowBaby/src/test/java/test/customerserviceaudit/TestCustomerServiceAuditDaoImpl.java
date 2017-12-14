package test.customerserviceaudit;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.CustomerServiceBean;
import model.dao.CustomerServiceAuditDao;

public class TestCustomerServiceAuditDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		CustomerServiceAuditDao dao = (CustomerServiceAuditDao) context.getBean("customerServiceAuditDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(6));
		*/
		
	  //update(CustomerServiceBean bean)
		/*
		CustomerServiceBean bean = new CustomerServiceBean();
		bean.setReportID(6);
		bean.setProblemTypes(2);
		bean.setProblemDescription("帳號消失了....");
		bean.setServiceFeedback("客服消失了....");
		bean.setProcessStatus(3);
		bean.setReportTime(new Timestamp((new Date("2017/12/10 13:54:11")).getTime()));
		bean.setReportiInProcess(new Timestamp((new Date("2017/12/11 14:55:22")).getTime()));
		bean.setReportFix(new Timestamp((new Date()).getTime()));
		dao.update(bean);
		*/
		
	  //find()
		/*
		for(CustomerServiceBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(CustomerServiceBean bean: dao.find(2, 4)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(CustomerServiceBean bean: dao.find(1, 5, "customerID")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("problemTypes", "= 2");
		condition.put("processStatus", "= 3");
		for(CustomerServiceBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("problemTypes", "= 2");
		for(CustomerServiceBean bean: dao.findByCondition(condition, 1, 5)) {
			System.out.println(bean);
		}
		
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("problemTypes", "= 1");
		for(CustomerServiceBean bean: dao.findByCondition(condition, 1, 5, "customerID")) {
			System.out.println(bean);
		}
		*/
		
	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("problemTypes", "= 2");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

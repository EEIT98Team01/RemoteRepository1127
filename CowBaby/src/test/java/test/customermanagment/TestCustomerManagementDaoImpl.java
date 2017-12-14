package test.customermanagment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.CustomerBean;
import model.dao.CustomerManagementDao;

public class TestCustomerManagementDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		CustomerManagementDao dao = (CustomerManagementDao) context.getBean("customerManagementDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		 System.out.println(dao.findById(10));
		*/
		
	  //update(CustomerBean bean)
		/*
		CustomerBean bean = new CustomerBean();
		bean.setCustomerID(10);
		bean.setEmail("test@gmail.com");;
		dao.update(bean);
		*/
		
	  //find()
		
		for(CustomerBean bean: dao.find()) {
			System.out.println(bean);
		}
		
		
	  //find(int page, int rows)
		/*
		for(CustomerBean bean: dao.find(1, 999)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(CustomerBean bean: dao.find(2, 300, "customerName")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerName", "like '%Harry%'");
		condition.put("customerID", "= 42");
		for(CustomerBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerName", "like '%Harry%'");
		for(CustomerBean bean: dao.findByCondition(condition, 2, 5)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerName", "like '%Harry%'");
		for(CustomerBean bean: dao.findByCondition(condition, 2, 5, "email")) {
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
		condition.put("customerName", "like '%Harry%'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

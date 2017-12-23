package test.backstage;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.BackstageBean;
import model.dao.BackstageDao;

public class TestBackstageDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		BackstageDao dao = (BackstageDao) context.getBean("backstageDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(2));
		*/

	  //insert(BackstageBean bean)
		/*
		BackstageBean bean = new BackstageBean();
		bean.setCustomerID(4);
		bean.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/12/16 20:05:44").getTime()));
		bean.setApplicationState(2);
		bean.setApplicationDescription(null);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(BackstageBean bean)
		/*
		BackstageBean bean = new BackstageBean();
		bean.setApplicationID(3);
		bean.setCustomerID(3);
		bean.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/12/16 15:05:44").getTime()));
		bean.setApplicationState(2);
		bean.setApplicationDescription(null);
		dao.update(bean);
		*/
		
	  //find()
		/*
		for(BackstageBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(BackstageBean bean: dao.find(2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(BackstageBean bean: dao.find(2, 3, "customerID")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("applicationState", "= 4");
		condition.put("applicationDate", "between '2017-12-16 14:00:00' AND '2017-12-16 22:00:00'");
		for(BackstageBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("applicationState", "= 4");
		condition.put("applicationDate", "between '2017-12-16 14:00:00' AND '2017-12-16 22:00:00'");
		for(BackstageBean bean: dao.findByCondition(condition, 2, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("applicationState", "= 4");
		condition.put("applicationDate", "between '2017-12-16 14:00:00' AND '2017-12-16 22:00:00'");                  
		for(BackstageBean bean: dao.findByCondition(condition, 1, 999, "applicationState")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("applicationDate", "between '2016-12-16 14:00:00' AND '2017-12-16 22:00:00'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

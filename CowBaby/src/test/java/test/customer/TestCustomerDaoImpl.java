package test.customer;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.CustomerBean;
import model.dao.CustomerDao;

public class TestCustomerDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		CustomerDao dao = (CustomerDao) context.getBean("customerDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(6));
		*/

	  //insert(CustomerBean bean)
		/*
		CustomerBean bean = new CustomerBean();
		bean.setCustomerID(10);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(CustomerBean bean)
		/*
		CustomerBean bean = new CustomerBean();
		bean.setCustomerID(6);
		bean.setCustomerName("好想睡");
		bean.setPassword("MD5");
		bean.setEmail("test@gmail.com");;
		dao.update(bean);
		*/
		
	  //find()
		/*
		for(CustomerBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
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
		condition.put("email", "like '%AllenLewis75129@gmail.com%'");
		//condition.put("customerID", "= 369");
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
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("address", "like '%士林區%'");
		                               
		for(CustomerBean bean: dao.findByCondition(condition, 1, 999, "customerID")) {
			System.out.println(bean);
		}
		

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

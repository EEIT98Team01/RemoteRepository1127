package test.order01;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.Order01Bean;
import model.dao.Order01Dao;

public class TestOrder01DaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		Order01Dao dao = (Order01Dao) context.getBean("order01DaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/
		
	  //insert(Order01Bean bean)
		/*
		Order01Bean bean = new Order01Bean();
		bean.setCustomerID(2);
		bean.setOrderDate(new java.sql.Timestamp(new java.util.Date("2017/12/13 15:22:33").getTime()));
		bean.setAcceptDate(new java.sql.Timestamp(new java.util.Date("2017/12/14 18:22:33").getTime()));
		bean.setBuyerRequestCancel(null);
		bean.setShippedDate(new java.sql.Timestamp(new java.util.Date("2017/12/15 18:22:33").getTime()));
		bean.setTransactionComplete(null);
		bean.setOrderCancellation(null);
		bean.setPickUpStore("台雞店");
		bean.setTotalAmount(3000);
		bean.setTotalItems(3);
		bean.setReceiverName("陳宸晨");
		bean.setReceiverEmail("ekdsf@gmail.com");
		bean.setReceiverPhone("0998-555-676");
		bean.setUsebonus(0);
		bean.setStoreID(1);
		bean.setStatus(3);
		bean.setPaymentMethod(1);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(Order01Bean bean)
		/*
		Order01Bean bean = new Order01Bean();
		bean.setOrderID(3);
		bean.setCustomerID(2);
		bean.setOrderDate(new java.sql.Timestamp(new java.util.Date("2017/12/13 15:22:33").getTime()));
		bean.setAcceptDate(new java.sql.Timestamp(new java.util.Date("2017/12/14 18:22:33").getTime()));
		bean.setBuyerRequestCancel(null);
		bean.setShippedDate(new java.sql.Timestamp(new java.util.Date("2017/12/15 18:22:33").getTime()));
		bean.setTransactionComplete(new java.sql.Timestamp(new java.util.Date("2017/12/16 18:22:33").getTime()));
		bean.setOrderCancellation(null);
		bean.setPickUpStore("台雞店");
		bean.setTotalAmount(3000);
		bean.setTotalItems(3);
		bean.setReceiverName("陳宸晨");
		bean.setReceiverEmail("ekdsf@gmail.com");
		bean.setReceiverPhone("0998-555-676");
		bean.setUsebonus(0);
		bean.setStoreID(1);
		bean.setStatus(4);
		bean.setPaymentMethod(1);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(Order01Bean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(Order01Bean bean: dao.find(2, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(Order01Bean bean: dao.find(1, 3, "pickUpStore")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 2");
		condition.put("status", "=4");
		for(Order01Bean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 2");
		condition.put("status", "=4");
		for(Order01Bean bean: dao.findByCondition(condition, 1, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 2");
		//condition.put("status", "=4");   
		for(Order01Bean bean: dao.findByCondition(condition, 1, 999, "status desc")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 2");
		//condition.put("status", "=4");   
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

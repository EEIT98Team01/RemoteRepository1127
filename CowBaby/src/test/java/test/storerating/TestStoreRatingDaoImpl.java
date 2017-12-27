package test.storerating;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.StoreRatingBean;
import model.dao.StoreRatingDao;

public class TestStoreRatingDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		StoreRatingDao dao = (StoreRatingDao) context.getBean("storeRatingDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(StoreRatingBean bean)
		/*
		StoreRatingBean bean = new StoreRatingBean();
		bean.setCustomerID(3);
		bean.setStoreID(2);
		bean.setRatingScore(5);
		bean.setRatingTime(new java.sql.Timestamp(new java.util.Date("2017/12/15 13:11:22").getTime()));
		System.out.println(dao.insert(bean));
		*/
		
	  //update(StoreRatingBean bean)
		/*
		StoreRatingBean bean = new StoreRatingBean();
		bean.setRatingID(4);
		bean.setCustomerID(3);
		bean.setStoreID(2);
		bean.setRatingScore(1);
		bean.setRatingTime(new java.sql.Timestamp(new java.util.Date("2017/12/16 13:11:22").getTime()));
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(StoreRatingBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(StoreRatingBean bean: dao.find(1, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(StoreRatingBean bean: dao.find(1, 3, "ratingScore")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 2");
		condition.put("ratingScore", ">= 4");
		for(StoreRatingBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 2");
		condition.put("ratingScore", ">= 4");
		for(StoreRatingBean bean: dao.findByCondition(condition, 1, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 2");
		condition.put("ratingScore", ">= 4");     
		for(StoreRatingBean bean: dao.findByCondition(condition, 1, 2, "ratingTime desc")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 2");
		//condition.put("ratingScore", ">= 4"); 
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

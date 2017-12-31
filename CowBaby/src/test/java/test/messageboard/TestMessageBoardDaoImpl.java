package test.messageboard;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.MessageBoardBean;
import model.dao.MessageBoardDao;

public class TestMessageBoardDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		MessageBoardDao dao = (MessageBoardDao) context.getBean("messageBoardDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(4));
		*/

	  //insert(MessageBoardBean bean)
		/*
		MessageBoardBean bean = new MessageBoardBean();
		bean.setStoreID(1);
		bean.setCustomerID(3);
		bean.setProductID(2);
		bean.setMessageTopic("有更大的尺寸嗎");
		bean.setMessageTime(new java.sql.Timestamp(new java.util.Date("2017/12/17 15:23:10").getTime()));
		System.out.println(dao.insert(bean));
		*/
		
	  //update(MessageBoardBean bean)
		/*
		MessageBoardBean bean = new MessageBoardBean();
		bean.setMessageID(4);
		bean.setStoreID(1);
		bean.setCustomerID(3);
		bean.setProductID(2);
		bean.setMessageTopic("請問這個好吃嗎");
		bean.setMessageTime(new java.sql.Timestamp(new java.util.Date("2017/12/17 15:23:15").getTime()));
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(MessageBoardBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(MessageBoardBean bean: dao.find(1, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(MessageBoardBean bean: dao.find(1, 3, "customerID")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 3");
		condition.put("productID", "= 3");
		for(MessageBoardBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 3");
		//condition.put("productID", "= 3");
		for(MessageBoardBean bean: dao.findByCondition(condition, 2, 2)) {
			System.out.println(bean);
		}
		
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 3");
		//condition.put("productID", "= 3");
		for(MessageBoardBean bean: dao.findByCondition(condition, 1, 2, "MessageTopic")) {
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
		condition.put("customerID", "= 3");
		//condition.put("productID", "= 3"); 
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

package test.messageboarddetail;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.MessageBoardDetailBean;
import model.dao.MessageBoardDetailDao;

public class TestMessageBoardDetailDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		MessageBoardDetailDao dao = (MessageBoardDetailDao) context.getBean("messageBoardDetailDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(MessageBoardDetailBean bean)
		/*
		MessageBoardDetailBean bean = new MessageBoardDetailBean();
		bean.setMessageID(1);
		bean.setMessageTime(new java.sql.Timestamp(new java.util.Date("2017/12/18 09:11:22").getTime()));
		bean.setMessageContent("嘻嘻");
		bean.setCustomerID(5);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(BlogBean bean)
		/*
		MessageBoardDetailBean bean = new MessageBoardDetailBean();
		bean.setMessageDetailID(5);
		bean.setMessageID(1);
		bean.setMessageTime(new java.sql.Timestamp(new java.util.Date("2017/12/18 11:11:22").getTime()));
		bean.setMessageContent("科科");
		bean.setCustomerID(5);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(MessageBoardDetailBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(MessageBoardDetailBean bean: dao.find(1, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(MessageBoardDetailBean bean: dao.find(1, 99, "customerID")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 3");
		condition.put("messageContent", "like '%寶寶%'");
		for(MessageBoardDetailBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 3");
		//condition.put("messageContent", "like '%寶寶%'");
		for(MessageBoardDetailBean bean: dao.findByCondition(condition, 2, 1)) {
			System.out.println(bean);
		}
		
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("customerID", "= 3");
		//condition.put("messageContent", "like '%寶寶%'");
		for(MessageBoardDetailBean bean: dao.findByCondition(condition, 1, 999, "messageContent")) {
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
		//condition.put("messageContent", "like '%寶寶%'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

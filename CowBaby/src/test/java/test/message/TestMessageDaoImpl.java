package test.message;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.MessageBean;
import model.dao.MessageDao;

public class TestMessageDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		MessageDao dao = (MessageDao) context.getBean("messageDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(MessageBean bean)
		/*
		MessageBean bean = new MessageBean();
		bean.setMsgSenderID(3);
		bean.setMsgReceiverID(5);
		bean.setMsgTime(new java.sql.Timestamp(new java.util.Date("2017/12/21 08:12:12").getTime()));
		bean.setReadStatus(false);
		bean.setMsgContent("不讀不回?");
		bean.setMsgResponse(null);
		bean.setMsgMarker(false);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(MessageBean bean)
		/*
		MessageBean bean = new MessageBean();
		bean.setMsgID(5);
		bean.setMsgSenderID(3);
		bean.setMsgReceiverID(5);
		bean.setMsgTime(new java.sql.Timestamp(new java.util.Date("2017/12/21 08:12:12").getTime()));
		bean.setReadStatus(true);
		bean.setMsgContent("不讀不回?");
		bean.setMsgResponse("咬我阿，笨蛋");
		bean.setMsgMarker(true);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(MessageBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(MessageBean bean: dao.find(2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(MessageBean bean: dao.find(1, 3, "msgContent")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("msgMarker", "= 0");
		condition.put("msgSenderID", "= 3");
		for(MessageBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("msgMarker", "= 0");
		condition.put("msgSenderID", "= 1");
		for(MessageBean bean: dao.findByCondition(condition, 1, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("msgMarker", "= 0");
		condition.put("msgSenderID", "= 1");  
		for(MessageBean bean: dao.findByCondition(condition, 2, 2, "readStatus")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("msgMarker", "= 0");
		condition.put("msgSenderID", "= 1");  
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

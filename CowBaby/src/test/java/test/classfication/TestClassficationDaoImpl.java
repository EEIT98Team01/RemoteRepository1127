package test.classfication;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.ClassficationBean;
import model.dao.ClassficationDao;

public class TestClassficationDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		ClassficationDao dao = (ClassficationDao) context.getBean("classficationDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(ClassficationBean bean)
		/*
		ClassficationBean bean = new ClassficationBean();
		bean.setClassficatoinName("模型");
		bean.setClassificationDescription("磨練心智");
		bean.setStartStopStatus(true);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(ClassficationBean bean)
		/*
		ClassficationBean bean = new ClassficationBean();
		bean.setClassficationID(6);
		bean.setClassficatoinName("模型");
		bean.setClassificationDescription("保護眼睛，鞏固牙齒");
		bean.setStartStopStatus(false);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(ClassficationBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(ClassficationBean bean: dao.find(1, 4)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(ClassficationBean bean: dao.find(1, 5, "startStopStatus")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("startStopStatus", "= 1");
		condition.put("classficationID", "= 5");
		for(ClassficationBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("startStopStatus", "= 1");
		//condition.put("classficationID", "= 5");
		for(ClassficationBean bean: dao.findByCondition(condition, 2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("startStopStatus", "= 1");
		//condition.put("classficationID", "= 5");     
		for(ClassficationBean bean: dao.findByCondition(condition, 1, 3, "classificationDescription")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("startStopStatus", "= 1");
		condition.put("classficationID", "= 5");    
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

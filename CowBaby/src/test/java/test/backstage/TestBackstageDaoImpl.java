package test.backstage;

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
//第一筆		
		BackstageBean bean = new BackstageBean();
		bean.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/10/10 20:05:44").getTime()));
		bean.setApplicationState(1);
		bean.setEmail("VinceClarke41956@gmail.com");
		bean.setApplicationDescription("等主管確認");
		System.out.println(dao.insert(bean));
//第二筆
		BackstageBean bean1 = new BackstageBean();
		bean1.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/11/12 20:05:44").getTime()));
		bean1.setApplicationState(2);
		bean.setEmail("VivianThompson2527@gmail.com");
		bean1.setApplicationDescription(null);
		System.out.println(dao.insert(bean1));
		/*
//第三筆
		BackstageBean bean11 = new BackstageBean();
		bean11.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/12/13 20:05:44").getTime()));
		bean11.setApplicationState(3);
		bean.setEmail("din003@yahoo.com");
		bean11.setApplicationDescription("審核完成了喔沒問題");
		System.out.println(dao.insert(bean11));
//第四筆
		BackstageBean bean111 = new BackstageBean();
		bean111.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/09/09 20:05:44").getTime()));
		bean111.setApplicationState(4);
		bean.setEmail("din004@yahoo.com");
		bean111.setApplicationDescription(null);
		System.out.println(dao.insert(bean111));
//第五筆
		BackstageBean bean1111 = new BackstageBean();
		bean1111.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/08/08 20:05:44").getTime()));
		bean1111.setApplicationState(1);
		bean.setEmail("din005@yahoo.com");
		bean1111.setApplicationDescription(null);
		System.out.println(dao.insert(bean1111));
//第六筆
		BackstageBean bean11111 = new BackstageBean();
		bean11111.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/07/15 20:05:44").getTime()));
		bean11111.setApplicationState(2);
		bean.setEmail("din006@yahoo.com");
		bean11111.setApplicationDescription(null);
		System.out.println(dao.insert(bean11111));
//第七筆
		BackstageBean bean111111 = new BackstageBean();
		bean111111.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/07/20 20:05:44").getTime()));
		bean111111.setApplicationState(3);
		bean.setEmail("din007@yahoo.com");
		bean111111.setApplicationDescription(null);
		System.out.println(dao.insert(bean111111));
//第八筆
		BackstageBean bean1111111 = new BackstageBean();
		bean1111111.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/06/16 20:05:44").getTime()));
		bean1111111.setApplicationState(4);
		bean.setEmail("din008@yahoo.com");
		bean1111111.setApplicationDescription(null);
		System.out.println(dao.insert(bean1111111));
//第九筆
		BackstageBean bean11111111 = new BackstageBean();
		bean11111111.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/05/05 20:05:44").getTime()));
		bean11111111.setApplicationState(1);
		bean.setEmail("din009@yahoo.com");
		bean11111111.setApplicationDescription(null);
		System.out.println(dao.insert(bean11111111));
//第十筆
		BackstageBean bean111111111 = new BackstageBean();
		bean111111111.setApplicationDate(new java.sql.Timestamp(new java.util.Date("2017/04/04 20:05:44").getTime()));
		bean111111111.setApplicationState(2);
		bean.setEmail("din0010@yahoo.com");
		bean111111111.setApplicationDescription("在檢查一下");
		System.out.println(dao.insert(bean111111111));*/
		
	  //update(BackstageBean bean)
		/*
		BackstageBean bean = new BackstageBean();
		bean.setApplicationID(3);
		bean.setApplicationID(3);
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
/*		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("applicationState", "= 4");
		condition.put("applicationDate", "between '2017-12-16 14:00:00' AND '2017-12-16 22:00:00'");                  
		for(BackstageBean bean: dao.findByCondition(condition, 1, 999, "applicationState")) {
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
		condition.put("applicationDate", "between '2016-12-16 14:00:00' AND '2017-12-16 22:00:00'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

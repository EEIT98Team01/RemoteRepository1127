package test.pageview;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.PageViewBean;
import model.dao.PageViewDao;

public class TestPageViewDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		PageViewDao dao = (PageViewDao) context.getBean("pageViewDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(PageViewBean bean)
		/*
		PageViewBean bean = new PageViewBean();
		bean.setStoreID(1);
		bean.setPageViewsDate(new java.sql.Timestamp(new java.util.Date("2017/08/05").getTime()));
		bean.setPageViews(456);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(PageViewBean bean)
		/*
		PageViewBean bean = new PageViewBean();
		bean.setPageViewsID(5);
		bean.setStoreID(1);
		bean.setPageViewsDate(new java.sql.Timestamp(new java.util.Date("2017/08/05").getTime()));
		bean.setPageViews(32);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(PageViewBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(PageViewBean bean: dao.find(2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(PageViewBean bean: dao.find(1, 3, "PageViews desc")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("pageViews", "> 55");
		condition.put("PageViewsDate", "between '2017-08-02' AND '2017-08-03'");
		for(PageViewBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("pageViews", "> 55");
		//condition.put("PageViewsDate", "between '2017-08-02' AND '2017-08-03'");
		for(PageViewBean bean: dao.findByCondition(condition, 2, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("pageViews", "> 55");   
		for(PageViewBean bean: dao.findByCondition(condition, 2, 2, "PageViews desc")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("pageViews", "> 55");
		condition.put("PageViewsDate", "between '2017-08-02' AND '2017-08-03'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

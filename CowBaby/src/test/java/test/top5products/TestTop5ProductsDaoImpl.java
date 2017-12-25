package test.top5products;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.Top5ProductsBean;
import model.dao.Top5ProductsDao;

public class TestTop5ProductsDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		Top5ProductsDao dao = (Top5ProductsDao) context.getBean("top5ProductsDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(Top5ProductsBean bean)
		/*
		Top5ProductsBean bean = new Top5ProductsBean();
		bean.setStoreID(1);
		bean.setMonthlyTime(new java.sql.Timestamp(new java.util.Date("2017/11/01").getTime()));
		bean.setTop1Product(1);
		bean.setTop2Product(3);
		bean.setTop3Product(1);
		bean.setTop4Product(4);
		bean.setTop5Product(2);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(Top5ProductsBean bean)
		/*
		Top5ProductsBean bean = new Top5ProductsBean();
		bean.setTop5ProductID(7);
		bean.setStoreID(1);
		bean.setMonthlyTime(new java.sql.Timestamp(new java.util.Date("2017/11/01").getTime()));
		bean.setTop1Product(2);
		bean.setTop2Product(1);
		bean.setTop3Product(1);
		bean.setTop4Product(3);
		bean.setTop5Product(4);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(Top5ProductsBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(Top5ProductsBean bean: dao.find(2, 4)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(Top5ProductsBean bean: dao.find(2, 3, "top1Product")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 1");
		condition.put("monthlyTime", "between '2017/08/01' AND '2017/09/01'");
		for(Top5ProductsBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 1");
		condition.put("monthlyTime", "between '2017/08/01' AND '2017/11/01'");
		for(Top5ProductsBean bean: dao.findByCondition(condition, 2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 1");
		condition.put("monthlyTime", "between '2017/08/01' AND '2017/11/01'");
		for(Top5ProductsBean bean: dao.findByCondition(condition, 2, 2, "top2Product desc")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeID", "= 1");
		condition.put("monthlyTime", "between '2017/08/01' AND '2017/11/01'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

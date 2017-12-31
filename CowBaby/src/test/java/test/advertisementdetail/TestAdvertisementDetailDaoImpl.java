package test.advertisementdetail;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.AdvertisementDetailBean;
import model.dao.AdvertisementDetailDao;

public class TestAdvertisementDetailDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		AdvertisementDetailDao dao = (AdvertisementDetailDao) context.getBean("advertisementDetailDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(6));
		*/

	  //insert(AdvertisementDetailBean bean)
		/*
		AdvertisementDetailBean bean = new AdvertisementDetailBean();
		bean.setAdID(3);
		bean.setAdPurchasedState(true);
		bean.setDisplayAdTime(new java.sql.Timestamp(new java.util.Date("2017/12/14").getTime()));
		System.out.println(dao.insert(bean));
		*/
		
	  //update(AdvertisementDetailBean bean)
		/*
		AdvertisementDetailBean bean = new AdvertisementDetailBean();
		bean.setAdDetailID(6);
		bean.setAdID(3);
		bean.setAdPurchasedState(true);
		bean.setDisplayAdTime(new java.sql.Timestamp(new java.util.Date("2017/12/11").getTime()));
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(AdvertisementDetailBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(AdvertisementDetailBean bean: dao.find(2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(AdvertisementDetailBean bean: dao.find(1, 3, "displayAdTime")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adPurchasedState", "= 1");
		condition.put("displayAdTime", "between '2017-12-11' AND '2017-12-13'");
		for(AdvertisementDetailBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adPurchasedState", "= 1");
		condition.put("displayAdTime", "between '2017-12-11' AND '2017-12-13'");
		for(AdvertisementDetailBean bean: dao.findByCondition(condition, 2, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adPurchasedState", "= 1");
		condition.put("displayAdTime", "between '2017-12-10' AND '2017-12-20'");                   
		for(AdvertisementDetailBean bean: dao.findByCondition(condition, 2, 5, "displayAdTime desc")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adPurchasedState", "= 1");
		condition.put("displayAdTime", "between '2017-12-10' AND '2017-12-15'");    
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

package test.advertisement;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.AdvertisementBean;
import model.dao.AdvertisementDao;

public class TestAdvertisementDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		AdvertisementDao dao = (AdvertisementDao) context.getBean("advertisementDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(3));
		*/

	  //insert(AdvertisementBean bean)
		/*
		AdvertisementBean bean = new AdvertisementBean();
		bean.setStoreID(1);
		bean.setAdState(4);
		bean.setOrderAdTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		bean.setAdFee(1500);
		bean.setAdPackage(2);
		System.out.println(dao.insert(bean));
		*/
		
	  //update(AdvertisementBean bean)
		/*
		AdvertisementBean bean = new AdvertisementBean();
		bean.setAdID(4);
		bean.setStoreID(1);
		bean.setAdState(4);
		bean.setOrderAdTime(new java.sql.Timestamp(new java.util.Date().getTime()));
		bean.setAdFee(900);
		bean.setAdPackage(1);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(AdvertisementBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(AdvertisementBean bean: dao.find(2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(AdvertisementBean bean: dao.find(1, 3, "adFee")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adState", "= 4");
		condition.put("adID", "= 3");
		for(AdvertisementBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adState", "= 4");
		condition.put("adFee", "= 1500");
		for(AdvertisementBean bean: dao.findByCondition(condition, 3, 1)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adState", "= 4");
		condition.put("adFee", "= 1500");                     
		for(AdvertisementBean bean: dao.findByCondition(condition, 2, 2, "adFee")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("adState", "= 4");
		condition.put("adFee", "= 1500");   
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

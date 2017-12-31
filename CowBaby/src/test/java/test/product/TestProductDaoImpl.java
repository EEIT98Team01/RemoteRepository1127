package test.product;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.ProductBean;
import model.dao.ProductDao;

public class TestProductDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		ProductDao dao = (ProductDao) context.getBean("productDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

//		private int productID;
//		private int storeID;
//		private String title;
//		private String summary;
//		private int unitPrice;
//		private String productDescription;
//		private boolean productStatus; 				// type改bit
//		private int classficationID;
//		private int suitableAges; 					// type改tinyint
//		private String genderPreference;
//		private java.sql.Timestamp displayTime;
//		private String productImage;
		
	  //insert(ProductBean bean)
		
		ProductBean bean = new ProductBean();
		bean.setStoreID(2);
		bean.setTitle("牛牛娃娃");
		bean.setSummary("牛牛娃娃寶寶1");
		bean.setUnitPrice(66);
		bean.setProductDescription("噹噹噹");
		bean.setProductStatus(true);
		bean.setClassficationID(2);
		bean.setSuitableAges(2);
		bean.setGenderPreference("M");
		bean.setDisplayTime(new java.sql.Timestamp(new java.util.Date("2017/11/11 08:11:31").getTime()));
		bean.setProductImage("123.jpg");
		System.out.println(dao.insert(bean));
		
		
		
		
	  //update(ProductBean bean)
		/*
		ProductBean bean = new ProductBean();
		bean.setProductID(3);
		bean.setStoreID(1);
		bean.setTitle("三字經");
		bean.setSummary("學童必備");
		bean.setUnitPrice(66);
		bean.setProductDescription("人之初,性本惡");
		bean.setProductStatus(true);
		bean.setClassficationID(2);
		bean.setSuitableAges(2);
		bean.setGenderPreference("M");
		bean.setDisplayTime(new java.sql.Timestamp(new java.util.Date("2017/11/10 08:11:31").getTime()));
		bean.setProductImage("1234.jpg");
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		
//		for(ProductBean bean: dao.find()) {
//			System.out.println(bean);
//		}
		
		
	  //find(int page, int rows)
		/*
		for(ProductBean bean: dao.find(1, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(ProductBean bean: dao.find(2, 3, "classficationID")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("unitPrice", "< 10000");
		condition.put("title", "like '%百首%'");
		for(ProductBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("unitPrice", "< 10000");
		//condition.put("title", "like '%百首%'");
		for(ProductBean bean: dao.findByCondition(condition, 1, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
//		HashMap<String, String> condition = new HashMap<String, String>();
//		condition.put("unitPrice", "< 10001");
//		//condition.put("title", "like '%百首%'"); 
//		for(ProductBean bean: dao.findByCondition(condition, 1, 999, "classficationID")) {
//			System.out.println(bean);
//		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("unitPrice", "< 10000");
		condition.put("title", "like '%百首%'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

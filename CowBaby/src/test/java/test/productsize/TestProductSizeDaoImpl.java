package test.productsize;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.ProductSizeBean;
import model.dao.ProductSizeDao;

public class TestProductSizeDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		ProductSizeDao dao = (ProductSizeDao) context.getBean("productSizeDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/
	
	  //insert(ProductSizeBean bean)
		
		ProductSizeBean bean = new ProductSizeBean();
		bean.setProductID(6);
		bean.setProductSpec("qq糖大");
		bean.setSpecStock(11);
		System.out.println(dao.insert(bean));
		
		
	  //update(ProductSizeBean bean)
		/*
		ProductSizeBean bean = new ProductSizeBean();
		bean.setProductSizeID(5);
		bean.setProductID(3);
		bean.setProductSpec("平裝");
		bean.setSpecStock(10);
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(ProductSizeBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(ProductSizeBean bean: dao.find(2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(ProductSizeBean bean: dao.find(1, 3, "specStock")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("specStock", "< 50");
		condition.put("productSpec", "like '22黑'");
		for(ProductSizeBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("specStock", "< 50");
		//condition.put("productSpec", "like '22黑'");
		for(ProductSizeBean bean: dao.findByCondition(condition, 1, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
//		HashMap<String, String> condition = new HashMap<String, String>();
//		condition.put("specStock", "< 50");
//		//condition.put("productSpec", "like '22黑'");     
//		for(ProductSizeBean bean: dao.findByCondition(condition, 1, 2, "specStock")) {
//			System.out.println(bean);
//		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("specStock", "< 50");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

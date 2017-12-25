package test.orderdetail;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.OrderDetailBean;
import model.dao.OrderDetailDao;

public class TestOrderDetailDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		OrderDetailDao dao = (OrderDetailDao) context.getBean("orderDetailDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(OrderDetailBean bean)
		/*
		OrderDetailBean bean = new OrderDetailBean();
		bean.setOrderID(3);
		bean.setProductID(4);
		bean.setUnitPrice(10000);
		bean.setQuantity(7);
		bean.setTitle("我是一件DinDin書喔");
		bean.setProductSpec("精裝");
		System.out.println(dao.insert(bean));
		*/
		
	  //update(OrderDetailBean bean)
		/*
		OrderDetailBean bean = new OrderDetailBean();
		bean.setOrderDetailID(3);
		bean.setOrderID(3);
		bean.setProductID(4);
		bean.setUnitPrice(10000);
		bean.setQuantity(100);
		bean.setTitle("我是一件DinDin書喔");
		bean.setProductSpec("平裝");
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(OrderDetailBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(OrderDetailBean bean: dao.find(2, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(OrderDetailBean bean: dao.find(2, 2, "quantity")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("productID", "= 3");
		condition.put("productSpec", "like '%紅%'");
		for(OrderDetailBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		//condition.put("productID", "= 3");
		condition.put("productSpec", "like '%紅%'");
		for(OrderDetailBean bean: dao.findByCondition(condition, 1, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		//condition.put("productID", "= 3");
		condition.put("productSpec", "like '%紅%'");     
		for(OrderDetailBean bean: dao.findByCondition(condition, 1, 999, "quantity")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		//condition.put("productID", "= 3");
		condition.put("productSpec", "like '%紅%'");  
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

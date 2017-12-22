package test.sellerBackstageManage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.SellerBackstageManageBean;
import model.dao.SellerBackstageManageDao;


public class TestSellerBackstageManageDaoImpl {

	public static void main(String[] args) throws IOException, SerialException, SQLException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		SellerBackstageManageDao dao = (SellerBackstageManageDao) context.getBean("sellerBackstageManageDaoImpl");
			
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(SellerBackstageManageBean bean)
		/*
		SellerBackstageManageBean bean = new SellerBackstageManageBean();
		bean.setStoreName("我是測試唷");
		bean.setCustomerID(4);
		bean.setStoreStatus(true);
		bean.setStorePhone("0987666444");
		bean.setStoreDescription("測測的店唷");
		bean.setStoreRating(0);
		bean.setStoreBanner("789.jpg");
		bean.setStoreLogo(null);
		bean.setTotalPageView(111111);
		System.out.println(dao.insert(bean));
		*/
			
	  //update(SellerBackstageManageBean bean)
		/*
		SellerBackstageManageBean bean = new SellerBackstageManageBean();
		bean.setStoreID(2);
		bean.setStoreName("小測的店唷");
		bean.setCustomerID(4);
		bean.setStoreStatus(true);
		bean.setStorePhone("0987666444");
		bean.setStoreDescription("測測的店唷");
		bean.setStoreRating(0);
		bean.setStoreBanner("789.jpg");
		bean.setStoreLogo(null);
		bean.setTotalPageView(111111);
		System.out.println(dao.update(bean));
		*/
			
	  //find()
		/*
		for(SellerBackstageManageBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
			
	  //find(int page, int rows)
		/*
		for(SellerBackstageManageBean bean: dao.find(1, 3)) {
			System.out.println(bean);
		}
		*/
			
	  //find(int page, int rows, String sortCondition)
		/*
		for(SellerBackstageManageBean bean: dao.find(2, 1, "customerID")) {
			System.out.println(bean);
		}
		*/
			
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeName", "like '%的店%'");
		condition.put("totalPageView", "> 100");
		for(SellerBackstageManageBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
			
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeName", "like '%的店%'");
		//condition.put("totalPageView", "> 100");
		for(SellerBackstageManageBean bean: dao.findByCondition(condition, 2, 1)) {
			System.out.println(bean);
		}
		*/
			
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeName", "like '%的店%'");
		for(SellerBackstageManageBean bean: dao.findByCondition(condition, 1, 999, "totalPageView desc")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
			
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("storeName", "like '%測%'");
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
		/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();

	}

}

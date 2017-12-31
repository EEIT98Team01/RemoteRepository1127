package test.blog;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.BlogBean;
import model.service.BlogService;

public class TestCustomerManagementService {

	public static void main(String[] args) throws IOException, SerialException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		BlogService service = (BlogService) context.getBean(BlogService.class);
		
	// 測試內容
		
		// 新增Blog資料
		//insert(AdvertisementBean bean)
		
//		BlogBean bean = new BlogBean();
//		BlogDao dao = new BlogDao();
//		bean.setArticlePhoto(null);
//		bean.setBloggerName("im Name");
//		bean.setArticleHeader("im header");
//		bean.setArticleContent("im content");
//		System.out.println(dao.insert(bean));
		
		
		BlogBean bean = new BlogBean();	
		bean.setBloggerName("name");
		bean.setArticlePhoto(null);
		bean.setArticleHeader("im header");
		bean.setArticleContent("im content");

		System.out.println(bean);
		System.out.println(service.insert(bean));
		
		
	  //findById(int id)
		/*
		System.out.println(service.findById(1));
		*/
		
	  //find()
		/*
		for(CustomerBean bean: service.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(CustomerBean bean: service.find(2, 10)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(CustomerBean bean: service.find(2, 10, "CustomerName")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String account, String userType, String clusterID)
		/*
		for(CustomerBean bean: service.findByCondition("Allen", "1", null)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String account, String userType, String clusterID, int page, int rows)
		/*
		for(CustomerBean bean: service.findByCondition("Allen", "1", null, 2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(String account, String userType, String clusterID, int page, int rows, String sortCondition)
		/*
		for(CustomerBean bean: service.findByCondition("Allen", "1", null, 1, 3, "customerName")) {
			System.out.println(bean);
		}
		*/
		
	  //getQuantity()
		/*
		System.out.println(service.getQuantity());
		*/
		
	  //getConditionQuantity(String account, String userType, String clusterID)
		
	//	System.out.println(service.getConditionQuantity("Allen", "1", null));
		
		
		
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}

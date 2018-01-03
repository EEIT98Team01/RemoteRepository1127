package test.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.ProductBean;

public class TestCustomerManagementService {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		ProductService service = (ProductService) context.getBean(ProductService.class);
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(service.findById(1));
		*/
		
		//insert(AdvertisementBean bean)
				
//		ProductBean bean = new ProductBean();
//		bean.setTitle("勇者達鋼");
//		bean.setAdState(4);
//		bean.setOrderAdTime(new java.sql.Timestamp(new java.util.Date().getTime()));
//		bean.setAdFee(1500);
//		bean.setAdPackage(2);
//		System.out.println(dao.insert(bean));
		
		
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
		
		for(ProductBean bean: service.findBycommodity("唐")) {
			System.out.println(bean);
		}
		
		
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
		
//		System.out.println(service.getConditionQuantity("Allen", "1", null));
		
		
		
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}

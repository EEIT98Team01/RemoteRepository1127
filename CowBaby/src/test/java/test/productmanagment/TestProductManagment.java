package test.productmanagment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.ProductBean;

public class TestProductManagment {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
		/*---------------------------------------------------------------------------------------------*/
			
		// 依照要測試的對象進行修改
		ProductManagmentService service = (ProductManagmentService) context.getBean(ProductManagmentService.class);
			
		// 測試內容
		  // findById(int id)
			/*
			System.out.println(service.findById(5));
			*/
		
		  // ProductBean insertProduct(ProductBean bean)
//			
//			ProductBean insert = new ProductBean();
//			insert.setStoreID(1);
//			insert.setTitle("牛牛娃娃");
//			insert.setSummary("牛牛娃娃寶寶9");
//			insert.setUnitPrice(66);
//			insert.setProductDescription("噹噹噹");
//			insert.setProductStatus(true);
//			insert.setClassficationID(2);
//			insert.setSuitableAges(2);
//			insert.setGenderPreference("M");
//			insert.setDisplayTime(new java.sql.Timestamp(new java.util.Date("2017/11/11 08:11:31").getTime()));
//			insert.setProductImage("123.jpg");
//			service.insertProduct(insert);
//			
			
		  // updateProdcut(ProductBean bean)
			/*
			ProductBean update = new ProductBean();
			update.setProductID(14);
			update.setStoreID(2);
			update.setTitle("牛牛娃娃-威力加強版");
			update.setSummary("超強牛寶寶");
			update.setUnitPrice(666);
			update.setProductDescription("噹噹噹噹");
			update.setProductStatus(true);
			update.setClassficationID(2);
			update.setSuitableAges(2);
			update.setGenderPreference("M");
			update.setDisplayTime(new java.sql.Timestamp(new java.util.Date("2017/11/11 09:11:31").getTime()));
			update.setProductImage("123.jpg");
			service.updateProdcut(update);
			*/
			
		  // List<ProductBean> findProduct(String storeId, String productName, String productClassfication, 
		  //                               String suitableAges, String genderPreference, String productStatus, 
		  //                               int page, int rows, String sortCondition)
			
			for(ProductBean bean: service.findProduct("", "Iphone", "", "", "", "1", 1, 10, "displayTime desc")) {
				System.out.println(bean);
			}
			
			
		/*---------------------------------------------------------------------------------------------*/
			((ConfigurableApplicationContext) context).close();
	}

}

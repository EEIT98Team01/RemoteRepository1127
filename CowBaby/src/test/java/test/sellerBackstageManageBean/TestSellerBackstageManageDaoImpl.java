package test.sellerBackstageManageBean;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import model.bean.SellerBackstageManageBean;
import model.dao.SellerBackstageManageDao;


public class TestSellerBackstageManageDaoImpl {

	public static void main(String[] args) throws IOException, SerialException, SQLException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		/*---------------------------------------------------------------------------------------------*/
		System.out.println("QQ");
		SellerBackstageManageDao dao = (SellerBackstageManageDao) context.getBean("sellerBackstageManageDaoImpl");
		
		
		/***查詢***/
//		System.out.println(dao.findStoreID(3));
	
			
		/***新增***/
//		SellerBackstageManageBean bean = new SellerBackstageManageBean();
//		bean.setCustomerID(2);
//		bean.setStoreName("雄大的店1");
//		bean.setStorePhone("asdasdasd7");
//		bean.setStoreRating(10);
//		bean.setStoreStatus(true);
//		bean.setStoreBanner("http://localhost:8080/CowBaby/images/01.jpg");
//		
//		File input = new File("src/main/resources/data/icon.jpg");
//		byte[] loginPhoto = new byte[(int) input.length()];
//		FileInputStream fis = new FileInputStream(input);
//		fis.read(loginPhoto);
//		fis.close();
//		bean.setStoreLogo(new javax.sql.rowset.serial.SerialBlob(loginPhoto));
//		dao.insert(bean);
	
		
		/***修改***/
		SellerBackstageManageBean updateBean = dao.findStoreID(1);
		updateBean.setStoreName("DINDIND的店");
		dao.update(updateBean);
		
		
		
		
		
//
//		ProductBean select = productDao.select(7);
//		System.out.println("select=" + select);
//
//		ProductBean update = productDao.update("HotDog XX", 667, new java.util.Date(), 200, 10);
//		System.out.println("update=" + update);
//
//		List<ProductBean> selects = productDao.select();
//		System.out.println("selects=" + selects);
//
//		// ProductBean bean = new ProductBean();
//		// bean.setId(100);
//		// bean.setName("xxxxx");
//		// bean.setPrice(123.456);
//		// bean.setMake(new java.util.Date());
//		// bean.setExpire(1000);
//		// productDao.insert(bean);
//
//		boolean delete = productDao.delete(123);
//		System.out.println("delete=" + delete);
		
		
		
	
		
		
		
		/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();

	}

}

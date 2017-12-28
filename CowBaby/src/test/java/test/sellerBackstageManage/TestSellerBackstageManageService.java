package test.sellerBackstageManage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.SellerBackstageManageBean;

public class TestSellerBackstageManageService {

	public static void main(String[] args) throws SerialException, SQLException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		SellerBackstageManageService service = (SellerBackstageManageService) context.getBean(SellerBackstageManageService.class);
		
	// 測試內容
	
		//getStoreData()-獲取該商家資料
		//System.out.println(service.getStoreData(1));
	
		//insertStoreData()-新增商家商店設置資料
		SellerBackstageManageBean addBean = new SellerBackstageManageBean();	
		File input = new File("src/main/resources/data/icon.jpg");
		byte[] loginPhoto = new byte[(int) input.length()];
		FileInputStream fis = new FileInputStream(input);
		fis.read(loginPhoto);
		fis.close();
		addBean.setEmail("999@gmail.com");
		addBean.setStoreLogo(new javax.sql.rowset.serial.SerialBlob(loginPhoto));
		addBean.setStoreBanner("http://localhost:8080/CowBaby/images/01.jpg");
		addBean.setStoreName("小牛爬爬爬");
		addBean.setStorePhone("1111111");
		addBean.setStoreDescription("哇哈哈");
		System.out.println(addBean);
		System.out.println(service.insertStoreData(addBean));
		
		//updateStoreData()-修改商家商店設置資料
		
		SellerBackstageManageBean aa = service.getStoreData(1);
			aa.setStoreName("QQQQQQQQQQ");
			service.updateStoreData(aa);
			
		
		
		
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}

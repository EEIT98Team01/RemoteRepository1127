package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.CustomerBean;

@Service
@Transactional
public class DataManagementService {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/* 隨機產生Customer Table資料 */
	@SuppressWarnings("deprecation")
	public void createCustomersData(int quantity) throws IOException, SerialException, SQLException {
		// 取得隨機產生資料所需FirstName及LastName
		ArrayList<String> lastNameList = readData("src/main/resources/data/LastName.txt");
		ArrayList<String> womanFirstNameList = readData("src/main/resources/data/WomanFirstName.txt");
		ArrayList<String> manFirstNameList = readData("src/main/resources/data/ManFirstName.txt");
		ArrayList<String> dist = readData("src/main/resources/data/Dist.txt");
		ArrayList<String> road = readData("src/main/resources/data/Road.txt");
		ArrayList<String> phoneNumber = readData("src/main/resources/data/phoneNumber.txt");
		
		for(int i = 0; i < quantity; i++) {
			CustomerBean bean = new CustomerBean();
			
			// 1. 產生Gender
			String gender;
			if(randNumber(0, 2) == 0) {
				gender = "M";
			} else {
				gender = "F";
			}
			bean.setGender(gender);
			
			// 2. 產生CustomerName
			String customerName;
			if("M".equals(gender)) {
				customerName = manFirstNameList.get(randNumber(0, manFirstNameList.size())) + " " +
							   lastNameList.get(randNumber(0, lastNameList.size()));
			} else {
				customerName = womanFirstNameList.get(randNumber(0, womanFirstNameList.size())) + " " +
						   	   lastNameList.get(randNumber(0, lastNameList.size()));
			}
			bean.setCustomerName(customerName);
			
			// 3. 產生E-mail
			String[] nameSplit = customerName.split(" ");
			String email = nameSplit[0] + nameSplit[1] + randNumber(100000, 1000) + "@gmail.com";
			bean.setEmail(email);
			
			// 4. 產生password
			String password = "123";
			bean.setPassword(password);
			
			// 5. 取得使用者頭像
			File input = new File("src/main/resources/data/icon.jpg");
			byte[] loginPhoto = new byte[(int) input.length()];
			FileInputStream fis = new FileInputStream(input);
			fis.read(loginPhoto);
			fis.close();
			bean.setLoginPhoto(new javax.sql.rowset.serial.SerialBlob(loginPhoto));
			
			// 6. 產生Birthday
			Date birthday = new Date(randNumber(1970, 2000) + "/" + randNumber(1, 12) + "/" + randNumber(1, 28));
			bean.setBirthday(new java.sql.Date(birthday.getTime()));
			
			// 7. 產生Address
			String address = "台北市" + dist.get(randNumber(0, dist.size())) + road.get(randNumber(0, road.size())) + randNumber(1, 300) + "號";
			bean.setAddress(address);
			
			// 8. 產生landline (家用電話)
			String landline = "";
			bean.setLandline(landline);
			
			// 9. 產生mobilePhone
			String mobilePhone = phoneNumber.get(randNumber(0, phoneNumber.size()));
			for(int j = 0; j < 6; j++) {
				mobilePhone += randNumber(0, 9);
			}
			bean.setMobilePhone(mobilePhone);
			
			// 10. 產生marriage
			boolean marriage;
			if(randNumber(0, 1) == 0) {
				marriage = false;
			} else {
				marriage = true;
			}
			bean.setMarriage(marriage);
			
			// 11. 產生subscription
			boolean subscription;
			if(randNumber(0, 1) == 0) {
				subscription = false;
			} else {
				subscription = true;
			}
			bean.setSubscription(subscription);
			
			// 12. 產生income (收入)
			int income = 0;
			bean.setIncome(income);
			
			// 13. 產生createTime
			Timestamp createTime = new java.sql.Timestamp((new Date()).getTime());
			bean.setCreateTime(createTime);
			
			// 14. 產生totalAmoutOfConsumption (累積消費金額)
			int totalAmoutOfConsumption = 0;
			bean.setTotalAmoutOfConsumption(totalAmoutOfConsumption);
			
			// 15. 產生consumptionTimes (累積消費次數)
			int consumptionTimes = 0;
			bean.setConsumptionTimes(consumptionTimes);
			
			// 16. 產生userType
			int userID = 1;
			bean.setUserID(userID);
			
			// 17. 產生bonus (紅利)
			int bonus = 0;
			bean.setBonus(bonus);
			
			// 18. 產生consumerSegmentation (所屬群集)
			byte consumerSegmentation = 0;
			bean.setConsumerSegmentation(consumerSegmentation);
			
			this.getSession().save(bean);
		}
	}
	
	private ArrayList<String> readData(String fileName) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String data;
		while((data = br.readLine()) != null) {
			list.add(data);
		}
		br.close();
		
		return list;
	}
	
	private int randNumber(int min, int max) {
		return (int) ((Math.random()*(max-min))+min);
	}
}
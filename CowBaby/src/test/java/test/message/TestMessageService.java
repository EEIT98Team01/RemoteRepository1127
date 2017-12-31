package test.message;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.MessageBean;

public class TestMessageService {

	public static void main(String[] args) throws SerialException, SQLException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.service.test.xml");
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		MessageService service = (MessageService) context.getBean(MessageService.class);
		
	// 測試內容
	  // findById(int id)
		/*
		System.out.println(service.findById(1));
		*/
		
	  // sendMessage(String msgSenderAccount, String msgReceiverAccount, String msgContent)
		/*
		service.sendMessage("666@gmail.com", "555@gmail.com", "987654321");
		*/
		
	  // receiverMessage(String receiverAccount, String msgSenderID, String readStatus, String msgMarker, int page, int rows, String sortCondition)
		/*
		for(MessageBean bean: service.receiverMessage("lihong@gmail.com", "", "", "1", 1, 999, "MsgSenderID")) {
			System.out.println(bean);
		}
		*/
		
	  // getQuantity(String receiverAccount, String msgSenderID, String readStatus, String msgMarker)
		
		System.out.println(service.getQuantity(null, "999@gmail.com", null, null));
		
		
	  // changeMessageStatus(int messageId, String readStatus, String msgMarker)
		/*
		System.out.println(service.changeMessageStatus(2, "true", ""));
		*/
		
	  // replyMessage(int messageId, String msgResponse)
		/*
		System.out.println(service.replyMessage(2, "556"));
		*/
		
	  // removeMessage(int messageId)
		/*
		System.out.println(service.removeMessage(3));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		((ConfigurableApplicationContext) context).close();
	}

}

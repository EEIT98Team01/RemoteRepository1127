package test.mydao;

import java.lang.reflect.Parameter;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.MessageBoardDetailBean;

@Repository
public class MyDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List getHotProduct() {
		Query query = this.getSession().createQuery("SELECT productID, count(*) as sum from OrderDetailBean group by productID order by count(*) desc");
		List result = query.getResultList();
		
		for(int i = 0; i <result.size(); i++) {
			Object[] object = (Object[])result.get(i); 
			int productID = (int) object[0]; 
			Long count = (Long) object[1];
			
			System.out.println(productID + "-" + count);
		}
		return null;
	}
}

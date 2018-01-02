package model.dao.impl;

import java.lang.reflect.Parameter;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
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
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getHotProduct() {
		Query<Object[]> query = this.getSession().createQuery("SELECT productID, count(*) as sum from OrderDetailBean group by productID order by count(*) desc");
		List<Object[]> result = query.getResultList();

		return result;
	}
}

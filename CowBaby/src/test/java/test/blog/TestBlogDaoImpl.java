package test.blog;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.bean.BlogBean;
import model.dao.BlogDao;

public class TestBlogDaoImpl {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.dao.test.xml");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	/*---------------------------------------------------------------------------------------------*/
		
	// 依照要測試的對象進行修改
		BlogDao dao = (BlogDao) context.getBean("blogDaoImpl");
		
	// 測試內容
	  //findById(int id)
		/*
		System.out.println(dao.findById(1));
		*/

	  //insert(BlogBean bean)
		/*
		BlogBean bean = new BlogBean();
		bean.setArticlePhoto(null);
		bean.setBloggerName("幫寶弒");
		bean.setArticleHeader("超推薦育兒聖經");
		bean.setArticleContent("唐詩三百首");
		System.out.println(dao.insert(bean));
		*/
		
	  //update(BlogBean bean)
		/*
		BlogBean bean = new BlogBean();
		bean.setArticleID(3);
		bean.setArticlePhoto(null);
		bean.setBloggerName("妙兒輸");
		bean.setArticleHeader("寶寶爬行大賽秘技");
		bean.setArticleContent("用眼神");
		System.out.println(dao.update(bean));
		*/
		
	  //find()
		/*
		for(BlogBean bean: dao.find()) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows)
		/*
		for(BlogBean bean: dao.find(2, 3)) {
			System.out.println(bean);
		}
		*/
		
	  //find(int page, int rows, String sortCondition)
		/*
		for(BlogBean bean: dao.find(2, 3, "articleContent")) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("bloggerName", "like '%幫寶%'");
		condition.put("articleContent", "like '%寶寶%'");
		for(BlogBean bean: dao.findByCondition(condition)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("bloggerName", "like '%幫寶%'");
		condition.put("articleContent", "like '%寶寶%'");
		for(BlogBean bean: dao.findByCondition(condition, 2, 2)) {
			System.out.println(bean);
		}
		*/
		
	  //findByCondition(Map<String, String> condition, int page, int rows, String sortCondition)
		
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("bloggerName", "like '%幫寶%'");
		condition.put("articleContent", "like '%寶寶%'");      
		for(BlogBean bean: dao.findByCondition(condition, 1, 999, "articleContent")) {
			System.out.println(bean);
		}
		

	  //getQuantity()
		/*
		System.out.println(dao.getQuantity());
		*/
		
	  //getConditionQuantity(Map<String, String> condition)
		/*
		HashMap<String, String> condition = new HashMap<String, String>();
		condition.put("bloggerName", "like '%幫寶%'");
		condition.put("articleContent", "like '%寶寶%'"); 
		System.out.println(dao.getConditionQuantity(condition));
		*/
		
	/*---------------------------------------------------------------------------------------------*/
		session.getTransaction().commit();
		((ConfigurableApplicationContext) context).close();
	}

}

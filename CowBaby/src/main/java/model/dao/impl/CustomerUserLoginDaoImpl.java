package model.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import model.bean.CustomerBean;
import model.dao.CustomerUserLoginDao;

@Repository
public class CustomerUserLoginDaoImpl implements CustomerUserLoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// 由CustomerID取得相對應資料
	@Override
	public CustomerBean findById(int id) {
		return this.getSession().get(CustomerBean.class, id);
	}

	// 編輯會員資料用
	@Override
	public CustomerBean update(CustomerBean bean) {

		CustomerBean select = this.findById(bean.getCustomerID());

		if (select != null && bean.getEmail() != null) {
			select.setCustomerName(bean.getCustomerName());
			// select.setEmail(bean.getEmail());
			select.setPassword(bean.getPassword());
			select.setLoginPhoto(bean.getLoginPhoto());
			select.setGender(bean.getGender());
			select.setBirthday(bean.getBirthday());
			select.setAddress(bean.getAddress());
			select.setLandline(bean.getLandline());
			select.setMobilePhone(bean.getMobilePhone());
			select.setMarriage(bean.isMarriage());
			select.setSubscription(bean.isSubscription());
			select.setIncome(bean.getIncome());
			select.setCreateTime(bean.getCreateTime());
			select.setTotalAmoutOfConsumption(bean.getTotalAmoutOfConsumption());
			select.setConsumptionTimes(bean.getConsumptionTimes());
			select.setUserID(bean.getUserID());
			select.setBonus(bean.getBonus());
			select.setConsumerSegmentation(bean.getConsumerSegmentation());

			return select;
		}
		return null;
	}

	// 取得所有會員資料
	@Override
	public List<CustomerBean> find() {
		Query<CustomerBean> query = this.getSession().createQuery("FROM CustomerBean", CustomerBean.class);
		return query.getResultList();
	}

	// 取得所有會員資料中某頁的n筆資料,供分頁功能使用
	@Override
	public List<CustomerBean> find(int page, int rows) {
		return this.subList(this.find(), (page - 1) * rows, rows);
	}

	// 取得所有會員資料中某頁的n筆資料,供分頁功能使用,會員資料會先依某條件進行排序
	@Override
	public List<CustomerBean> find(int page, int rows, String sortCondition) {
		Query<CustomerBean> query = this.getSession().createQuery("FROM CustomerBean ORDER BY " + sortCondition,
				CustomerBean.class);
		return this.subList(query.getResultList(), (page - 1) * rows, rows);
	}

	// 取得符合某條件之會員資料(K為欄位名稱, V為條件)
	@Override
	public List<CustomerBean> findByCondition(Map<String, String> condition) {
		if (condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM CustomerBean WHERE ", condition);

			// 查詢並將結果回傳
			Query<CustomerBean> query = this.getSession().createQuery(hql, CustomerBean.class);
			return query.getResultList();
		}
		return null;
	}

	// 取得符合某條件之會員資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用
	@Override
	public List<CustomerBean> findByCondition(Map<String, String> condition, int page, int rows) {
		List<CustomerBean> temp = this.findByCondition(condition);

		if (temp != null) {
			return this.subList(temp, (page - 1) * rows, rows);
		}
		return null;
	}

	// 取得符合某條件之會員資料(K為欄位名稱, V為條件)中某頁的n筆資料,供分頁功能使用,符合條件之資料會先依某條件進行排序
	@Override
	public List<CustomerBean> findByCondition(Map<String, String> condition, int page, int rows, String sortCondition) {
		if (condition != null) {
			// 組合hql查詢字串
			String hql = this.hqlAddCondition("FROM CustomerBean WHERE ", condition);
			hql = hql + " ORDER BY " + sortCondition;

			// 查詢並將結果回傳
			Query<CustomerBean> query = this.getSession().createQuery(hql, CustomerBean.class);
			return this.subList(query.getResultList(), (page - 1) * rows, rows);
		}
		return null;
	}

	// 取得所有會員數量
	@Override
	public int getQuantity() {
		return this.find().size();
	}

	// 取得符合某條件之會員數量
	@Override
	public int getConditionQuantity(Map<String, String> condition) {
		return this.findByCondition(condition).size();
	}

	private List<CustomerBean> subList(List<CustomerBean> list, int start, int end) {
		List<CustomerBean> result = new LinkedList<CustomerBean>();

		int i = 0;
		while (((start + i) < list.size()) && (i < end)) {
			result.add(list.get(start + i));
			i++;
		}
		return result;
	}

	private String hqlAddCondition(String hql, Map<String, String> condition) {
		Set<String> fieldNameSet = condition.keySet();

		int count = 0;
		for (String fieldName : fieldNameSet) {
			if (count == 0) {
				hql = hql + fieldName + " " + condition.get(fieldName);
				count++;
			} else {
				hql = hql + " AND " + fieldName + " " + condition.get(fieldName);
			}
		}
		return hql;
	}
}

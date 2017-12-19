package test.AdvertisementAudit;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.AdvertisementBean;
import model.bean.AdvertisementDetailBean;
import model.bean.CustomerBean;
import model.bean.CustomerServiceBean;
import model.dao.AdvertisementAuditDao;

@Repository
public class AdvertisementAuditDaoImpl implements AdvertisementAuditDao {
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public AdvertisementBean findById(int id) {
		return this.getSession().get(AdvertisementBean.class, id);
	}

	@Override
	public Timestamp[] findDisplayTime(int id) {
		Query<AdvertisementDetailBean> query = this.getSession().createQuery("FROM AdvertisementDetailBean WHERE adID = " + id, AdvertisementDetailBean.class);
		List<AdvertisementDetailBean> list = query.getResultList();
		
		Timestamp[] result = new Timestamp[list.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = list.get(i).getDisplayAdTime();
		}
		
		return result;
	}

	@Override
	public AdvertisementBean update(CustomerBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementBean> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementBean> find(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementBean> find(int page, int rows, String sortCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementBean> findByCondition(Map<String, String> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementBean> findByCondition(Map<String, String> condition, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdvertisementBean> findByCondition(Map<String, String> condition, int page, int rows,
			String sortCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getConditionQuantity(Map<String, String> condition) {
		// TODO Auto-generated method stub
		return 0;
	}

}

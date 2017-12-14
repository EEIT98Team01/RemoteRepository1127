package test.sellerBackstageManageBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.SellerBackstageManageBean;
import model.dao.SellerBackstageManageDao;

@Repository
public class SellerBackstageManageDaoImpl implements SellerBackstageManageDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public SellerBackstageManageBean findStoreID(int storeID) {
		return getSession().get(SellerBackstageManageBean.class, storeID);
	}

	@Override
	public SellerBackstageManageBean update(SellerBackstageManageBean bean) {
		SellerBackstageManageBean select = this.findStoreID(bean.getStoreID());
		if (select != null) {
			select.setStoreBanner(bean.getStoreBanner());
			select.setStoreDescription(bean.getStoreDescription());
			select.setStoreLogo(bean.getStoreLogo());
			select.setStoreName(bean.getStoreName());
			select.setStorePhone(bean.getStorePhone());
			return select;
		}
		return null;
	}

	@Override
	public SellerBackstageManageBean insert(SellerBackstageManageBean bean) {
		if (bean != null) {
			SellerBackstageManageBean temp = this.findStoreID(bean.getStoreID());
			if (temp == null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

}

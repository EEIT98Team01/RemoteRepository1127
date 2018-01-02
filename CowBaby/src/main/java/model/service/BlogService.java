package model.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.BlogBean;
import model.dao.BlogDao;

@Service
@Transactional
public class BlogService {
	@Autowired
	private BlogDao blogDao;

	// 回傳blog資料,若資料不存在,則回傳null
	@Transactional(readOnly = true)
	public BlogBean findById(int id) {
		return blogDao.findById(id);
	}

	// 回傳所有商品分類資料,若無資料,則回傳之List為空集合
	@Transactional(readOnly = true)
	public List<BlogBean> find() {
		return blogDao.find();
	}

	// 先依某條件進行排序,再回傳某頁的N筆資料
	@Transactional(readOnly = true)
	public List<BlogBean> find(int page, int rows, String sortCondition) {
		return blogDao.find(page, rows, sortCondition);
	}

	// 先依某條件進行排序,回傳符合某某條件的N筆資料
	@Transactional(readOnly = true)
	public List<BlogBean> findByCondition(String author, String article, int page, int rows, String sortCondition) {
		return blogDao.findByCondition(this.createCondition(author, article), page, rows, sortCondition);
	}

	// 回傳資料總筆數
	@Transactional(readOnly = true)
	public int getQuantity() {
		return blogDao.getQuantity();
	}

	// 回傳符合條件之資料筆數
	@Transactional(readOnly = true)
	public int getConditionQuantity(String author, String article) {
		return blogDao.getConditionQuantity(this.createCondition(author, article));
	}

	// 更新會員資料
	public boolean updateBlogData(BlogBean bean) {
		BlogBean update = blogDao.update(bean);

		if (update != null) {
			return true;
		} else {
			return false;
		}
	}

	// 將查詢條件塞進Map
	private HashMap<String, String> createCondition(String author, String article) {
		HashMap<String, String> condition = new HashMap<String, String>();

		// author對應到資料庫中的bloggerName,若為null或"",表不設定該條件
		if (author != null && author.trim().length() != 0) {
			condition.put("bloggerName", "like '%" + author + "%'");
		}

		// article對應到資料庫中的articleHeader,若為null或"",表不設定該條件
		if (article != null && article.trim().length() != 0) {
			condition.put("articleHeader", "like '%" + article + "%'");
		}

		return condition;
	}

	// 新增Blog資料
	@Transactional
	public BlogBean insert(BlogBean bean) {
		return blogDao.insert(bean);
	}

	// 回傳有商店名稱的商品
	public List<Object[]> findObject() {
		List<BlogBean> list = this.find(1, this.getQuantity(), "ArticleID desc");
		List<String> base64Strings = new ArrayList<>();
		for (BlogBean bb : list) {
			Blob blob = bb.getArticlePhoto();
			if (blob == null) {
				base64Strings.add("");
			} else {
				byte[] img = null;
				try {
					img = Base64.getEncoder().encode(blob.getBytes(1, (int) blob.length()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String logingPhotoImg = new String(img);
				base64Strings.add(logingPhotoImg);
			}
		}
		// // 如果大頭貼為空
		// if (bean.getLoginPhoto() != null) {
		//
		// // 從資料庫抓取LOGO圖片編碼(二進制)
		// java.sql.Blob logingPhoto = bean.getLoginPhoto();
		// try {
		// // LOGO圖片編碼(二進制)->轉base64
		// byte[] img = Base64.getEncoder().encode(logingPhoto.getBytes(1, (int)
		// logingPhoto.length()));
		// // base64 -> 轉字串顯示於畫面上
		// String logingPhotoImg = new String(img);
		// model.addAttribute("logingPhotoImg", logingPhotoImg);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		List<Object[]> objList = new LinkedList<Object[]>();
		// 自己組要的資料塞回頁面
		int i = 0;
		for (BlogBean bean : list) {
			Object[] obj = new Object[5];
			obj[0] = bean.getArticleID();
			obj[1] = base64Strings.get(i++);
			obj[2] = bean.getArticleHeader();
			obj[3] = bean.getBloggerName();
			obj[4] = bean.getArticleContent();
			objList.add(obj);
		}

		return objList;
	}

}

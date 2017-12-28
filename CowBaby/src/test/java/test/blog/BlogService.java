package test.blog;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.BlogBean;
import model.bean.SellerBackstageManageBean;
import model.dao.BlogDao;

@Service
@Transactional
public class BlogService {
		@Autowired
		private BlogDao blogDao;
		
		// 回傳blog資料,若資料不存在,則回傳null
		@Transactional(readOnly=true)
		public BlogBean findById(int id){
			return blogDao.findById(id);
		}
		
		// 先依某條件進行排序,再回傳某頁的N筆資料
		@Transactional(readOnly=true)
		public List<BlogBean> find(int page, int rows, String sortCondition) {
			return blogDao.find(page, rows, sortCondition);
		}
		
		// 先依某條件進行排序,回傳符合某某條件的N筆資料
		@Transactional(readOnly=true)
		public List<BlogBean> findByCondition(String author, String article, int page, int rows, String sortCondition) {
			return blogDao.findByCondition(this.createCondition(author, article), page, rows, sortCondition);
		}

		// 回傳資料總筆數
		@Transactional(readOnly=true)
		public int getQuantity() {
			return blogDao.getQuantity();
		}
		
		// 回傳符合條件之資料筆數
		@Transactional(readOnly=true)
		public int getConditionQuantity(String author, String article) {
			return blogDao.getConditionQuantity(this.createCondition(author, article));
		}
		
		// 更新會員資料
		public boolean updateBlogData(BlogBean bean) {
			BlogBean update = blogDao.update(bean);
			
			if(update != null) {
				return true;
			} else {
				return false;
			}
		}	
		
	
		// 將查詢條件塞進Map
		private HashMap<String, String> createCondition(String author, String article) {
			HashMap<String, String> condition = new HashMap<String, String>();
			
			// author對應到資料庫中的bloggerName,若為null或"",表不設定該條件
			if(author != null && author.trim().length() != 0) {
				condition.put("bloggerName", "like '%" + author + "%'");
			}
				
			// article對應到資料庫中的articleHeader,若為null或"",表不設定該條件
			if(article != null && article.trim().length() != 0) {
				condition.put("articleHeader", "like '%" + article + "%'");
			}
				
			return condition;
		}
		
		// 新增Blog資料
		@Transactional
		public BlogBean insert(BlogBean bean) {		
			
			return  blogDao.insert(bean);
		}
}

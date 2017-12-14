package model.dao;



import model.bean.SellerBackstageManageBean;

public interface SellerBackstageManageDao {
	
	// 由storeID取得該商店設置的資料
	public SellerBackstageManageBean findStoreID(int storeID);
	
	// 新增商店設置資料用
	public SellerBackstageManageBean insert(SellerBackstageManageBean bean);
	
	// 更新商店設置資料用
	public SellerBackstageManageBean update(SellerBackstageManageBean bean);

	
	
}

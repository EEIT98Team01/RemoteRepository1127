package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PageView")
public class PageViewBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pageViewsID;
	private int storeID;
	private Date pageViewsDate;
	private int pageViews;
	
	@Override
	public String toString() {
		return "PageViewBean [pageViewsID=" + pageViewsID + ", storeID=" + storeID + ", pageViewsDate=" + pageViewsDate
				+ ", pageViews=" + pageViews + "]";
	}

	public int getPageViewsID() {
		return pageViewsID;
	}

	public void setPageViewsID(int pageViewsID) {
		this.pageViewsID = pageViewsID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public Date getPageViewsDate() {
		return pageViewsDate;
	}

	public void setPageViewsDate(Date pageViewsDate) {
		this.pageViewsDate = pageViewsDate;
	}

	public int getPageViews() {
		return pageViews;
	}

	public void setPageViews(int pageViews) {
		this.pageViews = pageViews;
	}

}

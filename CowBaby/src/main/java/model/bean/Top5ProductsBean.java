package model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Top5Products")
public class Top5ProductsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int top5ProductID;
	private int storeID;
	private Date monthlyTime;
	private int top1Product;
	private int top2Product;
	private int top3Product;
	private int top4Product;
	private int top5Product;
	
	@Override
	public String toString() {
		return "Top5ProductsBean [top5ProductID=" + top5ProductID + ", storeID=" + storeID + ", monthlyTime="
				+ monthlyTime + ", top1Product=" + top1Product + ", top2Product=" + top2Product + ", top3Product="
				+ top3Product + ", top4Product=" + top4Product + ", top5Product=" + top5Product + "]";
	}

	public int getTop5ProductID() {
		return top5ProductID;
	}

	public void setTop5ProductID(int top5ProductID) {
		this.top5ProductID = top5ProductID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public Date getMonthlyTime() {
		return monthlyTime;
	}

	public void setMonthlyTime(Date monthlyTime) {
		this.monthlyTime = monthlyTime;
	}

	public int getTop1Product() {
		return top1Product;
	}

	public void setTop1Product(int top1Product) {
		this.top1Product = top1Product;
	}

	public int getTop2Product() {
		return top2Product;
	}

	public void setTop2Product(int top2Product) {
		this.top2Product = top2Product;
	}

	public int getTop3Product() {
		return top3Product;
	}

	public void setTop3Product(int top3Product) {
		this.top3Product = top3Product;
	}

	public int getTop4Product() {
		return top4Product;
	}

	public void setTop4Product(int top4Product) {
		this.top4Product = top4Product;
	}

	public int getTop5Product() {
		return top5Product;
	}

	public void setTop5Product(int top5Product) {
		this.top5Product = top5Product;
	}
	
}

package model.bean;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Blog")
public class BlogBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleID;
	private Blob articlePhoto;
	private String bloggerName;
	private String articleHeader;
	private String articleContent;

	@Override
	public String toString() {
		return "BlogBean [articleID=" + articleID + ", articlePhoto=" + articlePhoto + ", bloggerName=" + bloggerName
				+ ", articleHeader=" + articleHeader + ", articleContent=" + articleContent + "]";
	}

	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public java.sql.Blob getArticlePhoto() {
		return articlePhoto;
	}

	public void setArticlePhoto(java.sql.Blob articlePhoto) {
		this.articlePhoto = articlePhoto;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public String getArticleHeader() {
		return articleHeader;
	}

	public void setArticleHeader(String articleHeader) {
		this.articleHeader = articleHeader;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

}

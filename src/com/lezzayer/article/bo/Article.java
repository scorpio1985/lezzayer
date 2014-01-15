package com.lezzayer.article.bo;

import java.util.Date;

public class Article {
	
	public Article() {
		
	}
	
	private String title;
	private String webSiteName;
	private String articleUrl;
	private String textPreview;
	private Date articleDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWebSiteName() {
		return webSiteName;
	}
	public void setWebSiteName(String webSiteName) {
		this.webSiteName = webSiteName;
	}
	public String getArticleUrl() {
		return articleUrl;
	}
	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	public String getTextPreview() {
		return textPreview;
	}
	public void setTextPreview(String textPreview) {
		this.textPreview = textPreview;
	}
	public Date getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", webSiteName=" + webSiteName
				+ ", articleUrl=" + articleUrl + ", textPreview=" + textPreview
				+ ", articleDate=" + articleDate + "]";
	}
	
	

}

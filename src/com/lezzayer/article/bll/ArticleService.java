package com.lezzayer.article.bll;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import com.lezzayer.article.bo.Article;

public interface ArticleService {
	
	public Article computeArticle() throws MalformedURLException, IOException;
	public String computeTitle() throws MalformedURLException, IOException;
	public String computeWebSiteName();
	public String computeArticleUrl() throws MalformedURLException, IOException;
	public String computeTextPreview() throws MalformedURLException, IOException;
	public Date computeArticleDate();

}

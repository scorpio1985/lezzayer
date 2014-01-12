package com.lezzayer.article.bll;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

public interface ArticleService {
	
	public String computTitle() throws MalformedURLException, IOException;
	public String computeWebSiteName();
	public String computeArticleUrl() throws MalformedURLException, IOException;
	public String computeTextPreview() throws MalformedURLException, IOException;
	public Date computeArticleDate();

}

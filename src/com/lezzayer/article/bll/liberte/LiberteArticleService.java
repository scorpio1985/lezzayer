package com.lezzayer.article.bll.liberte;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.lezzayer.article.bll.ArticleService;
import com.lezzayer.article.bo.Article;

public class LiberteArticleService implements ArticleService {

	@Override
	public String computeTitle() throws MalformedURLException, IOException {
		HtmlCleaner cleaner = new HtmlCleaner();
		 
		TagNode node = cleaner.clean(new URL(LiberteUtils.ACTU_SITE_URL));
		 
		TagNode nodeArticle = node.findElementByAttValue("class", LiberteUtils.RUBRIQUE_ARTICLE, true, true);
		
		TagNode nodeTitle = nodeArticle.findElementByName("h2", true);
		
		return nodeTitle.getText().toString();
	}

	@Override
	public String computeWebSiteName() {
		return LiberteUtils.WEBSITE_NAME;
	}

	@Override
	public String computeArticleUrl() throws MalformedURLException, IOException {
		HtmlCleaner cleaner = new HtmlCleaner();
		 
		TagNode node = cleaner.clean(new URL(LiberteUtils.ACTU_SITE_URL));
		 
		TagNode nodeArticle = node.findElementByAttValue("class", LiberteUtils.RUBRIQUE_ARTICLE, true, true);
		
		TagNode nodeUrl = nodeArticle.findElementByAttValue("class", LiberteUtils.RUBRIQUE_ARTICLE_LINK, true, true);
				
		return LiberteUtils.SITE_URL + nodeUrl.getAttributeByName("href");
	}

	@Override
	public String computeTextPreview() throws MalformedURLException, IOException {
		HtmlCleaner cleaner = new HtmlCleaner();
		 
		TagNode node = cleaner.clean(new URL(LiberteUtils.ACTU_SITE_URL));
		 
		TagNode nodeArticle = node.findElementByAttValue("class", LiberteUtils.RUBRIQUE_ARTICLE, true, true);
		
		TagNode nodePreview = nodeArticle.findElementByName("p", true);
		
		return nodePreview.getText().toString();
	}

	@Override
	public Date computeArticleDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article computeArticle() throws MalformedURLException, IOException {
		Article article = new Article();
		article.setArticleDate(computeArticleDate());
		article.setArticleUrl(computeArticleUrl());
		article.setTextPreview(computeTextPreview());
		article.setTitle(computeTitle());
		article.setWebSiteName(computeWebSiteName());
		return article;
	}

}

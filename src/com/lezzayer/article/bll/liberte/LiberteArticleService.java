package com.lezzayer.article.bll.liberte;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.lezzayer.article.bll.ArticleService;
import com.lezzayer.article.bll.NodeUtils;
import com.lezzayer.article.bo.Article;

public class LiberteArticleService implements ArticleService {
	
	private HtmlCleaner cleaner;
	private TagNode node;
	private TagNode nodeArticle;
	
	public LiberteArticleService() throws Exception {
		cleaner = new HtmlCleaner();
		node = cleaner.clean(new URL(LiberteUtils.ACTU_SITE_URL), "UTF-8");
		nodeArticle = node.findElementByAttValue(NodeUtils.CLASS, LiberteUtils.RUBRIQUE_ARTICLE, true, true);
	}

	@Override
	public String computeTitle() throws MalformedURLException, IOException {
		
		TagNode nodeTitle = nodeArticle.findElementByName(NodeUtils.H2, true);
		
		return nodeTitle.getText().toString();
	}

	@Override
	public String computeWebSiteName() {
		return LiberteUtils.WEBSITE_NAME;
	}

	@Override
	public String computeArticleUrl() throws MalformedURLException, IOException {
		TagNode nodeUrl = nodeArticle.findElementByAttValue(NodeUtils.CLASS, LiberteUtils.RUBRIQUE_ARTICLE_LINK, true, true);
				
		return LiberteUtils.SITE_URL + nodeUrl.getAttributeByName(NodeUtils.HREF);
	}

	@Override
	public String computeTextPreview() throws MalformedURLException, IOException {
		TagNode nodePreview = nodeArticle.findElementByName(NodeUtils.P, true);
		
		return nodePreview.getText().toString();
	}

	@Override
	public Date computeArticleDate() throws Exception {
		TagNode nodeTitle = nodeArticle.findElementByName(NodeUtils.H3, true);
		String date = nodeTitle.getText().toString();
		SimpleDateFormat formater = new SimpleDateFormat(LiberteUtils.DATE_FORMAT);
		
		return formater.parse(date);
	}

	@Override
	public Article computeArticle() throws Exception {
		Article article = new Article();
		article.setArticleDate(computeArticleDate());
		article.setArticleUrl(computeArticleUrl());
		article.setTextPreview(computeTextPreview());
		article.setTitle(computeTitle());
		article.setWebSiteName(computeWebSiteName());
		return article;
	}

}

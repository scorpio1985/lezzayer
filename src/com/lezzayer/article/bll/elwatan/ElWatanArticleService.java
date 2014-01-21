package com.lezzayer.article.bll.elwatan;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.lezzayer.article.bll.ArticleService;
import com.lezzayer.article.bll.NodeUtils;
import com.lezzayer.article.bo.Article;

public class ElWatanArticleService implements ArticleService {
	
	private HtmlCleaner cleaner;
	private TagNode node;
	private TagNode nodeArticle;
	
	public ElWatanArticleService() throws Exception {
		cleaner = new HtmlCleaner();
		node = cleaner.clean(new URL(ElWatanUtils.ACTU_SITE_URL));
		nodeArticle = node.findElementByAttValue(NodeUtils.CLASS, ElWatanUtils.RUBRIQUE_ARTICLE, true, true);
	}

	@Override
	public String computeTitle() {

		TagNode nodeTitle = nodeArticle.findElementByName(NodeUtils.H1, true);
		TagNode nodeAhref = nodeTitle.findElementByName(NodeUtils.A, true);
		
		return nodeAhref.getText().toString();
	}

	@Override
	public String computeWebSiteName() {
		return ElWatanUtils.WEBSITE_NAME;
	}

	@Override
	public String computeArticleUrl() {
		
		TagNode nodeTitle = nodeArticle.findElementByName(NodeUtils.H1, true);
		TagNode nodeAhref = nodeTitle.findElementByName(NodeUtils.A, true);
		nodeAhref.getAttributeByName(NodeUtils.HREF);
		
		return ElWatanUtils.ACTU_SITE_URL + nodeAhref.getAttributeByName(NodeUtils.HREF);
	}

	@Override
	public String computeTextPreview() {
		
		TagNode nodePreview = nodeArticle.findElementByAttValue(NodeUtils.CLASS, ElWatanUtils.ACCROCHE, true, true);
		return nodePreview.getText().toString();
	}

	@Override
	public Date computeArticleDate() throws Exception {
		TagNode nodeDate = nodeArticle.findElementByAttValue(NodeUtils.CLASS, ElWatanUtils.DATE_PUBLI, true, true);
		String date = new String (nodeDate.getText().toString().getBytes("UTF-8"), "UTF-8");
		System.err.println("["+date+"]");
		SimpleDateFormat formater = new SimpleDateFormat(ElWatanUtils.DATE_FORMAT);
		
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

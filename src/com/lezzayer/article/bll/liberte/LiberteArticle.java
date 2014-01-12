package com.lezzayer.article.bll.liberte;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import com.lezzayer.article.bll.ArticleService;

public class LiberteArticle implements ArticleService {

	@Override
	public String computTitle() throws MalformedURLException, IOException {
		HtmlCleaner cleaner = new HtmlCleaner();
		final String siteUrl = "http://www.liberte-algerie.com/actualite";
		 
		TagNode node = cleaner.clean(new URL(siteUrl));
		 
		TagNode nodeArticle = node.findElementByAttValue("class", "rubrique-article", true, true);
		
		TagNode nodeTitle = nodeArticle.findElementByName("h2", true);
		
		return nodeTitle.getText().toString();
	}

	@Override
	public String computeWebSiteName() {
		return "Liberte";
	}

	@Override
	public String computeArticleUrl() throws MalformedURLException, IOException {
		HtmlCleaner cleaner = new HtmlCleaner();
		final String siteUrl = "http://www.liberte-algerie.com/actualite";
		 
		TagNode node = cleaner.clean(new URL(siteUrl));
		 
		TagNode nodeArticle = node.findElementByAttValue("class", "rubrique-article", true, true);
		
		TagNode nodeUrl = nodeArticle.findElementByAttValue("class", "rubrique-article_link", true, true);
				
		return "http://www.liberte-algerie.com" + nodeUrl.getAttributeByName("href");
	}

	@Override
	public String computeTextPreview() throws MalformedURLException, IOException {
		HtmlCleaner cleaner = new HtmlCleaner();
		final String siteUrl = "http://www.liberte-algerie.com/actualite";
		 
		TagNode node = cleaner.clean(new URL(siteUrl));
		 
		TagNode nodeArticle = node.findElementByAttValue("class", "rubrique-article", true, true);
		
		TagNode nodePreview = nodeArticle.findElementByName("p", true);
		
		return nodePreview.getText().toString();
	}

	@Override
	public Date computeArticleDate() {
		// TODO Auto-generated method stub
		return null;
	}

}

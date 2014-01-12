package com.lezzayer.test;

import java.net.MalformedURLException;

import com.lezzayer.article.bll.ArticleService;
import com.lezzayer.article.bll.elwatan.ElWatanArticleService;
import com.lezzayer.article.bll.liberte.LiberteArticle;

public class TestMain {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, Exception {
		
		ArticleService serv = new LiberteArticle();
		System.out.println(serv.computTitle());
		
		serv = new ElWatanArticleService();
		System.out.println(serv.computTitle());
		
	}

}

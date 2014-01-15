package com.lezzayer.article.bll;

import junit.framework.TestCase;

import com.lezzayer.article.bll.liberte.LiberteArticleService;

public class ArticleServiceTest extends TestCase {

	public void testLiberteArticle() throws Exception {
		
		ArticleService articleService = new LiberteArticleService();
		System.out.println(articleService.computeArticle());
		
	}

}

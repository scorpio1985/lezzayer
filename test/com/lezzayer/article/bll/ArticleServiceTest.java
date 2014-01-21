package com.lezzayer.article.bll;

import org.junit.Test;

import com.lezzayer.article.bll.elwatan.ElWatanArticleService;
import com.lezzayer.article.bll.lequotidiendoran.QuotidienOranArticleService;
import com.lezzayer.article.bll.liberte.LiberteArticleService;

public class ArticleServiceTest {

	@Test
	public void testLiberteArticle() throws Exception {
		
		ArticleService articleService = new LiberteArticleService();
		System.out.println(articleService.computeArticle());
		
	}

	@Test
	public void testElWatanArticle() throws Exception {
		
		ArticleService articleService = new ElWatanArticleService();
		System.out.println(articleService.computeArticle());
		
	}

	@Test
	public void testQOArticle() throws Exception {
	
		ArticleService articleService = new QuotidienOranArticleService();
		System.out.println(articleService.computeArticle());
	
	}
}

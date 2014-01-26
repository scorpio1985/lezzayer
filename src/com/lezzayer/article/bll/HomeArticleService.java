package com.lezzayer.article.bll;

import java.util.ArrayList;
import java.util.List;

import com.lezzayer.article.bll.elwatan.ElWatanArticleService;
import com.lezzayer.article.bll.lequotidiendoran.QuotidienOranArticleService;
import com.lezzayer.article.bll.liberte.LiberteArticleService;
import com.lezzayer.article.bo.Article;

public class HomeArticleService {
	
	public List<Article> loadArticles() throws Exception {
		
		List<Article> articles = new ArrayList<Article>();
		
		ArticleService articleService = new LiberteArticleService();
    	Article liberteArticle = articleService.computeArticle();
        articles.add(liberteArticle);
        
        articleService = new ElWatanArticleService();
        Article elWatanArticle = articleService.computeArticle();
        articles.add(elWatanArticle);
        
        articleService = new QuotidienOranArticleService();
        Article qoArticle = articleService.computeArticle();
        articles.add(qoArticle);
		
		return articles;
		
	}

}

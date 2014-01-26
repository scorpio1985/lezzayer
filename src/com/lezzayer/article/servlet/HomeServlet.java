package com.lezzayer.article.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lezzayer.article.bll.HomeArticleService;
import com.lezzayer.article.bo.Article;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	try {
    		HomeArticleService homeArticleService = new HomeArticleService();
	    	List<Article> articles = homeArticleService.loadArticles();
	        request.setAttribute("articles", articles);
	         
	        RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
	        rd.forward(request, response);
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    }
 
}
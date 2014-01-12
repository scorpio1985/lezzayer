package com.lezzayer.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lezzayer.article.bll.ArticleService;
import com.lezzayer.article.bll.liberte.LiberteArticle;

/**
 * Servlet implementation class UneServlet
 */
@WebServlet({ "/UneServlet", "/aLaUne" })
public class UneServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<HTML>");
		out.println("<HEAD><TITLE> Titre </TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Lezzayer - A La Une");
		out.println("</br>");
		ArticleService serv = new LiberteArticle();
		out.println(serv.computTitle());
		out.println("</br>");
		out.println(serv.computeTextPreview());
		out.println("</br>");
		out.println("<a href=\""+serv.computeArticleUrl()+"\">Lire la suite</a>");
		out.println("</br>");
		out.println(serv.computeWebSiteName());
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

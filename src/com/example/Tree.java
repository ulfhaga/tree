package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.SSLContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tree
 */
@WebServlet("/Tree")
public class Tree extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SSLContext ctx = SSLContext.getInstance("TLSv1.2");
			ctx.init(null, null, null);
			SSLContext.setDefault(ctx);

		} catch (Exception e) {
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.append("Error:  ").append(e.getMessage());
			System.out.println(e.getMessage());
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("TLSv1.2 set. Served at 2: ").append(request.getContextPath());
		out.append("</html>");
	}

}

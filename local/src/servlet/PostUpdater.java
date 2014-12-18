package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

/**
 * Servlet implementation class PostUpdater
 */
@WebServlet("/PostUpdater")
public class PostUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostUpdater() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String date = request.getParameter("date");

		FirebaseService inferno = new FirebaseServiceProxy();
		inferno.editPost(id, title, content, date);
		response.sendRedirect("index.jsf");
	}

}

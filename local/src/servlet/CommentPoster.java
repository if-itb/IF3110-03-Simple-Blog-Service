package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

import constrain.Constant;

/**
 * Servlet implementation class CommentPoster
 */
@WebServlet("/CommentPoster")
public class CommentPoster extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentPoster() {
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
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		Date now = new Date(System.currentTimeMillis());
		String snow = new SimpleDateFormat("yyyy-MM-dd").format(now);

		FirebaseService inferno = new FirebaseServiceProxy();
		inferno.addComment(name, email, content, snow, sid);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
	}
}

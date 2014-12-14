package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.wbd.heroku.service.FirebaseService;
import org.wbd.heroku.service.FirebaseServiceProxy;

import constrain.Constant;

/**
 * Servlet implementation class CommentGetter
 */
@WebServlet("/CommentGetter")
public class CommentGetter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String templateString = "<div class=\"row\"><div class=\"col-xs-2 col-md-offset-1\"><div class=\"row\" style=\"font-size: 16px\"><strong>{0}</strong></div><br /><div class=\"row\"><a href=\"mailto:{1}\">{1}</a></div><br /><div class=\"row\">{2}</div></div><div class=\"col-xs-5 col-md-offset-1\">{3}</div></div><hr />";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentGetter() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String suserID = request.getParameter("id");
		FirebaseService inferno = new FirebaseServiceProxy();
		org.wbd.heroku.service.Comment[] fire = inferno.listPostComment(suserID);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		for (org.wbd.heroku.service.Comment fira : fire) {
			out.write(MessageFormat.format(templateString, fira.getNama(),
					fira.getEmail(), fira.getTanggal(), fira.getKonten()));
		}
	}
}

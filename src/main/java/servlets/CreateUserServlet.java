package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/CreateUserView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBUtil dbUtil  = new DBUtil();
		User user =  new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		dbUtil.creatUser(user);
		 if(1 > 0) {
			 request.setAttribute("user", user);
			 RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/CreateUserView.jsp");
				dispatcher.forward(request, response);
		 }else {
			 response.sendRedirect(request.getContextPath() + "/Users");
			 
		 }
		
		
	}

}

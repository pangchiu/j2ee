package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DBUtil dbUtil = new DBUtil();
		List<User> users = dbUtil.getAllUser();
		User u = null;
		int id = Integer.parseInt(request.getParameter("id"));
		for (User user : users) {
			if(user.getId() == id ) {
				u = user;
				break;
			}
		}
		if(u == null ) {
			
			request.setAttribute("error", "not found");
		}else {
			request.setAttribute("user", u);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/EditUserView.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBUtil dbUtil = new DBUtil();
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		if(!dbUtil.editUser(user)) {
			
			request.setAttribute("error", "edit fail");
			
		}
			

		response.sendRedirect(request.getContextPath() + "/Users");
	
		
		
		
	}

}

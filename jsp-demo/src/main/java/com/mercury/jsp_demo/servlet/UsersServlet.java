package com.mercury.jsp_demo.servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.jsp_demo.bean.User;
import com.mercury.jsp_demo.service.UserService;
import com.mercury.jsp_demo.util.JdbcUtil;

/**
 * Servlet implementation class UsersServlet
 */
// 作用： 实现request和response
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService; // 没必要创建多个userService，用singleton更好，所以用Spring IoC更好，更容易实现singleton
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.userService = new UserService();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see Servlet#destroy()
	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	// 任何方法都会被service handle，get/post/delete/etc都不会用，general的方法，类似app.use()
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users;
		if (request.getParameter("minAge") != null) {
			int minAge = Integer.valueOf(request.getParameter("minAge"));
			users = userService.getUsersAboveAge(minAge);
		} else {
			users = userService.getAllUsers();
		}
		
		// 把请求给JSP，让JSP的HTML再转发回去
		request.setAttribute("users", users);
		// redirect request to users.jsp to show the final result
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/users.jsp");
		dispatcher.forward(request, response);
		
		// JSP will be compile to Servlet
		
//		Writer writer = response.getWriter();
//        writer.append("<html>");
//        writer.append("<head>");
//        writer.append("<title>Users</title>");
//        writer.append("</head>");
//        writer.append("<body>");
//        writer.append("<h2>Users</h2>");
//        writer.append("<ul>");
//        for(User u : users) {
//            writer.append("<li>");
//            writer.append(u.getName() + " - " + u.getAge());
//            writer.append("</li>");
//        }
//        writer.append("</ul>");
//        writer.append("</body>");
//        writer.append("</html>");
//        writer.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

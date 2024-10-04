package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.LoginDAO;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータの取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		//遷移先urlの記述
		String url = "menu.jsp";
		//daoのインスタンス生成
		LoginDAO dao = new LoginDAO();
		try {
			String name = dao.loginCheck(loginId, password);
			if(name != null) {
				HttpSession session = request.getSession();
				
				session.setAttribute("name", name);
			}else {
				String error = "ログイン情報が間違っています。";
				request.setAttribute("error", error);
				url = "login.jsp";
			}
			}catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		}
	}



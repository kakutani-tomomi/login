package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * Servlet implementation class EmployeeDatailServlet
 */
@WebServlet("/EmployeeDatail")
public class EmployeeDatailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDatailServlet() {
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
		//URLの記述
		String url = "datail.jsp";
		//リクエストパラメータの取得
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		//DAOノインスタンス生成
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			EmployeeBean bean = dao.getDatail(id);
			System.out.println(bean);
			if(bean != null) {
				request.setAttribute("bean", bean);
			}else {
				String error = "idと一致する従業員が存在しません";
				request.setAttribute("error", error);
				url = "menu.jsp";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}

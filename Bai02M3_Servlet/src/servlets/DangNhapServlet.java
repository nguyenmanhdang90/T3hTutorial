package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet(
		urlPatterns = { "/DangNhapServlet" }, 
		initParams = { 
				@WebInitParam(name = "tenDN", value = "t3h"), 
				@WebInitParam(name = "matKhau", value = "123456")
		})
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDN, matKhau;
		tenDN = request.getParameter("txtTenDN");
		matKhau = request.getParameter("txtMatKhau");
		
		ServletConfig scfg = getServletConfig();
		String tdn = scfg.getInitParameter("tenDN");
		String mk = scfg.getInitParameter("matKhau");
		
		if(tenDN.equals(tdn) && matKhau.equals(mk))
			response.sendRedirect("trang-chu.html");
		else
			response.sendRedirect("DangNhap.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

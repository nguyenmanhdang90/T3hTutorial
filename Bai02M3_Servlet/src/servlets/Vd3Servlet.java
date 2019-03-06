package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vd3Servlet
 */
@WebServlet(
		urlPatterns = { 
				"/Vd3Servlet", 
				"/vd3.htm"
		}, 
		initParams = { 
				@WebInitParam(name = "ten", value = "t3h"), 
				@WebInitParam(name = "matkhau", value = "123456")
		})
public class Vd3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vd3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig scfg = getServletConfig();
		String ten = scfg.getInitParameter("ten");
		
		ServletContext sct = getServletContext();
		String tenCongTy = sct.getInitParameter("tenCongTy");
		
		PrintWriter out = response.getWriter();
		out.println("Ten cong ty: "+tenCongTy+"<br>");
		out.println("Ten nguoi dung: "+ten+"<br>");
		
		out.println("Ten server: "+request.getServerName()+"<br>");
		out.println("Duong dan ngu canh: "+request.getContextPath()+"<br>");
		
		out.println("Ho ten: "+request.getParameter("hoTen"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
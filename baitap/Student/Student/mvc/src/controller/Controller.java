package controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Member;

public abstract class Controller extends HttpServlet {
	protected void saved(Map<Integer, Cart> carts, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("cart", carts);
	}
	
	protected static void saved(Member obj, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("member", obj);
		if (request.getParameter("remember") != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("JSESSIONID")) {
					cookie.setMaxAge(30 * 24 * 3600);
					cookie.setPath(request.getContextPath());
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
	
	protected static Map<Integer, Cart> getCarts(HttpServletRequest request, HttpServletResponse response){
		HttpSession session =  request.getSession();
		Object obj = session.getAttribute("cart");
		Map<Integer, Cart> carts = null;
		if(obj != null) {
			carts = (Map<Integer, Cart>)obj;
		}else {
			carts = new HashMap();
			session.setAttribute("cart", carts);
		}
		return carts;
	}
	
	
	protected static Member getMember(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session =  request.getSession();
		Object obj = session.getAttribute("member");
		return obj != null ? (Member)obj : null;
	}
	
	protected static void render(String path, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.getRequestDispatcher("/views/" + path).forward(req, resp);
	}
	
	protected static void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + url);
	}
}

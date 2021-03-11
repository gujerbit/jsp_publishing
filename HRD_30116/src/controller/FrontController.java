package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(name = "Front", urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private HashMap<String, Controller> map = null;
	private String charset = null;
	
	@Override
		public void init(ServletConfig config) throws ServletException {
			charset = config.getInitParameter("charset");
			
			map = new HashMap<String, Controller>();
			map.put("/Register.do", new RegisterController());
			map.put("/Select.do", new SelectController());
			map.put("/Update.do", new UpdateController());
			map.put("/Money.do", new MoneyController());
		}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);
		
		String url = req.getRequestURI();
		String context = req.getContextPath();
		String path = url.substring(context.length());
		
		Controller subController = map.get(path);
		subController.execute(req, resp);
	}
}

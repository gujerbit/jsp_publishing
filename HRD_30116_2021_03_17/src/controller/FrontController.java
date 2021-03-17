package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(name = "front", urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;
	private String charset;
	
    public FrontController() {}

	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		
		map = new HashMap<String, Controller>();
		map.put("/Register.do", new RegisterController());
		map.put("/SelectMember.do", new SelectMemberController());
		map.put("/Update.do", new UpdateController());
		map.put("/SelectBook.do", new SelectBookController());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		
		String url = request.getRequestURI();
		String context = request.getContextPath();
		String path = url.substring(context.length());
		
		Controller subController = map.get(path);
		subController.execute(request, response);
	}

}

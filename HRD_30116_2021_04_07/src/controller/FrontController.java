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

@WebServlet(name = "front", urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String charset = null;
	Map<String, Controller> map = null;

	public FrontController() {
	}

	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		map = new HashMap<String, Controller>();
		map.put("/View.do", new ViewMemberController());
		map.put("/Set.do", new SetMemberController());
		map.put("/Update.do", new UpdateMemberController());
		map.put("/Delete.do", new DeleteMemberController());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(charset);

		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());

		Controller subController = map.get(path);
		subController.execute(request, response);
	}
}

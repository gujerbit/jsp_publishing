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

@WebServlet(name = "Front", urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String charset = null;
	private Map<String, Controller> map = null;
	
    public FrontController() {}

	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		map = new HashMap<String, Controller>();
		map.put("/ViewCourse.do", new ViewCourseController());
		map.put("/AddCourse.do", new AddCourseController());
		map.put("/UpdateCourse.do", new UpdateCourseController());
		map.put("/DeleteCourse.do", new DeleteCourseController());
		map.put("/ViewLecturer.do", new ViewLecturerController());
		map.put("/AddLecturer.do", new AddLecturerController());
		map.put("/DeleteLecturer.do", new DeleteLecturerController());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Controller subController = map.get(path);
		subController.execute(request, response);
	}

}
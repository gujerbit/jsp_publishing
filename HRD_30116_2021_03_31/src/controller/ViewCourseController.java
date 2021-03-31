package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import vo.CourseVO;

public class ViewCourseController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CourseDAO instance = CourseDAO.getInstance();
		String path = "viewCourse.jsp";
		ArrayList<CourseVO> list = instance.getCourseList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher(path).forward(req, res);
	}
}

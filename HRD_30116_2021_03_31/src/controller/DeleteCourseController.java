package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;

public class DeleteCourseController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CourseDAO instance = CourseDAO.getInstance();
		int id = Integer.parseInt(req.getParameter("id"));
		String path = "deleteCourse.jsp";
		
		int result = instance.deleteCourse(id);
		
		if(result > 0) {
			req.setAttribute("msg", "교과목 삭제 성공");
		} else {
			req.setAttribute("msg", "교과목 삭제 실패");
		}
		
		req.getRequestDispatcher(path).forward(req, res);
	}
}
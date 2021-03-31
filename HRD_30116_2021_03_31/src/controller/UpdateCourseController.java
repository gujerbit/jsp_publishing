package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import vo.CourseVO;

public class UpdateCourseController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CourseDAO instance = CourseDAO.getInstance();
		int type = Integer.parseInt(req.getParameter("type"));
		String path = "updateCourse.jsp";
		
		if(type == 1) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			int credit = Integer.parseInt(req.getParameter("credit"));
			String lecName = req.getParameter("lecName");
			int week = Integer.parseInt(req.getParameter("week"));
			int start = Integer.parseInt(req.getParameter("start"));
			int end = Integer.parseInt(req.getParameter("end"));
			
			CourseVO vo = new CourseVO(id, name, credit, lecName, week, start, end);
			ArrayList<String> list = instance.getLecturer();
			
			req.setAttribute("vo", vo);
			req.setAttribute("list", list);
			req.getRequestDispatcher(path).forward(req, res);
		} else if(type == 2) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			int credit = Integer.parseInt(req.getParameter("credit"));
			String lecName = req.getParameter("lecName");
			int week = Integer.parseInt(req.getParameter("week"));
			int start = Integer.parseInt(req.getParameter("start"));
			int end = Integer.parseInt(req.getParameter("end"));
			
			int result = instance.updateCourse(id, name, credit, lecName, week, start, end);
			
			if(result > 0) {
				req.setAttribute("msg", "교과목 수정 성공");
			} else {
				req.setAttribute("msg", "교과목 수정 실패");
			}
			
			req.getRequestDispatcher(path).forward(req, res);
		}
	}
}
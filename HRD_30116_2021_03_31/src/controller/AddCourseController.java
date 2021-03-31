package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;

public class AddCourseController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CourseDAO instance = CourseDAO.getInstance();
		int type = Integer.parseInt(req.getParameter("type"));
		String path = "addCourse.jsp";
		
		if(type == 1) {
			ArrayList<String> list = instance.getLecturer();
			
			req.setAttribute("list", list);
			req.getRequestDispatcher(path).forward(req, res);
		} else if(type == 2) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String lecName = req.getParameter("lecName");
			int credit = Integer.parseInt(req.getParameter("credit"));
			int week = Integer.parseInt(req.getParameter("week"));
			int start = Integer.parseInt(req.getParameter("start"));
			int end = Integer.parseInt(req.getParameter("end"));
			
			int result = instance.addCourse(id, name, lecName, credit, week, start, end);
			
			if(result > 0) {
				req.setAttribute("msg", "교과목 추가 성공");
			} else {
				req.setAttribute("msg", "교과목 추가 실패");
			}
			
			req.getRequestDispatcher(path).forward(req, res);
		}
	}
}

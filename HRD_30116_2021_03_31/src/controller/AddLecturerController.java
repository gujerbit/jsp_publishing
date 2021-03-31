package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LecturerDAO;

public class AddLecturerController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LecturerDAO instance = LecturerDAO.getInstance();
		int type = Integer.parseInt(req.getParameter("type"));
		String path = "addLecturer.jsp";
		
		if(type == 1) {
			int nextNo = instance.getNextIdx();
			req.setAttribute("nextNo", nextNo);
		} else if(type == 2) {
			int idx = Integer.parseInt(req.getParameter("idx"));
			String name = req.getParameter("name");
			String major = req.getParameter("major");
			String field = req.getParameter("field");
			
			int result = instance.addLecturer(idx, name, major, field);
			
			if(result > 0) {
				req.setAttribute("msg", "강사 추가 성공");
			} else {
				req.setAttribute("msg", "강사 추가 실패");
			}
		}
		
		req.getRequestDispatcher(path).forward(req, res);
	}
}

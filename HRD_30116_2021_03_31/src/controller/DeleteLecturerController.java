package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LecturerDAO;

public class DeleteLecturerController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LecturerDAO instance = LecturerDAO.getInstance();
		String path = "deleteLecturer.jsp";
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		int result = instance.deleteLecturer(idx);
		
		if(result > 0) {
			req.setAttribute("msg", "강사 삭제 성공");
		} else {
			req.setAttribute("msg", "강사 삭제 실패");
		}
		
		req.getRequestDispatcher(path).forward(req, res);
	}
}

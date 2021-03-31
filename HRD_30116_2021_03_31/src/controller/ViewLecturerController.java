package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LecturerDAO;
import vo.LecturerVO;

public class ViewLecturerController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LecturerDAO instance = LecturerDAO.getInstance();
		String path = "viewLecturer.jsp";
		ArrayList<LecturerVO> list = instance.getLecturerList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher(path).forward(req, res);
	}
}
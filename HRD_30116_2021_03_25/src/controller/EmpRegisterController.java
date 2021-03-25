package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;

public class EmpRegisterController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		int type = Integer.parseInt(req.getParameter("type"));
		String path = "empRegister.jsp";
		
		if(type == 1) {
			int nextNo = dao.getNextNo();
			String now = dao.getNow();
			
			req.setAttribute("nextNo", nextNo);
			req.setAttribute("now", now);
			req.getRequestDispatcher(path).forward(req, res);
		} else if(type == 2) {
			int empNo = Integer.parseInt(req.getParameter("empNo"));
			String empName = req.getParameter("empName");
			String rank = req.getParameter("rank");
			String dept = req.getParameter("dept");
			int result = dao.empRegister(empNo, empName, rank, dept);
			
			if(result > 0) {
				req.setAttribute("msg", "사원 등록 성공");
			} else {
				req.setAttribute("msg", "사원 등록 실패");
			}
			
			req.getRequestDispatcher(path).forward(req, res);
		}
	}
}
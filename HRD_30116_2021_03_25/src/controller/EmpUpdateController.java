package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;

public class EmpUpdateController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		String path = "empUpdate.jsp";
		
		int empNo = Integer.parseInt(req.getParameter("empNo"));
		String empName = req.getParameter("empName");
		String rank = req.getParameter("rank");
		String dept = req.getParameter("dept");
		
		int result = dao.empUpdate(empNo, empName, rank, dept);
		
		if(result > 0) {
			req.setAttribute("msg", "회원정보 수정 성공");
		} else {
			req.setAttribute("msg", "회원정보 수정 실패");
		}
		
		req.getRequestDispatcher(path).forward(req, res);
	}
}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import vo.SalaryVO;

public class SalarySelectController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		String path = "salarySelect.jsp";
		ArrayList<SalaryVO> list = dao.getAllSalList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher(path).forward(req, res);
	}
}
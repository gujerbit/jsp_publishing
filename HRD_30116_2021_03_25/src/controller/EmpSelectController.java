package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import vo.EmpVO;

public class EmpSelectController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<EmpVO> list = dao.getAllEmpList();
		String path = "empSelect.jsp";
		
		req.setAttribute("list", list);
		req.getRequestDispatcher(path).forward(req, res);
	}
}

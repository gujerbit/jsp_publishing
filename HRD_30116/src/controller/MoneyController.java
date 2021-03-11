package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MoneyVO;

public class MoneyController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<MoneyVO> list = new ArrayList<MoneyVO>();
		list = dao.getAllMoney();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("money.jsp").forward(req, res);
	}
}

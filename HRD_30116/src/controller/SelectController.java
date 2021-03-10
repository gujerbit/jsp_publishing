package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class SelectController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<MemberVO> list = dao.getAllMember();
		String path = "update.jsp";
		
		req.setAttribute("list", list);
		req.getRequestDispatcher(path).forward(req, res);
	}
}

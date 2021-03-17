package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class SelectMemberController implements Controller {
	@Override
	public void execute(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String path = "selectMember.jsp";
		
		list = dao.getAllMember();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher(path).forward(req, res);
	}
}

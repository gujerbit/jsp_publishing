package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class ViewMemberController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		String path = "viewMember.jsp";
		int type = Integer.parseInt(req.getParameter("type"));
		ArrayList<MemberVO> list = new ArrayList<>();
		
		if(type == 1) {
			String id = req.getParameter("id");
			list = dao.getIdMemberList(id);
		} else if(type == 2) {
			String dept = req.getParameter("dept");
			list = dao.getDeptMemberList(dept);
		}
		
		req.setAttribute("list", list);
		req.getRequestDispatcher(path).forward(req, res);
	}
}
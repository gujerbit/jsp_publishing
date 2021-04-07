package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class SetMemberController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		String path = "index.jsp";
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String dept = req.getParameter("dept");
		String position = req.getParameter("position");
		String duty = req.getParameter("duty");
		String phone = req.getParameter("phone");
		
		int result = dao.setMember(id, name, dept, position, duty, phone);
		
		if(result > 0) {
			req.setAttribute("msg", "사원 등록 성공");
		} else {
			req.setAttribute("msg", "사원 등록 실패");
		}
		
		req.getRequestDispatcher(path).forward(req, res);
	}
}
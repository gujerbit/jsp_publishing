package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class DeleteMemberController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		String path = "index.jsp";
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		int result = dao.deleteMember(id, name);
		
		if(result > 0) {
			req.setAttribute("msg", "사원 삭제 성공");
		} else {
			req.setAttribute("msg", "사원 삭제 실패");
		}
		
		req.getRequestDispatcher(path).forward(req, res);
	}
}

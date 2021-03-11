package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class UpdateController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String grade = req.getParameter("grade");
		String city = req.getParameter("city");
		
		int result = dao.updateMember(id, name, phone, address, grade, city);
		String path = "member_update.jsp";
		
		if(result > 0) {
			req.setAttribute("msg", "회원정보수정이 완료되었습니다!");
			req.getRequestDispatcher(path).forward(req, res);
		} else {
			req.setAttribute("error", "회원정보수정 실패");
			req.getRequestDispatcher(path).forward(req, res);
		}
	}
}

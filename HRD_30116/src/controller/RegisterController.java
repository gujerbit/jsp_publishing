package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class RegisterController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String grade = req.getParameter("grade");
		String city = req.getParameter("city");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.InsertMember(name, phone, address, grade, city);
		
		String path = "register.jsp";
		
		if(result > 0) {
			req.setAttribute("msg", "회원등록이 완료 되었습니다!");
			req.getRequestDispatcher(path).forward(req, res);
		} else {
			req.setAttribute("error", "회원등록 실패");
			req.getRequestDispatcher(path).forward(req, res);
		}
	}
}

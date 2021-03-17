package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class RegisterController implements Controller {
	@Override
	public void execute(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int type = Integer.parseInt(req.getParameter("type"));
		MemberDAO dao = MemberDAO.getInstance();
		String path = "register.jsp";
		
		if(type == 1) {
			int maxNo = dao.getMaxNo() + 1;
			String joindate = dao.getDate();
			
			MemberDTO dto = new MemberDTO(maxNo, joindate);
			
			req.setAttribute("dto", dto);
			req.getRequestDispatcher(path).forward(req, res);
		} else if(type == 2) {
			int custno = Integer.parseInt(req.getParameter("custno"));
			String custname = req.getParameter("custname");
			String grade = req.getParameter("grade");
			String address = req.getParameter("address");
			
			int result = dao.RegisterMember(custno, custname, grade, address);
			
			if(result > 0) {
				req.setAttribute("success", "회원가입 성공");
				req.getRequestDispatcher(path).forward(req, res);
			} else {
				req.setAttribute("error", "회원가입 실패");
				req.getRequestDispatcher(path).forward(req, res);
			}
		}
	}
}

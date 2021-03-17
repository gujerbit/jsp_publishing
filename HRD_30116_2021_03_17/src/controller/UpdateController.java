package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class UpdateController implements Controller {
	@Override
	public void execute(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int type = Integer.parseInt(req.getParameter("type"));
		MemberDAO dao = MemberDAO.getInstance();
		String path = "update.jsp";
		
		if(type == 1) {
			int inputCustno = Integer.parseInt(req.getParameter("custno"));
			MemberVO vo = dao.getMember(inputCustno);
			
			req.setAttribute("vo", vo);
			req.getRequestDispatcher(path).forward(req, res);
		} else if(type == 2) {
			int custno = Integer.parseInt(req.getParameter("custno"));
			String custname = req.getParameter("custname");
			String grade = req.getParameter("grade");
			String address = req.getParameter("address");
			
			int result = dao.updateMember(custno, custname, grade, address);
			
			if(result > 0) {
				req.setAttribute("success", "회원정보 수정 성공");
				req.getRequestDispatcher(path).forward(req, res);
			} else {
				req.setAttribute("error", "회원정보 수정 실패");
				req.getRequestDispatcher(path).forward(req, res);
			}
		}
	}
}

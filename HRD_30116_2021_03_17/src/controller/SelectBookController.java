package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import dao.MemberDAO;
import vo.BookVO;

public class SelectBookController implements Controller {
	@Override
	public void execute(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		String path = "selectBook.jsp";
		ArrayList<BookVO> list1 = dao.getMemberTotal();
		ArrayList<BookVO> list2 = dao.getBookTotal();
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.getRequestDispatcher(path).forward(req, res);
	}
}
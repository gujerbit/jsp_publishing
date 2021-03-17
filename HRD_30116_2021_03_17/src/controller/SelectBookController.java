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
		ArrayList<BookVO> list1 = dao.getMemberTotal();
		ArrayList<BookVO> list2 = dao.getBookTotal();
		ArrayList<BookVO> list = dao.memberBookTotal(list1, list2);
	}
}

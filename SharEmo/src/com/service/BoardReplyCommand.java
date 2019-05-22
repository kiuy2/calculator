package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;

//BoardReplyCommand�� �亯�� ���� ȭ�鿡�� �亯�ޱ� ��ư�� �������� ����Ǵ� ����Դϴ�.
public class BoardReplyCommand implements BoardCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//����� �۾��� ��ɰ� ������ ������ ���������� �亯���� ǥ�õǴ� ����� ����� �����ϱ� ���ؼ� 
		//repRoot(����), repStep(���ۿ� ���� ����), repIndent(�亯 ����) ���ڰ� �߰������� �ʿ��մϴ�.
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String repRoot = request.getParameter("repRoot");
		String repStep = request.getParameter("repStep");
		String repIndent = request.getParameter("repIndent");
		
		BoardDAO dao = new BoardDAO();
		dao.reply(num, title, author, content, repRoot, repStep, repIndent);
	}
}

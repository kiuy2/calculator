package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;

//BoardWriteCommand�� �۾��� ȭ�鿡�� ���� ��ư�� �������� ����Ǵ� ����Դϴ�.
public class BoardWriteCommand implements BoardCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//����� ����ڰ� �Է��� ������ �޾ƿͼ� DAO�� ���� DB�� ���ο� row�� �����մϴ�.
		String title =request.getParameter("title");
		String author =request.getParameter("author");
		String content =request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.write(title, author, content);
	}
}

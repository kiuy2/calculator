package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;

//BoardWriteCommand는 글쓰기 화면에서 저장 버튼을 눌렀을때 실행되는 기능입니다.
public class BoardWriteCommand implements BoardCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//실행시 사용자가 입력한 정보를 받아와서 DAO를 통해 DB에 새로운 row를 삽입합니다.
		String title =request.getParameter("title");
		String author =request.getParameter("author");
		String content =request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.write(title, author, content);
	}
}

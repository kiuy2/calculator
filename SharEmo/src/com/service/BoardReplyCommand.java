package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;

//BoardReplyCommand는 답변글 쓰기 화면에서 답변달기 버튼을 눌렀을때 실행되는 기능입니다.
public class BoardReplyCommand implements BoardCommand {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//실행시 글쓰기 기능과 유사한 절차를 수행하지만 답변글이 표시되는 방식을 제대로 구현하기 위해서 
		//repRoot(원글), repStep(원글에 대한 순서), repIndent(답변 깊이) 인자가 추가적으로 필요합니다.
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

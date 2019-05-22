package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BoardCommand;
import com.service.BoardListCommand;
import com.service.BoardWriteCommand;
import com.service.BoardRetrieveCommand;
import com.service.BoardUpdateCommand;
import com.service.BoardDeleteCommand;
import com.service.BoardReplyUICommand;
import com.service.BoardReplyCommand;

//해당 어노테이션은 "~.do"로 들어오는 모든 요청을 이 서블릿에서 처리하겠다는 의미입니다. (맵핑)
@WebServlet("*.do")

public class BoardFrontController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException{
		//doPost를 호출함으로써 get방식으로 온 요청도 post방식과 함께 처리합니다.
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		//URL에서 스키마, 서버이름, 포트번호를 제외한 나머지 주소와 파라미터를 가져옵니다.
		//(http://localhost:8080)/SharEmo/emo/list.do
		String requestURL=request.getRequestURI();
		//URL에서 컨텍스트 경로를 가져옵니다. (/SharEmo)
		String contextPath=request.getContextPath();
		//36줄에서 가져온 페이지 주소에서 컨텍스트 경로마저 제외시킵니다. (/emo/list.do)
		String com=requestURL.substring(contextPath.length());
		BoardCommand command = null;
		String nextPage= null;
		
		//이렇게 추출한 com 변수를 각각 적합한 처리 모델에 넘겨서 일을 처리하고
		//그다음에 수행할 요청 혹은 띄울 페이지를 설정해줍니다.
		//목록 보기
		if(com.equals("/emo/list.do")) {
			command=new BoardListCommand();
			command.execute(request,response);
			nextPage="list.jsp";
		}
		//글쓰기 폼
		if(com.equals("/emo/writeui.do")) {
			nextPage="write.jsp";
		}
		//글쓰기
		if(com.equals("/emo/write.do")) {
			command= new BoardWriteCommand();
			command.execute(request,response);
			nextPage="list.do";
		}
		//글 자세히 보기
		if(com.equals("/emo/retrieve.do")) {
			command = new BoardRetrieveCommand();
			command.execute(request,response);
			nextPage="retrieve.jsp";
		}
		//글 수정하기
		if(com.equals("/emo/update.do")) {
			command = new BoardUpdateCommand();
			command.execute(request,response);
			nextPage="list.do";
		}
		//글 삭제하기
		if(com.equals("/emo/delete.do")) {
			command = new BoardDeleteCommand();
			command.execute(request,response);
			nextPage="list.do";
		}
		//글 검색하기 (미구현)
		
		//답변글 입력 폼 보기
		if(com.equals("/emo/replyui.do")) {
			command = new BoardReplyUICommand();
			command.execute(request,response);
			nextPage="reply.jsp";
		}
		//답변 글쓰기
		if(com.equals("/emo/reply.do")) {
			command = new BoardReplyCommand();
			command.execute(request,response);
			nextPage="list.do";
		}
		
		//지정한 경로로 제어를 이동(리다이렉트)시키기 위한 코드입니다.
		RequestDispatcher dis=request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}
	
}

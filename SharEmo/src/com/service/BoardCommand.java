package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//BoardCommand는 게시판에서 요청하는 여러 기능들을 상속하는 하나의 인터페이스입니다.
//Controller 부분에서 command.execute라는 단순한 하나의 문장만으로 다양한 기능을 수행할 수 있게 해줍니다.
public interface BoardCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}

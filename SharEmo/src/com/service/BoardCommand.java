package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//BoardCommand�� �Խ��ǿ��� ��û�ϴ� ���� ��ɵ��� ����ϴ� �ϳ��� �������̽��Դϴ�.
//Controller �κп��� command.execute��� �ܼ��� �ϳ��� ���常���� �پ��� ����� ������ �� �ְ� ���ݴϴ�.
public interface BoardCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}

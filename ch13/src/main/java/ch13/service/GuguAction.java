package ch13.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuguAction implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		// 0 ~ 7 => 2 ~ 9
		int num = (int)(Math.random()*8) + 2;
		request.setAttribute("num", num);
		return "gugu.jsp";
	}
}
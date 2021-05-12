package ch13.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Color implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int num = (int)(Math.random()*7);
		String[] color = {"red","orange","yellow","green","blue","navy","violet"};
		request.setAttribute("color", color[num]);
		return "color.jsp";
	}
}
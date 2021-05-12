package ch13.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Message implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", "대박 ! 점심시간이 가까웠네");
		return "message.jsp";
	}
}
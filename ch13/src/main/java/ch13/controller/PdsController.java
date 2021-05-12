package ch13.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch13.dao.PdsItem;
import ch13.service.PdsItemService;
// 확장자가 action인 경우에는 이 컨트롤러로 처리하거야
// url : http://localhost:8080/ch13/pds/fileUpload.action
@WebServlet("*.action")
public class PdsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath();
//		System.out.println("path = "+path);   // /ch13(프로젝트명)
		String uri = request.getRequestURI(); // /ch13/pds/fileUpload.action
//		System.out.println("uri = "+uri);
		String command = uri.substring(path.length()+1);
//		System.out.println("command = "+command); // pds/fileUpload.action
		String pgm = "";
		if (command.equals("pds/fileUpload.action")) {
			PdsItemService pis = new PdsItemService();
			int result = pis.insert(request);
			request.setAttribute("result", result);
			pgm = "uploadResult.jsp";
		} else if (command.equals("pds/list.action")) {
			PdsItemService pis = new PdsItemService();
			List<PdsItem> list = pis.list();
			request.setAttribute("list", list);
			pgm = "list.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(pgm);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
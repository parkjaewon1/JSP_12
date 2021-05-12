package ch13.service;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import ch13.dao.PdsItem;
import ch13.dao.PdsItemDao;
public class PdsItemService {
	public int insert(HttpServletRequest request) {
		int result = 0;
		// jsp application.getRealPath("/upload");
	//	request.getRealPath("/upload");
		String real = request.getSession().getServletContext().getRealPath("/upload");
		int maxSize = 1024 * 1024 * 10; //10M
		try {
			MultipartRequest mr = new MultipartRequest(request, real, maxSize,
				"utf-8",new DefaultFileRenamePolicy());
			String fileName = mr.getFilesystemName("file");
			String description = mr.getParameter("description");
			File file = new File(real+"/"+fileName);
			// 실제 파일과 저장되는 파일 이름을 바꾸고 싶을 때 사용
			file.renameTo(new File(real+"/k_"+fileName));
			int fileSize = (int)file.length();
			PdsItem pi = new PdsItem();
			pi.setFileName("k_"+fileName);
			pi.setFileSize(fileSize);
			pi.setDescription(description);
			PdsItemDao pid = PdsItemDao.getInstance();
			result = pid.insert(pi);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public List<PdsItem> list() {
		PdsItemDao pid = PdsItemDao.getInstance();
		List<PdsItem> list = pid.list();
		return list;
	}

}
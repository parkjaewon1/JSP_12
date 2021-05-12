package ch13.service;
public class IdCheck {
	public int idChk(String id, String pass) {
		int result = 0; 
		if (id.equals("java") && pass.equals("1234")) {
			result = 1;
		}
		return result;
	}
}
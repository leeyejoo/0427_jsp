package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class junittest {

	private LoginService loginService = new LoginService();
	@Test
	void testLogin() {
		String msg = loginService.loginCheck("java","1111");
		System.out.println(msg);
	}

}

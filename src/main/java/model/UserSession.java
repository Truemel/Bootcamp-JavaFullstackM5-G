package model;

public class UserSession {
	private static final String NICKNAME = "admin";
	private static final String PASSWORD = "1234";

	public static boolean loginVerify(String nick, String pass) {
		if(nick.equals(NICKNAME) && pass.equals(PASSWORD))
				return true;
		else
			return false;
	}
}
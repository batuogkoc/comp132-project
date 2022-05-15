package mvc;

import backend.*;

public class Model {
	private static User currentUser;
	
	public static void setCurrentUser(User user) {
		currentUser = user;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
}

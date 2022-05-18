package mvc;

import backend.*;

public class Model {
	private static User currentUser;
	private static User userOfInterest;
	private static Group groupOfInterest;
	private static Content contentOfInterest;
	public static Content getContentOfInterest() {
		return contentOfInterest;
	}

	public static void setContentOfInterest(Content contentOfInterest) {
		Model.contentOfInterest = contentOfInterest;
	}

	public static Group getGroupOfInterest() {
		return groupOfInterest;
	}

	public static void setGroupOfInterest(Group groupOfInterest) {
		Model.groupOfInterest = groupOfInterest;
	}

	public static User getUserOfInterest() {
		return userOfInterest;
	}

	public static void setUserOfInterest(User userOfInterest) {
		Model.userOfInterest = userOfInterest;
	}

	public static void setCurrentUser(User user) {
		currentUser = user;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
	
	
}

package mvc;

import backend.*;

/**
 * holds a part representation of the model state. The rest of the state is stored within static variables in the backend package
 * stores the users, contents, groups to be displayed alongside the currently logged in user. 
 * @author batu
 *
 */
public class Model {
	private static User currentUser; //logged in user
	private static User userOfInterest; //user to be displayed
	private static Group groupOfInterest; //group to be displayed
	private static Content contentOfInterest; //content to be displayed
	
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

package mvc;

import backend.Content;
import backend.Group;
import backend.User;
import frontend.Login;

/**
 * controller class for the mvc structure. Manipulates View and Model to give functionality to the program.
 * Mostly involved in switching between windows
 * 
 */
public class Controller {
	/**
	 * receives events from frontend components, takes neccecary actions such as changing the view accordingly or updating the model.
	 * @param eventCode : what the executed event is
	 */
	public static void sendEvent(String eventCode) {
		switch (eventCode) {
			case "LOGIN":
				Model.setCurrentUser(null);
				View.setFrameContents(new Login());
				break;
			
			case "HOME PAGE":
				View.displayView("HOME PAGE");
				break;
				
			case "ADD CONTENT MENU":
				View.displayView("ADD CONTENT MENU");
				break;
				
			case "PROFILE PAGE":
				Model.setUserOfInterest(Model.getCurrentUser());
				View.displayView("USER PROFILE");
				break;
			
			case "NEW ACCOUNT":
				View.displayView(eventCode);
				break;
			
			case "GROUPS PAGE":
				View.displayView("GROUPS PAGE");
				break;
				
			case "OTHER USER":
				View.displayView("USER PROFILE");
				break;
				
			case "GROUP":
				View.displayView("GROUP");
				break;
				
			case "CONTENT EDIT":
				View.displayView("CONTENT EDIT");
				break;
				
			case "CREATE GROUP":
				View.displayView("CREATE GROUP");
				break;
			default:
				System.out.println("Controller: Unknown event code: " +eventCode);
				break;
		}
	}
	
	/**
	 * initialise the model and start the program from the login page
	 * @param args
	 */
	public static void main(String[] args) {
		__initialiseModel();
		sendEvent("LOGIN");
	}
	/**
	 * create some users, contents, groups for demonstration purposes
	 */
	private static void __initialiseModel() {
		User batu = new User("a", "a", "Batu Orhun", "Gunduz", 18, "batuorhungunduz@gmail.com", true, "Turkey");
		batu.addHobby("death");
		User u1 = new User("b", "b", "Emperor", "Hirohito", 40, "greateasterncoprosperitysphere@gmail.com", false, "Japan");
		u1.addHobby("death");
		User u2 = new User("c", "c", "Joseph", "Stalin", 40, "revolution@gmail.com", true, "Soviet Union");
		batu.followUser(u1);
		batu.followUser(u2);
		
		batu.setProfilePicturePath(".//images//cat.png");
		new Content(batu, batu, "First content", "Hello world!",".//images//cat.png");
		new Content(batu, batu, "Second content", "second c", ".//images//defaultProfilePicture.png");
		new Content(u2, u2, "Red army is strong", "lolsies", ".//images//defaultProfilePicture.png");
		Group g1 = new Group(batu, "dictators", "germany");
		g1.addHobby("Genocide");
		g1.addHobby("Warmongering");
		new Content(g1, u1, "I will bomb pearl harbour", "Lol", ".//images//pearl-harbor.jpg");
		u1.joinGroup(g1);
		u2.joinGroup(g1);
	}
	

	
	
}

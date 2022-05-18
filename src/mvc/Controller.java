package mvc;

import backend.Content;
import backend.Group;
import backend.User;
import frontend.Login;

/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from
anyone else. The effort in the project thus belongs completely to me. I did not search for a
solution, or I did not consult to any program written by others or did not copy any program from
other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Batu Orhun Gunduz, 79886>
************************************************************************************************************/

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
			case "LOGIN": //displays login page
				Model.setCurrentUser(null); //set the currently logged in user to null
				View.setFrameContents(new Login()); //show the login page
				break;
			
			case "HOME PAGE": //displays home page
				View.displayView("HOME PAGE"); //display home page
				break;
				
			case "ADD CONTENT MENU":  //displays new content page
				View.displayView("ADD CONTENT MENU");
				break;
				
			case "PROFILE PAGE":  //displays the profile page of the currently logged in user
				Model.setUserOfInterest(Model.getCurrentUser());
				View.displayView("USER PROFILE");
				break;
			
			case "NEW ACCOUNT": //displays new account generation page
				View.displayView("NEW ACCOUNT");
				break;
				
			case "OTHER USER": //displays the profile of a user
				View.displayView("USER PROFILE");
				break;
				
			case "GROUP": //displays a group's page
				View.displayView("GROUP");
				break;
				
			case "CONTENT EDIT": //displays the edit menu for a content
				View.displayView("CONTENT EDIT");
				break;
				
			case "CREATE GROUP": //displays the new group generation page
				View.displayView("CREATE GROUP");
				break;
			default:
				System.err.println("Controller: Unknown event code: " +eventCode); //print an error if the event code is unknown
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

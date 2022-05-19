package mvc;

import backend.Content;
import backend.Group;
import backend.User;
import frontend.Login;
import java.util.*;
import java.security.*;

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
		SecureRandom sr = new SecureRandom();
		User batu = new User("a", "a", "Batu Orhun", "Gunduz", 18, "batuorhungunduz@gmail.com", true, "Turkey");
		batu.addHobby("coding");
		batu.setProfilePicturePath(".//images//cat.png");
		ArrayList<User> users = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			String s = Integer.toString(i);
			User u = new User(s, s, s, s, 10, "email@domain.com", i%2==0?true:false, "Turkey");
			for(int j = 0; j<2; j++) {
				String t = Integer.toString(j) + " " + s;
				Content c = new Content(u, u, t, t);
				if(j%2==0)
					c.setImagePath(".//images//"+sr.nextInt(1,15)+".jpg");
			}
			u.setProfilePicturePath(".//images//"+s+".jpg");
			users.add(u);
		}

		ArrayList<Group> groups = new ArrayList<>();
		for (int i = 1; i <= 4; i++) {
			String s = Integer.toString(i);
			Group g = new Group(batu, s, s);
			for(int j = 0; j<3; j++) {
				User u = users.get(sr.nextInt(users.size()));
				u.joinGroup(g);
				
				for(int k = 0; k<2; k++) {
					String t = Integer.toString(k) + " " + s + " g";
					Content c = new Content(g, u, t, t);
					if(j%2==0)
						c.setImagePath(".//images//"+sr.nextInt(1,15)+".jpg");
				}
			}
			groups.add(g);
		}
		for (User user : users) {
			for(int j = 0; j<3; j++)
				user.followUser(users.get(sr.nextInt(users.size())));
		}
	}
}

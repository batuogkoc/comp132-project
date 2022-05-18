package mvc;

import java.awt.GridLayout;

import javax.swing.*;
import backend.*;
import frontend.*;

public class Controller {
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
				
			default:
				System.out.println("Controller: Unknown event code: " +eventCode);
				break;
		}
	}
	public static void main(String[] args) {
		__initialiseModel();
		sendEvent("LOGIN");
	}
	
	private static void __initialiseModel() {
		User batu = new User("a", "a", "Batu Orhun", "Gunduz", 18, "batuorhungunduz@gmail.com", true);
		User u1 = new User("b", "b", "Emperor", "Hirohito", 40, "greateasterncoprosperitysphere@gmail.com", false);
		User u2 = new User("c", "c", "Joseph", "Stalin", 40, "revolution@gmail.com", true);
		batu.followUser(u1);
		batu.followUser(u2);
		
		batu.setProfilePicturePath(".//images//cat.png");
		batu.addContent(new Content(batu, "First content", "Hello world!",".//images//cat.png"));
		batu.addContent(new Content(batu, "Second content", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", ".//images//defaultProfilePicture.png"));
		
		Group g1 = new Group(batu, "dictators", "germany");
		g1.addHobby("Genocide");
		g1.addHobby("Warmongering");
		g1.addContent(new Content(u1, "I will bomb pearl harbour", "Lol", ".//images//pearl-harbor.jpg"));
		u1.joinGroup(g1);
		u2.joinGroup(g1);
	}
	

	
	
}

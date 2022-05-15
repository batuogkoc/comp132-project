package mvc;

import java.awt.GridLayout;

import javax.swing.*;
import backend.*;
import frontend.*;

public class Controller {
	public static void sendEvent(String eventCode) {
		switch (eventCode) {
		case "LOGIN":
			View.setFrameContents(new Login());
			break;
		
		case "HOME PAGE":
			System.out.println(Model.getCurrentUser());
			View.displayView("HOME PAGE");
			break;
			
		case "ADD CONTENT MENU":
			View.displayView("ADD CONTENT MENU");
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
		User batu = new User("a", "b", "Batu Orhun", "Gunduz", 18, "batuorhungunduz@gmail.com");
		batu.addContent(new Content(batu, "First content", "Hello world!", "cat.png"));
		batu.addContent(new Content(batu, "Second content", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "cat.png"));
		User m1 = new User("c", "d", "Emperor", "Hirohito", 40, "greateasterncoprosperitysphere@gmail.com");
	}
	

	
	
}

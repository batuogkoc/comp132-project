package backend;

import java.util.TreeMap;
import java.util.TreeSet;

public class Group {
	private String name;
	private String country;
	private User groupCreator;
	private TreeSet<String> hobbies = new TreeSet<>();
	private TreeSet<Content> contents = new TreeSet<>();
	private TreeSet<User> members = new TreeSet<>();
	public Group(User groupCreator, String name, String country) {
		super();
		this.groupCreator = groupCreator;
		this.name = name;
		this.country = country;
	}
	
	public boolean addHobby(String hobby) {
		return this.hobbies.add(hobby);
	}
	public boolean removeHobby(String hobby) {
		return this.hobbies.remove(hobby);
	}
	
	public boolean addMember(User member) {
		return this.members.add(member);
	}
	
	public boolean removeMember(User member) {
		return this.members.remove(member);
	}
	
	
}

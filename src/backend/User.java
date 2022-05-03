package backend;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class User implements Comparable<User>{
	private final String nickname;
	private String password;
	private String name;
	private String surname;
	private int age;
	private String emailAddress;
	private String profilePicturePath;
	private static String defaultProfilePicturePath;
	private TreeSet<String> hobbies;
	private TreeSet<User> followedUsers;
	private TreeSet<Group> joinedGroups;
	private ArrayList<Content> posts;
	private static TreeMap<String, User> users;
	
	
	
	public User(String nickname, String password, String name, String surname, int age, String emailAddress) throws IllegalArgumentException{
		super();
		if (users.containsKey(nickname)){
			throw new IllegalArgumentException("Nickname must be unique");
		}
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.emailAddress = emailAddress;
		users.put(nickname, this);
	}
	
	protected void finalize() {
		users.remove(this.nickname);
	}

	public int compareTo(User usr) {
		return this.nickname.compareTo(usr.nickname);
	}
	
	public boolean followUser(User usr) {
		if (usr!=this && (!this.followedUsers.contains(usr))) {
			this.followedUsers.add(usr);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean unfollowUser(User usr) {
		if(this.followedUsers.contains(usr)) {
			this.followedUsers.remove(usr);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean joinGroup(Group group) {
		return this.joinedGroups.add(group);

	}
	
	public boolean leaveGroup(Group group) {
		return this.joinedGroups.remove(group);
	}
		
}

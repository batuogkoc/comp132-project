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
	private TreeSet<String> hobbies = new TreeSet<String>();
	private TreeSet<User> followedUsers = new TreeSet<User>();
	private TreeSet<Group> joinedGroups = new TreeSet<Group>();
	private TreeSet<Content> contents = new TreeSet<Content>();
	private static TreeMap<String, User> users = new TreeMap<>();
	
	
	
	public User(String nickname, String password, String name, String surname, int age, String emailAddress) throws IllegalArgumentException{
		super();
		if ( users.containsKey(nickname)){
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
	
	public boolean addContent(Content c) {
		return this.contents.add(c);
	}
		
	public boolean removeContent(Content c) {
		return this.contents.remove(c);
	}
	
	public boolean addHobby(String hobby) {
		return this.hobbies.add(hobby);
	}
	public boolean removeHobby(String hobby) {
		return this.hobbies.remove(hobby);
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public static String getDefaultProfilePicturePath() {
		return defaultProfilePicturePath;
	}

	public static void setDefaultProfilePicturePath(String defaultProfilePicturePath) {
		User.defaultProfilePicturePath = defaultProfilePicturePath;
	}

	public String getNickname() {
		return nickname;
	}

	public TreeSet<String> getHobbies() {
		return hobbies;
	}

	public TreeSet<User> getFollowedUsers() {
		return followedUsers;
	}

	public TreeSet<Group> getJoinedGroups() {
		return joinedGroups;
	}

	public TreeSet<Content> getContents() {
		return contents;
	}
}

package backend;

import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Comparable<User>, ContentContainer{
	private final String nickname;
	private String password;
	private String name;
	private String surname;
	private int age;
	private String emailAddress;
	private String profilePicturePath = "";
	private static String defaultProfilePicturePath;
	private boolean isPremium;
	private TreeSet<String> hobbies = new TreeSet<String>();
	private TreeSet<User> followedUsers = new TreeSet<User>();
	private HashSet<Group> joinedGroups = new HashSet<Group>();
	private TreeSet<Content> contents = new TreeSet<Content>();
	private static TreeMap<String, User> users = new TreeMap<>();
	private static SecureRandom rand = new SecureRandom();
	
	static {
		defaultProfilePicturePath = ".//images//defaultProfilePicture.png";
	}
	
	public User(String nickname, String password, String name, String surname, int age, String emailAddress, boolean isPremium) throws IllegalArgumentException{
		super();
		if ( users.containsKey(nickname)){
			throw new IllegalArgumentException("This nickname is taken");
		}
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		Pattern pattern = Pattern.compile(".+@.+\\..+");
		Matcher matcher = pattern.matcher(emailAddress);
		if(!matcher.find()) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.emailAddress = emailAddress;
		this.isPremium = isPremium;
		users.put(nickname, this);
	}

	protected void finalize() {
		users.remove(this.nickname);
	}

	public int compareTo(User usr) {
		return this.nickname.compareTo(usr.nickname);
	}
	
	public Collection<User> recommendUsers() {
		TreeMap<Double, User> sortedMap = new TreeMap<>();
		for (User user : users.values()) {
			sortedMap.put(this.getLikeness(user), user);
		}
		ArrayList<User> ret = new ArrayList<User>();
		for (Double key : sortedMap.keySet()) {
			if(sortedMap.get(key) != this)
				ret.add(sortedMap.get(key));
		}
		Collections.reverse(ret);
		return ret;
	}
	
	
	public Collection<Group> recommendGroups() {
		TreeMap<Double, Group> sortedMap = new TreeMap<>();
		for (Group group : Group.getGroups().values()) {
			sortedMap.put(this.getLikenessGroup(group), group);
		}
		ArrayList<Group> ret = new ArrayList<Group>();
		for (Double key : sortedMap.keySet()) {
			ret.add(sortedMap.get(key));
		}
		Collections.reverse(ret);
		return ret;
	}
	
	public double getLikeness(User user) {
		double ret = 0;
		for (String hobbyThis : this.hobbies) {
			for (String hobbyTheirs : user.hobbies) {
				if(hobbyThis.equals(hobbyTheirs)) {
					ret++;
				}
			}
		}
		return ret+rand.nextDouble()/100;
	}
	
	public double getLikenessGroup(Group group) {
		double ret = 0;
		for (String hobbyThis : this.hobbies) {
			for (String hobbyTheirs : group.getHobbies()) {
				if(hobbyThis.equals(hobbyTheirs)) {
					ret++;
				}
			}
		}
		return ret+rand.nextDouble()/100;
	}
	public HashSet<Content> getReceivedContents(){
		HashSet<Content> ret = new HashSet<>();
		for (User followedUser : followedUsers) {
			ret.addAll(followedUser.getContents());
		}
		for(Group group : joinedGroups) {
			ret.addAll(group.getContents());
		}
		return ret;
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
	
	public static User authenticateUser(String nickname, String password) {
		if(users.containsKey(nickname)) {
			if(users.get(nickname).getPassword().equals(password)) {
				return users.get(nickname);
			}
		}
		return null;
	}
	
	public boolean deleteUser() {
		if(users.remove(this.getNickname()) != null)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " " + surname + " Email: " + emailAddress;
	}

	
	public boolean joinGroup(Group group) {
		if(group.join(this))
			return this.joinedGroups.add(group);
		return false;
	}
	
	public boolean leaveGroup(Group group) {
		if(group.leave(this))
			return this.joinedGroups.remove(group);
		else
			return false;
	}
	
	public boolean addContent(Content c) {
		return this.contents.add(c);
	}
	
	@Override
	public boolean removeContent(Content c) {
		return this.contents.remove(c);
	}
	
	public boolean addHobby(String hobby) {
		return this.hobbies.add(hobby);
	}
	public boolean removeHobby(String hobby) {
		return this.hobbies.remove(hobby);
	}
	
	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
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
		return profilePicturePath.equals("")?defaultProfilePicturePath:profilePicturePath;
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

	public HashSet<Group> getJoinedGroups() {
		return joinedGroups;
	}

	public TreeSet<Content> getContents() {
		return contents;
	}
}

package backend;

import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * backend component of the users. Stores all relevant info and provides view-independant functionality like recommendation etc.
 * @author batu
 *
 */
public class User implements Comparable<User>, ContentContainer, HobbyContainer{
	private final String nickname; //unique nickname
	private String password;
	private String name;
	private String surname;
	private int age;
	private String emailAddress;
	private String profilePicturePath = ""; //path to profile picture. "" means default picture
	private static String defaultProfilePicturePath; //path to default profile picture
	private boolean isPremium;
	private String country;
	private TreeSet<String> hobbies = new TreeSet<String>(); //hobbies are stored in alphabetical order and are unique. Hence TreeSet
	private TreeSet<User> followedUsers = new TreeSet<User>(); //followedUsers are stored in nickname alphabetical order and are unique. Hence TreeSet
	private HashSet<Group> joinedGroups = new HashSet<Group>(); //joinedGroups are unique but dont have a comparator. Hence HashSet
	private TreeSet<Content> contents = new TreeSet<Content>(); //contents are stored in time order and are unique. Hence TreeSet
	private static TreeMap<String, User> users = new TreeMap<>(); //users are indexed in nickname alphabetical order and are unique. Hence TreeMap
	private static SecureRandom rand = new SecureRandom(); //needed for recommendation
	
	static {
		defaultProfilePicturePath = ".//images//defaultProfilePicture.png"; //set default pp path
	}
	/**
	 * constructor. Initialises fields and does input checks
	 * @param nickname
	 * @param password
	 * @param name
	 * @param surname
	 * @param age
	 * @param emailAddress
	 * @param isPremium
	 * @param country
	 * @throws IllegalArgumentException thrown when nickname or email invalid
	 */
	public User(String nickname, String password, String name, String surname, int age, String emailAddress, boolean isPremium, String country) throws IllegalArgumentException{
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
		this.country = country;
		users.put(nickname, this);
	}
	
	/**
	 * allows for users to be sorted by nickname alphabetical order
	 */
	public int compareTo(User usr) {
		return this.nickname.compareTo(usr.nickname);
	}
	
	/**
	 * reccomends users. Sorts all users by their likeness score
	 * A users likeness score compared to this user is determined by the proximity of their age, number of matching hobbies and whether or not they live in the same country or not.
	 * @return
	 */
	public Collection<User> recommendUsers() {
		TreeMap<Double, User> sortedMap = new TreeMap<>();
		//put all users into a map by their likeness score. This will be on increasing likeness order since it is a TreeMap
		for (User user : users.values()) {
			sortedMap.put(this.getLikeness(user), user);
		}
		ArrayList<User> ret = new ArrayList<User>();
		//add all users that the user doesnt follow or isnt themselves into the return list
		for (Double key : sortedMap.keySet()) {
			if(sortedMap.get(key) != this && !followedUsers.contains(sortedMap.get(key)))
				ret.add(sortedMap.get(key));
		}
		Collections.reverse(ret);//reverse the list so the output is in decreasing-likeness order
		return ret;
	}
	
	/**
	 * reccomends groups. Sorts all groups by their likeness score
	 * A groups likeness score compared to this user is determined by the number of matching hobbies and whether or not they live are originated in the same country.
	 * @return
	 */
	public Collection<Group> recommendGroups() {
		TreeMap<Double, Group> sortedMap = new TreeMap<>();
		//put all groups into a map by their likeness score. This will be on increasing likeness order since it is a TreeMap
		for (Group group : Group.getGroups().values()) {
			sortedMap.put(this.getLikenessGroup(group), group);
		}
		ArrayList<Group> ret = new ArrayList<Group>();
		//add all groups that the user isnt a part of into the return list
		for (Double key : sortedMap.keySet()) {
			if(!joinedGroups.contains(sortedMap.get(key)))
					ret.add(sortedMap.get(key));
		}
		Collections.reverse(ret);//reverse the list so the output is in decreasing-likeness order
		return ret;
	}
	/**
	 * searches users by a keyword. returns all users whose nickname contain the keyword.
	 * @param keyword
	 * @return users that have been found
	 */
	public static ArrayList<User> searchUsers(String keyword) {
		ArrayList<User> usersTemp = new ArrayList<User>();
		for (User user : users.values()) {
			if(user.nickname.contains(keyword)) {
				usersTemp.add(user);
			}
		}
		return usersTemp;
	}
	
	/**
	 * user-user likeness score calculator. 1 point up for every matching hobby. 1 Point down for every year in age difference. 1 point for same country of origin. 
	 * @param user user to compare the linekess of this user to
	 * @return likeness score
	 */
	public double getLikeness(User user) {
		double ret = 0;
		for (String hobbyThis : this.hobbies) {
			for (String hobbyTheirs : user.hobbies) {
				if(hobbyThis.equals(hobbyTheirs)) {
					ret++;
				}
			}
		}
		//since this score is used as a key value for a map, different users that got the same score will be overridden. So a tiny bit of randomness is added
		//to ensure that same likeness score individuals can be differentiated from.
		return ret+rand.nextDouble()/100+(user.country.equals(this.country)?1:0)-Math.abs(age-user.age); 
	}
	
	/**
	 * user-group likeness score calculator. 1 point up for every matching hobby. 1 point for same country of origin. 
	 * @param user user to compare the linekess of this user to
	 * @return likeness score
	 */
	public double getLikenessGroup(Group group) {
		double ret = 0;
		for (String hobbyThis : this.hobbies) {
			for (String hobbyTheirs : group.getHobbies()) {
				if(hobbyThis.equals(hobbyTheirs)) {
					ret++;
				}
			}
		}
		//since this score is used as a key value for a map, different groups that got the same score will be overridden. So a tiny bit of randomness is added
		//to ensure that same likeness score groups can be differentiated from.
		return ret+rand.nextDouble()/100+(group.getCountry().equals(this.country)?1:0);
	}
	
	/**
	 * returns all contents that the followers of this user, the groups of this user have posted.
	 * @return
	 */
	public HashSet<Content> getReceivedContents(){
		HashSet<Content> ret = new HashSet<>();
		for (User followedUser : followedUsers) {
			ret.addAll(followedUser.getContents());
		}
		for(Group group : joinedGroups) {
			ret.addAll(group.getContents());
		}
		HashSet<Content> ret2 = new HashSet<>();
		for (Content content : ret) {
			if(content.getAuthor() != this) {
				ret2.add(content);
			}
		}
		return ret;
	}
	
	/**
	 * follow a user
	 * @param usr user to follow
	 * @return true if success, false if not
	 */
	public boolean followUser(User usr) {
		if (usr!=this && (!this.followedUsers.contains(usr))) {
			this.followedUsers.add(usr);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * unfollow a user
	 * @param usr user to follow
	 * @return true if success, false if not
	 */
	public boolean unfollowUser(User usr) {
		if(this.followedUsers.contains(usr)) {
			this.followedUsers.remove(usr);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * checks whether there is a user with said nickname and password
	 * @param nickname
	 * @param password
	 * @return the user if it exists, null if not
	 */
	public static User authenticateUser(String nickname, String password) {
		if(users.containsKey(nickname)) {
			if(users.get(nickname).getPassword().equals(password)) {
				return users.get(nickname);
			}
		}
		return null;
	}
	
	/**
	 * deletes user
	 * @return true if success, false if not
	 */
	public boolean deleteUser() {
		if(users.remove(this.getNickname()) != null)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return name + " " + surname + " (" + nickname+")";
	}

	/**
	 * joins a group
	 * @param group group to be joined
	 * @return true if success, false if not
	 */
	public boolean joinGroup(Group group) {
		if(group.join(this))
			return this.joinedGroups.add(group);
		return false;
	}
	/**
	 * leaves a group
	 * @param group group to be left
	 * @return true if success, false if not
	 */
	public boolean leaveGroup(Group group) {
		if(group.leave(this))
			return this.joinedGroups.remove(group);
		else
			return false;
	}
	@Override
	public boolean addContent(Content c) {
		return this.contents.add(c);
	}
	
	@Override
	public boolean removeContent(Content c) {
		return this.contents.remove(c);
	}
	
	public boolean addHobby(String hobby) {
		if(hobby.equals(""))
			return false;
		return this.hobbies.add(hobby);
	}
	public boolean removeHobby(String hobby) {
		return this.hobbies.remove(hobby);
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
    
	/**
	 * path to profile picture. returns default pp path if no pp is specified
	 * @return
	 */
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

	public void setHobbies(TreeSet<String> hobbies) {
		this.hobbies = hobbies;
	}
	
}

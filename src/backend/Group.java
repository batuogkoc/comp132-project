package backend;

import java.util.*;

/**
 * backend component of the groups. Stores all relevant info and provides view-independant functionality.
 * @author batu
 *
 */
public class Group implements ContentContainer, HobbyContainer{
	private final String name; //name of group
	private String country; //country of group
	private User groupCreator; //creator of group
	private TreeSet<String> hobbies = new TreeSet<>(); //hobbies the group has. TreeSet as we don't want duplicates and keeping them sorted is more visually pleasing
	private TreeSet<Content> contents = new TreeSet<>(); //all the contents added to the group. TreeSet as they will be unique and displayed in creation-time-decreasing order
	private TreeSet<User> members = new TreeSet<>(); //all the users. TreeSet as users are unique and they are stored alphabetically according to their nicknames.
	private static HashMap<String, Group> groups; //all the groups. HashMap as the groups are indexed by their nicknames. 
	static {
		groups = new HashMap<String, Group>();
	}
	/**
	 * Constructor
	 * @param groupCreator creator of the group. Has admin privileges
	 * @param name 
	 * @param country
	 * @throws IllegalArgumentException thrown when group name isnt unique
	 */
	public Group(User groupCreator, String name, String country) throws IllegalArgumentException{
		super();
		this.groupCreator = groupCreator;
		if(groups.containsKey(name)) {
			throw new IllegalArgumentException("This group exits");
		}
		this.name = name;
		this.country = country;
		this.groupCreator.joinGroup(this); //make the group creator a member of the group
		groups.put(name, this);
	}
	
	public static HashMap<String, Group> getGroups() {
		return groups;
	}
	/**
	 * searches all of the groups and returns all whose nickname contain the keyword
	 * @param keyword
	 * @return found groups
	 */
	public static ArrayList<Group> searchGroups(String keyword) {
		ArrayList<Group> groupsTemp = new ArrayList<Group>();
		for (Group group : groups.values()) {
			if(group.name.contains(keyword)) {
				groupsTemp.add(group);
			}
		}
		return groupsTemp;
	}
	/**
	 * function to remove content as per ContentContainer interface
	 */
	@Override
	public boolean removeContent(Content content) {
		return contents.remove(content);
	}
	/**
	 * function to add content as per ContentContainer interface
	 */
	@Override
	public boolean addContent(Content content) {
		return contents.add(content);
	}
	
	public TreeSet<Content> getContents() {
		return contents;
	}
	
	/**
	 * function to add hobby as per HobbyContainer interface
	 */
	public boolean addHobby(String hobby) {
		if(hobby.equals(""))
			return false;
		return this.hobbies.add(hobby);
	}
	/**
	 * function to add hobby as per HobbyContainer interface
	 */
	public boolean removeHobby(String hobby) {
		return this.hobbies.remove(hobby);
	}
	
	/**
	 * function to allow users to leave the group. User will call this and pass themselves. Their contents along themselves will be removed from group
	 * since contents posted on a group are only pointed to by the groups contents list, removing them from list will make the garbage collector delete them.
	 * @param member member to leave
	 * @return true if success, false if not
	 */
	public boolean leave(User member) {
		ArrayList<Content> contentsToRemove = new ArrayList<Content>();
		for (Content content : contents) {
			if(content.getAuthor() == member) {
				contentsToRemove.add(content);
			}
		}
		for (Content content : contentsToRemove) {
			removeContent(content);
		}
		return this.members.remove(member);
	}
	/**
	 * function to allow users to join the group. User will call this and pass themselves and they will be added to the group.
	 * @param member
	 * @return true if success, false if not
	 */
	public boolean join(User member) {
		return this.members.add(member);
	}
	
	/**
	 * deletes the group and makes everybody leave.
	 */
	public void deleteGroup() {
		while (members.size()>0) {
			members.first().leaveGroup(this);
		}
		groupCreator.leaveGroup(this);
	}
	

	public TreeSet<String> getHobbies() {
		return hobbies;
	}

	@Override
	public String toString() {
		return name + " (" +members.size()+")";
	}

	public boolean isCreator(User user) {
		return groupCreator==user;
	}

	public User getGroupCreator() {
		return groupCreator;
	}
	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public TreeSet<User> getMembers() {
		return members;
	}
	
}

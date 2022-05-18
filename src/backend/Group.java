package backend;

import java.util.*;


public class Group implements ContentContainer{
	private final String name;
	private String country;
	private User groupCreator;
	private TreeSet<String> hobbies = new TreeSet<>();
	private TreeSet<Content> contents = new TreeSet<>();
	private TreeSet<User> members = new TreeSet<>();
	private static HashMap<String, Group> groups;
	static {
		groups = new HashMap<String, Group>();
	}
	public Group(User groupCreator, String name, String country) throws IllegalArgumentException{
		super();
		this.groupCreator = groupCreator;
		if(groups.containsKey(name)) {
			throw new IllegalArgumentException("This group exits");
		}
		this.name = name;
		this.country = country;
		this.groupCreator.joinGroup(this);
	}
	
	@Override
	public boolean removeContent(Content content) {
		return contents.remove(content);
	}
	
	public boolean addContent(Content content) {
		return contents.add(content);
	}
	
	public TreeSet<Content> getContents() {
		return contents;
	}

	public boolean addHobby(String hobby) {
		return this.hobbies.add(hobby);
	}
	public boolean removeHobby(String hobby) {
		return this.hobbies.remove(hobby);
	}
	
	private boolean addMember(User member) {
		return member.joinGroup(this);
	}
	
	private boolean removeMember(User member) {
		return member.leaveGroup(this);
	}
	
	public boolean leave(User member) {
		return this.members.remove(member);
	}
	
	public boolean join(User member) {
		return this.members.add(member);
	}
	
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

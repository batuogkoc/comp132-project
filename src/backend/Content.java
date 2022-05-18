package backend;

import java.time.LocalDateTime;

public class Content implements Comparable<Content>{
	private final User author;
	private final String title;
	private final LocalDateTime timeOfCreation;
	private final ContentContainer contentDestination;
	private String text;
	private String imagePath;
	
	public Content(ContentContainer contentDestination, User author, String title, String text) throws IllegalArgumentException{
		super();
		this.timeOfCreation = LocalDateTime.now();
		this.author = author;
		if(title.equals("")) {
			throw new IllegalArgumentException("Invalid title");
		}
		this.contentDestination = contentDestination;
		this.title = title;
		this.text = text;
		this.contentDestination.addContent(this);
	}
	public Content(ContentContainer contentDestination, User author, String title, String text, String imagePath) throws IllegalArgumentException{
		super();
		this.timeOfCreation = LocalDateTime.now();
		this.author = author;
		this.title = title;
		if(title.equals("")) {
			throw new IllegalArgumentException("Invalid title");
		}
		this.contentDestination = contentDestination;
		this.text = text;
		this.imagePath = imagePath;
		this.contentDestination.addContent(this);
	}

	
	public int compareTo(Content c) {
		return -this.timeOfCreation.compareTo(c.timeOfCreation);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public User getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public LocalDateTime getTimeOfCreation() {
		return timeOfCreation;
	}
	public boolean delete() {
		return this.contentDestination.removeContent(this);
	}
}
